package com.kbank.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.kbank.lms.common.LMSException;
import com.kbank.lms.datatable.Order;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.mapper.InterestRowMapper;
import com.kbank.lms.model.InterestMst;
import com.kbank.lms.model.MapErrorMsg;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("interestDao")
public class InterestDaoImpl implements InterestDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(InterestDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
	
	@Override
	public void insertInterestTmp(InterestMst interestMst) {
		try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.INTEREST_TMP);
	    	sql.append(" (INTEREST_TYPE, INTEREST_RATE, CORP_CODE, ACTIVE_STATUS, AUTHORIZE_STATUS ");
        	sql.append(", OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getInterestType());
	                ps.setBigDecimal(2, interestMst.getInterestRate());
	                ps.setString(3, interestMst.getCorpCode());
	                ps.setString(4, interestMst.getActiveStatus());
	                ps.setString(5, interestMst.getAuthorizeStatus());
	                ps.setString(6, interestMst.getOperationFlag());
	                ps.setString(7, interestMst.getCreatedBy());
	                ps.setString(8, interestMst.getLastUpdatedBy());
	            }
	        });
    	}catch (Exception e) {
    		logger.error(e);
        	throw e;
        }
	}
	
	@Override
	@Transactional
	public void copyToInterestMst(InterestMst interestMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.INTEREST_MST).append(" (INTEREST_TYPE, INTEREST_RATE, CORP_CODE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT INTEREST_TYPE, INTEREST_RATE, CORP_CODE, ACTIVE_STATUS, ?, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, SYSDATE(), ?, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.INTEREST_TMP);
			sql.append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getAuthorizeStatus());
	            	ps.setString(2, interestMst.getAuthorizedBy());
	            	ps.setString(3, interestMst.getInterestType());
	            	ps.setBigDecimal(4, interestMst.getInterestRate());
	            	ps.setString(3, interestMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.INTEREST_TMP).append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { interestMst.getAuthorizeStatus(), interestMst.getAuthorizedBy(), interestMst.getInterestType() });
	    	transactionManager.commit(status);
		}catch (Exception e) {
			logger.error(e);
        	throw e;
	    }
	}
	
	@Override
	@Transactional
	public void updateTmpToInterestMst(InterestMst interestMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.INTEREST_MST);
	    	sql.append(" a INNER JOIN ").append(DBConstants.INTEREST_TMP).append(" ON a.INTEREST_TYPE = b.INTEREST_TYPE AND a.INTEREST_RATE = b.INTEREST_RATE AND a.CORP_CODE = b.CORP_CODE");
	    	sql.append(" SET a.ACTIVE_STATUS = b.ACTIVE_STATUS, a.OPERATION_FLAG = b.OPERATION_FLAG, a.AUTHORIZE_STATUS = b.AUTHORIZE_STATUS, a.AUTHORIZED_BY = ?, a.AUTHORIZED_DATE = SYSDATE(), a.LAST_UPDATED_DATE = b.LAST_UPDATED_DATE , a.LAST_UPDATED_BY = b.LAST_UPDATED_BY");
	    	sql.append(" WHERE a.INTEREST_TYPE = ? AND a.INTEREST_RATE = ? AND a.CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getAuthorizedBy());
	            	ps.setString(2, interestMst.getInterestType());
	            	ps.setBigDecimal(3, interestMst.getInterestRate());
	            	ps.setString(4, interestMst.getCorpCode());
	            }
	        });
	    	sql = new StringBuilder();
	    	sql.append("DELETE FROM ").append(DBConstants.INTEREST_TMP).append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { interestMst.getAuthorizeStatus(), interestMst.getAuthorizedBy(), interestMst.getInterestType() });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
			logger.error(e);
        	throw e;
        }
    }
	
	@Override
	public void copyToInterestTmp(InterestMst interestMst) {
        try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.INTEREST_TMP).append(" (INTEREST_TYPE, INTEREST_RATE, CORP_CODE, START_DATE, END_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE(), ?, SYSDATE(), ? FROM ");
			sql.append(DBConstants.INTEREST_MST);
			sql.append(" WHERE INTEREST_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getInterestType());
	            	ps.setBigDecimal(2, interestMst.getInterestRate());
	            	ps.setString(3, interestMst.getCorpCode());
	            	ps.setString(6, interestMst.getActiveStatus());
	            	ps.setString(7, interestMst.getAuthorizeStatus());
	            	ps.setString(8, interestMst.getOperationFlag());
	            	/*ps.setString(9, accountMst.getActiveStatus());
	            	ps.setString(10, accountMst.getOperationFlag());
	            	ps.setString(11, accountMst.getLastUpdatedBy());
	            	ps.setInt(12, accountMst.getAccountId());*/
	            }
	        });
		}catch (Exception e) {
			logger.error(e);
        	throw e;
	    }
	}

	@Override
	public void updateInterestTmp(InterestMst interestMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.INTEREST_TMP);
			sql.append(" SET ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getActiveStatus());
	            	ps.setString(2, interestMst.getAuthorizeStatus());
	            	ps.setString(3, interestMst.getOperationFlag());
	            	ps.setString(4, interestMst.getLastUpdatedBy());
	            	ps.setString(5, interestMst.getInterestType());
	            	ps.setBigDecimal(6, interestMst.getInterestRate());
	            	ps.setString(7, interestMst.getCorpCode());
	            }
	        });
		} catch(Exception e){
			logger.error(e);
        	throw e;
		}
	}

	@Override
	public void updateAutorizeStatus(InterestMst interestMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.INTEREST_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, interestMst.getAuthorizeStatus());
	            	ps.setString(2, interestMst.getAuthorizedBy());
	            	ps.setString(3, interestMst.getRejectReason());
	            	ps.setString(4, interestMst.getInterestType());
	            	ps.setBigDecimal(4, interestMst.getInterestRate());
	            	ps.setString(4, interestMst.getCorpCode());
	            }
	        });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public List<InterestMst> searchInterest(SearchDataTable<InterestMst> searchDataTable) {
		List<InterestMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.INTERESTTABLETMP)){
				orderColumns = new String[]{"a.INTEREST_TYPE", "a.INTEREST_RATE", "a.CORP_CODE", "a.AUTHORIZE_STATUS"};
			}else if(searchDataTable.getTableType().equals(Constants.INTERESTTABLEMST)){
				orderColumns = new String[]{"a.INTEREST_TYPE", "a.INTEREST_RATE", "a.CORP_CODE", "a.ACTIVE_STATUS"};
			}
			if(searchDataTable.getTableType().equals(Constants.INTERESTTABLETMP)){
				sql.append("SELECT a.INTEREST_TYPE, a.INTEREST_RATE, a.CORP_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG, u.USER_GROUP, a.ACTIVE_STATUS FROM ");
				sql.append(DBConstants.INTEREST_TMP).append(" a ");
			}else if(searchDataTable.getTableType().equals(Constants.INTERESTTABLEMST)){
				sql.append("SELECT a.INTEREST_TYPE, a.INTEREST_RATE, a.CORP_CODE, u.USER_GROUP, a.ACTIVE_STATUS, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS,");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG ");
				sql.append("FROM ");
				sql.append(DBConstants.INTEREST_MST).append(" a LEFT JOIN ").append(DBConstants.INTEREST_TMP).append(" b ");
				sql.append("ON b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' OR b.OPERATION_FLAG = 'D') AND a.INTEREST_TYPE = b.INTEREST_TYPE AND a.INTEREST_RATE = b.INTEREST_RATE AND a.CORP_CODE = b.CORP_CODE ");
			}
			sql.append(" INNER JOIN ").append(DBConstants.USER_MST).append(" u ON u.USER_ID = a.LAST_UPDATED_BY");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				where.add(" a.CORP_CODE LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getInterestType())){
				where.add(" a.INTEREST_TYPE = ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				where.add(" a.AUTHORIZE_STATUS = ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getActiveStatus())){
				where.add(" a.ACTIVE_STATUS = ?");
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getCorpCode() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getInterestType())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getActiveStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getActiveStatus());
		                }
		            }
		        }, new RowMapper<InterestMst>() {
				 
					@Override
					public InterestMst mapRow(ResultSet rs, int numRow) throws SQLException {
						InterestMst interest = new InterestMst();
						interest.setInterestType(rs.getString("INTEREST_TYPE"));
						interest.setInterestRate(rs.getBigDecimal("INTEREST_RATE"));
						interest.setCorpCode(rs.getString("CORP_CODE"));
						interest.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						interest.setOperationFlag(rs.getString("OPERATION_FLAG"));
						interest.setActiveStatus(rs.getString("ACTIVE_STATUS"));
						interest.setUserGroup(rs.getString("USER_GROUP"));
						return interest;
					}
			 
			    });
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
		return results;
	}

	@Override
	public int countInterestFilter(SearchDataTable<InterestMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {		
			sql.append("SELECT COUNT(0) FROM ");
			if(searchDataTable.getTableType().equals(Constants.INTERESTTABLETMP)){
				sql.append(DBConstants.INTEREST_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.INTERESTTABLEMST)){
				sql.append(DBConstants.INTEREST_MST);
			}
			sql.append(" a ");
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.INTEREST_TYPE LIKE ? END");
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.INTEREST_RATE LIKE ? END");
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.CORP_CODE LIKE ? END");
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.AUTHORIZE_STATUS = ? END");
			where.add(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.ACTIVE_STATUS = ? END");
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{
					searchDataTable.getDataSearch().getInterestType(),
					searchDataTable.getDataSearch().getInterestType(),
					"%" + searchDataTable.getDataSearch().getInterestType() + "%",
					searchDataTable.getDataSearch().getInterestRate(),
					searchDataTable.getDataSearch().getInterestRate(),
					"%" + searchDataTable.getDataSearch().getInterestRate() + "%",
					searchDataTable.getDataSearch().getCorpCode(),
					searchDataTable.getDataSearch().getCorpCode(),
					"%" + searchDataTable.getDataSearch().getCorpCode() + "%",
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getActiveStatus(),
					searchDataTable.getDataSearch().getActiveStatus(),
					searchDataTable.getDataSearch().getActiveStatus()
			}, Integer.class);
		
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}

	@Override
	public int countInterestTotal(SearchDataTable<InterestMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		try {		
			sql.append("SELECT COUNT(0) FROM ");
			if(searchDataTable.getTableType().equals(Constants.INTERESTTABLETMP)){
				sql.append(DBConstants.INTEREST_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.INTERESTTABLEMST)){
				sql.append(DBConstants.INTEREST_MST);
			}
			sql.append(" a ");
			results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{}, Integer.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}

	@Override
	public int checkInterestDuplicate(InterestMst interestMst) throws Exception {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM(SELECT INTEREST_TYPE, INTEREST_RATE, CORP_CODE, 'MST' TYPE FROM ").append(DBConstants.INTEREST_MST).append(" UNION SELECT INTEREST_TYPE, INTEREST_RATE, CORP_CODE, 'TMP' TYPE FROM ");
			sql.append(DBConstants.INTEREST_TMP);
			sql.append(")a WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ? ORDER BY TYPE DESC");
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql.toString(), new Object[] { interestMst.getInterestType(), interestMst.getInterestRate(), interestMst.getCorpCode() });
			if(rows.size() > 0){
				for (Map<String, Object> row : rows) {
					if("TMP".equals((String) row.get("TYPE"))){
						MapErrorMsg mapError = new MapErrorMsg("@InterestRate", interestMst.getInterestRate().toString());
		        		throw new LMSException(mapError, 107);
					}else if("MST".equals((String) row.get("TYPE"))){
						MapErrorMsg mapError = new MapErrorMsg("@InterestRate", interestMst.getInterestRate().toString());
		        		throw new LMSException(mapError, 106);
					}
				}
			}
		} catch(Exception ex){
			logger.error(ex);
        	throw ex;
		}
		return result;
	}

	@Override
	public InterestMst getInterestMst(InterestMst interestMst) {
		InterestMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.INTEREST_MST);
			sql.append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { interestMst.getInterestType(), interestMst.getInterestRate(), interestMst.getCorpCode() }, new InterestRowMapper());
		} catch(Exception  ex){
			logger.error(ex); 
		}
		return result;
	}

	@Override
	public InterestMst getInterestTmp(InterestMst interestMst) {
		InterestMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.INTEREST_TMP);
			sql.append(" WHERE INTEREST_TYPE = ? AND INTEREST_RATE = ? AND CORP_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { interestMst.getInterestType(), interestMst.getInterestRate(), interestMst.getCorpCode() }, new InterestRowMapper());
		} catch(Exception  ex){
			logger.error(ex); 
		}
		return result;
	}
}
