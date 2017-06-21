package com.kbank.lms.dao;

import java.util.List;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.FunctionMst;

public interface FunctionDao {

	public void insertFunctionMst(FunctionMst functionMst);
	public int checkFunctionDuplicate(String corpCode);
	public List<FunctionMst> searchFunction(SearchDataTable<FunctionMst> searchDataTable);
	public int countFunctionTotal(SearchDataTable<FunctionMst> searchDataTable);
	public int countFunctionFilter(SearchDataTable<FunctionMst> searchDataTable);
	public void insertFunctionTmp(FunctionMst functionMst);
	public void copyToFunctionTmp(FunctionMst functionMst);
	public void updateFunctionTmp(FunctionMst functionMst);
	public void copyToFunctionTmpDelete(FunctionMst functionMst);
	public void copyToFunctionMst(FunctionMst functionMst);
	public void updateFunctionTmpToFunctionMst(FunctionMst functionMst);
	public void updateAutorizeStatus(FunctionMst functionMst);
	public void deleteFunctionMstCorpCode(String corpCode);
	public void deleteFunctionTmpCorpCode(String corpCode);
	public FunctionMst getFunctionTmpByCorpCode(String corpCode);
	public FunctionMst getFunctionMstByCorpCode(String corpCode);
	public void updateEffectiveDate(String corpCode);
	public int countFuctionTmp();
	public void deleteAllFunctionTmp();
	public void deleteAllFunctionMst();
	public int countFunctionMst();
	
}
