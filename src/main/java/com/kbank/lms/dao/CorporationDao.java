package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;

public interface CorporationDao {

	public void insertCorporationMst(CorporationMst corporationMst);
	public void insertCorporationTmp(CorporationMst corporationMst);
	public void insertCorporationTmpWithAccount(CorporationMst corporationMst, AccountMst savingAccountMst, AccountMst currentAccountMst);
	public void copyToCorporationMst(CorporationMst corporationMst);
	public void copyToCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount);
	public void updateTmpToCorporationMst(CorporationMst corporationMst);
	public void updateAutorizeStatus(CorporationMst corporationMst);
	public void updateCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount);
	public void updateCorporationTmpForDraft(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount);
	public int checkCorpDuplicate(String corpCode);
	public List<CorporationMst> searchCorporation(SearchDataTable<CorporationMst> searchDataTable);
	public int countCorporationFilter(SearchDataTable<CorporationMst> searchDataTable);
	public int countCorporationTotal(SearchDataTable<CorporationMst> searchDataTable);
	public CorporationMst getCorporationTmpByCorpCode(String corpCode);
	public CorporationMst getCorporationMstByCorpCode(String corpCode);
	public void deleteCorporationMstCorpCode(String corpCode);
	public void deleteCorporationTmpCorpCode(String corpCode);
	public void copyToCorporationTmpDelete(CorporationMst corporationMst);
	public int countCorporationTmp();
	public int countCorporationMst();
	public void updateCorporationInformationWithUMMProfile(CorporationMst corporationMst);
	public void updateCorporationUMMStatusOnlyWithUMMProfile(CorporationMst corporationMst);
	public void deleteAllCorporationTmp();
	public void deleteAllCorporationMst();
	public int checkClientInCorporation(String corpCode);
}
