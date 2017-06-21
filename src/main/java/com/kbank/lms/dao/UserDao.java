package com.kbank.lms.dao;

import java.util.List;

import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.User;
import com.kbank.lms.model.UserMst;

public interface UserDao {
	
	public User checkLogin(User user);
		
	// business sync user
	public int checkUserDuplicate(String userLogin);
	public void insertUserMst(UserMst user);
	public void insertUserTmp(UserMst user);
	public void updateUserMst(UserMst user);
	public void updateUserTmp(UserMst user);
	public void updateUserInformationbyUMM(UserMst user);
	public void updateUserUMMStatusOnlyWithUMMProfile(UserMst user);
	public void copyUserTmpToUserMst(UserMst user);
	public void deleteUserMstByUserLogin(String userLogin);
	public void deleteUserTmpByUserLogin(String userLogin);
	public UserMst getUserTmpByUserLogin(String userLogin);
	public UserMst getUserMstByUserLogin(String userLogin);
	public int countAllUserMst();
	public int countAllUserTmp();

	// unit-test
	public void deleteAllUserTmpByCorpCode(String corpCode);
	public void deleteAllUserMstByCorpCode(String corpCode);
	public List<UserMst> searchUser(SearchDataTable<UserMst> searchDataTable);
	public int countUserFilter(SearchDataTable<UserMst> searchDataTable);
	public int countUserTotal(SearchDataTable<UserMst> searchDataTable);
	public void updateUserPending(UserMst userMst);
	public void copyUserMstToUserTmp(UserMst userMst);
	public void updateAutorizeStatus(UserMst userMst);
	public void copyTmpToUserMst(UserMst userMst);
	public void updateTmpToUserMst(UserMst userMst);
}