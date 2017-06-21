package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;

public interface AccountDao {

	public int insertAccountMst(AccountMst accountMst);
	public int insertAccountTmp(AccountMst accountMst);
	public int checkAccountDuplicate(String accountNo);
	public void copyToAccountTmp(AccountMst accountMst);
	public void updateAccountTmp(AccountMst accountMst);
	public void deleteAccountMstByAccountId(int accountId);
	public void deleteAccountTmpByAccountId(int accountId);
	public void copyToAccountMst(AccountMst accountMst);
	//public AccountMst getAccountByAccountIdMst(int accountId);
	//public AccountMst getAccountByAccountIdTmp(int accountId);
	public void updateTmpToAccountMst(AccountMst accountMst);
	public void updateAutorizeStatus(AccountMst accountMst);
	public List<AccountMst> searchAccount(SearchDataTable<AccountMst> searchDataTable);
	public int countAccountFilter(SearchDataTable<AccountMst> searchDataTable);
	public int countAccountTotal(SearchDataTable<AccountMst> searchDataTable);
	public AccountMst getAccountTmpById(int id);
	public AccountMst getAccountMstById(int id);
	public void copyToAccountTmpDelete(AccountMst accountMst);
	//public void deleteAccountTmpAccountId(int accountId);
	public List<AccountMst> getAllAccountIdFromSearch(AccountMst accountMst);
	public List<AccountMst> getAccountTmpByCorpCode(String corpCode);
	public List<AccountMst> getAccountMstByCorpCode(String corpCode);
	public void deleteAccountTmpAndMst(int accountId);
	public int countAccountTmp();
	public int countAccountMst();
	public void deleteAllAccountTmp();
	public void deleteAllAccountMst();
	public int checkAccountInInStrunction(int accountId);
	public AccountMst getAccountMstByAccountNo(String accountNo);
	public AccountMst getAccountMst(String corpCode, String accountLevel);
	public List<AccountMst> getAllAccountMstByCorpCode(String corpCode);
	public AccountMst getAccountTmpByAccountNo(String accountNo);
}
