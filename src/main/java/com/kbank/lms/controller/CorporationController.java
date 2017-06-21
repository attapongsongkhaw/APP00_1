package com.kbank.lms.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.ResponseListJson;
import com.kbank.lms.service.CorporationService;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/corporation")
public class CorporationController {

	@Autowired
	@Qualifier("corporationService")
	private CorporationService corporationService;
	
	private static final Logger logger = Logger.getLogger(CorporationController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "saveCorporation", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveCorporation(@RequestBody final String str,
			final HttpServletRequest request) throws LMSException {
		Claims claims = (Claims) request.getAttribute(CLAIMSTR);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			CorporationMst corporationMst = mapper.convertValue(node.get("corporationMst"), CorporationMst.class);
			AccountMst savingAccount = mapper.convertValue(node.get("savingAccount"), AccountMst.class);
			AccountMst currentAccount = mapper.convertValue(node.get("currentAccount"), AccountMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			corporationMst.setCreatedBy(claims.getSubject());
			corporationMst.setLastUpdatedBy(claims.getSubject());
			savingAccount.setCreatedBy(claims.getSubject());
			savingAccount.setLastUpdatedBy(claims.getSubject());
			savingAccount.setCorpCode(corporationMst.getCorpCode());
			currentAccount.setCreatedBy(claims.getSubject());
			currentAccount.setLastUpdatedBy(claims.getSubject());
			currentAccount.setCorpCode(corporationMst.getCorpCode());
			corporationService.saveCorporationByMaker(corporationMst, savingAccount, currentAccount, mode, type);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "checkCorpDuplicate/{corpCode}", method = RequestMethod.GET)
	public int checkAccountDuplicate(@PathVariable final String corpCode) throws LMSException {
		int result = 0;
		try {
			result = corporationService.checkCorpDuplicate(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "searchCorporationPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<CorporationMst> searchCorporation(@RequestBody SearchDataTable<CorporationMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<CorporationMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.CORPTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = corporationService.searchCorporation(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "searchCorporationActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<CorporationMst> searchCorporationActive(@RequestBody SearchDataTable<CorporationMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<CorporationMst> result = new DataTable<>();
		try{
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.CORPTABLEMST);
			result = corporationService.searchCorporation(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "getCorporationPendingByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public ResponseListJson<CorporationMst, AccountMst>  getCorporationTmpByCorpCode(@PathVariable String corpCode) throws LMSException {
		ResponseListJson<CorporationMst, AccountMst> result = new ResponseListJson<>();
		try {	
			result = corporationService.getCorporationPendingByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "getCorporationActiveByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public ResponseListJson<CorporationMst, AccountMst> getCorporationMstByCorpCode(@PathVariable String corpCode) throws LMSException {
		ResponseListJson<CorporationMst, AccountMst> result = new ResponseListJson<>();
		try {	
			result = corporationService.getCorporationActiveByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "deleteCorporationByCorpCode/{corpCode}", method = RequestMethod.GET)
	public String deleteCorporationByCorpCode(@PathVariable String corpCode,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			CorporationMst corporationMst = new CorporationMst();
			corporationMst.setCorpCode(corpCode);
			corporationMst.setLastUpdatedBy(claims.getSubject());
			corporationMst.setAuthorizeStatus("W");
	    	corporationMst.setOperationFlag("D");
			corporationService.deleteCorporationByCorpCode(corporationMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectCorporationByCorpCode", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectCorporationByCorpCode(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			String corpCode = mapper.convertValue(node.get("corpCode"), String.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			CorporationMst corporationMst = new CorporationMst();
			corporationMst.setCorpCode(corpCode);
			corporationMst.setLastUpdatedBy(claims.getSubject());
	    	corporationMst.setOperationFlag(operationFlag);
	    	corporationMst.setRejectReason(rejectReason);
	    	corporationMst.setAuthorizeStatus("N");
			corporationService.rejectCorporationByCorpCode(corporationMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "cancelCorporationByCorpCode/{corpCode}", method = RequestMethod.GET)
	public String cancelCorporationByCorpCode(@PathVariable String corpCode) throws LMSException {
		try {
			corporationService.cancelCorporationByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "approveCorporationByCorpCode/{corpCode}/{operationFlag}", method = RequestMethod.GET)
	public String approveCorporationByCorpCode(@PathVariable String corpCode,
			@PathVariable String operationFlag,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			CorporationMst corporationMst = new CorporationMst();
			corporationMst.setCorpCode(corpCode);
			corporationMst.setLastUpdatedBy(claims.getSubject());
			corporationMst.setOperationFlag(operationFlag);
			corporationMst.setAuthorizedBy(claims.getSubject());
			corporationMst.setAuthorizeStatus("Y");
			corporationService.acceptCorporationByCorpCode(corporationMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
}
