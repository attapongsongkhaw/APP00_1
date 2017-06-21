package com.kbank.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.dao.UserDao;
import com.kbank.lms.datatable.DataTable;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.User;
import com.kbank.lms.model.UserMst;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public User checkLogin(User user) {
		User u = null;
		try{
			u = userDao.checkLogin(user);
			if(!passwordEncoder.matches(user.getPassword(), u.getPassword())){
				throw new LMSException("Invalid Password");
			}
		}catch(Exception ex){
    		logger.error(ex);
    	}
		return u;
		
	}

	@Override
	public DataTable<UserMst> searchUser(SearchDataTable<UserMst> searchDataTable) {
		DataTable<UserMst> result = new DataTable<>();
		try {
			List<UserMst> users = userDao.searchUser(searchDataTable);
			result.setData(users);
			result.setDraw(searchDataTable.getDraw());
			result.setRecordsTotal(userDao.countUserTotal(searchDataTable));
			result.setRecordsFiltered(userDao.countUserFilter(searchDataTable));
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public UserMst getUserMstByUserLogin(String userId) {
		UserMst user = null;
		try {
			user = userDao.getUserMstByUserLogin(userId);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return user;
	}

	@Override
	public UserMst getUserTmpByUserLogin(String userId) {
		UserMst user = null;
		try {
			user = userDao.getUserTmpByUserLogin(userId);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return user;
	}
	
	@Override
	public void saveUserByMaker(UserMst userMst, String type, String mode) {
		try {
			if("ADD".equals(mode)){
				userMst.setOperationFlag("N");
				userMst.setAuthorizeStatus("W");
				userDao.insertUserTmp(userMst);
			}else if("EDIT".equals(mode)){
				if("A".equals(type)){
					userMst.setAuthorizeStatus("W");
					userMst.setOperationFlag("E");
					userDao.copyUserMstToUserTmp(userMst);
				}else if("P".equals(type)){
					if("D".equals(userMst.getAuthorizeStatus())){
						userMst.setAuthorizeStatus("W");
						userDao.updateUserPending(userMst);
					}else{
						userMst.setAuthorizeStatus("W");
						userDao.updateUserPending(userMst);	
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void rejectUserByUserId(UserMst userMst) {
		try {
			userDao.updateAutorizeStatus(userMst);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void acceptUserByUserId(UserMst userMst) {
		try {
			if("D".equals(userMst.getOperationFlag())){
				userDao.deleteUserMstByUserLogin(userMst.getUserId());
				userDao.deleteUserTmpByUserLogin(userMst.getUserId());
			}else{
				userMst.setAuthorizeStatus("Y");
				UserMst user = userDao.getUserMstByUserLogin(userMst.getUserId());
				if(user == null){
					userDao.copyTmpToUserMst(userMst);
				}else{
					userDao.updateTmpToUserMst(userMst);
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			throw ex; 
		}
	}
	
	@Override
	public void canceluserByUserId(String userId) {
		try {
			userDao.deleteUserTmpByUserLogin(userId);
		} catch (Exception e) {
    		logger.error(e);
    		throw e; 
        }
	}
	
	

}
