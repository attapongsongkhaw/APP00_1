package com.kbank.lms.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.dao.MasterSetupDao;
import com.kbank.lms.model.FuncMaster;

@Service("masterSetupService")
public class MasterSetupServiceImpl implements MasterSetupService {

	@Autowired
	@Qualifier("masterSetupDao")
	MasterSetupDao masterSetupDao;
	
	private static final Logger logger = Logger.getLogger(MasterSetupServiceImpl.class);
	
	@Override
	public List<Map<String, Object>> getCorporationForDropdown() {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupDao.getCorporationForDropdown();
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getFunctionMst() {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupDao.getFuncMasterForDropdown();
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
	
	@Override
	public FuncMaster getFuncMasterById(String funcCode) {
		FuncMaster result = null;
		try {
			result = masterSetupDao.getFuncMasterById(funcCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getCorporationFuncForDropdown(String corpCode) {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupDao.getCorporationFuncForDropdown(corpCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getLookupForDropdown(String lookupType) {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupDao.getLookupForDropdown(lookupType);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getClientFromCorpForDropdown(String corpCode) {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupDao.getClientFromCorpForDropdown(corpCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getMemberAccountForDropdown(String corpCode, String clientCode) {
		List<Map<String, Object>> accounts = null;
		try {
			accounts = masterSetupDao.getMemberAccountForDropdown(corpCode, clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return accounts;
	}

	@Override
	public List<Map<String, Object>> getMasterAccountForDropdown( String corpCode, String clientCode) {
		List<Map<String, Object>> accounts = null;
		try {
			accounts = masterSetupDao.getMasterAccountForDropdown(corpCode, clientCode);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return accounts;
	}
	
	@Override
	public FuncMaster getEndingBalanceByDirection(String direction) {
		FuncMaster result = null;
		try {
			result = masterSetupDao.getEndingBalanceByDirection(direction);
		} catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getSweepRateForDropdown(String corpCode){
		List<Map<String, Object>> sweepRates = null;
		try {
			sweepRates = masterSetupDao.getSweepRateForDropDown(corpCode);
		} catch (Exception ex){
			logger.error(ex);
			throw ex;
		}
		return sweepRates;
	}
	
	@Override
	public List<Map<String, Object>> getDeficitRateForDropDown(String corpCode){
		List<Map<String, Object>> deficitRates = null;
		try{
			deficitRates = masterSetupDao.getDeficitRateForDropDown(corpCode);
		} catch (Exception ex){
			logger.error(ex);
			throw ex;
		}
		return deficitRates;
	}
	
	@Override
	public List<Map<String, Object>> getUserRoleBankForDropdown() {
		List<Map<String, Object>> roles = null;
		try {
			roles = masterSetupDao.getUserRoleBankForDropdown();
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return roles;
	}

	@Override
	public List<Map<String, Object>> getUserRoleCustForDropdown() {
		List<Map<String, Object>> roles = null;
		try {
			roles = masterSetupDao.getUserRoleCustForDropdown();
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return roles;
	}

	@Override
	public Map<String, Object> getSystemMstByKey(String key) {
		Map<String, Object> roles = null;
		try {
			roles = masterSetupDao.getSystemMstByKey(key);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return roles;
	}
}
