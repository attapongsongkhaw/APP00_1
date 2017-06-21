package com.kbank.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kbank.lms.datatable.Order;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.mapper.AccountRowMapper;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
    
	@Override
	public int insertAccountMst(AccountMst accountMst) {
		KeyHolder holder = new GeneratedKeyHolder();
		try{
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO ");
        	sql.append(DBConstants.ACCOUNT_MST);
        	sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE");
        	sql.append(", REJECT_REASON ");
        	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
        	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?,SYSDATE(),?)");
        	jdbcTemplate.update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                	PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, accountMst.getAccountNo());
                    ps.setString(2, accountMst.getAccountNameTh());
                    ps.setString(3, accountMst.getAccountNameEn());
                    ps.setString(4, accountMst.getKbankProductCode());
                    ps.setString(5, accountMst.getCisId());
                    ps.setString(6, accountMst.getAccountLevel());
                    ps.setString(7, accountMst.getCorpCode());
                    ps.setString(8, accountMst.getClientCode());
                    ps.setString(9, accountMst.getRejectReason());
                    ps.setString(10, accountMst.getAuthorizeStatus());
                    ps.setString(11, accountMst.getActiveStatus());
                    ps.setString(12, accountMst.getOperationFlag());
                    ps.setString(13, accountMst.getCreatedBy());
                    ps.setString(14, accountMst.getAuthorizedBy());
                    ps.setString(15, accountMst.getLastUpdatedBy());
                    return ps;
                }
            }, holder);
        }catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return (int) holder.getKey().longValue();
	}
	
	@Override
	public int checkAccountDuplicate(String accountNo) {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM(SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE ACTIVE_STATUS = 'Y' ").append(" UNION SELECT ACCOUNT_NO FROM ");
			sql.append(DBConstants.ACCOUNT_TMP).append(" WHERE ACTIVE_STATUS = 'Y' ");
			sql.append(")a WHERE ACCOUNT_NO = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { accountNo }, Integer.class);
		} catch(Exception ex){
			logger.error(ex);
        	throw ex;
		}
		return result;
	}

	@Override
	public int insertAccountTmp(AccountMst accountMst) {
		KeyHolder holder = new GeneratedKeyHolder();
		try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.ACCOUNT_TMP);
	    	sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE ");
        	sql.append(", REJECT_REASON ");
	    	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, accountMst.getAccountNo());
	                ps.setString(2, accountMst.getAccountNameTh());
	                ps.setString(3, accountMst.getAccountNameEn());
	                ps.setString(4, accountMst.getKbankProductCode());
	                ps.setString(5, accountMst.getCisId());
	                ps.setString(6, accountMst.getAccountLevel());
	                ps.setString(7, accountMst.getCorpCode());
	                ps.setString(8, accountMst.getClientCode());
	                ps.setString(9, accountMst.getRejectReason());
	                ps.setString(10, accountMst.getAuthorizeStatus());
	                ps.setString(11, accountMst.getActiveStatus());
	                ps.setString(12, accountMst.getOperationFlag());
	                ps.setString(13, accountMst.getCreatedBy());
	                ps.setString(14, accountMst.getLastUpdatedBy());
	                
                    return ps;
                }
            }, holder);
    	}catch (Exception e) {
    		logger.error(e);
        	throw e;
        }
        return (int) holder.getKey().longValue();
	}
	
	@Override
	public void copyToAccountTmp(AccountMst accountMst) {
        try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ?, ?, ?, ?, ?, ACCOUNT_LEVEL, ?, ?, ?, AUTHORIZED_DATE, AUTHORIZED_BY, ?, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAccountNo());
	            	ps.setString(2, accountMst.getAccountNameTh());
	            	ps.setString(3, accountMst.getAccountNameEn());
	            	ps.setString(4, accountMst.getKbankProductCode());
	            	ps.setString(5, accountMst.getCisId());
	            	ps.setString(6, accountMst.getCorpCode());
	            	ps.setString(7, accountMst.getClientCode());
	            	ps.setString(8, accountMst.getAuthorizeStatus());
	            	ps.setString(9, accountMst.getActiveStatus());
	            	ps.setString(10, accountMst.getOperationFlag());
	            	ps.setString(11, accountMst.getLastUpdatedBy());
	            	ps.setInt(12, accountMst.getAccountId());
	            }
	        });
		}catch (Exception e) {
			logger.error(e);
        	throw e;
	    }
	}
	
	@Override
	public void updateAccountTmp(AccountMst accountMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" SET ACCOUNT_NO = ?, ACCOUNT_NAME_TH = ?, ACCOUNT_NAME_EN = ?, KBANK_PRODUCT_CODE = ?, CORP_CODE = ?, CLIENT_CODE = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAccountNo());
	            	ps.setString(2, accountMst.getAccountNameTh());
	            	ps.setString(3, accountMst.getAccountNameEn());
	            	ps.setString(4, accountMst.getKbankProductCode());
	            	ps.setString(5, accountMst.getCorpCode());
	            	ps.setString(6, accountMst.getClientCode());
	            	ps.setString(7, accountMst.getCisId());
	            	ps.setString(8, accountMst.getActiveStatus());
	            	ps.setString(9, accountMst.getAuthorizeStatus());
	            	ps.setString(10, accountMst.getOperationFlag());
	            	ps.setString(11, accountMst.getLastUpdatedBy());
	            	ps.setInt(12, accountMst.getAccountId());
	            }
	        });
		} catch(Exception e){
			logger.error(e);
        	throw e;
		}
	}

	@Override
	public void deleteAccountMstByAccountId(int accountId) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { accountId });
		} catch(Exception e){
			logger.error(e);
        	throw e;
		}
	}

	@Override
	public void deleteAccountTmpByAccountId(int accountId) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { accountId });
		} catch(Exception e){
			logger.error(e);
        	throw e;
		}
	}

	@Override
	@Transactional
	public void copyToAccountMst(AccountMst accountMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_MST).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ?, SYSDATE(), ?, ACTIVE_STATUS, ?, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAuthorizeStatus());
	            	ps.setString(2, accountMst.getAuthorizedBy());
	            	ps.setString(3, accountMst.getOperationFlag());
	            	ps.setInt(4, accountMst.getAccountId());
	            }
	        });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { accountMst.getAccountId() });
	    	transactionManager.commit(status);
		}catch (Exception e) {
			logger.error(e);
        	throw e;
	    }
	}

	@Override
	@Transactional
	public void updateTmpToAccountMst(AccountMst accountMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.ACCOUNT_MST);
	    	sql.append(" SET ACCOUNT_NAME_EN = ?, ACCOUNT_NAME_TH = ?, CIS_ID = ?, CORP_CODE = ?, CLIENT_CODE = ?, KBANK_PRODUCT_CODE = ?, ACCOUNT_LEVEL = ?,  AUTHORIZE_STATUS = ?, AUTHORIZED_BY = ?, AUTHORIZED_DATE = SYSDATE(), OPERATION_FLAG = ?, LAST_UPDATED_DATE = ? , LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE ACCOUNT_NO = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAccountNameEn());
	            	ps.setString(2, accountMst.getAccountNameTh());
	            	ps.setString(3, accountMst.getCisId());
	            	ps.setString(4, accountMst.getCorpCode());
	            	ps.setString(5, accountMst.getClientCode());
	            	ps.setString(6, accountMst.getKbankProductCode());
	            	ps.setString(7, accountMst.getAccountLevel());
	            	ps.setString(8, accountMst.getAuthorizeStatus());
	                ps.setString(9, accountMst.getAuthorizedBy());
	                ps.setString(10, accountMst.getOperationFlag());
	                ps.setDate(11, new java.sql.Date(accountMst.getLastUpdatedDate().getTime()));
	                ps.setString(12, accountMst.getLastUpdatedBy());
	                ps.setString(13, accountMst.getAccountNo());
	            }
	        });
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE ACCOUNT_NO = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { accountMst.getAccountNo() });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
			logger.error(e);
        	throw e;
        }
    }

	@Override
	public void updateAutorizeStatus(AccountMst accountMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.ACCOUNT_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAuthorizeStatus());
	            	ps.setString(2, accountMst.getAuthorizedBy());
	            	ps.setString(3, accountMst.getRejectReason());
	            	ps.setInt(4, accountMst.getAccountId());
	            }
	        });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public List<AccountMst> searchAccount(SearchDataTable<AccountMst> searchDataTable) {
		List<AccountMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
				orderColumns = new String[]{"a.LAST_UPDATED_DATE", "a.ACCOUNT_NO", "a.ACCOUNT_NO", "a.ACCOUNT_NAME_EN", "a.ACCOUNT_NAME_TH", "a.CORP_CODE", "a.CLIENT_CODE", "a.AUTHORIZE_STATUS"};
			}else if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLEMST)){
				orderColumns = new String[]{"a.ACCOUNT_NO", "a.ACCOUNT_NO", "a.ACCOUNT_NO", "a.ACCOUNT_NAME_EN", "a.ACCOUNT_NAME_TH", "a.CORP_CODE", "a.CLIENT_CODE", "a.AUTHORIZE_STATUS"};
			}
			if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLETMP)){
				sql.append("SELECT a.ACCOUNT_ID, a.ACCOUNT_NO, a.ACCOUNT_NAME_EN, a.ACCOUNT_NAME_TH, a.CORP_CODE, a.CLIENT_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG FROM ");
				sql.append(DBConstants.ACCOUNT_TMP).append(" a ");
			}else if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLEMST)){
				sql.append("SELECT a.ACCOUNT_ID, a.ACCOUNT_NO, a.ACCOUNT_NAME_EN, a.ACCOUNT_NAME_TH, a.CORP_CODE, a.CLIENT_CODE, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS,");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG ");
				sql.append("FROM ");
				sql.append(DBConstants.ACCOUNT_MST).append(" a LEFT JOIN ").append(DBConstants.ACCOUNT_TMP).append(" b ");
				sql.append("ON b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' OR b.OPERATION_FLAG = 'D') AND a.ACCOUNT_NO = b.ACCOUNT_NO ");
			}
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				where.add(" a.ACCOUNT_NO LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				where.add(" a.AUTHORIZE_STATUS = ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountLevel())){
				where.add(" a.ACCOUNT_LEVEL = ?");
			}
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountNo())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getAccountNo() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountLevel())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAccountLevel());
		                }
		            }
		        }, new RowMapper<AccountMst>() {
				 
					@Override
					public AccountMst mapRow(ResultSet rs, int numRow) throws SQLException {
						AccountMst acct = new AccountMst();
						acct.setAccountId(rs.getInt("ACCOUNT_ID"));
						acct.setAccountNo(rs.getString("ACCOUNT_NO"));
						acct.setAccountNameEn(rs.getString("ACCOUNT_NAME_EN"));
						acct.setAccountNameTh(rs.getString("ACCOUNT_NAME_TH"));
						acct.setCorpCode(rs.getString("CORP_CODE"));
						acct.setClientCode(rs.getString("CLIENT_CODE"));
						acct.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						acct.setOperationFlag(rs.getString("OPERATION_FLAG"));
						return acct;
					}
			 
			    });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
		return results;
	}
	
	@Override
	public int countAccountFilter(SearchDataTable<AccountMst> searchDataTable) {
		List<AccountMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {
			sql.append("SELECT ACCOUNT_NO FROM ");
			if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLETMP)){
				sql.append(DBConstants.ACCOUNT_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLEMST)){
				sql.append(DBConstants.ACCOUNT_MST);
			}
			where.add(" ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountNo())){
				where.add(" ACCOUNT_NO LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				where.add(" AUTHORIZE_STATUS = ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountLevel())){
				where.add(" ACCOUNT_LEVEL = ?");
			}
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			results = jdbcTemplate.query(sql.toString(), new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement preparedStatement) throws
		                    SQLException {
		            	int i = 1;
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountNo())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getAccountNo() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAccountLevel())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAccountLevel());
		                }
		            }
		        }, new RowMapper<AccountMst>() {
						@Override
						public AccountMst mapRow(ResultSet rs, int numRow) throws SQLException {
							AccountMst acct = new AccountMst();
							acct.setAccountNo(rs.getString("ACCOUNT_NO"));
							return acct;
						}
				 
				    });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}	
		return results.size();
	}
	
	@Override
	public int countAccountTotal(SearchDataTable<AccountMst> searchDataTable) {
		StringBuilder sql = new StringBuilder();
		int result = 0;
		try {
			sql.append("SELECT COUNT(0) FROM ");
			if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLETMP)){
				sql.append(DBConstants.ACCOUNT_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.ACCOUNTTABLEMST)){
				sql.append(DBConstants.ACCOUNT_MST);
			}
			sql.append(" WHERE ACTIVE_STATUS = 'Y' AND CASE WHEN (? = '' || ? IS NULL) THEN 1 = 1 ELSE AUTHORIZE_STATUS = ? END");
			sql.append(" AND CASE WHEN (? = '' || ? IS NULL) THEN 1 = 1 ELSE ACCOUNT_LEVEL = ? END");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { 
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAccountLevel(),
					searchDataTable.getDataSearch().getAccountLevel(),
					searchDataTable.getDataSearch().getAccountLevel()}, Integer.class);
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
		return result;
	}

	@Override
	public AccountMst getAccountTmpById(int id) {
		AccountMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE ACCOUNT_ID = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { id }, new AccountRowMapper());
		} catch(Exception  ex){
			logger.error(ex); 
		}
		return result;
	}

	@Override
	public AccountMst getAccountMstById(int id) {
		AccountMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE ACCOUNT_ID = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { id }, new AccountRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);      
		}
		return result;
	}
	
	@Override
	public AccountMst getAccountMstByAccountNo(String accountNo) {
		AccountMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE ACCOUNT_NO = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { accountNo }, new AccountRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);      
		}
		return result;
	}

	@Override
	public AccountMst getAccountTmpByAccountNo(String accountNo) {
		AccountMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE ACCOUNT_NO = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { accountNo }, new AccountRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);      
		}
		return result;
	}
	
	@Override
	public void copyToAccountTmpDelete(AccountMst accountMst) {
		try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, REJECT_REASON,CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ?, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, ?, REJECT_REASON,CREATED_DATE, CREATED_BY, SYSDATE(), ?  ");
			sql.append(" FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, accountMst.getAuthorizeStatus());
	            	ps.setString(2, accountMst.getOperationFlag());
	            	ps.setString(3, accountMst.getLastUpdatedBy());
	            	ps.setInt(4, accountMst.getAccountId());
	            }
	        });
			
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public List<AccountMst> getAllAccountIdFromSearch(AccountMst accountMst) {
		List<AccountMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {
			sql.append("SELECT ACCOUNT_ID, OPERATION_FLAG, ACCOUNT_NO FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			where.add(" ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(accountMst.getCorpCode())){
				where.add(" ACCOUNT_NO LIKE ?");
			}
			if(StringUtils.isNotBlank(accountMst.getAuthorizeStatus())){
				where.add(" AUTHORIZE_STATUS = ?");
			}
			if(StringUtils.isNotBlank(accountMst.getAuthorizeStatus())){
				where.add(" ACCOUNT_LEVEL = ?");
			}
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			results = jdbcTemplate.query(sql.toString(), new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement preparedStatement) throws
		                    SQLException {
		            	int i = 1;
		                if (StringUtils.isNotBlank(accountMst.getAccountNo())) {
		                    preparedStatement.setString(i++, "%" + accountMst.getAccountNo() + "%");
		                }
		                if (StringUtils.isNotBlank(accountMst.getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, accountMst.getAuthorizeStatus());
		                }
		                if (StringUtils.isNotBlank(accountMst.getAccountLevel())) {
		                    preparedStatement.setString(i++, accountMst.getAccountLevel());
		                }
		            }
		        }, new RowMapper<AccountMst>() {
					@Override
					public AccountMst mapRow(ResultSet rs, int numRow) throws SQLException {
						AccountMst accountMst = new AccountMst();
						accountMst.setAccountId(rs.getInt("ACCOUNT_ID"));
						accountMst.setOperationFlag(rs.getString("OPERATION_FLAG"));
						accountMst.setAccountNo(rs.getString("ACCOUNT_NO"));
						return accountMst;
					} 
			    });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
		return results;
	}
	
	@Override
	public List<AccountMst> getAccountTmpByCorpCode(String corpCode) {
		List<AccountMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('01','02') AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { corpCode }, new AccountRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public List<AccountMst> getAccountMstByCorpCode(String corpCode) {
		List<AccountMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('01','02') AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { corpCode }, new AccountRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public List<AccountMst> getAllAccountMstByCorpCode(String corpCode) {
		List<AccountMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y' ");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { corpCode }, new AccountRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void deleteAccountTmpAndMst(int accountId) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE a, b FROM ").append(DBConstants.ACCOUNT_MST).append(" a INNER JOIN ");
			sql.append(DBConstants.ACCOUNT_TMP).append(" b ON a.ACCOUNT_NO = b.ACCOUNT_NO WHERE b.ACCOUNT_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { accountId });	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public int countAccountTmp() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}

	@Override
	public int countAccountMst() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public void deleteAllAccountTmp() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public void deleteAllAccountMst() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_MST);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public int checkAccountInInStrunction(int accountId) {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM (SELECT MEMBER_ACCOUNT_ID FROM ");
			sql.append(DBConstants.INSTRUCTION_MST);
			sql.append(" WHERE MEMBER_ACCOUNT_ID = ? ");
			sql.append("UNION SELECT MEMBER_ACCOUNT_ID FROM ").append(DBConstants.INSTRUCTION_TMP);
			sql.append(" WHERE MEMBER_ACCOUNT_ID = ?) a");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { accountId, accountId }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}

	@Override
	public AccountMst getAccountMst(String corpCode, String accountLevel) {
		AccountMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL = ? ");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode, accountLevel }, new AccountRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);      
		}
		return result;
	}
	
}
