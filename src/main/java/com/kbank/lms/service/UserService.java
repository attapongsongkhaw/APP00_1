package com.kbank.lms.service;

import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.User;
import com.kbank.lms.model.UserMst;


public interface UserService {
	
	public User checkLogin(User user);
	public DataTable<UserMst> searchUser(SearchDataTable<UserMst> searchDataTable);
	public UserMst getUserMstByUserLogin(String userId);
	public UserMst getUserTmpByUserLogin(String userId);
	public void saveUserByMaker(UserMst userMst, String type, String mode);
	public void rejectUserByUserId(UserMst userMst);
	public void acceptUserByUserId(UserMst userMst);
	public void canceluserByUserId(String userId);
}
