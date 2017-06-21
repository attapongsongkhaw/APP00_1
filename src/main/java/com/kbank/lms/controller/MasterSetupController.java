package com.kbank.lms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.model.FuncMaster;
import com.kbank.lms.service.MasterSetupService;

@RestController
@RequestMapping("/apis/masterSetup")
public class MasterSetupController {

	@Autowired
	@Qualifier("masterSetupService")
	private MasterSetupService masterSetupService;
	
	private static final Logger logger = Logger.getLogger(MasterSetupController.class);
	
	@RequestMapping(value = "loadCorporation", method = RequestMethod.GET)
	public List<Map<String, Object>> loadCorporation() throws LMSException  {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getCorporationForDropdown();
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadFunctionMst", method = RequestMethod.GET)
	public List<Map<String, Object>> loadFunctionMst() throws LMSException  {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getFunctionMst();
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "getFuncMasterById/{funcCode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public FuncMaster getFuncMstById(@PathVariable String funcCode) throws LMSException {
		FuncMaster result = null;
		try {
			result = masterSetupService.getFuncMasterById(funcCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	
	@RequestMapping(value = "loadCorporationFunc", method = RequestMethod.GET)
	public List<Map<String, Object>> loadCorporationFunc(@RequestParam(value = "corpCode", required = false) String corpCode) throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getCorporationFuncForDropdown(corpCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadChargeType", method = RequestMethod.GET)
	public List<Map<String, Object>> loadChargType() throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getLookupForDropdown("CHARGE_TYPE");
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadChargeFreq", method = RequestMethod.GET)
	public List<Map<String, Object>> loadChargFreq() throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getLookupForDropdown("CHARGE_FREQ");
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadClientFromCorp/{corpCode}", method = RequestMethod.GET)
	public List<Map<String, Object>> loadClientFromCorp(@PathVariable String corpCode) throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getClientFromCorpForDropdown(corpCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadAccountLevel", method = RequestMethod.GET)
	public List<Map<String, Object>> loadAccountLevel() throws LMSException {
		List<Map<String, Object>> result = null;
		try {	
			result = masterSetupService.getLookupForDropdown("ACCOUNT_LEVEL");
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadMemberAccount/{corpCode}", method = RequestMethod.GET)
	public List<Map<String, Object>> loadMemberAccount(
			@PathVariable String corpCode,
			@RequestParam(value = "clientCode", required=false) String clientCode) throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getMemberAccountForDropdown(corpCode, clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadMasterAccount/{corpCode}", method = RequestMethod.GET)
	public List<Map<String, Object>> loadMasberAccount(
			@PathVariable final String corpCode,
			@RequestParam(value = "clientCode", required=false) String clientCode) throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getMasterAccountForDropdown(corpCode, clientCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "MasterChangeReport", method = RequestMethod.POST)
	public void loadMasberAccount(@RequestParam("optionsRadios") final String optionsRadios,
			@RequestParam("requestDate") final String requestDate,
			final HttpServletRequest request,
			final HttpServletResponse response) throws LMSException {
		try {
			String filePath = "";
			if(optionsRadios != null && ! "".equals(optionsRadios)){
				DateFormat fromFormat = new SimpleDateFormat("dd/MM/yyyy");
				fromFormat.setLenient(false);
				DateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
				toFormat.setLenient(false);
				Date date = fromFormat.parse(requestDate);
				String	sDate = toFormat.format(date);
				filePath = "/home/jbusr/LMSBatchSync/LMSREGFUNC_"+sDate+".xls";
				if("account".equalsIgnoreCase(optionsRadios)){
					filePath = "/home/jbusr/LMSBatchSync/LMSREGACCT_"+sDate+".xls";
				}
			}
			
			if(new File(filePath).exists()){
				File downloadFile = new File(filePath);
		        FileInputStream inStream = new FileInputStream(downloadFile);
		        ServletContext context = request.getServletContext();
		        String mimeType = context.getMimeType(filePath);
		        if (mimeType == null) {
		        	mimeType = "application/octet-stream";
		        }
		        response.setContentType(mimeType);
		        response.setContentLength((int) downloadFile.length());// forces download
		        String headerKey = "Content-Disposition";
		        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		        response.setHeader(headerKey, headerValue);
		        // obtains response's output stream
		        OutputStream outStream = response.getOutputStream();
		        byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		        while ((bytesRead = inStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }
		        inStream.close();
		        outStream.close();
			}
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
	}
	
	@RequestMapping(value = "ValidateFile", method = RequestMethod.POST)
	public String validateFile(@RequestParam("reportDate") final String reportDate,
			@RequestParam("reportName") final String reportName,
			final HttpServletResponse response) throws LMSException {
		try {
			if(reportName != null && ! "".equals(reportName)){
				DateFormat fromFormat = new SimpleDateFormat("dd/MM/yyyy");
				fromFormat.setLenient(false);
				DateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
				toFormat.setLenient(false);
				Date date = fromFormat.parse(reportDate);
				String sDate = toFormat.format(date);
				String filePath = "/home/jbusr/LMSBatchSync/LMSREGFUNC_"+sDate+".xls";
				if("account".equalsIgnoreCase(reportName)){
					filePath = "/home/jbusr/LMSBatchSync/LMSREGACCT_"+sDate+".xls";
				}
				response.getWriter().write("F");
				if(new File(filePath).exists()){
					response.getWriter().write("T");
				}
			}	
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return "1";
	}
	
	@RequestMapping(value = "getEndingBalanceByDirection/{direction}", method = RequestMethod.GET, produces="application/json;charset=UTF-8",headers = {"Accept=text/xml, application/json"})
	@ResponseBody
	public FuncMaster getEndingBalanceByDirection(@PathVariable String direction) throws LMSException {
		FuncMaster result = null;
		try {
			result = masterSetupService.getEndingBalanceByDirection(direction);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadUserRoleBank", method = RequestMethod.GET)
	public List<Map<String, Object>> loadUserRoleBank() throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getUserRoleBankForDropdown();
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}

	@RequestMapping(value = "loadSweepRateByCorp/{corpCode}", method = RequestMethod.GET)
	public List<Map<String, Object>> loadSweepRateByCorp(@PathVariable String corpCode) throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getSweepRateForDropdown(corpCode);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}

	@RequestMapping(value = "loadUserRoleCust", method = RequestMethod.GET)
	public List<Map<String, Object>> loadUserRoleCust() throws LMSException {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getUserRoleCustForDropdown();
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "loadDeficitRateByCorp/{corpCode}", method = RequestMethod.GET)
	public List<Map<String, Object>> loadDeficitRateByCorp(@PathVariable String corpCode) throws LMSException{
		List<Map<String, Object>> result = null;
		try{
			result = masterSetupService.getDeficitRateForDropDown(corpCode);
		}catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	@RequestMapping(value = "getSystemMstByKey/{key}", method = RequestMethod.GET)
	public Map<String, Object> getSystemMstByKey(@PathVariable String key) throws LMSException {
		Map<String, Object> result = null;
		try {
			result = masterSetupService.getSystemMstByKey(key);
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
}
