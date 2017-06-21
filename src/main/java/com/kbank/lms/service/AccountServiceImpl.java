package com.kbank.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.dao.AccountDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.AccountMst;

@Service("accountSevice")
public class AccountServiceImpl implements AccountService {

	@Autowired
	@Qualifier("accountDao")
	AccountDao accountDao;
	
	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	@Override
	public void saveAccountByMaker(AccountMst accountMst, String mode, String type) {
		try {
			accountMst.setAuthorizeStatus("W");
			if("ADD".equals(mode)){
				accountMst.setOperationFlag("N");
				accountDao.insertAccountTmp(accountMst);
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					accountMst.setOperationFlag("E");
					accountDao.copyToAccountTmp(accountMst);
				}else if("P".equals(type)){
					accountDao.updateAccountTmp(accountMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void saveAccountMst(AccountMst accountMst) {
		try {
			accountDao.insertAccountMst(accountMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}

	@Override
	public int checkAccountDuplicate(String accountNo) {
		int result = 0;
		try {
			result = accountDao.checkAccountDuplicate(accountNo);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
	
	@Override
	public DataTable<AccountMst> searchAccount(SearchDataTable<AccountMst> searchDataTable) {
		DataTable<AccountMst> result = new DataTable<>();
		try {
			searchDataTable.getDataSearch().setAccountLevel("03");
			List<AccountMst> accts = accountDao.searchAccount(searchDataTable);
			result.setData(accts);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(accountDao.countAccountTotal(searchDataTable));
			result.setRecordsFiltered(accountDao.countAccountFilter(searchDataTable));
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public AccountMst getAccountPendingById(int id) {
		AccountMst result = null;
		try {
			result = accountDao.getAccountTmpById(id);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public AccountMst getAccountActiveById(int id) {
		AccountMst result = null;
		try {
			result = accountDao.getAccountMstById(id);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public void deleteAccountById(AccountMst accountMst) throws LMSException {
		try {
			if(accountDao.checkAccountInInStrunction(accountMst.getAccountId()) == 0){
				accountDao.copyToAccountTmpDelete(accountMst);
			}else{
				throw new LMSException(104);
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void rejectAccountById(AccountMst accountMst) {
		try {
			accountDao.updateAutorizeStatus(accountMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void cancelAccountById(int accountId) {
		try {
			accountDao.deleteAccountTmpByAccountId(accountId);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void acceptAccountByAccountId(AccountMst accountMst) throws LMSException {
		try {
			if("D".equals(accountMst.getOperationFlag())){
				accountDao.deleteAccountTmpAndMst(accountMst.getAccountId());
			}else{
				accountMst.setAuthorizeStatus("Y");
				AccountMst acct = accountDao.getAccountMstByAccountNo(accountMst.getAccountNo());
				if(acct == null){
					accountDao.copyToAccountMst(accountMst);
				}else{
					AccountMst acctTmp = accountDao.getAccountTmpByAccountNo(accountMst.getAccountNo());
					accountMst.setAccountNameEn(acctTmp.getAccountNameEn());
					accountMst.setAccountNameTh(acctTmp.getAccountNameTh());
					accountMst.setCisId(acctTmp.getCisId());
					accountMst.setCorpCode(acctTmp.getCorpCode());
					accountMst.setClientCode(acctTmp.getClientCode());
					accountMst.setKbankProductCode(acctTmp.getKbankProductCode());
					accountMst.setAccountLevel(acctTmp.getAccountLevel());
					accountMst.setLastUpdatedDate(acctTmp.getLastUpdatedDate());
					accountMst.setLastUpdatedBy(acctTmp.getLastUpdatedBy());
					accountDao.updateTmpToAccountMst(accountMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public List<AccountMst> getAllAccountIdFromSearch(AccountMst accountMst) {
		List<AccountMst> result = null;
		try {
			result = accountDao.getAllAccountIdFromSearch(accountMst);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}

	@Override
	public AccountMst getAccountMst(String corpCode, String accountLevel) {
		AccountMst account = null;
		try {
			account = accountDao.getAccountMst(corpCode, accountLevel);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return account;
	}

	@Override
	public List<AccountMst> getAllAccountActiveByCorpCode(String corpCode) {
		List<AccountMst> result = null;
		try {
			result = accountDao.getAllAccountMstByCorpCode(corpCode);
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
		return result;
	}
}
