package com.kbank.lms.service;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.FunctionMst;

public interface FunctionService {

	public void saveFunctionByMaker(FunctionMst functionMst, String mode, String type);
	public void acceptFunctionByCorpCode(FunctionMst functionMst);
	public int checkFunctionDuplicate(String corpCode);
	public DataTable<FunctionMst> searchFunction(SearchDataTable<FunctionMst> searchDataTable);
	public FunctionMst getFunctionPendingByCorpCode(String corpCode);
	public FunctionMst getFunctionActiveByCorpCode(String corpCode);
	public void deleteFunctionByCorpCode(FunctionMst functionMst);
	public void cancelFunctionByCorpCode(String corpCode);
	public void rejectFunctionByCorpCode(FunctionMst functionMst);
}
