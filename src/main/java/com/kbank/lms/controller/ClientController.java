package com.kbank.lms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
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
import com.kbank.lms.model.ClientMst;
import com.kbank.lms.service.ClientService;
import com.kbank.lms.utils.Constants;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/apis/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	private static final Logger logger = Logger.getLogger(ClientController.class);
	private static final String CLAIMSTR = "claims";
	
	@RequestMapping(value = "saveClient", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String saveClient(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		Claims claims = (Claims) request.getAttribute(CLAIMSTR);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			ClientMst clientMst = mapper.convertValue(node.get("clientMst"), ClientMst.class);
			String mode = mapper.convertValue(node.get("mode"), String.class);
			String type = mapper.convertValue(node.get("type"), String.class);
			clientMst.setCreatedBy(claims.getSubject());
			clientMst.setLastUpdatedBy(claims.getSubject());
			
			if(claims.get("role").equals(Constants.MAKER)){
				clientService.saveClientByMaker(clientMst, mode, type);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "checkClientDuplicate/{clientCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public int checkClientDuplicate(@PathVariable final String clientCode) throws LMSException {
		int result = 0;
		try { 
			result = clientService.checkClientDuplicate(clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "searchClientPending", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<ClientMst> searchClient(@RequestBody SearchDataTable<ClientMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<ClientMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.CLIENTTABLETMP);
			if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
				searchDataTable.getDataSearch().setAuthorizeStatus("W");
			}
			result = clientService.searchClient(searchDataTable);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "searchClientActive", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	public DataTable<ClientMst> searchClientActive(@RequestBody SearchDataTable<ClientMst> searchDataTable,
			final HttpServletRequest request) throws LMSException {
		DataTable<ClientMst> result = new DataTable<>();
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			searchDataTable.setRoleUser(claims.get("role").toString());
			searchDataTable.setTableType(Constants.CLIENTTABLEMST);
			result = clientService.searchClient(searchDataTable);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "approveClientByClientCode/{clientCode}/{operationFlag}", method = RequestMethod.GET)
	public String approveClientByClientCode(@PathVariable String clientCode,
			@PathVariable String operationFlag,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			ClientMst clientMst = new ClientMst();
			clientMst.setClientCode(clientCode);
			clientMst.setLastUpdatedBy(claims.getSubject());
			clientMst.setOperationFlag(operationFlag);
			clientMst.setAuthorizedBy(claims.getSubject());
			clientMst.setAuthorizeStatus("Y");
			clientService.acceptClientByClientCode(clientMst);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "rejectClientByClientCode", method = RequestMethod.POST, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String rejectClientByClientCode(@RequestBody String str,
			final HttpServletRequest request) throws LMSException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(str);
			String rejectReason = mapper.convertValue(node.get("rejectReason"), String.class);
			String clientCode = mapper.convertValue(node.get("clientCode"), String.class);
			String operationFlag = mapper.convertValue(node.get("operationFlag"), String.class);
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			ClientMst clientMst = new ClientMst();
			clientMst.setClientCode(clientCode);
			clientMst.setLastUpdatedBy(claims.getSubject());
			clientMst.setOperationFlag(operationFlag);
			clientMst.setRejectReason(rejectReason);
			clientMst.setAuthorizeStatus("N");
			clientMst.setAuthorizedBy(claims.getSubject());
			clientService.rejectClientByClientCode(clientMst);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getClientPendingByClientCode/{clientCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public ClientMst getClientPendingByClientCode(@PathVariable String clientCode) throws LMSException {
		ClientMst result = null;
		try {
			result = clientService.getClientPendingByClientCode(clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "getClientActiveByClientCode/{clientCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public ClientMst getClientActiveByClientCode(@PathVariable String clientCode) throws LMSException {
		ClientMst result = null;
		try {
			result = clientService.getClientActiveByClientCode(clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "deleteClientByClientCode/{clientCode}", method = RequestMethod.GET)
	public String deleteClientByClientCode(@PathVariable String clientCode,
			final HttpServletRequest request) throws LMSException {
		try {
			Claims claims = (Claims) request.getAttribute(CLAIMSTR);
			ClientMst clientMst = new ClientMst();
			clientMst.setClientCode(clientCode);
			clientMst.setLastUpdatedBy(claims.getSubject());
			clientMst.setAuthorizeStatus("W");
			clientMst.setOperationFlag("D");
			clientService.deleteClientByClientCode(clientMst);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "cancelClientByClientCode/{clientCode}", method = RequestMethod.GET)
	public String cancelClientByClientCode(@PathVariable String clientCode) throws LMSException {
		try {
			clientService.cancelClientByClientCode(clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return Constants.SUCCESS;
	}
	
	@RequestMapping(value = "getCisByClientCode/{clientCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public String getCisByClientCode(@PathVariable String clientCode) throws LMSException {
		Map<String, String> map = new HashMap<String, String>();
		try {
			String result = clientService.getCisByClientCode(clientCode);
			map.put("CIS", result);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return JSONObject.toJSONString(map);
	}
	
}
