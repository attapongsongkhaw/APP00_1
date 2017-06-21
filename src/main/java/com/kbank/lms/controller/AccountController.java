package com.kbank.lms.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbank.lms.common.LMSException;
import com.kbank.lms.common.WebServiceException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.MapErrorMsg;
import com.kbank.lms.service.AccountService;
import com.kbank.lms.soap.ws.service.CBS1183I01Service;
import com.kbank.lms.soap.ws.service.CIS0367I01Service;
import com.kbank.lms.soap.ws.service.KBANK1554I01Service;
import com.kbank.lms.utils.AppUtils;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	CBS1183I01Service CBSService;
	
	@Autowired
	CIS0367I01Service CISService;
	
	@Autowired
	KBANK1554I01Service KBANKService;
	
	private static final Logger logger = Logger.getLogger(AccountController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "saveAccount", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveAccount(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		Claims claims = (Claims) request.getAttribute(CLAIMSTR);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			AccountMst accountMst = mapper.convertValue(node.get("accountMst"), AccountMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			accountMst.setCreatedBy(claims.getSubject());
			accountMst.setLastUpdatedBy(claims.getSubject());
			accountService.saveAccountByMaker(accountMst, mode, type);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex); 
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "checkAccountDuplicate/{accountNo}", method = RequestMethod.GET)
	public int checkAccountDuplicate(@PathVariable final String accountNo) throws LMSException {
		int result = 0;
		try {
			result = accountService.checkAccountDuplicate(accountNo);
			if(result == 1){
				throw new LMSException(103);
			}
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex); 
		}
		return result;
	}
	
	@RequestMapping(value = "searchAccountPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<AccountMst> searchAccountPending(@RequestBody SearchDataTable<AccountMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<AccountMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.ACCOUNTTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = accountService.searchAccount(searchDataTable);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "searchAccountActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<AccountMst> searchAccountActive(@RequestBody SearchDataTable<AccountMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<AccountMst> result = new DataTable<>();
		try{
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.ACCOUNTTABLEMST);
			result = accountService.searchAccount(searchDataTable);
		}catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getAccountPendingById/{id}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public AccountMst  getAccountPendingById(@PathVariable int id) throws LMSException {
		AccountMst result = null;
		try {	
			result = accountService.getAccountPendingById(id);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getAccountActiveById/{id}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public AccountMst getAccountActiveById(@PathVariable int id) throws LMSException {
		AccountMst result = null;
		try {	
			result = accountService.getAccountActiveById(id);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "deleteAccountById/{id}", method = RequestMethod.GET)
	public String deleteAccountById(@PathVariable int id,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			AccountMst accountMst = new AccountMst();
			accountMst.setAccountId(id);
			accountMst.setLastUpdatedBy(claims.getSubject());
			accountMst.setAuthorizeStatus("W");
			accountMst.setOperationFlag("D");
			accountService.deleteAccountById(accountMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectAccountById", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectAccountById(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			int accountId = mapper.convertValue(node.get("accountId"), Integer.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			AccountMst accountMst = new AccountMst();
			accountMst.setAccountId(accountId);
			accountMst.setLastUpdatedBy(claims.getSubject());
			accountMst.setOperationFlag(operationFlag);
			accountMst.setRejectReason(rejectReason);
			accountMst.setAuthorizeStatus("N");
			accountService.rejectAccountById(accountMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "cancelAccountById/{id}", method = RequestMethod.GET)
	public String cancelAccountById(@PathVariable int id) throws LMSException {
		try {
			accountService.cancelAccountById(id);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "approveAccountById/{id}/{operationFlag}/{accountNo}", method = RequestMethod.GET)
	public String approveAccountById(@PathVariable int id,
			@PathVariable String operationFlag,
			@PathVariable String accountNo,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			AccountMst accountMst = new AccountMst();
			accountMst.setAccountId(id);
			accountMst.setLastUpdatedBy(claims.getSubject());
			accountMst.setOperationFlag(operationFlag);
			accountMst.setAuthorizedBy(claims.getSubject());
			accountMst.setAuthorizeStatus("Y");
			accountMst.setAccountNo(accountNo);
			accountService.acceptAccountByAccountId(accountMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getAccountDetailByAccountNo/{accountNo}/{accountType}", method = RequestMethod.GET)
	public AccountMst getAccountDetailByAccountNo(@PathVariable String accountNo, 
			@PathVariable String accountType,
			@RequestParam(value = "clientCisId", required = false) final String clientCisId) throws LMSException {
		AccountMst account = new AccountMst();
		account.setAccountNo(accountNo);
		/*account.setAccountLevel("01");
		account.setAccountNameEn("xxxxxx");
		account.setAccountNameTh("ccccccc");
		account.setActiveStatus("Y");
		account.setCisId("1111111111");
		account.setKbankProductCode("CA");*/
	
		try {
			com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response CBS1183I01 = CBSService.getServiceCBS1183I01(accountNo);
	        if("00".equals(CBS1183I01.getKBankHeader().getStatusCode())){
	        	if("4".equals(CBS1183I01.getCBSAccount().getAcctStatus())){
	        		String KbankProductCode = CBS1183I01.getCBSAccount().getKBankProductCode();
	        		account.setAccountLevel("03");
	        		if(accountType.equals(Constants.SAVING)){
	        			if(!"2102".equals(KbankProductCode.substring(0, 4))){
	        				throw new LMSException(202);
	        			}
	        			account.setAccountLevel("01");
	        			account.setKbankProductCode("SA");
	        		}else{
	        			if(!"2101".equals(KbankProductCode.substring(0, 4))){
	        				throw new LMSException(203);
	        			}
	        			account.setAccountLevel("02");
	        			account.setKbankProductCode("CA");
	        		}
	        		
	        		if(StringUtils.isBlank(CBS1183I01.getCBSAccount().getRefAcctId().getValue())){
        				account.setAccountNameTh(CBS1183I01.getCBSAccount().getAcctNameTh());
        				account.setAccountNameEn(CBS1183I01.getCBSAccount().getAcctNameEn().getValue());
        				
        				com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response CIS0367I01 = CISService.getServiceCIS0367I01(accountNo);
        		        
        		        if(0 == CIS0367I01.getEAIHeader().getStatus()){
        		        	account.setCisId(CIS0367I01.getCISCustomers().getCISCustsVect().getCISCustomer().get(0).getNum());
        		        	if(StringUtils.isNotEmpty(clientCisId)){
        						if(!clientCisId.equals(account.getCisId())){
        							List<MapErrorMsg> mapError = new ArrayList<MapErrorMsg>();
        			        		mapError.add(new MapErrorMsg("@CisIdClient", clientCisId));
        			        		mapError.add(new MapErrorMsg("@CisIdAccount", account.getCisId()));
        			        		throw new LMSException(mapError, 205);
        						}
        					}
        		        	com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response KBANK1554I01 = KBANKService.getServiceKBANK1554I01(accountNo);
            		        if("00".equals(KBANK1554I01.getKBankHeader().getStatusCode())){
            		        	if("N".equals(KBANK1554I01.getCVRSInfo().getSanctionFlg())){
            		        		account.setActiveStatus("Y");
            		        	}else{
            		        		throw new LMSException(204);
            		        	}
            		        }else{
            		        	throw new WebServiceException(AppUtils.getErrorMsgWs(KBANK1554I01.getKBankHeader().getErrorVect().getError().get(0).getErrorCode(), KBANK1554I01.getKBankHeader().getErrorVect().getError().get(0).getErrorDesc()));
            		        }
        		        }else{
        		        	throw new WebServiceException(AppUtils.getErrorMsgWs(CIS0367I01.getEAIHeader().getReasonCode(), CIS0367I01.getEAIHeader().getReasonDesc()));
        		        }
        			}else{
        				throw new LMSException(new MapErrorMsg("@RefAcctId", CBS1183I01.getCBSAccount().getRefAcctId().getValue()), 207);
        			}
	        	}else{
	        		throw new LMSException(201);
	        	}
	        }else {
	        	if("10".equals(CBS1183I01.getKBankHeader().getStatusCode())){
	        		if("E0002".equals(CBS1183I01.getKBankHeader().getErrorVect().getError().get(0).getErrorCode())){
	        			throw new LMSException(206);
	        		}
	        	}	
	        	throw new WebServiceException(AppUtils.getErrorMsgWs(CBS1183I01.getKBankHeader().getErrorVect().getError().get(0).getErrorCode(), CBS1183I01.getKBankHeader().getErrorVect().getError().get(0).getErrorDesc()));
	        }
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return account;
	}
	
	@RequestMapping(value = "saveMultipleAccount", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveMultipleAccount(@RequestBody List<AccountMst> accounts,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			for(AccountMst account : accounts){
				account.setCreatedBy(claims.getSubject());
				account.setLastUpdatedBy(claims.getSubject());
				account.setAuthorizedBy(claims.getSubject());
				accountService.saveAccountByMaker(account, "ADD", "");
			}
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "approveAccountAll", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public String approveAccountAll(@RequestBody List<AccountMst> accounts,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			for(AccountMst accountMst : accounts){
				accountMst.setLastUpdatedBy(claims.getSubject());
				accountMst.setAuthorizedBy(claims.getSubject());
				accountMst.setAuthorizeStatus("Y");
				accountService.acceptAccountByAccountId(accountMst);
			}
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectAccountAll", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public String rejectAccountAll(@RequestBody String str,
			final HttpServletRequest request) throws LMSException  {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			List<AccountMst> accounts = mapper.convertValue(node.get("accounts"), new TypeReference<List<AccountMst>>(){});
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			for(AccountMst accountMst : accounts){
				accountMst.setLastUpdatedBy(claims.getSubject());
				accountMst.setRejectReason(rejectReason);
				accountMst.setAuthorizeStatus("N");
				accountService.rejectAccountById(accountMst);
			}
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getAllAccountIdFromSearch", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public List<AccountMst> getAllAccountIdFromSearch(@RequestBody AccountMst accountMst) throws LMSException {
		List<AccountMst> result = null;
		try {
			accountMst.setAccountLevel("03");
			result = accountService.getAllAccountIdFromSearch(accountMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}	
	
	@RequestMapping(value = "getAllAccountActiveByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public List<AccountMst> getAccountActiveByCorpCode(@PathVariable String corpCode) throws LMSException {
		List<AccountMst> result = null;
		try {
			result = accountService.getAllAccountActiveByCorpCode(corpCode);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}	
	
}
