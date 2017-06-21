package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.UserMst;

public class UserMstRowMapper implements RowMapper<UserMst>  {

	@Override
	public UserMst mapRow(ResultSet rs, int arg1) throws SQLException {
		UserMst user = new UserMst();
		user.setUserId(rs.getString("USER_ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setCorpCode(rs.getString("CORP_CODE"));
		user.setClientCode(rs.getString("CLIENT_CODE"));
		user.setUserGroup(rs.getString("USER_GROUP"));
		user.setUserRole(rs.getString("USER_ROLE"));
		user.setLoggedOn(rs.getString("LOGGED_ON"));
		user.setLockoutCounter(rs.getInt("LOCKOUT_COUNTER"));
		user.setLastLoggedOn(rs.getTimestamp("LAST_LOGGED_ON"));
		user.setLastLoggedOff(rs.getTimestamp("LAST_LOGGED_OFF"));
		user.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		user.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		user.setRejectReason(rs.getString("REJECT_REASON"));
		user.setOperationFlag(rs.getString("OPERATION_FLAG"));
		user.setUmmUserStatus(rs.getString("UMM_USER_STATUS"));
		user.setUmmServiceStatus(rs.getString("UMM_SERVICE_STATUS"));
		user.setUmmSyncDate(rs.getTimestamp("UMM_SYNC_DATE"));
		user.setCreatedDate(rs.getDate("CREATED_DATE"));
		user.setCreatedBy(rs.getString("CREATED_BY"));
		user.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		user.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		user.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		user.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));

		return user;
	}

}
