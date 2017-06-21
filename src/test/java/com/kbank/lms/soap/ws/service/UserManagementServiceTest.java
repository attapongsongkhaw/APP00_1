package com.kbank.lms.soap.ws.service;

import static org.junit.Assert.assertEquals;

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

import com.kbank.corp.umm.schema.companymanagement.CompanyProfileBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyResBase;
import com.kbank.corp.umm.schema.ummcommon.Service;
import com.kbank.corp.umm.schema.ummcommon.Services;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserManagementServiceTest {
	private static final String LOGIN_NAME = "user.lms";
	private static final String COMPANY_CODE = "KBANK-001";
	
	@Autowired
	UserManagementService userManagementService;
	
	@Autowired
	CorporationManagementService corpManagementService;

	private CreateCompanyReqBase createCompanyReqBase;
	
	private UserProfileBase userProfileBase;
	private UMMRequestBase ummRequestBase;
	
	
	public CreateCompanyReqBase getCreateCompanyReqBase() {
		return createCompanyReqBase;
	}

	public void setCreateCompanyReqBase(CreateCompanyReqBase createCompanyReqBase) {
		this.createCompanyReqBase = createCompanyReqBase;
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

	public void setUmmRequestBase(UMMRequestBase ummRequestBase) {
		this.ummRequestBase = ummRequestBase;
	}

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		
		CompanyProfileBase baseData = new CompanyProfileBase();
		CreateCompanyReqBase cropCreate = new CreateCompanyReqBase();
		baseData.setCompanyCode(COMPANY_CODE);
		baseData.setCompanyNameEn("UNITTEST-NEW001");
		baseData.setCompanyStatus("A");
		
		cropCreate.setCompanyProfile(baseData);
		this.setCreateCompanyReqBase(cropCreate);
		
		UserProfileBase user = new UserProfileBase();
		user.setLoginAccount(LOGIN_NAME);
		user.setCompanyCode(COMPANY_CODE);
		user.setActionMode("A");
		user.setLastname("PENGNAM_Lastname");
		user.setFirstname("PENGNAM_Firstname");
		user.setStatus("A");
		
		
		com.kbank.corp.umm.schema.ummcommon.Services serviceList  = new Services();
		com.kbank.corp.umm.schema.ummcommon.Service service = new Service();
		
		service.setServiceCode("LMS");
		service.setServiceName(COMPANY_CODE);
		service.setServiceStatus("A");
		serviceList.getService().add(service);
		user.setServicelist(serviceList);

		this.setUserProfileBase(user);
	}
	
	@Test
	public void createUser_Success(){
		CreateUserReqBase input = new CreateUserReqBase();
		CreateUserResBase output = new  CreateUserResBase();
		//========= prepare corporation ====================
		corpManagementService.createCompany(this.getCreateCompanyReqBase());
		//========= End prepare corporation ====================
		
		input.setUserProfile(this.getUserProfileBase());
		output = userManagementService.createUser(input);

		//=============Clear Data ================
		userManagementService.clearAllUserByCorpCode(COMPANY_CODE);
		corpManagementService.clearCorporationByCorpCode(COMPANY_CODE);
		//=============End Clear Data ================
		assertEquals(output.isSuccess(),true);
	}

	@Test
	public void modifyUser_Success(){
		//========= prepare corporation ====================
		corpManagementService.createCompany(this.getCreateCompanyReqBase());
		//========= End prepare corporation ====================
		
		//============= Prepare data ================
		CreateUserReqBase prepareInput = new CreateUserReqBase();
		prepareInput.setUserProfile(this.getUserProfileBase());
		userManagementService.createUser(prepareInput);
		//=============End Prepare data ================
		
		
		ModifyUserReqBase input = new ModifyUserReqBase();
		ModifyUserResBase output = new  ModifyUserResBase();
		
		input.setUserProfile(this.getUserProfileBase());
		output = userManagementService.modifyUser(input);

		//=============Clear Data ================
		userManagementService.clearAllUserByCorpCode(COMPANY_CODE);
		corpManagementService.clearCorporationByCorpCode(COMPANY_CODE);
		//=============End Clear Data ================
		assertEquals(output.isSuccess(),true);
	}

	@Test
	public void checkDeleteUser_Success(){
		//========= prepare corporation ====================
		corpManagementService.createCompany(this.getCreateCompanyReqBase());
		//========= End prepare corporation ====================
		//============= Prepare data ================
		CreateUserReqBase prepareInput = new CreateUserReqBase();
		prepareInput.setUserProfile(this.getUserProfileBase());
		userManagementService.createUser(prepareInput);
		//=============End Prepare data ================
		CheckDeleteUserReqBase input = new CheckDeleteUserReqBase();
		CheckDeleteUserResBase output = new  CheckDeleteUserResBase();
		
		input.setCompanyCode(COMPANY_CODE);
		input.setLoginAccount(LOGIN_NAME);
		
		output = userManagementService.checkDeleteUser(input);

		//=============Clear Data ================
		userManagementService.clearAllUserByCorpCode(COMPANY_CODE);
		corpManagementService.clearCorporationByCorpCode(COMPANY_CODE);
		//=============End Clear Data ================
		assertEquals(output.isSuccess(),true);
	}

	@Test
	public void deleteUser_Success(){
		//========= prepare corporation ====================
		corpManagementService.createCompany(this.getCreateCompanyReqBase());
		//========= End prepare corporation ====================
		//============= Prepare data ================
		CreateUserReqBase prepareInput = new CreateUserReqBase();
		prepareInput.setUserProfile(this.getUserProfileBase());
		userManagementService.createUser(prepareInput);
		//=============End Prepare data ================

		DeleteUserReqBase input = new DeleteUserReqBase();
		DeleteUserResBase output = new  DeleteUserResBase();
		
		input.setUserProfile(this.getUserProfileBase());
		output = userManagementService.deleteUser(input);

		//=============Clear Data ================
		userManagementService.clearAllUserByCorpCode(COMPANY_CODE);
		corpManagementService.clearCorporationByCorpCode(COMPANY_CODE);
		//=============End Clear Data ================
		assertEquals(output.isSuccess(),true);
	}
}
