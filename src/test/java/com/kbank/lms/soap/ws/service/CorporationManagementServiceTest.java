package com.kbank.lms.soap.ws.service;

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
import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CheckDeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.CompanyProfileBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.CreateCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.DeleteCompanyResBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyReqBase;
import com.kbank.corp.umm.schema.companymanagement.ModifyCompanyResBase;
import com.kbank.corp.umm.schema.ummcommon.Service;
import com.kbank.corp.umm.schema.ummcommon.Services;
import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CorporationManagementServiceTest {


	@Autowired
	CorporationManagementService corporationManagementService;
	
	
	private CompanyProfileBase companyProfileBase;

	

	public CompanyProfileBase getCompanyProfileBase() {
		return companyProfileBase;
	}

	public void setCompanyProfileBase(CompanyProfileBase companyProfileBase) {
		this.companyProfileBase = companyProfileBase;
	}

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		CompanyProfileBase baseData = new CompanyProfileBase();
		baseData.setCompanyCode("UNITTEST-001");
		baseData.setCompanyNameEn("UNITTEST-NEW001");
		baseData.setCompanyStatus("A");
		
		this.setCompanyProfileBase(baseData);
	}

	/** 
	 * Create Company Group 1
	 */
	@Test	
	public void group1_case1_CreateNewCompany_null_fail(){
		CreateCompanyResBase output = new CreateCompanyResBase();
		output = corporationManagementService.createCompany(null);
		assertEquals("Create New corp : validate null : ",output.isSuccess(),false);
	}

	@Test	
	public void group1_case2_CreateNewCompany_Emptry_fail(){
		CreateCompanyReqBase input  = new CreateCompanyReqBase();
		CreateCompanyResBase output = new CreateCompanyResBase();
		
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp : validate new Object : ",output.isSuccess(),false);

	}

	@Test	
	public void group1_case3_CreateNewCompany_mandatory_fail(){
		
		CreateCompanyReqBase input  = new CreateCompanyReqBase();
		CreateCompanyResBase output = new CreateCompanyResBase();
		UMMRequestBase ummHeader = new UMMRequestBase();
		ummHeader.setRequestDate("17/05/2017 16:45:00");

		com.kbank.corp.umm.schema.ummcommon.Service service  = new Service(); 
		com.kbank.corp.umm.schema.ummcommon.Services services  = new Services();
		
		service.setServiceStatus("A");
		services.getService().add(service) ;
		

		CompanyProfileBase baseData = new CompanyProfileBase();
		baseData.setCompanyCode(null);
		baseData.setCompanyNameEn("UNITTEST-NEW001");
		baseData.setCompanyStatus("A");
		baseData.setCompanyServices(services);

		input.setCompanyProfile(baseData);
		input.setUMMHeader(ummHeader);
		
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp : validate Mandatory : ",output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("");
		baseData.setCompanyNameEn("UNITTEST-NEW001");
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp : validate Mandatory : ",output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("UNITTEST-001");
		baseData.setCompanyNameEn(null);
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp : validate Mandatory : ",output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("UNITTEST-001");
		baseData.setCompanyNameEn("");
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp : validate Mandatory : ",output.isSuccess(),false);

	}


	@Test	
	public void group1_case4_CreateNewCompany_Success(){
		CreateCompanyReqBase input  = new CreateCompanyReqBase();
		CreateCompanyResBase output = new CreateCompanyResBase();
		input.setCompanyProfile(this.getCompanyProfileBase());
		output = corporationManagementService.createCompany(input);
		assertEquals("Create New corp result",output.isSuccess(),true);


	}


	@Test	
	public void group1_case5_ExistsCompany_Success(){
		CreateCompanyReqBase input  = new CreateCompanyReqBase();
		CreateCompanyResBase output = new CreateCompanyResBase();
		CompanyProfileBase baseData = this.getCompanyProfileBase();
		baseData.setCompanyNameEn("UNITTEST-UDP001");
		input.setCompanyProfile(baseData);
		output = corporationManagementService.createCompany(input);
		assertEquals("Create Exists corp result",output.isSuccess(),true);

	}

	/****
	 * modify company  group 2
	 */


	@Test	
	public void group2_case1_UpdateInfomationCompany_null_fail(){
		ModifyCompanyResBase output = new ModifyCompanyResBase();
		output = corporationManagementService.modifyCompany(null);
		assertEquals(output.isSuccess(),false);


	}
	@Test	
	public void group2_case2_UpdateInfomationCompany_Emptry_fail(){
		ModifyCompanyReqBase input  = new ModifyCompanyReqBase();
		ModifyCompanyResBase output = new ModifyCompanyResBase();
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);

	}

	@Test	
	public void group2_case3_UpdateInfomationCompany_mandatory_fail(){
		ModifyCompanyReqBase input  = new ModifyCompanyReqBase();
		ModifyCompanyResBase output = new ModifyCompanyResBase();

		CompanyProfileBase baseData = new CompanyProfileBase();
		baseData.setCompanyCode(null);
		baseData.setCompanyNameEn("UNITTEST-MODIFY001");
		baseData.setCompanyStatus("A");
		
		input.setCompanyProfile(baseData);
		
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("");
		baseData.setCompanyNameEn("UNITTEST-MODIFY001");
		baseData.setCompanyStatus("A");
		
		input.setCompanyProfile(baseData);
		
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("UNITTEST-001");
		baseData.setCompanyNameEn(null);
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);

		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("UNITTEST-001");
		baseData.setCompanyNameEn("");
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);
		
		
		baseData = new CompanyProfileBase();
		baseData.setCompanyCode("NOT-001");
		baseData.setCompanyNameEn("");
		baseData.setCompanyStatus("A");
		input.setCompanyProfile(baseData);
		
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),false);

	}
	
	@Test	
	public void group2_case4_UpdateInfomationCompany_Success(){
		ModifyCompanyReqBase input  = new ModifyCompanyReqBase();
		ModifyCompanyResBase output = new ModifyCompanyResBase();

		UMMRequestBase ummHeader = new UMMRequestBase();
		ummHeader.setRequestDate("17/05/2017 16:45:00");
		com.kbank.corp.umm.schema.ummcommon.Service service  = new Service(); 
		com.kbank.corp.umm.schema.ummcommon.Services services  = new Services();
		service.setServiceStatus("A");
		services.getService().add(service) ;

		CompanyProfileBase baseData = this.getCompanyProfileBase();
		baseData.setCompanyNameEn("UNITTEST-MODIFY001");
		baseData.setCompanyServices(services);
		baseData.setCompanyStatus("A");

		input.setCompanyProfile(baseData);
		output = corporationManagementService.modifyCompany(input);
		assertEquals(output.isSuccess(),true);

	}




	/** 
	 * Check Delete  group 3
	 */
	
	@Test	
	public void group3_case1_CheckBeforeDeleteCompany_null_fail(){
		CheckDeleteCompanyResBase output = new CheckDeleteCompanyResBase();
		output = corporationManagementService.checkDeleteCompany(null);
		assertEquals(output.isSuccess(),false);


	}
	@Test	
	public void group3_case2_CheckBeforeDeleteCompany_Emptry_fail(){
		CheckDeleteCompanyReqBase input  = new CheckDeleteCompanyReqBase();
		CheckDeleteCompanyResBase output = new CheckDeleteCompanyResBase();
		output = corporationManagementService.checkDeleteCompany(input);
		assertEquals(output.isSuccess(),false);

	}

	@Test	
	public void group3_case3_CheckBeforeDeleteCompany_validation_fail(){
		CheckDeleteCompanyReqBase input  = new CheckDeleteCompanyReqBase();
		CheckDeleteCompanyResBase output = new CheckDeleteCompanyResBase();

		input.setCompanyCode(null);
		output = corporationManagementService.checkDeleteCompany(input);
		assertEquals(output.isSuccess(),false);


		input.setCompanyCode("CORP001-NOTEXIST");
		output = corporationManagementService.checkDeleteCompany(input);
		assertEquals(output.isSuccess(),false);

	}
	
	@Test	
	public void group3_case4_CheckBeforeDeleteCompany_Success(){
		CheckDeleteCompanyReqBase input  = new CheckDeleteCompanyReqBase();
		CheckDeleteCompanyResBase output = new CheckDeleteCompanyResBase();

		CompanyProfileBase baseData = this.getCompanyProfileBase();
		input.setCompanyCode(baseData.getCompanyCode());

		output = corporationManagementService.checkDeleteCompany(input);
		assertEquals(output.isSuccess(),true);

	}

	/** 
	 * Check Delete  group 4
	 */
	@Test	
	public void group4_case1_DeleteCompany_null_fail(){
		DeleteCompanyResBase output = new DeleteCompanyResBase();
		output = corporationManagementService.deleteCompany(null);
		assertEquals(output.isSuccess(),false);


	}
	@Test	
	public void group4_case2_DeleteCompany_Emptry_fail(){
		DeleteCompanyReqBase input  = new DeleteCompanyReqBase();
		DeleteCompanyResBase output = new DeleteCompanyResBase();
		output = corporationManagementService.deleteCompany(input);
		assertEquals(output.isSuccess(),false);

	}

	@Test	
	public void group4_case3_DeleteCompany_validation_fail(){
		DeleteCompanyReqBase input  = new DeleteCompanyReqBase();
		DeleteCompanyResBase output = new DeleteCompanyResBase();
		
		CompanyProfileBase baseData = new CompanyProfileBase();
		baseData.setCompanyCode(null);
		
		output = corporationManagementService.deleteCompany(input);
		assertEquals(output.isSuccess(),false);

		baseData.setCompanyCode("CORP001-NOTEXIST");
		output = corporationManagementService.deleteCompany(input);
		assertEquals(output.isSuccess(),false);
	}
	
	@Test	
	public void group4_case4_DeleteCompany_Success(){
		DeleteCompanyReqBase input  = new DeleteCompanyReqBase();
		DeleteCompanyResBase output = new DeleteCompanyResBase();

		CompanyProfileBase baseData = this.getCompanyProfileBase();
		baseData.setCompanyStatus("I");
		
		
		input.setCompanyProfile(baseData);

		output = corporationManagementService.deleteCompany(input);
		assertEquals(output.isSuccess(),true);

	}
}
