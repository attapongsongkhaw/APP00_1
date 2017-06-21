package com.kbank.lms.service;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

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
import com.kbank.lms.dao.FunctionDao;
import com.kbank.lms.model.FunctionMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_FUNCTION)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
public class FunctionProcessTest {
	
	@Autowired
	FunctionDao functionDao;
	
	@Autowired
	FunctionService functionService;
	
	private FunctionMst functionMst;

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		FunctionMst function = new FunctionMst();
		function.setCorpCode("INSURE01");
		function.setFuncCode("01");
		function.setExecFreq("D");
		function.setDayOfWeek("0000000");
		function.setDayOfMonth("0000000000000000000000000000");
		function.setVipFlag("Y");
		function.setOvernightFlag("Y");
		
		function.setEffectiveDateStr("2017-05-11");
		function.setEffectiveDate(new GregorianCalendar(2017,05, 11).getTime());
		function.setActiveStatus("Y");
		function.setOperationFlag("N");
		function.setAuthorizeStatus("W");
		function.setAuthorizedBy("CHECKER");
		function.setRejectReason("REJECT REASON");
		function.setLastUpdatedBy("TEST");
		function.setCreatedBy("TEST");
		this.setFunctionMst(function);
		clearData();
	}
	
	@Test
    public void Test_Maker_SaveFunctionByMaker_Mode_ADD_Success(){	
		int cntFuncBefore = functionDao.countFuctionTmp();
		functionService.saveFunctionByMaker(this.getFunctionMst(), "ADD", "");
		int cntFuncAffter = functionDao.countFuctionTmp();
		cntFuncBefore = cntFuncBefore + 1;
		assertEquals(cntFuncBefore, cntFuncAffter);		
    }
	

	/*@Test
	public void Test_Checker_rejectFuncByCorpCode_Pending_Success(){
		functionDao.insertFunctionTmp(this.getFunctionMst());
		functionMst.setAuthorizeStatus("N");
		functionService.rejectFunctionByCorpCode(functionMst);
		FunctionMst functionTmp = (FunctionMst) functionDao.getFunctionTmpByCorpCode(this.getFunctionMst().getCorpCode());
		assertEquals(functionTmp.getAuthorizeStatus(), "N");	
	}*/
	
	/*@Test
	public void Test_Checker_AcceptFunctionByCorpCode_FUnctionMst_Isnull_Success(){
		functionDao.insertFunctionTmp(this.getFunctionMst());
		int cntfuncBefore = functionDao.countFunctionMst();
		functionService.acceptFunctionByCorpCode(functionMst);
		int cntFunctionAfter = functionDao.countFunctionMst();
		cntfuncBefore = cntfuncBefore + 1;
		assertEquals(cntfuncBefore, cntFunctionAfter);	
	}*/
	
	@Test
    public void Test_Maker_SaveFunctionByMaker_Mode_EDIT_Type_P_Success(){	
		functionMst.setAuthorizeStatus("N");
		functionDao.insertFunctionTmp(this.getFunctionMst());
		functionMst.setAuthorizeStatus("W");
		functionService.saveFunctionByMaker(this.getFunctionMst(), "EDIT", "P");
		FunctionMst functionTmp = (FunctionMst) functionDao.getFunctionTmpByCorpCode(this.getFunctionMst().getCorpCode());
		assertEquals(functionTmp.getAuthorizeStatus(), "W");	
    }
	
	@Test
    public void Test_Maker_SaveFunctionByMaker_Mode_EDIT_Type_A_Success(){	
		functionMst.setAuthorizeStatus("Y");
		functionDao.insertFunctionMst(this.getFunctionMst());
		int cntFunctionBefore = functionDao.countFuctionTmp();
		functionMst.setAuthorizeStatus("W");
		functionService.saveFunctionByMaker(this.getFunctionMst(), "EDIT", "A");
		int cntFunctionAfter = functionDao.countFunctionMst();
		cntFunctionBefore = cntFunctionBefore + 1;
		assertEquals(cntFunctionBefore, cntFunctionAfter);			
    }
	
	/*@Test
	public void Test_Checker_AcceptFunctionByCorpCode_FunctionMst_IsNotnull_Success(){
		functionMst.setAuthorizeStatus("W");
		functionDao.insertFunctionTmp(this.getFunctionMst());
		functionMst.setAuthorizeStatus("Y");
		functionService.acceptFunctionByCorpCode(functionMst);
		FunctionMst functionTmp = functionDao.getFunctionTmpByCorpCode(this.getFunctionMst().getCorpCode());
		assertEquals(functionTmp.getAuthorizeStatus(), "Y");	
	}*/
	
	/*@Test
	public void Test_Checker_AcceptFunctionByCorpCode_FunctionMst_Delete_Success(){
		functionMst.setAuthorizeStatus("Y");
		functionDao.insertFunctionTmp(this.getFunctionMst());
		functionMst.setOperationFlag("D");
		functionService.acceptFunctionByCorpCode(functionMst);
		int cntCorp = functionDao.countFunctionMst();
		assertEquals(cntCorp, 0);
	}*/

	private void clearData(){
		functionDao.deleteAllFunctionMst();
		functionDao.deleteAllFunctionTmp();
	}
	
	private FunctionMst getFunctionMst() {
		return functionMst;
	}

	private void setFunctionMst(FunctionMst functionMst) {
		this.functionMst = functionMst;
	}

}
