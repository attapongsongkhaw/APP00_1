package com.kbank.lms.dao;

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

import com.kbank.lms.common.Application;
import com.kbank.lms.config.DataSorceConfig;
import com.kbank.lms.model.ClientMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_CLIENT)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientDaoTest {
	
	private static final String DEFAULT_CLIENT_CODE = "CLIENT001";
	private static final String DEFAULT_CLIENT_NAME = "CLIENT-001-NAME";
	private static final String DEFAULT_USER = "SYSTEM-UNIT";
	private static final String DEFAULT_CORP_CODE = "KBANK001";

	@Autowired
	ClientDao  clientDao;
	
	private ClientMst clientMst ;

	public ClientMst getClientMst() {
		return clientMst;
	}

	public void setClientMst(ClientMst clientMst) {
		this.clientMst = clientMst;
	}
	
	
	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
	@Before
	public void setUp() {
		ClientMst mst = new ClientMst();	
		mst.setClientCode(DEFAULT_CLIENT_CODE);
		mst.setClientName(DEFAULT_CLIENT_NAME);
		mst.setCorpCode(DEFAULT_CORP_CODE);
		mst.setActiveStatus("Y"); //not null
		mst.setOperationFlag("N"); //not null
		mst.setAuthorizedBy(DEFAULT_USER); 
		mst.setAuthorizedDate(null);
		mst.setAuthorizeStatus("Y"); //not null
		mst.setRejectReason(null);
		mst.setCreatedBy(DEFAULT_USER);
		mst.setLastUpdatedBy(DEFAULT_USER);
		this.setClientMst(mst);
		
		
	}
	
	@Test
	public void insertClientMst_Success(){
		ClientMst beforeClient = this.getClientMst();
		//============== Business ==================/
		clientDao.insertClientMst(beforeClient);
		//============== Business ==================/
		ClientMst afterClient = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(beforeClient , afterClient);
	}
	
	@Test
	public void insertClientTmp_Success(){
		ClientMst beforeClient = this.getClientMst();
		//============== Business ==================/
		clientDao.insertClientTmp(beforeClient);
		//============== Business ==================/
		ClientMst afterClient = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(beforeClient , afterClient);
		
	}

	@Test
	public void checkClientDuplicate_Success(){
		ClientMst clientMst = this.getClientMst();
		int countBefore = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);
		clientDao.insertClientTmp(clientMst);
		clientDao.insertClientMst(clientMst);

		//============== Business ==================/
		int countAfter  = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);
		//============== Business ==================/

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(countBefore , (countAfter-1) );
		
	}
	
	@Test
	public void getClientByClientCodeTmp_Success(){
		ClientMst beforeClient = this.getClientMst();
		clientDao.insertClientTmp(beforeClient);

		//============== Business ==================/
		ClientMst afterClient = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);
		//============== Business ==================/

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(beforeClient , afterClient);
		
	}

	@Test
	public void getClientByClientMst_Success(){
		ClientMst beforeClient = this.getClientMst();
		clientDao.insertClientMst(beforeClient);

		//============== Business ==================/
		ClientMst afterClient = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);
		//============== Business ==================/

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(beforeClient , afterClient);
		
	}
	
	@Test
	public void copyToClientMst_Success(){
	///////   Insert ClientMst from ClientTmp
		ClientMst beforeClientTmp = this.getClientMst();
		clientDao.insertClientTmp(beforeClientTmp);
		ClientMst beforeMstNull = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);
		
		//============== Business ==================/
		clientDao.copyToClientMst(beforeClientTmp);
		//============== Business ==================/

		int count = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);
		ClientMst afterClientMst = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(1, count);
		assertEquals(beforeMstNull, null);
		assertEquals(beforeClientTmp , afterClientMst);
	}
	
	
	@Test
	public void copyToClientTmp_Success(){
	///////   Insert ClientTmp from ClientMst
		ClientMst beforeClientMst = this.getClientMst();
		clientDao.insertClientMst(beforeClientMst);
		ClientMst beforeTempNull = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);
		
		//============== Business ==================/
		clientDao.copyToClientTmp(beforeClientMst);
		//============== Business ==================/

		int count = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);
		ClientMst afterClientTmp = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(1, count);
		assertEquals(null, beforeTempNull);
		assertEquals(beforeClientMst , afterClientTmp);
	}
	
	@Test
	public void copyToClientTmpDelete_Success(){
	///////   Insert ClientTmp from ClientMst
		ClientMst beforeClientMst = this.getClientMst();
		clientDao.insertClientMst(beforeClientMst);
		ClientMst beforeTempNull = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);
		
		//============== Business ==================/
		clientDao.copyToClientTmpDelete(beforeClientMst);
		//============== Business ==================/

		int count = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);
		ClientMst afterClientTmp = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(1, count);
		assertEquals(null, beforeTempNull);
		assertEquals(beforeClientMst , afterClientTmp);
	}
	
	@Test
	public void updateAutorizeStatus_Success(){
		////// Update status Autorize in ClientTmp 
		 ClientMst beforeClientTmp = this.getClientMst();
		 clientDao.insertClientTmp(beforeClientTmp);

		// set up value
		 beforeClientTmp.setAuthorizedBy("UPD-UNIT");
		 beforeClientTmp.setAuthorizeStatus("A");
		 beforeClientTmp.setRejectReason("update autorize status to A ");

		//============== Business ==================/
		clientDao.updateAutorizeStatus(beforeClientTmp);
		//============== Business ==================/

		ClientMst afterClientTmp = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals(beforeClientTmp, afterClientTmp);
		 
	}
	
	@Test
	public void deleteClientMstClientCode_Success(){
		///// Delete ClientMst by ClientCode 
		 ClientMst beforeClientMst = this.getClientMst();
		 clientDao.insertClientMst(beforeClientMst);
		int countBefore = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);

		//============== Business ==================/
		clientDao.deleteClientMstClientCode(DEFAULT_CLIENT_CODE);
		//============== Business ==================/

		int countAfter = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals( (countBefore-1) , countAfter );

	}
	
	@Test
	public void deleteClientTmpClientCode_Success(){
		///// Delete ClientMst by ClientCode 
		 ClientMst beforeClientTmp = this.getClientMst();
		 clientDao.insertClientTmp(beforeClientTmp);
		int countBefore = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);

		//============== Business ==================/
		clientDao.deleteClientTmpClientCode(DEFAULT_CLIENT_CODE);
		//============== Business ==================/

		int countAfter = clientDao.checkClientDuplicate(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals( (countBefore-1) , countAfter );

	}
	
	
	@Test
	public void updateClientTmpToClientMst_Success(){
		// update ClientMST and delete clientTmp by clientCode
		 ClientMst beforeClientTmp = this.getClientMst();
		 clientDao.insertClientTmp(beforeClientTmp);
		 clientDao.insertClientMst(beforeClientTmp);
		 ClientMst beforeTmp = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);
		 ClientMst beforeMst = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);
		 
		 beforeClientTmp.setActiveStatus("N");
		 beforeClientTmp.setClientName("TEST0002");
		//============== Business ==================/
		clientDao.updateClientTmpToClientMst(beforeClientTmp);
		//============== Business ==================/

		 ClientMst afterTmpNull = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);
		 ClientMst afterMstUpdate = clientDao.getClientByClientMst(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals( beforeTmp , beforeMst );
		assertEquals( null , afterTmpNull);
		assertEquals( beforeClientTmp, afterMstUpdate);

	}
	
	@Test
	public void updateClientTmp_Success(){
		// update clientTmp  
		 ClientMst beforeClientTmp = this.getClientMst();
		 clientDao.insertClientTmp(beforeClientTmp);

		 beforeClientTmp.setActiveStatus("N");
		 beforeClientTmp.setClientName("TEST0002");
		 beforeClientTmp.setOperationFlag("U");
		 beforeClientTmp.setAuthorizeStatus("N");
		 beforeClientTmp.setAuthorizedBy("TOM");
		//============== Business ==================/
		clientDao.updateClientTmp(beforeClientTmp);
		//============== Business ==================/

		 ClientMst afterTmpUpdate = clientDao.getClientByClientCodeTmp(DEFAULT_CLIENT_CODE);

		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/

		assertEquals( beforeClientTmp, afterTmpUpdate);

	}
	
	@Test
	public void countClientMst_Success(){
		 ClientMst beforeClient1 = this.getClientMst();
		 clientDao.insertClientMst(beforeClient1);

		 ClientMst beforeClient2 = this.getClientMst();
		 beforeClient2.setClientCode("CLIENT-002");
		 beforeClient2.setClientName("CLIENT-002");
		 clientDao.insertClientMst(beforeClient2);
		 
		//============== Business ==================/
		 int countResult = clientDao.countClientMst();
		//============== Business ==================/


		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/
		
		assertEquals( 2 , countResult );
	}

	@Test
	public void countClientTmp_Success(){
		 ClientMst beforeClient1 = this.getClientMst();
		 clientDao.insertClientTmp(beforeClient1);

		 ClientMst beforeClient2 = this.getClientMst();
		 beforeClient2.setClientCode("CLIENT-002");
		 beforeClient2.setClientName("CLIENT-002");
		 clientDao.insertClientTmp(beforeClient2);
		 
		//============== Business ==================/
		 int countResult = clientDao.countClientTmp();
		//============== Business ==================/


		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/
		
		assertEquals( 2 , countResult );
	}
	
	@Test
	public void deleteAllClientTmp_Success(){
		 ClientMst beforeClient1 = this.getClientMst();
		 clientDao.insertClientTmp(beforeClient1);

		 ClientMst beforeClient2 = this.getClientMst();
		 beforeClient2.setClientCode("CLIENT-002");
		 beforeClient2.setClientName("CLIENT-002");
		 clientDao.insertClientTmp(beforeClient2);
		 int countResultBefore  = clientDao.countClientTmp();
		 
		//============== Business ==================/
		 clientDao.deleteAllClientTmp();
		//============== Business ==================/

		 int countResultAfter = clientDao.countClientTmp();


		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/
		
		assertEquals( countResultBefore  ,( countResultAfter + 2)  );
		
	}

	@Test
	public void deleteAllClientMst_Success(){
		 ClientMst beforeClient1 = this.getClientMst();
		 clientDao.insertClientMst(beforeClient1);

		 ClientMst beforeClient2 = this.getClientMst();
		 beforeClient2.setClientCode("CLIENT-002");
		 beforeClient2.setClientName("CLIENT-002");
		 clientDao.insertClientMst(beforeClient2);
		 int countResultBefore  = clientDao.countClientMst();
		 
		//============== Business ==================/
		 clientDao.deleteAllClientMst();
		//============== Business ==================/

		 int countResultAfter = clientDao.countClientMst();


		//============== Clear data ==================/
		 this.cleanAllClientData();
		//============== Clear data ==================/
		
		assertEquals( countResultBefore  ,( countResultAfter + 2)  );
		
	}
	
	private void cleanAllClientData(){
		clientDao.deleteAllClientTmp();
		clientDao.deleteAllClientMst();
	}
	
	
/*
	 * 
x	public void insertClientMst(ClientMst clientMst);
x	public int checkClientDuplicate(String clientCode);
x	public void insertClientTmp(ClientMst clientMst);
x	public ClientMst getClientByClientCodeTmp(String clientCode);
x	public ClientMst getClientByClientMst(String clientCode);
x	public void copyToClientMst(ClientMst clientMst);
x	public void copyToClientTmp(ClientMst clientMst);
x	public void copyToClientTmpDelete(ClientMst clientMst);
x	public void updateAutorizeStatus(ClientMst clientMst);
x	public void deleteClientMstClientCode(String clientCode);
x	public void deleteClientTmpClientCode(String clientCode);
x	public void updateClientTmpToClientMst(ClientMst clientMst);
x	public void updateClientTmp(ClientMst clientMst);
	public int countClientFilter(SearchDataTable<ClientMst> searchDataTable);
	public List<ClientMst> searchClient(SearchDataTable<ClientMst> searchDataTable);
	public int countClientTotal(SearchDataTable<ClientMst> searchDataTable);
x	public int countClientMst();
x	public int countClientTmp();
x	public void deleteAllClientTmp();
x   public void deleteAllClientMst();
	 */


}
