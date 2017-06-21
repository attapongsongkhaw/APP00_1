package com.kbank.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.kbank.lms.model.InstructionMst;
import com.kbank.lms.service.AccountService;
import com.kbank.lms.service.FunctionService;
import com.kbank.lms.service.InstructionService;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.Convert;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/instruction")
public class InstructionController {

	@Autowired
	private InstructionService instructionService;
	
	@Autowired
	private FunctionService functionService;
	
	@Autowired
	private AccountService accountService;
	
	private static final Logger logger = Logger.getLogger(InstructionController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "saveInstruction", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveInstruction(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			JsonNode node = mapper.readTree(str);
			InstructionMst instucMst = mapper.convertValue(node.get("instructionMst"), InstructionMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			instucMst.setCreatedBy(claims.getSubject());
			instucMst.setLastUpdatedBy(claims.getSubject());
			if(StringUtils.isNotBlank(instucMst.getEffectiveDateStr())){
				instucMst.setEffectiveDate(Convert.parseDate(instucMst.getEffectiveDateStr()));
			}
			instucMst.setActiveStatus("Y");
			if(claims.get("role").equals(Constants.MAKER)){
				 instructionService.saveInstructionByMaker(instucMst, mode, type);
			}
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "searchInstructionPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<InstructionMst> searchInstruction(@RequestBody SearchDataTable<InstructionMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<InstructionMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.INSTRUCTIONTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = instructionService.searchInstruction(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	@RequestMapping(value = "searchInstructionActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<InstructionMst> searchInstructionActive(@RequestBody SearchDataTable<InstructionMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<InstructionMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.INSTRUCTIONTABLEMST);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("Y");
				searchDataTable.getDataSearch().setSyncStatus("S");
			}
			result = instructionService.searchInstruction(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	@RequestMapping(value = "approveInstructionByInstructionId/{instructionId}/{operationFlag}", method = RequestMethod.GET)
	public String approveInstructionByInstructionId(@PathVariable int instructionId,
			@PathVariable String operationFlag,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			InstructionMst instrucMst = new InstructionMst();
			instrucMst.setInstructionId(instructionId);
			instrucMst.setLastUpdatedBy(claims.getSubject());
			instrucMst.setOperationFlag(operationFlag);
			instrucMst.setAuthorizedBy(claims.getSubject());
			instrucMst.setAuthorizeStatus("Y");
			instructionService.acceptInstructionByInstructionId(instrucMst);
		}  catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	@RequestMapping(value = "rejectInstructionByInstructionId", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectInstructionByInstructionId(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			int instructionId = mapper.convertValue(node.get("instructionId"), int.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			InstructionMst instrucMst = new InstructionMst();
			instrucMst.setInstructionId(instructionId);
			instrucMst.setLastUpdatedBy(claims.getSubject());
			instrucMst.setOperationFlag(operationFlag);
			instrucMst.setRejectReason(rejectReason);
			instrucMst.setAuthorizeStatus("N");
			instrucMst.setAuthorizedBy(claims.getSubject());
			instructionService.rejectInstructionByInstructionId(instrucMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getInstructionPendingByInstructionId/{instructionId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public List<InstructionMst> getInstructionPendingByInstructionId(@PathVariable int instructionId) throws LMSException {
		List<InstructionMst> result = null;
		try {
			result = instructionService.getInstructionPendingByInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "getInstructionActiveByInstructionId/{instructionId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public List<InstructionMst> getInstructionActiveByInstructionId(@PathVariable int instructionId) throws LMSException {
		List<InstructionMst> result = null;
		try {
			result = instructionService.getInstructionActiveByInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "deleteInstructionByInstructionId/{InstructionId}", method = RequestMethod.GET)
	public String deleteInstructionByInstructionId(@PathVariable int instructionId,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			InstructionMst instrucMst = new InstructionMst();
			instrucMst.setInstructionId(instructionId);
			instrucMst.setLastUpdatedBy(claims.getSubject());
			instrucMst.setAuthorizeStatus("W");
			instrucMst.setOperationFlag("D");
			instructionService.deleteInstructionByInstructionId(instrucMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}

	@RequestMapping(value = "cancelInstructionByInstructionId/{instructionId}", method = RequestMethod.GET)
	public String cancelInstructionByInstructionId(@PathVariable int instructionId) throws LMSException {
		try {
			instructionService.cancelInstructionByInstructionId(instructionId);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getInstructionByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public List<InstructionMst> getInstructionByCorpCode(@PathVariable String corpCode) throws LMSException {
		List<InstructionMst> result = null;
		try {
			result = instructionService.getInstructionByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "getInstructionMstByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public List<InstructionMst> getInstructionMstByCorpCode(@PathVariable String corpCode) throws LMSException {
		List<InstructionMst> result = null;
		try {
			result = instructionService.getInstructionMstByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "saveMultipleInstruction", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveMultipleInstruction(@RequestBody List<InstructionMst> instructions,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			for(InstructionMst instruction : instructions){
				//functionService.getFunctionPendingByCorpCode(corpCode);
				instruction.setCreatedBy(claims.getSubject());
				instruction.setLastUpdatedBy(claims.getSubject());
				instruction.setAuthorizedBy(claims.getSubject());
				instructionService.saveInstructionByMaker(instruction, "ADD", "");
			}
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getDefaultInstruction/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public InstructionMst getDefaultInstruction(@PathVariable String corpCode) throws LMSException {
		InstructionMst instruction;
		try {
			AccountMst account = accountService.getAccountMst(corpCode, "01");
			instruction = new InstructionMst();
			if(account != null){
				instruction.setMemberAccountId(account.getAccountId());
				instruction.setMemberAccount(account.getAccountNo());
			}
			instruction.setInstructionName("Root Account");
			instruction.setPriority(1);
			instruction.setDirection("N");
			instruction.setOperationFlag("N");
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return instruction;
	}
	
}