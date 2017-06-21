package com.kbank.lms.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kbank.lms.common.Application;
import com.kbank.lms.config.DataSorceConfig;
import com.kbank.lms.model.AccountMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_ACCOUNT)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDaoTest {
	
	private static final String DEFAULT_USER = "UNIT-TEST";
	private static final String DEFAULT_CODE_CORP = "UNIT001";
	private static final String DEFAULT_SAVING_ACCOUNTNO = "0000000000";
	private static final String DEFAULT_CURRENT_ACCOUNTNO = "0111111111";

	@Autowired
	AccountDao accountDao;
	
	private AccountMst savingAccount;
	private AccountMst currentAccount;

	public AccountMst getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(AccountMst savingAccount) {
		this.savingAccount = savingAccount;
	}

	public AccountMst getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(AccountMst currentAccount) {
		this.currentAccount = currentAccount;
	}

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		
		AccountMst accountSaving = new AccountMst();
		accountSaving.setAccountNo(DEFAULT_SAVING_ACCOUNTNO);
		accountSaving.setAccountNameEn("Mr.David Beckham");
		accountSaving.setAccountNameTh("นายเดวิด เบคแฮม");
		accountSaving.setKbankProductCode("SA");
		accountSaving.setCisId("123456789012");
		accountSaving.setAccountLevel("01");
		accountSaving.setCorpCode(DEFAULT_CODE_CORP);
		accountSaving.setClientCode(null);
		accountSaving.setActiveStatus("Y");
		accountSaving.setRejectReason("REJECT REASON");
		accountSaving.setOperationFlag("N");
		accountSaving.setAuthorizeStatus("W");
		accountSaving.setAuthorizedBy("CHECKER");
		accountSaving.setRejectReason("REJECT REASON");
		accountSaving.setLastUpdatedBy("TEST");
		accountSaving.setCreatedBy("TEST");
		this.setSavingAccount(accountSaving);
		
		AccountMst accountCurrent = new AccountMst();
		accountCurrent.setAccountNo(DEFAULT_CURRENT_ACCOUNTNO);
		accountCurrent.setAccountNameEn("Mrs.Orngsan Sooji");
		accountCurrent.setAccountNameTh("นางอองซาน ซูจี");
		accountCurrent.setKbankProductCode("CA");
		accountCurrent.setCisId("123456789012");
		accountCurrent.setAccountLevel("02");
		accountCurrent.setCorpCode(DEFAULT_CODE_CORP);
		accountCurrent.setClientCode(null);
		accountCurrent.setRejectReason("REJECT REASON");
		accountCurrent.setActiveStatus("Y");
		accountCurrent.setOperationFlag("N");
		accountCurrent.setAuthorizeStatus("W");
		accountCurrent.setAuthorizedBy("CHECKER");
		accountCurrent.setRejectReason("REJECT REASON");
		accountCurrent.setLastUpdatedBy("TEST");
		accountCurrent.setCreatedBy("TEST");
		this.setCurrentAccount(accountCurrent);	
	}
	 
	@Test
	public void insertAccountMst_Success(){
		AccountMst accountBefore = this.getSavingAccount();
		//===============   Bussiness =====================//
		accountDao.insertAccountMst(accountBefore);
		//===============   Bussiness =====================//
		List<AccountMst> accountAfterList = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		
		AccountMst accountAfter  = null;
		if(!accountAfterList.isEmpty()){
			accountAfter = accountAfterList.get(0);
		}
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		assertEquals(accountBefore,accountAfter);
	}
	
	@Test
	public void insertAccountTmp_Success(){
		AccountMst accountBefore = this.getSavingAccount();
		//===============   Bussiness =====================//
		accountDao.insertAccountTmp(accountBefore);
		//===============   Bussiness =====================//
		List<AccountMst> accountAfterList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		
		AccountMst accountAfter  = null;
		if(!accountAfterList.isEmpty()){
			accountAfter = accountAfterList.get(0);
		}
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(accountBefore,accountAfter);
	}
	
	@Test
	public void checkAccountDuplicate_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		// TEST case 1  insert tmp 
		accountDao.insertAccountTmp(accountSaving);
		//===============   Bussiness =====================//
		int savingResult1 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		//===============   Bussiness =====================//

		// TEST case 2  insert mst 
		accountDao.insertAccountMst(accountSaving);
		//===============   Bussiness =====================//
		int savingResult2 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		//===============   Bussiness =====================//

		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		
		assertEquals(savingResult1, savingResult2);
		
	}
	
	@Test
	public void copyToAccountTmp_Success(){
		// ========== Prepare data================//
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountMst(accountSaving);
		int savingResult1 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		// ========== Prepare data================//
		
		
		//===============   Bussiness =====================//
		accountDao.copyToAccountTmp(accountSaving);
		//===============   Bussiness =====================//

		int savingResult2 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		assertEquals(savingResult1, savingResult2);
		
	}
	@Test
	public void updateAccountTmp_Success(){
		// ========== Prepare data================//
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountTmp(accountSaving);
		// ========== Prepare data================//
		List<AccountMst> accountPrepareList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		AccountMst accountPrepare = new AccountMst();
		if(!accountPrepareList.isEmpty()){
			accountPrepare = accountPrepareList.get(0);
		}
		
		accountPrepare.setAccountNameEn("UPDATE-NEW-NAME");	
		//accountPrepare.setActiveStatus("N");
		accountPrepare.setAccountNameTh("THAI");
		//===============   Bussiness =====================//
		accountDao.updateAccountTmp(accountPrepare);
		//===============   Bussiness =====================//

		List<AccountMst> accountAfterList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		AccountMst accountAfter  = null;
		if(!accountAfterList.isEmpty()){
			accountAfter = accountAfterList.get(0);
		}
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(accountPrepare, accountAfter);
		
	}
	
	
	@Test
	public void deleteAccountMst_Success(){
		int accountId = 0;
		boolean flagCheckDataExists = false;
		AccountMst beforeAccount = this.getSavingAccount();
		accountDao.insertAccountMst(beforeAccount);
		// ========== Prepare data================//
		List<AccountMst> accountPrepareList = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(!accountPrepareList.isEmpty()){
			accountId = accountPrepareList.get(0).getAccountId();
			flagCheckDataExists = true;
		}
		
	    accountDao.deleteAccountMstByAccountId(accountId);	
	    
	    AccountMst afterAccount = null;
	    
	    try{
	    	afterAccount = accountDao.getAccountMstById(accountId);
	    }catch(Exception e){
	    	afterAccount = null;
	    }

		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(true, flagCheckDataExists);
		assertEquals(null, afterAccount);

		
	}
	
	@Test
	public void deleteAccountTmp_Success(){
		int accountId = 0;
		boolean flagCheckDataExists = false;
		AccountMst beforeAccount = this.getSavingAccount();
		accountDao.insertAccountTmp(beforeAccount);
		// ========== Prepare data================//
		List<AccountMst> accountPrepareList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountPrepareList.isEmpty()){
			accountId = accountPrepareList.get(0).getAccountId();
			flagCheckDataExists = true;
		}
		
	    accountDao.deleteAccountTmpByAccountId(accountId);	
	    
	    AccountMst afterAccount = null;
	    
	    try{
	    	afterAccount = accountDao.getAccountTmpById(accountId);
	    }catch(Exception e){
	    	afterAccount = null;
	    }

		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(true, flagCheckDataExists);
		assertEquals(null, afterAccount);
		
	}
	
	
	
	@Test
	public void copyToAccountMst_Success(){
		
		// ========== Prepare data================//
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountTmp(accountSaving);
		int savingResult1 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		// ========== Prepare data================//
		int accountId = 0;
		List<AccountMst> accountPrepareList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountPrepareList.isEmpty()){
			accountId = accountPrepareList.get(0).getAccountId();
		}
		
		//===============   Bussiness =====================//
		accountDao.copyToAccountMst(accountSaving);
		//===============   Bussiness =====================//

		int savingResult2 = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		AccountMst afterAccountTmp = null;
		try{
			accountDao.getAccountTmpById(accountId);
		}catch(Exception e){
			afterAccountTmp = null;
		}
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		assertEquals(savingResult1, savingResult2);
		assertEquals(null, afterAccountTmp);
	}
	
	
	
	@Test
	public void updateTmpToAccountMst_Success(){
		// ========== Prepare data================//
		AccountMst accountSaving = this.getSavingAccount();
		int accountTmpId = 0;
		accountDao.insertAccountTmp(accountSaving);
		accountDao.insertAccountMst(accountSaving);
		List<AccountMst> accountPrepareList = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(!accountPrepareList.isEmpty()){
			accountSaving = accountPrepareList.get(0);
		}
		List<AccountMst> accountTmpList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountTmpList.isEmpty()){
			accountTmpId = accountTmpList.get(0).getAccountId();
		}
		
		// ========== Prepare data================//

		//===============   Bussiness =====================//
		accountDao.updateTmpToAccountMst(accountSaving);
		//===============   Bussiness =====================//

		AccountMst afterAccountTmp = null;
		AccountMst afterAccountMst = accountDao.getAccountMstById(accountSaving.getAccountId());
		try{
			afterAccountTmp = accountDao.getAccountTmpById(accountTmpId);
		}catch(Exception e){
			afterAccountTmp = null;
		}
		
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		assertEquals(accountSaving, afterAccountMst);
		assertEquals(null, afterAccountTmp);
		
	}
	
	@Test
	public void updateAutorizeStatus_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountTmp(accountSaving);
		AccountMst accountBefore = new AccountMst();
		int accountTmpId = 0;
		List<AccountMst> accountTmpList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountTmpList.isEmpty()){
			accountTmpId = accountTmpList.get(0).getAccountId();
			accountBefore = accountTmpList.get(0);
		}
		
		accountBefore.setAuthorizedBy(DEFAULT_USER);
		accountBefore.setAuthorizeStatus("N");
		//=================== Business ==================/
		accountDao.updateAutorizeStatus(accountBefore);
		//=================== Business ==================/
		
		AccountMst accountAfter = accountDao.getAccountTmpById(accountTmpId);
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		assertEquals(accountBefore, accountAfter);
	}
	
	
	@Test
	public void getAccountTmpById_Success(){
		AccountMst afterAccountTmp = null;
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountTmp(accountSaving);

		int accountTmpId = 0;
		List<AccountMst> accountTmpList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountTmpList.isEmpty()){
			accountTmpId = accountTmpList.get(0).getAccountId();
		}

		try{
			afterAccountTmp = accountDao.getAccountTmpById(accountTmpId);
		}catch(Exception e){
			afterAccountTmp = null;
		}
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
	
		assertEquals(accountSaving, afterAccountTmp);
	}
	
	@Test
	public void getAccountMstById_Success(){
		AccountMst afterAccountMst = null;
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountMst(accountSaving);

		int accountMstId = 0;
		List<AccountMst> accountTmpList = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(!accountTmpList.isEmpty()){
			accountMstId = accountTmpList.get(0).getAccountId();
		}
		
		
		try{
			afterAccountMst = accountDao.getAccountMstById(accountMstId);
		}catch(Exception e){
			afterAccountMst = null;
		}

		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		
		assertEquals(accountSaving, afterAccountMst);
	}
	
	
	@Test
	public void copyToAccountTmpDelete_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountMst(accountSaving);

		AccountMst accountMstBefore = new AccountMst();
		List<AccountMst> accountMstList= accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(!accountMstList.isEmpty()){
			accountMstBefore = accountMstList.get(0);
		}

		//==============  Business ============================//
		accountDao.copyToAccountTmpDelete(accountMstBefore);
		//============== End Business ============================//

		AccountMst accountTmpAfter = new AccountMst();
		List<AccountMst> accountTmpList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountTmpList.isEmpty()){
			accountTmpAfter = accountTmpList.get(0);
		}
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		
		assertEquals(accountMstBefore, accountTmpAfter);
		
	}
	
	
	@Test
	public void getAllAccountIdFromSearch_Success(){
		// search  Tmp Account table
		AccountMst accountSaving = this.getSavingAccount();
		accountDao.insertAccountTmp(accountSaving);
		boolean checkBefore = false;
		boolean checkAfter = false;
		
		AccountMst accountTmp = new AccountMst();
		List<AccountMst> accountMstList = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(!accountMstList.isEmpty()){
			accountTmp = accountMstList.get(0);
			checkBefore = true;
		}
		

		AccountMst accountTmpSearch = new AccountMst();
		List<AccountMst> accountTmpList = accountDao.getAllAccountIdFromSearch(accountSaving);
		if(!accountTmpList.isEmpty()){
			accountTmpSearch = accountTmpList.get(0);
			checkAfter = true;
		}
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(true, checkBefore);
		assertEquals(true, checkAfter);
		assertEquals(accountTmp.getAccountId(), accountTmpSearch.getAccountId());
		assertEquals(accountTmp.getOperationFlag(), accountTmpSearch.getOperationFlag());
		
	}
	
	
	@Test
	public void getAccountTmpByCorpCode_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountTmp(accountSaving);
		accountDao.insertAccountTmp(accountCurrent);
		
		
		AccountMst accountSavingAfter = new AccountMst();
		AccountMst accountCurrentAfter = new AccountMst();
		List<AccountMst> listResult = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);

		if(!listResult.isEmpty()){
			for(AccountMst mst : listResult){
					if(accountSaving.getAccountLevel().equals(mst.getAccountLevel())){
						accountSavingAfter  = mst;
					}else if(accountCurrent.getAccountLevel().equals(mst.getAccountLevel())){
						accountCurrentAfter = mst;
					}
				
			}
		}
		

		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================
		
		assertEquals(accountSaving, accountSavingAfter);
		assertEquals(accountCurrent, accountCurrentAfter);
	}
	
	@Test
	public void getAccountMstByCorpCode_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountMst(accountSaving);
		accountDao.insertAccountMst(accountCurrent);
		
		
		AccountMst accountSavingAfter = new AccountMst();
		AccountMst accountCurrentAfter = new AccountMst();
		List<AccountMst> listResult = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);

		if(!listResult.isEmpty()){
			for(AccountMst mst : listResult){
					if(accountSaving.getAccountLevel().equals(mst.getAccountLevel())){
						accountSavingAfter  = mst;
					}else if(accountCurrent.getAccountLevel().equals(mst.getAccountLevel())){
						accountCurrentAfter = mst;
					}
				
			}
		}
		
		
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(accountSaving, accountSavingAfter);
		assertEquals(accountCurrent, accountCurrentAfter);
	}

     @Test
     public void countAccountTmp_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountTmp(accountSaving);
		accountDao.insertAccountTmp(accountCurrent);
		
		
		
		//============= Business =========================/
		int i = accountDao.countAccountTmp();
		//============= Business =========================/
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(2, i);

    	 
     }

     @Test
     public void countAccountMst_Success(){
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountMst(accountSaving);
		accountDao.insertAccountMst(accountCurrent);
		
		
		
		//============= Business =========================/
		int i = accountDao.countAccountMst();
		//============= Business =========================/
		//=================== Clear Data ===================
		this.clearAllAccountData();
		//=================== Clear Data ===================

		assertEquals(2, i);

    	 
     }

 	@Test
 	public void deleteAllAccountMst_Success(){
 		//=========== prepare data before call method //
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountMst(accountSaving);
		accountDao.insertAccountMst(accountCurrent);
 		//=========== End prepare data before call method //
 		int beforeCount = accountDao.countAccountMst();
 		
 	    //================ Business ===================================/
 		accountDao.deleteAllAccountMst();
 	    //================End Business ===================================/
 		
 		int afterCount = accountDao.countAccountMst();


 		assertEquals(2, beforeCount);
 		assertEquals(0, afterCount);
 		
 	}
 	
 	@Test
 	public void deleteAllAccountTmp_Success(){
 		//=========== prepare data before call method //
		AccountMst accountSaving = this.getSavingAccount();
		AccountMst accountCurrent = this.getCurrentAccount();
		accountDao.insertAccountTmp(accountSaving);
		accountDao.insertAccountTmp(accountCurrent);
 		//=========== End prepare data before call method //
 		int beforeCount = accountDao.countAccountTmp();
 		
 	    //================ Business ===================================/
 		accountDao.deleteAllAccountTmp();
 	    //================End Business ===================================/
 		
 		int afterCount = accountDao.countAccountTmp();


 		assertEquals(2, beforeCount);
 		assertEquals(0, afterCount);
 		
 	}
	

	private void clearAllAccountData(){
		accountDao.deleteAllAccountTmp();
		accountDao.deleteAllAccountMst();
	}
	/**
x	public int insertAccountMst(AccountMst accountMst) { return 0; }
x	public int insertAccountTmp(AccountMst accountMst) { return 0; }
x	public int checkAccountDuplicate(String accountNo) { return 0; } 
x	public void copyToAccountTmp(AccountMst accountMst) { } 
x	public void updateAccountTmp(AccountMst accountMst) { } 
x	public void deleteAccountMstByAccountId(int accountId) { } 
x	public void deleteAccountTmpByAccountId(int accountId) { } 
x	public void copyToAccountMst(AccountMst accountMst) { } 
dup	public AccountMst getAccountByAccountIdMst(int accountId) { return null; } 
dup	public AccountMst getAccountByAccountIdTmp(int accountId) { return null; } 
??	public void updateTmpToAccountMst(AccountMst accountMst) { } 
x	public void updateAutorizeStatus(AccountMst accountMst) { } 
*	public List<AccountMst> searchAccount(SearchDataTable<AccountMst> searchDataTable) { return null; } 
*	public int countAccountFilter(SearchDataTable<AccountMst> searchDataTable) { return 0; } 
*	public int countAccountTotal(SearchDataTable<AccountMst> searchDataTable) { return 0; } 
x	public AccountMst getAccountTmpById(int id) { return null; } 
x	public AccountMst getAccountMstById(int id) { return null; } 
x	public void copyToAccountTmpDelete(AccountMst accountMst) { } 
dup	public void deleteAccountTmpAccountId(int accountId) { } 
x	public List<AccountMst> getAllAccountIdFromSearch(AccountMst accountMst) { return null; } 
x	public List<AccountMst> getAccountTmpByCorpCode(String corpCode) { return null; } 
x	public List<AccountMst> getAccountMstByCorpCode(String corpCode) { return null; } 
??	public void deleteAccountTmpAndMst(int accountId) { } 
	public int countAccountTmp() { return 0; } 
	public int countAccountMst() { return 0; } 
	public void deleteAllAccountTmp() { } 
	public void deleteAllAccountMst() { } 
	*/
}
