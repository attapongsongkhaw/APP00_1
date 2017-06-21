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
import com.kbank.lms.dao.ClientDao;
import com.kbank.lms.model.ClientMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_CLIENT)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
public class ClientProcessTest {
	
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	ClientService clientService;
	
	private ClientMst clientMst;

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		ClientMst client = new ClientMst();
		client.setClientCode("GORILLAZ");
		client.setClientName("TEST");
		client.setCorpCode("GOR");
		client.setCisId("111111");
		client.setActiveStatus("Y");
		client.setOperationFlag("N");
		client.setAuthorizeStatus("W");
		client.setAuthorizedBy("CHECKER");
		client.setRejectReason("REJECT REASON");
		client.setLastUpdatedBy("TEST");
		client.setCreatedBy("TEST");
		this.setClientMst(client);
		clearData();
	}
	
	@Test
    public void Test_Maker_SaveClientByMaker_Mode_ADD_Success(){	
		int cntClientStart = clientDao.countClientTmp();
		clientService.saveClientByMaker(this.getClientMst(), "ADD", "");
		int cntClientEnd = clientDao.countClientTmp();
		cntClientStart = cntClientStart + 1;
		assertEquals(cntClientStart, cntClientEnd);		
    }
	
	@Test
	public void Test_Checker_rejectClientByCorpCode_Client_Pending_Success(){
		clientDao.insertClientTmp(this.getClientMst());
		clientMst.setAuthorizeStatus("N");
		clientService.rejectClientByClientCode(clientMst);
		ClientMst clientTmp = clientDao.getClientByClientCodeTmp(this.getClientMst().getClientCode());
		assertEquals(clientTmp.getAuthorizeStatus(), "N");	
	}
	
	@Test
	public void Test_Checker_AcceptClientByClientCode_ClientMst_Isnull_Success(){
		clientDao.insertClientTmp(this.getClientMst());
		int cntClientStart = clientDao.countClientMst();
		clientService.acceptClientByClientCode(clientMst);
		int cntClientEnd = clientDao.countClientMst();
		cntClientStart = cntClientStart + 1;
		assertEquals(cntClientStart, cntClientEnd);	
	}
	
	@Test
    public void Test_Maker_SaveClientByMaker_Mode_EDIT_Type_P_Success(){	
		clientMst.setAuthorizeStatus("N");
		clientDao.insertClientTmp(this.getClientMst());
		clientMst.setAuthorizeStatus("W");
		clientService.saveClientByMaker(this.getClientMst(), "EDIT", "P");
		ClientMst clientTmp = clientDao.getClientByClientCodeTmp(this.getClientMst().getClientCode());
		assertEquals(clientTmp.getAuthorizeStatus(), "W");	
    }
	
	@Test
    public void Test_Maker_SaveClientByMaker_Mode_EDIT_Type_A_Success(){	
		clientMst.setAuthorizeStatus("Y");
		clientDao.insertClientMst(this.getClientMst());
		int cntClientStart = clientDao.countClientTmp();
		clientMst.setAuthorizeStatus("W");
		clientService.saveClientByMaker(this.getClientMst(), "EDIT", "A");
		int cntClientEnd = clientDao.countClientMst();
		cntClientStart = cntClientStart + 1;
		assertEquals(cntClientStart, cntClientEnd);			
    }
	
	@Test
	public void Test_Checker_AcceptClientByClientCode_ClientMst_IsNotnull_Success(){
		clientMst.setAuthorizeStatus("W");
		clientDao.insertClientTmp(this.getClientMst());
		clientService.acceptClientByClientCode(clientMst);
		ClientMst clientTmp = clientDao.getClientByClientMst(this.getClientMst().getClientCode());
		assertEquals(clientTmp.getAuthorizeStatus(), "Y");	
	}
	
	@Test
	public void Test_Checker_AcceptClientByClientCode_ClientMst_Delete_Success(){
		clientMst.setAuthorizeStatus("Y");
		clientDao.insertClientTmp(this.getClientMst());
		clientMst.setOperationFlag("D");
		clientService.acceptClientByClientCode(clientMst);
		int cntCorp = clientDao.countClientMst();
		assertEquals(cntCorp, 0);
	}

	private void clearData(){
		clientDao.deleteAllClientMst();
		clientDao.deleteAllClientTmp();
	}
	
	
	public ClientMst getClientMst() {
		return clientMst;
	}

	public void setClientMst(ClientMst clientMst) {
		this.clientMst = clientMst;
	}

}
