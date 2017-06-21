package com.kbank.lms.controller;

import java.util.Date;
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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.FunctionMst;
import com.kbank.lms.model.InstructionMst;
import com.kbank.lms.service.FunctionService;
import com.kbank.lms.service.InstructionService;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.Convert;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/function")
public class FunctionController {

	@Autowired
	private FunctionService functionService;
	
	@Autowired
	private InstructionService instructionService;
	
	private static final Logger logger = Logger.getLogger(FunctionController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "saveFunction", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveFunction(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			JsonNode node = mapper.readTree(str);
			FunctionMst funcMst = mapper.convertValue(node.get("functionMst"), FunctionMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			
			JavaType t = mapper.getTypeFactory().constructCollectionType(List.class, InstructionMst.class);
			List<InstructionMst> instructions = mapper.convertValue(node.get("instructions"), t);
			
			funcMst.setCreatedBy(claims.getSubject());
			funcMst.setLastUpdatedBy(claims.getSubject());
			if(StringUtils.isNotBlank(funcMst.getEffectiveDateStr())){
				funcMst.setEffectiveDate(Convert.parseDate(funcMst.getEffectiveDateStr()));
			}
			//funcMst.setActiveStatus("Y");
			if(claims.get("role").equals(Constants.MAKER)){
				functionService.saveFunctionByMaker(funcMst, mode, type);
			}
			
			FunctionMst f = functionService.getFunctionPendingByCorpCode(funcMst.getCorpCode());
			
			for(InstructionMst instruction : instructions) {
				if("P".equals(type)){
					if("DD".equals(instruction.getOperationFlag())) {
						if(instruction.getInstructionId() > 0) {
							instructionService.cancelInstructionByInstructionId(instruction.getInstructionId());
						}
					} else {
						instruction.setEffectiveDate(f.getEffectiveDate());
						instruction.setAuthorizeStatus(f.getAuthorizeStatus());
						//instruction.setOperationFlag(f.getOperationFlag());
						instruction.setActiveStatus("Y");
						instruction.setCreatedBy(claims.getSubject());
						instruction.setCreatedDate(new Date());
						instruction.setLastUpdatedBy(claims.getSubject());
						
						instructionService.saveInstructionByMaker(instruction, mode, type);
					}
				} else if("A".equals(type)){
					if(!"DD".equals(instruction.getOperationFlag())) {
						instruction.setEffectiveDate(f.getEffectiveDate());
						instruction.setAuthorizeStatus(f.getAuthorizeStatus());
						instruction.setActiveStatus("Y");
						instruction.setCreatedBy(claims.getSubject());
						instruction.setCreatedDate(new Date());
						instruction.setLastUpdatedBy(claims.getSubject());
						
						instructionService.saveInstructionByMaker(instruction, mode, type);
					}
				}
				
			}
			
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "searchFunctionPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<FunctionMst> searchFunction(@RequestBody SearchDataTable<FunctionMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<FunctionMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.FUNCTIONTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = functionService.searchFunction(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "searchFunctionActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<FunctionMst> searchFunctionActive(@RequestBody SearchDataTable<FunctionMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<FunctionMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.FUNCTIONTABLEMST);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("Y");
				searchDataTable.getDataSearch().setSyncStatus("S");
			}
			result = functionService.searchFunction(searchDataTable);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "approveFunctionByCorpCode/{corpCode}/{operationFlag}", method = RequestMethod.GET)
	public String approveFunctionByCorpCode(@PathVariable String corpCode,
			@PathVariable String operationFlag,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			FunctionMst funcMst = new FunctionMst();
			funcMst.setCorpCode(corpCode);
			funcMst.setLastUpdatedBy(claims.getSubject());
			funcMst.setOperationFlag(operationFlag);
			funcMst.setAuthorizedBy(claims.getSubject());
			funcMst.setAuthorizeStatus("Y");
			functionService.acceptFunctionByCorpCode(funcMst);
		}  catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectFunctionByCorpCode", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectFunctionByCorpCode(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			String corpCode = mapper.convertValue(node.get("corpCode"), String.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			FunctionMst funcMst = new FunctionMst();
			funcMst.setCorpCode(corpCode);
			funcMst.setLastUpdatedBy(claims.getSubject());
			funcMst.setOperationFlag(operationFlag);
			funcMst.setRejectReason(rejectReason);
			funcMst.setAuthorizeStatus("N");
			funcMst.setAuthorizedBy(claims.getSubject());
			functionService.rejectFunctionByCorpCode(funcMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getFunctionPendingByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public FunctionMst getFunctionPendingByCorpCode(@PathVariable String corpCode) throws LMSException {
		FunctionMst result = null;
		try {
			result = functionService.getFunctionPendingByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return result;
	}
	
	@RequestMapping(value = "getFunctionActiveByCorpCode/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public FunctionMst getFunctionActiveByCorpCode(@PathVariable String corpCode) throws LMSException {
		FunctionMst result = null;
		try {
			result = functionService.getFunctionActiveByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		//throw new LMSException(e);
    		result = new FunctionMst();
        }
		return result;
	}
	
	@RequestMapping(value = "deleteFunctionByCorpCode/{corpCode}", method = RequestMethod.GET)
	public String deleteFunctionByCorpCode(@PathVariable String corpCode,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			FunctionMst funcMst = new FunctionMst();
			funcMst.setCorpCode(corpCode);
			funcMst.setLastUpdatedBy(claims.getSubject());
			funcMst.setAuthorizeStatus("W");
			funcMst.setOperationFlag("D");
			functionService.deleteFunctionByCorpCode(funcMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "cancelFunctionByCorpCode/{corpCode}", method = RequestMethod.GET)
	public String cancelFunctionByCorpCode(@PathVariable String corpCode) throws LMSException {
		try {
			functionService.cancelFunctionByCorpCode(corpCode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getEffectiveDate", method = RequestMethod.GET)
	@ResponseBody
	public String getEffectiveDate(
			final HttpServletRequest request) throws LMSException {
		java.util.Date d = new java.util.Date();
		int days = d.getHours() > 17 ? 2 : 1 ;
		java.util.Calendar c = java.util.Calendar.getInstance(); 
		c.setTime(d); 
		c.add(java.util.Calendar.DATE, days);
		d = c.getTime();
		java.sql.Date dd = new java.sql.Date(d.getTime());
		return Convert.parseString(dd);
	}
	
}
