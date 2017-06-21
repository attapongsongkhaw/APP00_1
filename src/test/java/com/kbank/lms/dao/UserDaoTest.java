package com.kbank.lms.dao;

import static org.junit.Assert.*;

import java.util.Date;

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
import com.kbank.lms.model.UserMst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class, DataSorceConfig.class })
//@ActiveProfiles(value=DataSorceConfig.TEST_USER)
@ActiveProfiles(value=DataSorceConfig.UNIT_TEST_LMS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	private static final String USER_LOGIN = "VEERAYOOT";
	private static final String DEFAULT_CODE_CORP = "UNIT001";
	private static final String DEFAULT_USER = "UNIT-TEST";

	@Autowired
	UserDao userDao;
	private UserMst userMst;

	public UserMst getUserMst() {
		return userMst;
	}
	public void setUserMst(UserMst userMst) {
		this.userMst = userMst;
	}

	@BeforeClass
	public static void init() {
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}

	@Before
	public void setUp() {
		UserMst user = new UserMst();
		user.setUserId(USER_LOGIN);
		user.setCorpCode(DEFAULT_CODE_CORP);
		user.setUserGroup("COM");
		user.setFirstName("VEERAYOOT");
		user.setLastName("PENGNAM");
		user.setUserRole(null);
		user.setLockoutCounter(0);
		user.setLoggedOn("N");

		user.setActiveStatus("Y");
		user.setAuthorizeStatus("D");
		user.setOperationFlag("N");
		user.setCreatedBy(DEFAULT_USER);

		user.setLastUpdatedBy(DEFAULT_USER);
		user.setLastUpdatedDate(new Date());
		
		user.setUmmServiceStatus("A");
		user.setUmmUserStatus("A");
		user.setUmmSyncDate(new java.sql.Timestamp(new Date().getTime()));
		
		
		this.setUserMst(user);
	}
	private void cleanAllUserMstByCorpCode(String corpCode){
		 userDao.deleteAllUserTmpByCorpCode(corpCode);
		 userDao.deleteAllUserMstByCorpCode(corpCode);
	}
	// business sync user
	@Test
	public void checkUserDuplicate_Success(){
		//========= prepare data ============
		UserMst userBefore = this.getUserMst();
		userDao.insertUserTmp(userBefore);
		userDao.insertUserMst(userBefore);
		//========= End prepare data ============

		//========= Business  ============
		int result = userDao.checkUserDuplicate(USER_LOGIN);
		//========= End Business  ============
		UserMst userTmpAfter = userDao.getUserTmpByUserLogin(USER_LOGIN);
		UserMst userMstAfter = userDao.getUserMstByUserLogin(USER_LOGIN);

		//========= Clean Data ============
		this.cleanAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		assertEquals(1,result);
		assertEquals(userBefore,userTmpAfter);
		assertEquals(userTmpAfter,userMstAfter);
	}

	@Test
	public void insertUserMst_Success(){
		//========= prepare data ============
		UserMst userBefore = this.getUserMst();
		//========= End prepare data ============

		//========= Business  ============
		userDao.insertUserMst(userBefore);
		//========= End Business  ============
		UserMst userMstAfter = userDao.getUserMstByUserLogin(USER_LOGIN);

		//========= Clean Data ============
		this.cleanAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		assertEquals(userBefore,userMstAfter);
		
	}
	@Test
	public void insertUserTmp_Success(){
		//========= prepare data ============
		UserMst userBefore = this.getUserMst();
		//========= End prepare data ============

		//========= Business  ============
		userDao.insertUserTmp(userBefore);
		//========= End Business  ============
		UserMst userTmpAfter = userDao.getUserTmpByUserLogin(USER_LOGIN);

		//========= Clean Data ============
		this.cleanAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		assertEquals(userBefore,userTmpAfter);
		
	}
	
	@Test
	public void updateUserInformationbyUMM_Success(){
		UserMst userBefore = this.getUserMst();
		//======== prepare ==================
		userDao.insertUserTmp(userBefore);
		userDao.insertUserMst(userBefore);
		//======== prepare ==================

		userBefore.setFirstName("TEST-upd-info");
		userBefore.setLastName("TEST-upd-info");
		userBefore.setCorpCode("CORP-001");
		
		//===================== Business ==================
		userDao.updateUserInformationbyUMM(userBefore);
		//===================== End Business ==================

		UserMst userTmpAfter = userDao.getUserTmpByUserLogin(USER_LOGIN);
		UserMst userMstAfter = userDao.getUserMstByUserLogin(USER_LOGIN);

		//========= Clean Data ============
		this.cleanAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		this.cleanAllUserMstByCorpCode("CORP-001");
		//=========End Clean Data ============

		assertEquals(userBefore,userTmpAfter);
		assertEquals(userTmpAfter,userMstAfter);
	}
	
	@Test
	public void updateUserUMMStatusOnlyWithUMMProfile_Success(){
		UserMst userBefore = this.getUserMst();
		//======== prepare ==================
		userDao.insertUserTmp(userBefore);
		userDao.insertUserMst(userBefore);
		//======== prepare ==================

		userBefore.setUmmServiceStatus("I");
		userBefore.setUmmUserStatus("X");
		userBefore.setUmmSyncDate(new java.sql.Timestamp(new Date().getTime()));
		
		//===================== Business ==================
		userDao.updateUserUMMStatusOnlyWithUMMProfile(userBefore);
		//===================== End Business ==================

		UserMst userTmpAfter = userDao.getUserTmpByUserLogin(USER_LOGIN);
		UserMst userMstAfter = userDao.getUserMstByUserLogin(USER_LOGIN);


		//========= Clean Data ============
		this.cleanAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		assertEquals(userBefore,userTmpAfter);
		assertEquals(userTmpAfter,userMstAfter);
	}

	// unit-test
    @Test
	public void deleteAllUserTmpByCorpCode_Success(){
    	
		UserMst userBefore = this.getUserMst();
		//======== prepare ==================
		userDao.insertUserTmp(userBefore);
		//======== prepare ==================

		//========= Clean Data ============
		userDao.deleteAllUserTmpByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		int result = userDao.checkUserDuplicate(USER_LOGIN);
		assertEquals(0,result);
    }
    @Test
	public void deleteAllUserMstByCorpCode_Success(){
		UserMst userBefore = this.getUserMst();
		//======== prepare ==================
		userDao.insertUserMst(userBefore);
		//======== prepare ==================

		//========= Clean Data ============
		userDao.deleteAllUserMstByCorpCode(DEFAULT_CODE_CORP);
		//=========End Clean Data ============

		int result = userDao.checkUserDuplicate(USER_LOGIN);
		assertEquals(0,result);
    	
    }
	
	public void updateUserMst(){}
	public void updateUserTmp(){}
	public void copyUserTmpToUserMst(){}
	public void deleteUserMstByUserLogin(){}
	public void deleteUserTmpByUserLogin(){}
	public void getUserTmpByUserLogin(){}
	public void getUserMstByUserLogin(){}
	public void countAllUserMst(){}
	public void countAllUserTmp(){}


}
