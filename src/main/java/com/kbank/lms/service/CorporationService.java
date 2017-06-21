package com.kbank.lms.service;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.model.ResponseListJson;

public interface CorporationService {
	
	public void saveCorporationByMaker(CorporationMst corporationMst, AccountMst savingAccountMst, AccountMst currentAccountMst, String mode, String type);
	public int checkCorpDuplicate(String corpCode);
	public DataTable<CorporationMst> searchCorporation(SearchDataTable<CorporationMst> searchDataTable);
	public ResponseListJson<CorporationMst, AccountMst>  getCorporationPendingByCorpCode(String corpCode);
	public ResponseListJson<CorporationMst, AccountMst> getCorporationActiveByCorpCode(String corpCode);
	public void cancelCorporationByCorpCode(String corpCode);
	public void acceptCorporationByCorpCode(CorporationMst corporationMst);
	public void rejectCorporationByCorpCode(CorporationMst corporationMst);
	public void deleteCorporationByCorpCode(CorporationMst corporationMst) throws LMSException;
}
