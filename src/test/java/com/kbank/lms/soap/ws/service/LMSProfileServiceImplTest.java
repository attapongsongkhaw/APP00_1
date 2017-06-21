package com.kbank.lms.soap.ws.service;

import static org.junit.Assert.*;

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

import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.CompanyProfileBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyResBase;
import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;
import com.kbank.corp.umm.schema.usermanagement.CheckDeleteUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.CheckDeleteUserResBase;
import com.kbank.corp.umm.schema.usermanagement.CreateUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.CreateUserResBase;
import com.kbank.corp.umm.schema.usermanagement.DeleteUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.DeleteUserResBase;
import com.kbank.corp.umm.schema.usermanagement.ModifyUserReqBase;
import com.kbank.corp.umm.schema.usermanagement.ModifyUserResBase;
import com.kbank.corp.umm.schema.usermanagement.UserProfileBase;
import com.kbank.lms.common.Application;
import com.kbank.lms.config.DataSorceConfig;
import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_UMMSERVICE)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LMSProfileServiceImplTest {

	private static final String DEFAULT_USER = "UNIT-TEST";
	private static final String DEFAULT_CODE_CORP = "CORP-UNIT001";
	private static final String DEFAULT_NAME_CORP = "UNIT001-NEW";
	
	
	@Autowired
	LMSProfileServiceImpl lMSProfileServiceImpl;

	@Autowired
	CorporationDao corporationDao;

	@Autowired
	UserDao userDao;

	private CompanyProfileBase companyProfileBase;
	private UserProfileBase userProfileBase;
	private UMMRequestBase ummRequestBase;
	private CreateCompanyReqBase createCompanyReqBase;
	
	

	public void setUmmRequestBase(UMMRequestBase ummRequestBase) {
		this.ummRequestBase = ummRequestBase;
	}

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		UserProfileBase user = new UserProfileBase();
		user.setCompanyCode(DEFAULT_CODE_CORP);
		user.setUserId(DEFAULT_USER);
		user.setStatus("A");
		user.setLoginAccount("VEERAYOOT");
		user.setFirstname("VEERAYOOT");
		user.setLastname("PENGNAM");
		
		this.setUserProfileBase(user);
		
		
		CompanyProfileBase company = new CompanyProfileBase();
		company.setCompanyCode(DEFAULT_CODE_CORP);
		company.setCompanyNameEn(DEFAULT_NAME_CORP);
		company.setCompanyStatus("A");
		
		this.setCompanyProfileBase(company);
		
		
		UMMRequestBase header = new UMMRequestBase();
		header.setRequestDate("17/05/2017 16:45:00");
		this.setUmmRequestBase(header);

		CreateCompanyReqBase input = new CreateCompanyReqBase();
		input.setCompanyProfile(this.getCompanyProfileBase());
		input.setUMMHeader(this.getUmmRequestBase());
		this.setCreateCompanyReqBase(input);
		
		
	}
	
	private void cleanAllCorporationLMS(){
		corporationDao.deleteAllCorporationMst();
		corporationDao.deleteAllCorporationTmp();
	}


	private void cleanAllUserLMSByCropCode(String corpCode){
		corporationDao.deleteCorporationTmpCorpCode(corpCode);
		corporationDao.deleteCorporationMstCorpCode(corpCode);
		userDao.deleteAllUserTmpByCorpCode(corpCode);
		userDao.deleteAllUserMstByCorpCode(corpCode);
	}
	
	
	@Test
	public void createUser_Success() {
		/*========== Prepare Data ========================*/
		CreateUserReqBase input = new CreateUserReqBase();
		input.setUserProfile(this.getUserProfileBase());
		input.setUMMHeader(this.getUmmRequestBase());
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		/*========== Prepare Data ========================*/
		
		CreateUserResBase result = lMSProfileServiceImpl.createUser(input);		

		/*========== clean code ========================*/
		this.cleanAllUserLMSByCropCode(DEFAULT_CODE_CORP);
		/*========== clean code ========================*/
		
		assertEquals(true ,result.isSuccess() );
		
	}

	@Test
	public void modifyUser_Success() {
		/*========== Prepare Data ========================*/
		CreateUserReqBase inputPrepare = new CreateUserReqBase();
		inputPrepare.setUserProfile(this.getUserProfileBase());
		inputPrepare.setUMMHeader(this.getUmmRequestBase());
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		lMSProfileServiceImpl.createUser(inputPrepare);		
		/*========== Prepare Data ========================*/

		ModifyUserReqBase input = new ModifyUserReqBase();
		input.setUserProfile(this.getUserProfileBase());
		input.setUMMHeader(this.getUmmRequestBase());
		
		ModifyUserResBase result = lMSProfileServiceImpl.modifyUser(input);
		/*========== clean code ========================*/
		this.cleanAllUserLMSByCropCode(DEFAULT_CODE_CORP);
		/*========== clean code ========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void deleteUser_Success() {
		/*========== Prepare Data ========================*/
		CreateUserReqBase inputPrepare = new CreateUserReqBase();
		inputPrepare.setUserProfile(this.getUserProfileBase());
		inputPrepare.setUMMHeader(this.getUmmRequestBase());
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		lMSProfileServiceImpl.createUser(inputPrepare);		
		/*========== Prepare Data ========================*/

		DeleteUserReqBase input = new DeleteUserReqBase();
		input.setUserProfile(this.getUserProfileBase());
		input.setUMMHeader(this.getUmmRequestBase());

		DeleteUserResBase result =  lMSProfileServiceImpl.deleteUser(input);
		/*========== clean code ========================*/
		this.cleanAllUserLMSByCropCode(DEFAULT_CODE_CORP);
		/*========== clean code ========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void checkDeleteUser_Success() {
		/*========== Prepare Data ========================*/
		CreateUserReqBase inputPrepare = new CreateUserReqBase();
		inputPrepare.setUserProfile(this.getUserProfileBase());
		inputPrepare.setUMMHeader(this.getUmmRequestBase());
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		lMSProfileServiceImpl.createUser(inputPrepare);		
		/*========== Prepare Data ========================*/

		CheckDeleteUserReqBase input = new CheckDeleteUserReqBase();
		input.setCompanyCode(this.getUserProfileBase().getCompanyCode());
		input.setLoginAccount(this.getUserProfileBase().getLoginAccount());
		input.setUMMHeader(this.getUmmRequestBase());

		CheckDeleteUserResBase result =  lMSProfileServiceImpl.checkDeleteUser(input);
		/*========== clean code ========================*/
		this.cleanAllUserLMSByCropCode(DEFAULT_CODE_CORP);
		/*========== clean code ========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void createCompany_Success() {
		CreateCompanyResBase result =  lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());

		/** ============= Clean Data ==========================*/
		this.cleanAllCorporationLMS();
		/** ============= End Clean Data ==========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void modifyCompany_Success() {
		/** ================ prepare data ====================*/
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		/** ================ End prepare data ====================*/

		ModifyCompanyReqBase input = new ModifyCompanyReqBase();
		CompanyProfileBase profile = this.getCompanyProfileBase();
		profile.setCompanyNameEn("TESTUNIT-001");

		input.setCompanyProfile(profile);
		input.setUMMHeader(this.getUmmRequestBase());

		ModifyCompanyResBase result = lMSProfileServiceImpl.modifyCompany(input);

		/** ============= Clean Data ==========================*/
		this.cleanAllCorporationLMS();
		/** ============= End Clean Data ==========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void deleteCompany_Success() {
		/** ================ prepare data ====================*/
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		/** ================ End prepare data ====================*/

		DeleteCompanyReqBase input = new DeleteCompanyReqBase();
		input.setCompanyProfile(this.getCompanyProfileBase());
		input.setUMMHeader(this.getUmmRequestBase());
		
		
		DeleteCompanyResBase result = lMSProfileServiceImpl.deleteCompany(input);

		/** ============= Clean Data ==========================*/
		this.cleanAllCorporationLMS();
		/** ============= End Clean Data ==========================*/

		assertEquals(true ,result.isSuccess() );
	}

	@Test
	public void checkDeleteCompany_Success() {
		/** ================ prepare data ====================*/
		lMSProfileServiceImpl.createCompany(this.getCreateCompanyReqBase());
		/** ================ End prepare data ====================*/

		CheckDeleteCompanyReqBase input = new CheckDeleteCompanyReqBase();
		input.setUMMHeader(this.getUmmRequestBase());
		input.setCompanyCode(this.getCompanyProfileBase().getCompanyCode());

		CheckDeleteCompanyResBase result = lMSProfileServiceImpl.checkDeleteCompany(input);

		/** ============= Clean Data ==========================*/
		this.cleanAllCorporationLMS();
		/** ============= End Clean Data ==========================*/

		assertEquals(true ,result.isSuccess() );
	}
	

	/** ============================== UN Success ===================================== */
	@Test
	public void createUser_UnSuccess() {
		CreateUserReqBase input = null;
		CreateUserResBase result = lMSProfileServiceImpl.createUser(input);		
		assertEquals(false ,result.isSuccess() );
		
	}

	@Test
	public void modifyUser_UnSuccess() {
		ModifyUserReqBase input = null;
		ModifyUserResBase result = lMSProfileServiceImpl.modifyUser(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void deleteUser_UnSuccess() {
		DeleteUserReqBase input = null;
		DeleteUserResBase result =  lMSProfileServiceImpl.deleteUser(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void checkDeleteUser_UnSuccess() {
		CheckDeleteUserReqBase input = null;
		CheckDeleteUserResBase result =  lMSProfileServiceImpl.checkDeleteUser(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void createCompany_UnSuccess() {
		CreateCompanyReqBase input = null;
		CreateCompanyResBase result =  lMSProfileServiceImpl.createCompany(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void modifyCompany_UnSuccess() {
		ModifyCompanyReqBase input = null;
		ModifyCompanyResBase result = lMSProfileServiceImpl.modifyCompany(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void deleteCompany_UnSuccess() {
		DeleteCompanyReqBase input = null ;
		DeleteCompanyResBase result = lMSProfileServiceImpl.deleteCompany(input);
		assertEquals(false ,result.isSuccess() );
	}

	@Test
	public void checkDeleteCompany_UnSuccess() {
		CheckDeleteCompanyReqBase input = null;
		CheckDeleteCompanyResBase result = lMSProfileServiceImpl.checkDeleteCompany(input);
		assertEquals(false ,result.isSuccess() );
	}
	
	
	
	public CreateCompanyReqBase getCreateCompanyReqBase() {
		return createCompanyReqBase;
	}

	public void setCreateCompanyReqBase(CreateCompanyReqBase createCompanyReqBase) {
		this.createCompanyReqBase = createCompanyReqBase;
	}

	public CompanyProfileBase getCompanyProfileBase() {
		return companyProfileBase;
	}

	public void setCompanyProfileBase(CompanyProfileBase companyProfileBase) {
		this.companyProfileBase = companyProfileBase;
	}

	public UserProfileBase getUserProfileBase() {
		return userProfileBase;
	}

	public void setUserProfileBase(UserProfileBase userProfileBase) {
		this.userProfileBase = userProfileBase;
	}

	public UMMRequestBase getUmmRequestBase() {
		return ummRequestBase;
	}
}
