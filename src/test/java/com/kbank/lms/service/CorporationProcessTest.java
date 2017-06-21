package com.kbank.lms.service;

import static org.junit.Assert.*;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kbank.lms.common.Application;
import com.kbank.lms.config.DataSorceConfig;
import com.kbank.lms.dao.AccountDao;
import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_CORPORATION)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
public class CorporationProcessTest {
	
	@Autowired
	CorporationService corporationService;
    
	@Autowired
	CorporationDao corporationDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	AccountService accountService;
	
	private CorporationMst corporationMst;
	private AccountMst savingAccountMst;
	private AccountMst currentAccountMst;

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		CorporationMst corporation = new CorporationMst();
		corporation.setCorpCode("GOR");
		corporation.setCorpName("GORILLAZ");
		corporation.setCisId("111111111111");
		corporation.setTaxpayerNo(null);
		corporation.setTaxpayerName(null);
		corporation.setChargeFlag(null);
		corporation.setChargeAccount(null);
		corporation.setChargeAmount(null);
		corporation.setChargeDate(null);
		corporation.setChargeFreq(null);
		corporation.setChargeType(null);
		corporation.setActiveStatus("Y");
		corporation.setOperationFlag("N");
		corporation.setAuthorizeStatus("W");
		corporation.setAuthorizedBy("CHECKER");
		corporation.setRejectReason("REJECT REASON");
		corporation.setLastUpdatedBy("TEST");
		corporation.setCreatedBy("TEST");
		this.setCorporationMst(corporation);
		
		AccountMst accountSaving = new AccountMst();
		accountSaving.setAccountNo("0000000000");
		accountSaving.setAccountNameEn("Mr.David Beckham");
		accountSaving.setAccountNameTh("นายเดวิด เบคแฮม");
		accountSaving.setKbankProductCode("SA");
		accountSaving.setCisId("123456789012");
		accountSaving.setAccountLevel("01");
		accountSaving.setCorpCode("GOR");
		accountSaving.setClientCode(null);
		accountSaving.setActiveStatus("Y");
		accountSaving.setRejectReason("REJECT REASON");
		accountSaving.setOperationFlag("N");
		accountSaving.setAuthorizeStatus("W");
		accountSaving.setAuthorizedBy("CHECKER");
		accountSaving.setRejectReason("REJECT REASON");
		accountSaving.setLastUpdatedBy("TEST");
		accountSaving.setCreatedBy("TEST");
		this.setSavingAccountMst(accountSaving);
		
		AccountMst accountCurrent = new AccountMst();
		accountCurrent.setAccountNo("0111111111");
		accountCurrent.setAccountNameEn("Mrs.Orngsan Sooji");
		accountCurrent.setAccountNameTh("นางอองซาน ซูจี");
		accountCurrent.setKbankProductCode("CA");
		accountCurrent.setCisId("123456789012");
		accountCurrent.setAccountLevel("02");
		accountCurrent.setCorpCode("GOR");
		accountCurrent.setClientCode(null);
		accountCurrent.setRejectReason("REJECT REASON");
		accountCurrent.setActiveStatus("Y");
		accountCurrent.setOperationFlag("N");
		accountCurrent.setAuthorizeStatus("W");
		accountCurrent.setAuthorizedBy("CHECKER");
		accountCurrent.setRejectReason("REJECT REASON");
		accountCurrent.setLastUpdatedBy("TEST");
		accountCurrent.setCreatedBy("TEST");
		this.setCurrentAccountMst(accountCurrent);	
		clearData();
		
	}
	
	@Test
    public void Test_Maker_SaveCorporationByMaker_Mode_ADD_Success(){	
		int cntCorpStart = corporationDao.countCorporationTmp();
		int cntAccountStart = accountDao.countAccountTmp();
		corporationService.saveCorporationByMaker(this.getCorporationMst(), this.getSavingAccountMst(), this.getCurrentAccountMst(), "ADD", "");
		int cntCorpEnd = corporationDao.countCorporationTmp();
		int cntAccountEnd = accountDao.countAccountTmp();
		cntCorpStart = cntCorpStart + 1;
		cntAccountStart = cntAccountStart + 2;
		assertEquals(cntCorpStart, cntCorpEnd);	
		assertEquals(cntAccountStart, cntAccountEnd);	
    }
	
	@Test
	public void Test_Checker_rejectCorporationByCorpCode_Coprporation_Pending_Success(){
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		int idSaving = accountDao.insertAccountTmp(this.getSavingAccountMst());
		int idCurrent = accountDao.insertAccountTmp(this.getCurrentAccountMst());
		corporationMst.setAuthorizeStatus("N");
		corporationService.rejectCorporationByCorpCode(corporationMst);
		CorporationMst corpTmp = corporationDao.getCorporationTmpByCorpCode(this.getCorporationMst().getCorpCode());
		//AccountMst savingAccountTmp = accountDao.getAccountByAccountIdTmp(idSaving);
		//AccountMst currentAccountTmp = accountDao.getAccountByAccountIdTmp(idCurrent);
		AccountMst savingAccountTmp = accountDao.getAccountTmpById(idSaving);
		AccountMst currentAccountTmp = accountDao.getAccountTmpById(idCurrent);
		assertEquals(corpTmp.getAuthorizeStatus(), "N");	
		assertEquals(savingAccountTmp.getAuthorizeStatus(), "N");
		assertEquals(currentAccountTmp.getAuthorizeStatus(), "N");
	}
	
	@Test
	public void Test_Checker_AcceptCorporationByCorpCode_CoprporationMst_Isnull_Success(){
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		accountDao.insertAccountTmp(this.getSavingAccountMst());
		accountDao.insertAccountTmp(this.getCurrentAccountMst());
		int cntCorpStart = corporationDao.countCorporationMst();
		int cntAccountStart = accountDao.countAccountMst();
		corporationService.acceptCorporationByCorpCode(corporationMst);
		int cntCorpEnd = corporationDao.countCorporationMst();
		int cntAccountEnd = accountDao.countAccountMst();
		cntCorpStart = cntCorpStart + 1;
		cntAccountStart = cntAccountStart + 2;
		assertEquals(cntCorpStart, cntCorpEnd);	
		assertEquals(cntAccountStart, cntAccountEnd);	
	}
	
	@Test
    public void Test_Maker_SaveCorporationByMaker_Mode_EDIT_Type_P_Success(){	
		corporationMst.setAuthorizeStatus("N");
		savingAccountMst.setAuthorizeStatus("N");
		currentAccountMst.setAuthorizeStatus("N");
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		int idSaving = accountDao.insertAccountTmp(this.getSavingAccountMst());
		int idCurrent = accountDao.insertAccountTmp(this.getCurrentAccountMst());
		corporationMst.setAuthorizeStatus("W");
		savingAccountMst.setAuthorizeStatus("W");
		currentAccountMst.setAuthorizeStatus("W");
		corporationService.saveCorporationByMaker(this.getCorporationMst(), this.getSavingAccountMst(), this.getCurrentAccountMst(), "EDIT", "P");
		CorporationMst corpTmp = corporationDao.getCorporationTmpByCorpCode(this.getCorporationMst().getCorpCode());
//		AccountMst savingAccountTmp = accountDao.getAccountByAccountIdTmp(idSaving);
//		AccountMst currentAccountTmp = accountDao.getAccountByAccountIdTmp(idCurrent);
		AccountMst savingAccountTmp = accountDao.getAccountTmpById(idSaving);
		AccountMst currentAccountTmp = accountDao.getAccountTmpById(idCurrent);
		assertEquals(corpTmp.getAuthorizeStatus(), "W");	
		assertEquals(savingAccountTmp.getAuthorizeStatus(), "W");
		assertEquals(currentAccountTmp.getAuthorizeStatus(), "W");		
    }
	
	@Test
    public void Test_Maker_SaveCorporationByMaker_Mode_EDIT_Type_A_Success(){	
		corporationMst.setAuthorizeStatus("Y");
		savingAccountMst.setAuthorizeStatus("Y");
		currentAccountMst.setAuthorizeStatus("Y");
		corporationDao.insertCorporationMst(this.getCorporationMst());
		accountDao.insertAccountMst(this.getSavingAccountMst());
		accountDao.insertAccountMst(this.getCurrentAccountMst());
		int cntCorpStart = corporationDao.countCorporationTmp();
		int cntAccountStart = accountDao.countAccountTmp();
		corporationMst.setAuthorizeStatus("W");
		savingAccountMst.setAuthorizeStatus("W");
		currentAccountMst.setAuthorizeStatus("W");
		corporationService.saveCorporationByMaker(this.getCorporationMst(), this.getSavingAccountMst(), this.getCurrentAccountMst(), "EDIT", "A");
		int cntCorpEnd = corporationDao.countCorporationMst();
		int cntAccountEnd = accountDao.countAccountMst();
		cntCorpStart = cntCorpStart + 1;
		cntAccountStart = cntAccountStart + 2;
		assertEquals(cntCorpStart, cntCorpEnd);	
		assertEquals(cntAccountStart, cntAccountEnd);		
    }
	
	@Test
	public void Test_Checker_AcceptCorporationByCorpCode_CoprporationMst_IsNotnull_Success(){
		corporationMst.setAuthorizeStatus("Y");
		savingAccountMst.setAuthorizeStatus("Y");
		currentAccountMst.setAuthorizeStatus("Y");
		corporationDao.insertCorporationMst(this.getCorporationMst());
		int idSaving = accountDao.insertAccountMst(this.getSavingAccountMst());
		int idCurrent = accountDao.insertAccountMst(this.getSavingAccountMst());
		corporationMst.setAuthorizeStatus("W");
		savingAccountMst.setAuthorizeStatus("W");
		currentAccountMst.setAuthorizeStatus("W");
		corporationMst.setOperationFlag("E");;
		savingAccountMst.setOperationFlag("E");
		currentAccountMst.setOperationFlag("E");
		corporationMst.setCorpName("GORILLAR UPDATE");
		savingAccountMst.setAccountNameEn("GORILLAR UPDATE");
		currentAccountMst.setAccountNameEn("GORILLAR UPDATE");
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		accountDao.insertAccountTmp(this.getSavingAccountMst());
		accountDao.insertAccountTmp(this.getSavingAccountMst());
		corporationService.acceptCorporationByCorpCode(corporationMst);
		CorporationMst corpMst = corporationDao.getCorporationMstByCorpCode(this.getCorporationMst().getCorpCode());
		AccountMst savingAccountMst = accountDao.getAccountMstById(idSaving);
		AccountMst currentAccountMst = accountDao.getAccountMstById(idCurrent);
		assertEquals(corpMst.getAuthorizeStatus(), "Y");	
		assertEquals(savingAccountMst.getAuthorizeStatus(), "Y");
		assertEquals(currentAccountMst.getAuthorizeStatus(), "Y");
		/*assertEquals(corpMst.getCorpName(), "GORILLAR UPDATE");
		assertEquals(savingAccountMst.getAccountNameEn(), "GORILLAR UPDATE");
		assertEquals(currentAccountMst.getAccountNameEn(), "GORILLAR UPDATE");*/
	}
	
	@Test
	public void Test_Checker_AcceptCorporationByCorpCode_CoprporationMst_Delete_Success(){
		corporationMst.setAuthorizeStatus("Y");
		savingAccountMst.setAuthorizeStatus("Y");
		currentAccountMst.setAuthorizeStatus("Y");
		corporationDao.insertCorporationTmp(this.getCorporationMst());
		accountDao.insertAccountTmp(this.getSavingAccountMst());
		accountDao.insertAccountTmp(this.getCurrentAccountMst());
		corporationMst.setOperationFlag("D");
		corporationService.acceptCorporationByCorpCode(corporationMst);
		int cntCorp = corporationDao.countCorporationMst();
		int cntAccount = accountDao.countAccountMst();
		assertEquals(cntCorp, 0);	
		assertEquals(cntAccount, 0);
	}
	
	private void clearData(){
		corporationDao.deleteAllCorporationMst();
		corporationDao.deleteAllCorporationTmp();
		accountDao.deleteAllAccountTmp();
		accountDao.deleteAllAccountMst();
	}
	
	public CorporationMst getCorporationMst() {
		return corporationMst;
	}

	public void setCorporationMst(CorporationMst corporationMst) {
		this.corporationMst = corporationMst;
	}

	public AccountMst getSavingAccountMst() {
		return savingAccountMst;
	}

	public void setSavingAccountMst(AccountMst savingAccountMst) {
		this.savingAccountMst = savingAccountMst;
	}

	public AccountMst getCurrentAccountMst() {
		return currentAccountMst;
	}

	public void setCurrentAccountMst(AccountMst currentAccountMst) {
		this.currentAccountMst = currentAccountMst;
	}
}
