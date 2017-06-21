package com.kbank.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kbank.lms.datatable.Order;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.mapper.UserMstRowMapper;
import com.kbank.lms.mapper.UserRowMapper;
import com.kbank.lms.model.User;
import com.kbank.lms.model.UserMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}

	@Override
	public User checkLogin(User user) {
		return (User) jdbcTemplate.queryForObject("SELECT ID_USER, USERNAME, PASSWORD, ROLE FROM USER WHERE USERNAME = ?", 
				new Object[] { user.getUsername() }, new UserRowMapper());
	}

	/*** =================================   New method by UserMST ========================================*/
	@Override
	public int checkUserDuplicate(String userLogin) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(0) FROM( ");
			sql.append("SELECT USER_ID FROM ").append(DBConstants.USER_MST);
			sql.append(" UNION ");
			sql.append(" SELECT USER_ID FROM ").append(DBConstants.USER_TMP);
			sql.append(")a WHERE USER_ID = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { userLogin }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	private void insertUserAssignTable(UserMst user , String tableName){
		try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(tableName);
	    	sql.append(" (  ");
	    	sql.append(" USER_ID  , FIRST_NAME  , LAST_NAME  , CORP_CODE  , USER_GROUP  , ");
	    	sql.append(" USER_ROLE  , LOGGED_ON  , LOCKOUT_COUNTER  , LAST_LOGGED_ON  , ");
	    	sql.append(" LAST_LOGGED_OFF  , ACTIVE_STATUS  , AUTHORIZE_STATUS  , REJECT_REASON  , ");
	    	sql.append(" OPERATION_FLAG  , UMM_USER_STATUS  , UMM_SERVICE_STATUS  , UMM_SYNC_DATE  , ");
	    	sql.append(" CREATED_DATE  , CREATED_BY  , AUTHORIZED_DATE  , ");
	    	sql.append(" AUTHORIZED_BY  , LAST_UPDATED_DATE  , LAST_UPDATED_BY	 ");
	    	sql.append(" ) VALUES ");
	    	sql.append("( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,?,?,SYSDATE(),? ) ");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	    		@Override
	    		public void setValues(PreparedStatement ps) throws SQLException {
	    			ps.setString(1, user.getUserId());
	    			ps.setString(2, user.getFirstName());
	    			ps.setString(3, user.getLastName());
	    			ps.setString(4, user.getCorpCode());
	    			ps.setString(5, user.getUserGroup());
	    			ps.setString(6, user.getUserRole());
	    			ps.setString(7, user.getLoggedOn());
	    			ps.setInt(8, user.getLockoutCounter());
	    			ps.setTimestamp(9, null);
	    			ps.setTimestamp(10, null);
	    			ps.setString(11, user.getActiveStatus());
	    			ps.setString(12, user.getAuthorizeStatus());
	    			ps.setString(13, user.getRejectReason());
	    			ps.setString(14, user.getOperationFlag());
	    			ps.setString(15, user.getUmmUserStatus());
	    			ps.setString(16, user.getUmmServiceStatus());
	    			ps.setTimestamp(17, user.getUmmSyncDate());
	    			ps.setString(18, user.getCreatedBy());
	    			ps.setTimestamp(19,  user.getAuthorizedDate()!=null?new java.sql.Timestamp(user.getAuthorizedDate().getTime()):null   );
	    			ps.setString(20, user.getAuthorizedBy());
	    			ps.setString(21, user.getLastUpdatedBy());
	    		}
	    	});
    	}catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		
	}
	@Override
	public void insertUserMst(UserMst user) {
		this.insertUserAssignTable(user, DBConstants.USER_MST);
	}

	@Override
	public void insertUserTmp(UserMst user) {
		this.insertUserAssignTable(user, DBConstants.USER_TMP);
	}
	@Override
	public void updateUserMst(UserMst user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserTmp(UserMst user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyUserTmpToUserMst(UserMst user) {
		// TODO Auto-generated method stub
		
	}

	private void deleteUserByUserLoginAssignTatle(String userLogin, String tableName){
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(tableName).append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { userLogin });
		}catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public void deleteUserTmpByUserLogin(String userLogin){
		this.deleteUserByUserLoginAssignTatle(userLogin, DBConstants.USER_TMP);
		
	}
	@Override
	public void deleteUserMstByUserLogin(String userLogin){
		this.deleteUserByUserLoginAssignTatle(userLogin, DBConstants.USER_MST);
		
	}

	private UserMst getUserMstAssignTable(String userLogin , String tableName){
		UserMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(tableName);
			sql.append(" WHERE USER_ID = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { userLogin }, new UserMstRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			String detail = ">> get "+tableName+" ByUserLogin ERROR ";
			logger.error(detail+ ex);
		}
		return result;
		
	}
	@Override
	public UserMst getUserTmpByUserLogin(String userLogin){
		return this.getUserMstAssignTable(userLogin, DBConstants.USER_TMP);
	}

	@Override
	public UserMst getUserMstByUserLogin(String userLogin){
		return this.getUserMstAssignTable(userLogin, DBConstants.USER_MST);
	}


	private void deleteAllUserByCorpCodeAssignTable(String corpCode , String tableName){
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(tableName).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
		}catch (Exception e) {
			logger.error(e);
			throw e;
		}		
	}

	@Override
	public void deleteAllUserTmpByCorpCode(String corpCode) {
		this.deleteAllUserByCorpCodeAssignTable(corpCode, DBConstants.USER_TMP);
	}

	@Override
	public void deleteAllUserMstByCorpCode(String corpCode) {
		this.deleteAllUserByCorpCodeAssignTable(corpCode, DBConstants.USER_MST);
	}

   private void updateUserInformationByUMMAssignTable(UserMst user , String tableName){
		    try{
		        StringBuilder sql = new StringBuilder();
		    	sql.append("UPDATE ").append(tableName);
		    	sql.append(" SET  FIRST_NAME = ? ");
		    	sql.append("      , LAST_NAME  = ? ");
		    	sql.append("      , CORP_CODE  = ? ");
		    	sql.append("      , LAST_UPDATED_DATE  = SYSDATE() ");
		    	sql.append("      , LAST_UPDATED_BY  = ? ");
		    	sql.append("      , UMM_USER_STATUS  = ? ");
		    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
		    	sql.append("      , UMM_SYNC_DATE  = ? "); 
		    	sql.append(" WHERE USER_ID = ?");
		    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement ps) throws SQLException {
		                ps.setString(1, user.getFirstName());
		                ps.setString(2, user.getLastName());
		                ps.setString(3, user.getCorpCode());
		                ps.setString(4, user.getLastUpdatedBy());
		                ps.setString(5, user.getUmmUserStatus());
		                ps.setString(6, user.getUmmServiceStatus());
		                ps.setTimestamp(7, user.getUmmSyncDate());
		                ps.setString(8, user.getUserId());
		            }
		        });
		    }catch (Exception e) {
	        	logger.error(" >>> updateUserInformationByUMMAssignTable Error !!! : "+e);
	        	throw e;
	        }
	   
   }
	@Override
	public void updateUserInformationbyUMM(UserMst user) {
		this.updateUserInformationByUMMAssignTable(user, DBConstants.USER_TMP);
		this.updateUserInformationByUMMAssignTable(user, DBConstants.USER_MST);
	}	
	
	private void updateUserUMMStatusOnlyWithUMMProfileAssignTable(UserMst user , String tableName){
	    StringBuilder sql = new StringBuilder();
        try{
	    	sql.append("UPDATE ").append(tableName);
	    	sql.append(" SET   ");
	    	sql.append("      LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append("      , LAST_UPDATED_BY  = ? ");
	    	sql.append("      , UMM_USER_STATUS  = ? ");
	    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
	    	sql.append("      , UMM_SYNC_DATE  = ? "); 
	    	sql.append(" WHERE USER_ID = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, user.getLastUpdatedBy());
	                ps.setString(2, user.getUmmUserStatus());
	                ps.setString(3, user.getUmmServiceStatus());
	                ps.setTimestamp(4, user.getUmmSyncDate());
	                ps.setString(5, user.getUserId());
	            }
	        });
	    }catch (Exception e) {
        	logger.error(" >>> updateUserUMMStatusOnlyWithUMMProfileAssignTable Error !!! : "+e);
        	throw e;
        }
	}

	@Override
	public void updateUserUMMStatusOnlyWithUMMProfile(UserMst user) {
		this.updateUserUMMStatusOnlyWithUMMProfileAssignTable(user, DBConstants.USER_TMP);
		this.updateUserUMMStatusOnlyWithUMMProfileAssignTable(user, DBConstants.USER_MST);
		
	}


	private int countAllUserAssignTable(String tableName){
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(tableName);
			sql.append(" WHERE ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}

	@Override
	public int countAllUserMst() {
		return this.countAllUserAssignTable(DBConstants.USER_MST);
	}

	@Override
	public int countAllUserTmp() {
		return this.countAllUserAssignTable(DBConstants.USER_TMP);
	}

	@Override
	public List<UserMst> searchUser(SearchDataTable<UserMst> searchDataTable) {
		List<UserMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		List<String> whereCause = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.USERTABLETMP)){
				orderColumns = new String[]{"LAST_UPDATED_DATE", "USER_ID", "FIRST_NAME", "LAST_NAME", "USER_ROLE", "CORP_CODE", "STATUSSTR"};
			}else{
				orderColumns = new String[]{"USER_ID", "USER_ID", "FIRST_NAME", "LAST_NAME", "USER_ROLE", "CORP_CODE", "STATUSSTR"};
			}
			sql.append("SELECT * FROM (");
			if(searchDataTable.getTableType().equals(Constants.USERTABLETMP)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG, a.LAST_UPDATED_DATE, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'W' THEN '").append(Constants.PENDING).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'D' THEN '").append(Constants.DRAFT).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.REJECT).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_TMP).append(" a ");
				if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
					where.add(" a.AUTHORIZE_STATUS = 'W'");
				}
			}else if(searchDataTable.getTableType().equals(Constants.USERTABLEMST)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, ");
				sql.append("(CASE WHEN c.AUTHORIZE_STATUS = 'W' AND (c.OPERATION_FLAG = 'E' || c.OPERATION_FLAG = 'D') THEN c.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS, ");
				sql.append("(CASE WHEN c.AUTHORIZE_STATUS = 'W' AND (c.OPERATION_FLAG = 'E' || c.OPERATION_FLAG = 'D') THEN c.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'Y' THEN '").append(Constants.ENABLE).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.DISABLE).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_MST).append(" a ");
				sql.append(" LEFT JOIN ").append(DBConstants.USER_TMP).append(" c ON a.USER_ID = c.USER_ID ");	
			}
			sql.append(" LEFT JOIN ").append(DBConstants.LOOKUP_MST).append(" b ON a.USER_ROLE = b.LOOKUP_CODE ");
			if("CORP".equals(searchDataTable.getDataSearch().getUserGroup())){
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_CORP'");
			}else{
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_BANK'");
			}
			where.add(" a.USER_GROUP = ?");
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			sql.append(") e "); 
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getUserId())){
				whereCause.add(" e.USER_ID LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				whereCause.add(" e.STATUSSTR LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getFirstName())){
				whereCause.add(" e.FIRST_NAME LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getLastName())){
				whereCause.add(" e.LAST_NAME LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getUserRole())){
				whereCause.add(" e.USER_ROLE LIKE ?");
			}
			if(!whereCause.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : whereCause){
					sql.append(strWhere).append(" OR ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 3));
			}
			if(!searchDataTable.getOrder().isEmpty()){
				for(Order field : searchDataTable.getOrder()){
					order.append(orderColumns[field.getColumn()]).append(" ").append(field.getDir());
				}
				if(order.length() > 0){
					sql.append(" ORDER BY ").append(order);
				}
			}
			sql.append(" LIMIT ").append(searchDataTable.getLength()).append(" OFFSET ").append(searchDataTable.getStart());
			results = jdbcTemplate.query(sql.toString(), new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement preparedStatement) throws
		                    SQLException {
		            	int i = 1;
		                preparedStatement.setString(i++, searchDataTable.getDataSearch().getUserGroup());
		                if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getUserId())){
		                	preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getUserId() + "%");
		    			}
		    			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
		    				preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getAuthorizeStatus() + "%");
		    			}
		    			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getFirstName())){
		    				preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getFirstName() + "%");
		    			}
		    			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getLastName())){
		    				preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getLastName() + "%");
		    			}
		    			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getUserRole())){
		    				preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getUserRole() + "%");
		    			}
		            }
		        }, new RowMapper<UserMst>() {
				 
					@Override
					public UserMst mapRow(ResultSet rs, int numRow) throws SQLException {
						UserMst user = new UserMst();
						user.setUserId(rs.getString("USER_ID"));
						user.setFirstName(rs.getString("FIRST_NAME"));
						user.setLastName(rs.getString("LAST_NAME"));
						user.setUserRole(rs.getString("USER_ROLE"));
						user.setCorpCode(rs.getString("CORP_CODE"));
						user.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						user.setOperationFlag(rs.getString("OPERATION_FLAG"));
						return user;
					}
			    });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results;
	}
	
	@Override
	public int countUserFilter(SearchDataTable<UserMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		List<String> whereCause = new ArrayList<>();
		try {		
			sql.append("SELECT COUNT(0) FROM (");
			if(searchDataTable.getTableType().equals(Constants.USERTABLETMP)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG, a.LAST_UPDATED_DATE, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'W' THEN '").append(Constants.PENDING).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'D' THEN '").append(Constants.DRAFT).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.REJECT).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_TMP).append(" a ");
				if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
					where.add(" a.AUTHORIZE_STATUS = 'W'");
				}
			}else if(searchDataTable.getTableType().equals(Constants.USERTABLEMST)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, ");
				sql.append(" a.AUTHORIZE_STATUS, ");
				sql.append(" a.OPERATION_FLAG, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'Y' THEN '").append(Constants.ENABLE).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.DISABLE).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_MST).append(" a ");
				sql.append(" LEFT JOIN ").append(DBConstants.USER_TMP).append(" c ON a.USER_ID = c.USER_ID ");	
			}
			sql.append(" LEFT JOIN ").append(DBConstants.LOOKUP_MST).append(" b ON a.USER_ROLE = b.LOOKUP_CODE ");
			if("CORP".equals(searchDataTable.getDataSearch().getUserGroup())){
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_CORP'");
			}else{
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_BANK'");
			}
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.USER_GROUP = ? END");
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			sql.append(") e "); 
			whereCause.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE e.USER_ID LIKE ? END");
			whereCause.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE e.STATUSSTR LIKE ? END");
			whereCause.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE e.FIRST_NAME LIKE ? END");
			whereCause.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE e.LAST_NAME LIKE ? END");
			whereCause.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE e.USER_ROLE LIKE ? END");
			if(!whereCause.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : whereCause){
					sql.append(strWhere).append(" OR ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 3));
			}
			results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{
					searchDataTable.getDataSearch().getUserGroup(),
					searchDataTable.getDataSearch().getUserGroup(),
					searchDataTable.getDataSearch().getUserGroup(),
					searchDataTable.getDataSearch().getUserId(),
					searchDataTable.getDataSearch().getUserId(),
					"%" + searchDataTable.getDataSearch().getUserId() + "%",
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					"%" + searchDataTable.getDataSearch().getAuthorizeStatus() + "%",
					searchDataTable.getDataSearch().getFirstName(),
					searchDataTable.getDataSearch().getFirstName(),
					"%" + searchDataTable.getDataSearch().getFirstName() + "%",
					searchDataTable.getDataSearch().getLastName(),
					searchDataTable.getDataSearch().getLastName(),
					"%" + searchDataTable.getDataSearch().getLastName() + "%",
					searchDataTable.getDataSearch().getUserRole(),
					searchDataTable.getDataSearch().getUserRole(),
					"%" + searchDataTable.getDataSearch().getUserRole() + "%"
			}, Integer.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}
	
	@Override
	public int countUserTotal(SearchDataTable<UserMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {		
			sql.append("SELECT COUNT(0) FROM (");
			if(searchDataTable.getTableType().equals(Constants.USERTABLETMP)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG, a.LAST_UPDATED_DATE, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'W' THEN '").append(Constants.PENDING).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'D' THEN '").append(Constants.DRAFT).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.REJECT).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_TMP).append(" a ");
				if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
					where.add(" a.AUTHORIZE_STATUS = 'W'");
				}
			}else if(searchDataTable.getTableType().equals(Constants.USERTABLEMST)){
				sql.append("SELECT a.USER_ID, a.FIRST_NAME, a.LAST_NAME, b.LOOKUP_DESCRIPTION USER_ROLE, a.CORP_CODE, ");
				sql.append(" a.AUTHORIZE_STATUS, ");
				sql.append(" a.OPERATION_FLAG, ");
				sql.append(" (CASE"); 
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'Y' THEN '").append(Constants.ENABLE).append("'");
				sql.append(" WHEN a.AUTHORIZE_STATUS = 'N' THEN '").append(Constants.DISABLE).append("'");
				sql.append(" END) STATUSSTR FROM ");
				sql.append(DBConstants.USER_MST).append(" a ");
				sql.append(" LEFT JOIN ").append(DBConstants.USER_TMP).append(" c ON a.USER_ID = c.USER_ID ");	
			}
			sql.append(" LEFT JOIN ").append(DBConstants.LOOKUP_MST).append(" b ON a.USER_ROLE = b.LOOKUP_CODE ");
			if("CORP".equals(searchDataTable.getDataSearch().getUserGroup())){
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_CORP'");
			}else{
				sql.append(" AND b.LOOKUP_TYPE = 'USER_ROLE_BANK'");
			}
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.USER_GROUP = ? END");
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			sql.append(") e "); 
			results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{ 
					searchDataTable.getDataSearch().getUserGroup(),
					searchDataTable.getDataSearch().getUserGroup(),
					searchDataTable.getDataSearch().getUserGroup()
				}, Integer.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}
	
	@Override
	public void updateUserPending(UserMst userMst) {
		StringBuilder sql = new StringBuilder();
        try{
        	sql.append("UPDATE ").append(DBConstants.USER_TMP);
	    	sql.append(" SET");
	    	sql.append(" USER_ROLE  = ? ");
	    	sql.append(" ,CLIENT_CODE  = ? ");
	    	sql.append(" ,AUTHORIZE_STATUS  = ? ");
	    	sql.append(" ,LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append(" , LAST_UPDATED_BY  = ? ");
	    	sql.append(" , LOCKOUT_COUNTER  = ? ");
	    	sql.append(" , FIRST_NAME  = ? ");
	    	sql.append(" , LAST_NAME  = ? ");
	    	sql.append(" WHERE USER_ID = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, userMst.getUserRole());
	                ps.setString(2, userMst.getClientCode());
	                ps.setString(3, userMst.getAuthorizeStatus());
	                ps.setString(4, userMst.getLastUpdatedBy());
	                ps.setInt(5, userMst.getLockoutCounter());
	                ps.setString(6, userMst.getFirstName());
	                ps.setString(7, userMst.getLastName());
	                ps.setString(8, userMst.getUserId());
	            }
	        });
	    }catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	
	@Override
	public void copyUserMstToUserTmp(UserMst userMst) {
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.USER_TMP).append(" (USER_ID, FIRST_NAME, LAST_NAME, CLIENT_CODE, CORP_CODE, USER_GROUP, USER_ROLE, LOGGED_ON, LOCKOUT_COUNTER, LAST_LOGGED_ON, LAST_LOGGED_OFF, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, UMM_USER_STATUS, UMM_SERVICE_STATUS, UMM_SYNC_DATE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT USER_ID, ?, ?, ?, CORP_CODE, USER_GROUP, ?, LOGGED_ON, LOCKOUT_COUNTER, LAST_LOGGED_ON, LAST_LOGGED_OFF, ACTIVE_STATUS, ?, REJECT_REASON, ?, UMM_USER_STATUS, UMM_SERVICE_STATUS, UMM_SYNC_DATE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.USER_MST);
			sql.append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, userMst.getFirstName());
	            	ps.setString(2, userMst.getLastName());
	            	ps.setString(3, userMst.getClientCode());
	            	ps.setString(4, userMst.getUserRole());
	            	ps.setString(5, userMst.getAuthorizeStatus());
	            	ps.setString(6, userMst.getOperationFlag());
	            	ps.setString(7, userMst.getLastUpdatedBy());
	            	ps.setString(8, userMst.getUserId());
	            }
	        });
		}catch (Exception e) {
	    	logger.error(e);
			throw e;
	    }
	}
	
	@Override
	public void updateAutorizeStatus(UserMst userMst) {
    	try{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE ").append(DBConstants.USER_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, userMst.getAuthorizeStatus());
	            	ps.setString(2, userMst.getAuthorizedBy());
	            	ps.setString(3, userMst.getRejectReason());
	            	ps.setString(4, userMst.getUserId());
	            }
	        });
		}catch (Exception e) {
	    	logger.error(e);
	    	throw e;
	    }
	}
	
	@Override
	@Transactional
	public void copyTmpToUserMst(UserMst userMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
    		sql.append("INSERT INTO ").append(DBConstants.USER_MST).append(" (USER_ID, FIRST_NAME, LAST_NAME, CLIENT_CODE, CORP_CODE, USER_GROUP, USER_ROLE, LOGGED_ON, LOCKOUT_COUNTER, LAST_LOGGED_ON, LAST_LOGGED_OFF, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, UMM_USER_STATUS, UMM_SERVICE_STATUS, UMM_SYNC_DATE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT USER_ID, FIRST_NAME, LAST_NAME, CLIENT_CODE, CORP_CODE, USER_GROUP, USER_ROLE, LOGGED_ON, ?, LAST_LOGGED_ON, LAST_LOGGED_OFF, ACTIVE_STATUS, ?, REJECT_REASON, ?, UMM_USER_STATUS, UMM_SERVICE_STATUS, UMM_SYNC_DATE, CREATED_DATE, CREATED_BY, SYSDATE(), ?, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.USER_TMP);
			sql.append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setInt(1, userMst.getLockoutCounter());
	            	ps.setString(2, userMst.getAuthorizeStatus());
	            	ps.setString(3, userMst.getOperationFlag());
	            	ps.setString(4, userMst.getAuthorizedBy());	            	
	            	ps.setString(5, userMst.getUserId());
	            }
	        });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.USER_TMP).append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { userMst.getUserId() });
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}
	
	@Override
	@Transactional
	public void updateTmpToUserMst(UserMst userMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.USER_MST).append(" a ").append("INNER JOIN ").append(DBConstants.USER_TMP).append(" b ON a.USER_ID = b.USER_ID");
	    	sql.append(" SET a.FIRST_NAME = b.FIRST_NAME, a.LAST_NAME = b.LAST_NAME, a.CORP_CODE = b.CORP_CODE, a.CLIENT_CODE = b.CLIENT_CODE, a.USER_ROLE = b.USER_ROLE, a.AUTHORIZE_STATUS = b.AUTHORIZE_STATUS, a.AUTHORIZED_BY = b.AUTHORIZED_BY, a.AUTHORIZED_DATE = SYSDATE(), a.OPERATION_FLAG = b.OPERATION_FLAG, a.LAST_UPDATED_DATE = b.LAST_UPDATED_DATE, a.LAST_UPDATED_BY = b.LAST_UPDATED_BY");
	    	sql.append(" WHERE a.USER_ID = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, userMst.getUserId());
	            }
	        });
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.USER_TMP).append(" WHERE USER_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { userMst.getUserId() });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
        }
	}

}