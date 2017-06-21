package com.kbank.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.VisitPathMst;
import com.kbank.lms.service.VisitPathService;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/path")
public class VisitPathController {
	
	@Autowired
	private VisitPathService visitPathService;
	
	private static final Logger logger = Logger.getLogger(VisitPathController.class);
	private static final String CLAIMSTR = "claims";

	@RequestMapping(value = "searchVisitPathPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<VisitPathMst> searchVisitPathPending(@RequestBody SearchDataTable<VisitPathMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<VisitPathMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.VISITPATHTABLETMP);
			result = visitPathService.searchVisitPath(searchDataTable);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "searchVisitPathActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<VisitPathMst> searchVisitPathActive(@RequestBody SearchDataTable<VisitPathMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<VisitPathMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.VISITPATHTABLEMST);
			result = visitPathService.searchVisitPath(searchDataTable);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getVisitPathDetail/{accountId}/{type}", method = RequestMethod.GET)
	public List<VisitPathMst> getVisitPathDetail(@PathVariable int accountId,
			@PathVariable String type) throws LMSException {
		List<VisitPathMst> result = null;
		try {
			type = ("PENDING".equals(type.toUpperCase())) ? Constants.VISITPATHTABLETMP : Constants.VISITPATHTABLEMST;
			result = visitPathService.getVisitPathDetail(accountId, type);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getCorporationNameForVisitPath/{corpCode}", method = RequestMethod.GET)
	public CorporationMst getCorporationNameForVisitPath(@PathVariable String corpCode) throws LMSException {
		CorporationMst result = null;
		try {
			result = visitPathService.getCorporationNameForVisitPath(corpCode);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
}
