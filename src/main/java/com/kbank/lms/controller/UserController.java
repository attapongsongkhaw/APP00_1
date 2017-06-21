package com.kbank.lms.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.kbank.lms.model.UserMst;
import com.kbank.lms.service.UserService;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "searchUserPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<UserMst> searchUserPending(@RequestBody SearchDataTable<UserMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<UserMst> result = new DataTable<>();
		try{
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.USERTABLETMP);
			result = userService.searchUser(searchDataTable);
		}catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "searchUserActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<UserMst> searchUserActive(@RequestBody SearchDataTable<UserMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<UserMst> result = new DataTable<>();
		try{
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.USERTABLEMST);
			result = userService.searchUser(searchDataTable);
		}catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getUserPendingById/{userId:.*}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public UserMst  getAccountPendingById(@PathVariable String userId) throws LMSException {
		UserMst result = null;
		try {	
			result = userService.getUserTmpByUserLogin(userId);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "getUserActiveById/{userId:.*}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public UserMst  getAccountActiveById(@PathVariable String userId) throws LMSException {
		UserMst result = null;
		try {	
			result = userService.getUserMstByUserLogin(userId);
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex);  
		}
		return result;
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveCorporation(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		Claims claims = (Claims) request.getAttribute(CLAIMSTR);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			UserMst userMst = mapper.convertValue(node.get("userMst"), UserMst.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			userMst.setCreatedBy(claims.getSubject());
			userMst.setLastUpdatedBy(claims.getSubject());
			userService.saveUserByMaker(userMst, type, mode);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectUserById", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectCorporationByCorpCode(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			String userId = mapper.convertValue(node.get("userId"), String.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			UserMst userMst = new UserMst();
			userMst.setUserId(userId);
			userMst.setLastUpdatedBy(claims.getSubject());
			userMst.setOperationFlag(operationFlag);
			userMst.setRejectReason(rejectReason);
			userMst.setAuthorizeStatus("N");
			userService.rejectUserByUserId(userMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "approveUserByUserId/{userId:.*}/{operationFlag}", method = RequestMethod.GET)
	public String approveCorporationByCorpCode(@PathVariable String userId,
			@PathVariable String operationFlag,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			UserMst userMst = new UserMst();
			userMst.setUserId(userId);
			userMst.setLastUpdatedBy(claims.getSubject());
			userMst.setOperationFlag(operationFlag);
			userMst.setAuthorizedBy(claims.getSubject());
			userMst.setAuthorizeStatus("Y");
			userService.acceptUserByUserId(userMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "cancelUserByUserId/{userId}", method = RequestMethod.GET)
	public String cancelCorporationByCorpCode(@PathVariable String userId) throws LMSException {
		try {
			userService.canceluserByUserId(userId);
		} catch (Exception e) {
    		logger.error(e);
    		throw new LMSException(e);
        }
		return Constants.SUCCESS;
	}
}
