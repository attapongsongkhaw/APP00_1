package com.kbank.lms.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
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
import com.kbank.lms.model.CorporationMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_CORPORATION)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CorporationDaoTest {

	private static final String DEFAULT_USER = "UNIT-TEST";
	private static final String DEFAULT_CODE_CORP = "UNIT001";
	private static final String DEFAULT_NAME_CORP = "UNIT001-NEW";
	private static final String DEFAULT_SAVING_ACCOUNTNO = "0000000000";
	private static final String DEFAULT_CURRENT_ACCOUNTNO = "0111111111";
	private static final Timestamp DEFAULT_DATE = new java.sql.Timestamp(new Date().getTime());

	@Autowired
	CorporationDao corporationDao;
	
	@Autowired
	AccountDao accountDao;
	
	
	private CorporationMst corporationMst;
	private AccountMst savingAccount;
	private AccountMst currentAccount;

	public CorporationMst getCorporationMst() {
		return corporationMst;
	}

	public void setCorporationMst(CorporationMst corporationMst) {
		this.corporationMst = corporationMst;
	}
	
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
		CorporationMst mst = new CorporationMst();

		mst.setCisId(null);
		mst.setTaxpayerNo(null);
		mst.setTaxpayerName(null);
		mst.setChargeFlag(null);
		mst.setChargeAccount(null);
		mst.setChargeType(null);
		mst.setChargeFreq(null);
		mst.setChargeDate(null);
		mst.setChargeAmount(null);
		mst.setEffectiveDate(null);
		mst.setRejectReason(null);
		mst.setUmmCompanyStatus(null);
		mst.setUmmServiceStatus(null);
		mst.setUmmSyncDate(null);
		
		mst.setCorpCode(DEFAULT_CODE_CORP);
		mst.setCorpName(DEFAULT_NAME_CORP);
		mst.setActiveStatus("Y");
		mst.setOperationFlag("N");
		mst.setAuthorizeStatus("D");
		
		mst.setCreatedBy(DEFAULT_USER);
		mst.setCreatedDate(DEFAULT_DATE);
		mst.setLastUpdatedBy(DEFAULT_USER);
		mst.setLastUpdatedDate(DEFAULT_DATE);
		
		this.setCorporationMst(mst);
		
		
		
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
	public void insertCorporationMst_Success() {
		CorporationMst beforeMst = this.getCorporationMst();
		Date dateUtil = new Date();
		Timestamp ummRequestDate = new java.sql.Timestamp(dateUtil.getTime());
		beforeMst.setUmmCompanyStatus("A");
		beforeMst.setUmmServiceStatus("A");
		beforeMst.setUmmSyncDate(ummRequestDate);
		
		int beforeInsert = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		corporationDao.insertCorporationMst(beforeMst);
		int afterInsert = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		CorporationMst mstResult = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeInsert , (afterInsert-1));
		assertEquals(beforeMst, mstResult);
		
	}
	
	
	@Test(expected = Exception.class) 
	public void insertCorporationTmp_Fail() {
		CorporationMst mst = this.getCorporationMst();

		mst.setCorpCode(null);
		mst.setCorpName(null);
		mst.setActiveStatus(null);
		mst.setAuthorizeStatus(null);
		mst.setOperationFlag(null);
		corporationDao.insertCorporationTmp(mst);

	}
	

	@Test
	public void insertCorporationTmp_Success() {
		CorporationMst beforeMst = this.getCorporationMst();
		Date dateUtil = new Date();
		Timestamp ummRequestDate = new java.sql.Timestamp(dateUtil.getTime());
		beforeMst.setUmmCompanyStatus("A");
		beforeMst.setUmmServiceStatus("A");
		beforeMst.setUmmSyncDate(ummRequestDate);
		
		int beforeInsert = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		corporationDao.insertCorporationTmp(beforeMst);
		int afterInsert = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		CorporationMst mstResult = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeInsert , (afterInsert-1));
		assertEquals(beforeMst, mstResult);
		
	}
	
	@Test
	public void insertCorporationTmpWithAccount_Success(){
		
		int beforeCorp = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		int beforeSaving  = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		int beforeCurrent = accountDao.checkAccountDuplicate(DEFAULT_CURRENT_ACCOUNTNO);
		
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());

		int afterCorp = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);
		int afterSaving  = accountDao.checkAccountDuplicate(DEFAULT_SAVING_ACCOUNTNO);
		int afterCurrent = accountDao.checkAccountDuplicate(DEFAULT_CURRENT_ACCOUNTNO);

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeCorp, (afterCorp-1));
		assertEquals(beforeSaving, (afterSaving-1));
		assertEquals(beforeCurrent, (afterCurrent-1));
		
		
	}

	@Test
	public void copyToCorporationMst_Success(){
		int beforeSize_account = 0;
		int afterSize_account = 0;
		
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		// END =============== prepare Data before copy  temp to mst //
		
		CorporationMst corpTemp = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listAccountTemp = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(listAccountTemp !=null){
			beforeSize_account = listAccountTemp.size();
		}
		
		corporationDao.copyToCorporationMst(this.getCorporationMst());
		
		
		CorporationMst corpMst = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listAccountMst = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(listAccountMst !=null){
			afterSize_account = listAccountMst.size();
		}
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/
		
		assertEquals(corpTemp, corpMst);
		assertEquals(beforeSize_account, afterSize_account);
	}
	
	
	@Test
	public void copyToCorporationTmp_Success(){
		int beforeSize_account = 0;
		int afterSize_account = 0;
		
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		corporationDao.copyToCorporationMst(this.getCorporationMst());
		// END =============== prepare Data before copy  temp to mst //
		
		CorporationMst corpMst = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listAccountMst = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		if(listAccountMst !=null){
			beforeSize_account = listAccountMst.size();
		}
		
		//=====================  business ====================/
		corporationDao.copyToCorporationTmp(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		//=====================  business ====================/

		CorporationMst corpTemp = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listAccountTemp = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		if(listAccountTemp !=null){
			afterSize_account = listAccountTemp.size();
		}

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/

		assertEquals(corpTemp, corpMst);
		assertEquals(beforeSize_account, afterSize_account);
	}
	
	@Test
	public void updateTmpToCorporationMst_Success(){
		String default_name = "XXXX-USER";
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		corporationDao.copyToCorporationMst(this.getCorporationMst());
		// END =============== prepare Data before copy  temp to mst //
		CorporationMst corpTemp = this.getCorporationMst();
		
		corpTemp.setAuthorizeStatus("D");
		corpTemp.setAuthorizedBy("XXX");
		corpTemp.setLastUpdatedBy(default_name);
		
		//----- Business -------/
		corporationDao.updateTmpToCorporationMst(corpTemp);
		//----- Business -------/
		
		CorporationMst corpTmpAfter = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listTmpAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);

		CorporationMst corpAfter = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listAccount = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
		
		boolean checkAccount = false;
		int sizeAfter = 0;
		int sizeTempAfter = 0;
		if(listTmpAccount!=null){
			sizeTempAfter	= listTmpAccount.size();
		}
		if(listAccount!=null){
			sizeAfter = listAccount.size() ;
			for(AccountMst x : listAccount){
				if(!default_name.equals(x.getLastUpdatedBy())){
					checkAccount = false;
					break;
				}
				checkAccount = true;
			}
		}
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/
		
		assertEquals(corpTemp, corpAfter);
		assertEquals(true, checkAccount);
		assertEquals(2, sizeAfter);

		// check Corporation Temp 
		assertEquals(null, corpTmpAfter);
		// check Account Temp 
		assertEquals(0 , sizeTempAfter);
	}
	
	
	@Test
	public void updateAutorizeStatus_Success(){
		String default_name = "XXXX-USER";
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		//=============== End prepare Data before copy  temp to mst //
		CorporationMst beforeCorp = this.getCorporationMst();
		
		beforeCorp.setAuthorizeStatus("X");
		beforeCorp.setAuthorizedBy(default_name);
		beforeCorp.setAuthorizedDate(new Date());
		beforeCorp.setRejectReason("UNITCHANGE");
		beforeCorp.setLastUpdatedBy(default_name);
		
		
		//=========== Business =================//
		corporationDao.updateAutorizeStatus(beforeCorp);
		//=========== End Business =================//
		
		CorporationMst corpTmpAfter = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listTmpAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		
		boolean checkAccount = false;
		int sizeTempAfter = 0;
		if(listTmpAccount!=null){
			sizeTempAfter = listTmpAccount.size() ;
			for(AccountMst x : listTmpAccount){
				if(!default_name.equals(x.getAuthorizedBy())){
					checkAccount = false;
					break;
				}
				checkAccount = true;
			}
		}
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeCorp , corpTmpAfter);
		assertEquals(2, sizeTempAfter);
		assertEquals(true, checkAccount);
		
	}
	
	
	
	@Test
	public void updateCorporationTmp_Success(){
		String default_name = "VEE-UNIT";
		
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		//=============== End prepare Data before copy  temp to mst //
		CorporationMst beforeCorp = this.getCorporationMst();
		beforeCorp.setCorpName(default_name);
		
		AccountMst saving = this.getSavingAccount();
		saving.setAccountNameEn(default_name);

		AccountMst current = this.getSavingAccount();
		current.setAccountNameEn(default_name);
		
		//=========== Business ==================================/
		corporationDao.updateCorporationTmp(beforeCorp, saving, current);
		//===========End Business ==================================/
		
		CorporationMst afterCorp = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		List<AccountMst> listTmpAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
		boolean checkAccount = false;
		int sizeTempAfter = 0;
		if(listTmpAccount!=null){
			sizeTempAfter = listTmpAccount.size() ;
			for(AccountMst x : listTmpAccount){
				if(!default_name.equals(x.getAccountNameEn())){
					checkAccount = false;
					break;
				}
				checkAccount = true;
			}
		}
		
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeCorp , afterCorp);
		assertEquals(2, sizeTempAfter);
		assertEquals(true, checkAccount);
		
	}
	
	@Test
	public void checkCorpDuplicate_Success(){
	     int beforeCount = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);

	     corporationDao.insertCorporationTmp(this.getCorporationMst());
	     int tempCount = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);

	     corporationDao.insertCorporationMst(this.getCorporationMst());
	     int mstCount = corporationDao.checkCorpDuplicate(DEFAULT_CODE_CORP);

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//==============End clear all data on database =============/

		assertEquals(0, beforeCount);
		assertEquals(1, tempCount);
		assertEquals(1, mstCount);
	}
	
	@Test
	public void getCorporationTmpByCorpCode_Success(){
		corporationDao.insertCorporationTmp(this.getCorporationMst());

		CorporationMst afterResult =    corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//==============End clear all data on database =============/

		assertEquals(this.getCorporationMst(), afterResult);
	}

	@Test
	public void getCorporationMstByCorpCode_Success(){
		corporationDao.insertCorporationMst(this.getCorporationMst());

		CorporationMst afterResult =  corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//==============End clear all data on database =============/
		
		
		assertEquals(this.getCorporationMst(), afterResult);
	}
	
	
	
	@Test
	public void deleteCorporationMstCorpCode_Success(){
		int beforeSize = 0;
		int afterSize = 0;
		
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		corporationDao.copyToCorporationMst(this.getCorporationMst());
		// END =============== prepare Data before copy  temp to mst //
		
	    CorporationMst beforeMaster = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> beforeAccount = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
	    if(null != beforeAccount){
	    	beforeSize = beforeAccount.size();
	    }
		
	    //================== Business ================================/
		corporationDao.deleteCorporationMstCorpCode(DEFAULT_CODE_CORP);
	    //==================End Business ================================/

	    CorporationMst afterMaster = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> afterAccount = accountDao.getAccountMstByCorpCode(DEFAULT_CODE_CORP);
	    if(null != afterAccount){
	    	afterSize = afterAccount.size();
	    }
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//==============End clear all data on database =============/
		
		
		assertEquals(this.getCorporationMst(), beforeMaster);
		assertEquals(null , afterMaster);

		assertEquals(2, beforeSize);
		assertEquals(0, afterSize);
	}
	
	
	@Test
	public void deleteCorporationTmpCorpCode_Success(){
		int beforeSize = 0;
		int afterSize = 0;
		
		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		// END =============== prepare Data before copy  temp to mst //
		
	    CorporationMst beforeMaster = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> beforeAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
	    if(null != beforeAccount){
	    	beforeSize = beforeAccount.size();
	    }
		
	    //================ Business ===================================/
		corporationDao.deleteCorporationTmpCorpCode(DEFAULT_CODE_CORP);
	    //================End Business ===================================/

	    CorporationMst afterMaster = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> afterAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
	    if(null != afterAccount){
	    	afterSize = afterAccount.size();
	    }
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//==============End clear all data on database =============/
		
		
		// result Corporation
		assertEquals(this.getCorporationMst(), beforeMaster);
		assertEquals(null , afterMaster);

		// result Account 
		assertEquals(2, beforeSize);
		assertEquals(0, afterSize);
		
	}

	
	@Test
	public void copyToCorporationTmpDelete_Success(){
		int beforeSize = 0;
		int afterSize = 0;

		//=============== prepare Data before copy  temp to mst //
		corporationDao.insertCorporationTmpWithAccount(this.getCorporationMst(), this.getSavingAccount(), this.getCurrentAccount());
		corporationDao.copyToCorporationMst(this.getCorporationMst());
		// END =============== prepare Data before copy  temp to mst //
	    CorporationMst beforeMaster = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> beforeAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
	    if(null != beforeAccount){
	    	beforeSize = beforeAccount.size();
	    }
		
	    //================ Business ===================================/
	    corporationDao.copyToCorporationTmpDelete(this.getCorporationMst());
	    //================End Business ===================================/
		
		
	    CorporationMst afterMaster = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);	
	    List<AccountMst> afterAccount = accountDao.getAccountTmpByCorpCode(DEFAULT_CODE_CORP);
	    if(null != afterAccount){
	    	afterSize = afterAccount.size();
	    }
		
		//============== clear all data on database =============/
		this.clearAllCorporationData();
		this.clearAllAccountData();
		//==============End clear all data on database =============/
		
		
		// result Corporation
		assertEquals(null , beforeMaster);
		assertEquals(this.getCorporationMst(), afterMaster);

		// result Account 
		assertEquals(0, beforeSize);
		assertEquals(2, afterSize);
	}
	
	
	@Test
	public void countCorporationTmp_Success(){
		int beforeCount = corporationDao.countCorporationTmp();

		//=========== prepare data before call method //
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		//=========== End prepare data before call method //
		
		
	    //================ Business ===================================/
		int afterCount = corporationDao.countCorporationTmp();
	    //================ End Business ===================================/

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//==============End clear all data on database =============/


		assertEquals(0, beforeCount);
		assertEquals(1, afterCount);
		
	}
	
	@Test
	public void countCorporationMst(){
		int beforeCount = corporationDao.countCorporationMst();

		//=========== prepare data before call method //
		corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //
		
		
	    //================ Business ===================================/
		int afterCount = corporationDao.countCorporationMst();
	    //================End Business ===================================/

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//==============End clear all data on database =============/

		assertEquals(0, beforeCount);
		assertEquals(1, afterCount);
		
	}
	
	
	
/*
	@Test(expected = Exception.class) 
	public void updateCorporationInformationWithUMMProfile_Fail() {
		//=========== prepare data before call method //
		corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //
		
		CorporationMst mst = this.getCorporationMst();

		mst.setCorpName(null);
		mst.setLastUpdatedBy(null);
		corporationDao.updateCorporationInformationWithUMMProfile(mst);

	}
	*/
	
	
	
	@Test
	public void updateCorporationInformationWithUMMProfile_Success() {
		//=========== prepare data before call method //
		corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //
	     
		CorporationMst beforeMst = this.getCorporationMst();
		Date dateUtil = new Date();
		Timestamp ummRequestDate = new java.sql.Timestamp(dateUtil.getTime());

		beforeMst.setUmmCompanyStatus("A");
		beforeMst.setUmmServiceStatus("A");
		beforeMst.setUmmSyncDate(ummRequestDate);
		
	    //================ Business ===================================/
		corporationDao.updateCorporationInformationWithUMMProfile(beforeMst);
	    //================ End Business ===================================/
		CorporationMst tempResult = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		CorporationMst mstResult = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		CorporationMst resultFinal = null;
		if(tempResult !=null){
			resultFinal = tempResult;
		}else if(mstResult != null){
			resultFinal = mstResult;
		}else{
			resultFinal = null;
		}

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeMst, resultFinal );
		
	}
	
	
	/*
	@Test(expected = Exception.class) 
	public void updateCorporationUMMStatusOnlyWithUMMProfile_Fail() {
		//=========== prepare data before call method //
	     corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //

		CorporationMst mst = this.getCorporationMst();

		mst.setLastUpdatedBy(null);
		corporationDao.updateCorporationUMMStatusOnlyWithUMMProfile(mst);

	}
	*/
	

	@Test
	public void updateCorporationUMMStatusOnlyWithUMMProfile_Success() {
		//=========== prepare data before call method //
	     corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //
	     
	     
		CorporationMst beforeMst = this.getCorporationMst();
		Date dateUtil = new Date();
		Timestamp ummRequestDate = new java.sql.Timestamp(dateUtil.getTime());

		beforeMst.setUmmCompanyStatus("I");
		beforeMst.setUmmServiceStatus("I");
		beforeMst.setUmmSyncDate(ummRequestDate);
		
	    //================ Business ===================================/
		corporationDao.updateCorporationUMMStatusOnlyWithUMMProfile(beforeMst);
	    //================End Business ===================================/
		CorporationMst tempResult = corporationDao.getCorporationTmpByCorpCode(DEFAULT_CODE_CORP);
		CorporationMst mstResult = corporationDao.getCorporationMstByCorpCode(DEFAULT_CODE_CORP);
		CorporationMst resultFinal = null;
		if(tempResult !=null){
			resultFinal = tempResult;
		}else if(mstResult != null){
			resultFinal = mstResult;
		}else{
			resultFinal = null;
		}

		//============== clear all data on database =============/
		this.clearAllCorporationData();
		//============== END clear all data on database =============/
		
		assertEquals(beforeMst, resultFinal);
		
	}

	@Test
	public void deleteAllCorporationTmp_Success(){

		//=========== prepare data before call method //
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		//=========== End prepare data before call method //
		int beforeCount = corporationDao.countCorporationTmp();
		
	    //================ Business ===================================/
		corporationDao.deleteAllCorporationTmp();
	    //================End Business ===================================/
		
		int afterCount = corporationDao.countCorporationTmp();


		assertEquals(1, beforeCount);
		assertEquals(0, afterCount);
		
	}
	
	@Test
	public void deleteAllCorporationMst_Success(){
		//=========== prepare data before call method //
		corporationDao.insertCorporationMst(this.getCorporationMst());
		//=========== End prepare data before call method //
		int beforeCount = corporationDao.countCorporationMst();
		
	    //================ Business ===================================/
		corporationDao.deleteAllCorporationMst();
	    //================End Business ===================================/
		
		int afterCount = corporationDao.countCorporationMst();


		assertEquals(1, beforeCount);
		assertEquals(0, afterCount);
		
	}
	
	
/**
x	public void insertCorporationMst(CorporationMst corporationMst);
x	public void insertCorporationTmp(CorporationMst corporationMst);
x	public void insertCorporationTmpWithAccount(CorporationMst corporationMst, AccountMst savingAccountMst, AccountMst currentAccountMst);
x	public void copyToCorporationMst(CorporationMst corporationMst);
x	public void copyToCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount);
x	public void updateTmpToCorporationMst(CorporationMst corporationMst);
x	public void updateAutorizeStatus(CorporationMst corporationMst);
x	public void updateCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount);
x	public int checkCorpDuplicate(String corpCode);
	public List<CorporationMst> searchCorporation(SearchDataTable<CorporationMst> searchDataTable);
	public int countCorporationFilter(SearchDataTable<CorporationMst> searchDataTable);
	public int countCorporationTotal(SearchDataTable<CorporationMst> searchDataTable);
x	public CorporationMst getCorporationTmpByCorpCode(String corpCode);
x	public CorporationMst getCorporationMstByCorpCode(String corpCode);
x	public void deleteCorporationMstCorpCode(String corpCode);
x	public void deleteCorporationTmpCorpCode(String corpCode);
x	public void copyToCorporationTmpDelete(CorporationMst corporationMst);
x	public int countCorporationTmp();
x	public int countCorporationMst();
x	public void updateCorporationInformationWithUMMProfile(CorporationMst corporationMst);
x	public void updateCorporationUMMStatusOnlyWithUMMProfile(CorporationMst corporationMst);
x	public void deleteAllCorporationTmp();
x	public void deleteAllCorporationMst();
*/
	
	private void clearAllCorporationData(){
		corporationDao.deleteAllCorporationTmp();
		corporationDao.deleteAllCorporationMst();
	}

	private void clearAllAccountData(){
		accountDao.deleteAllAccountTmp();
		accountDao.deleteAllAccountMst();
	}


}
