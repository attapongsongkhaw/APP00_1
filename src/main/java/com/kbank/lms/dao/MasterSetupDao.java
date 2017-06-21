package com.kbank.lms.dao;

import java.util.List;
import java.util.Map;

import com.kbank.lms.model.FuncMaster;

public interface MasterSetupDao {

	public List<Map<String, Object>> getCorporationForDropdown();
	public List<Map<String, Object>> getCorporationFuncForDropdown(String corpCode);
	public List<Map<String, Object>> getLookupForDropdown(String lookupType);
	public List<Map<String, Object>> getClientFromCorpForDropdown(String corpCode);
	public List<Map<String, Object>> getMemberAccountForDropdown(String corpCode, String clientCode);
	public List<Map<String, Object>> getMasterAccountForDropdown(String corpCode, String clientCode);
	public List<Map<String, Object>> getFuncMasterForDropdown();
	public FuncMaster getFuncMasterById(String funcCode);
	public FuncMaster getEndingBalanceByDirection(String direction);
	public List<Map<String, Object>> getSweepRateForDropDown(String corpCode);
	public List<Map<String, Object>> getDeficitRateForDropDown(String corpCode);
	public List<Map<String, Object>> getUserRoleBankForDropdown();
	public List<Map<String, Object>> getUserRoleCustForDropdown();
	public Map<String, Object> getSystemMstByKey(String key);
}
