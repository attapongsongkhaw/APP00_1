package com.kbank.lms.controller;

import java.math.BigDecimal;

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
import com.kbank.lms.model.InterestMst;
import com.kbank.lms.service.InterestService;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/interest")
public class InterestController {

	private static final Logger logger = Logger.getLogger(InterestController.class);
	private static final String CLAIMSTR = "claims";
	
	@Autowired
	@Qualifier("interestService")
	InterestService interestService;
	
	@RequestMapping(value = "searchInterestPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<InterestMst> searchInterestPending(@RequestBody SearchDataTable<InterestMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<InterestMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.INTERESTTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = interestService.searchInterest(searchDataTable);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "searchInterestActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<InterestMst> searchInterestActive(@RequestBody SearchDataTable<InterestMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<InterestMst> result = new DataTable<>();
		try{
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.INTERESTTABLEMST);
			result = interestService.searchInterest(searchDataTable);
		}catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "saveInterest", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveInterest(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		Claims claims = (Claims) request.getAttribute(CLAIMSTR);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			InterestMst interestMst = mapper.convertValue(node.get("interestMst"), InterestMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			interestMst.setCreatedBy(claims.getSubject());
			interestMst.setLastUpdatedBy(claims.getSubject());
			interestService.saveInterestByMaker(interestMst, mode, type);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex); 
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "checkInterestDuplicate", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public int checkInterestDuplicate(@RequestBody final InterestMst interestMst
			) throws LMSException {
		int result = 0;
		try {
			result = interestService.checkInterestDuplicate(interestMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex); 
		}
		return result;
	}
	
	@RequestMapping(value = "getInterestPending/{interestType}/{interestRate}/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public InterestMst  getAccountPendingById(@PathVariable String interestType,
			@PathVariable BigDecimal interestRate,
			@PathVariable String corpCode) throws LMSException {
		InterestMst result = null;
		try {	
			InterestMst interestMst = new InterestMst();
			interestMst.setInterestType(interestType);
			interestMst.setInterestRate(interestRate);
			interestMst.setCorpCode(corpCode);
			result = interestService.getInterestPending(interestMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getInterestActive/{interestType}/{interestRate}/{corpCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public InterestMst getAccountActiveById(@PathVariable String interestType,
			@PathVariable BigDecimal interestRate,
			@PathVariable String corpCode) throws LMSException {
		InterestMst result = null;
		try {	
			InterestMst interestMst = new InterestMst();
			interestMst.setInterestType(interestType);
			interestMst.setInterestRate(interestRate);
			interestMst.setCorpCode(corpCode);
			result = interestService.getInterestActive(interestMst);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
}
