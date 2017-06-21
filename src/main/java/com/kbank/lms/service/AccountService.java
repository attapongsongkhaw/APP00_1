package com.kbank.lms.service;

import java.util.List;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;

public interface AccountService {

	public void  saveAccountMst(AccountMst accountMst);
	public int checkAccountDuplicate(String accountNo);
	public DataTable<AccountMst> searchAccount(SearchDataTable<AccountMst> searchDataTable);
	public AccountMst getAccountPendingById(int id);
	public AccountMst getAccountActiveById(int id);
	public void deleteAccountById(AccountMst accountMst) throws LMSException;
	public void rejectAccountById(AccountMst accountMst);
	public void cancelAccountById(int accountId);
	public void acceptAccountByAccountId(AccountMst accountMst) throws LMSException;
	public void saveAccountByMaker(AccountMst accountMst, String mode, String type);
	public List<AccountMst> getAllAccountIdFromSearch(AccountMst accountMst); 
	public AccountMst getAccountMst(String corpCode, String accountLevel);
	public List<AccountMst> getAllAccountActiveByCorpCode(String corpCode);
}
