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
import com.kbank.lms.mapper.FunctionRowMapper;
import com.kbank.lms.model.FunctionMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;
import com.kbank.lms.utils.Convert;


@Repository("functionDao")
public class FunctionDaoImpl implements FunctionDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(FunctionDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
 
	@Override
	public void insertFunctionMst(FunctionMst functionMst) {
	    try{
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO ");
        	sql.append(DBConstants.FUNCTION_MST);
        	sql.append(" (FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE");
        	sql.append(", ACTIVE_STATUS , AUTHORIZE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
        	sql.append("(?,?,?, ?,?,?,?, SYSDATE ,? ,?, ?,  SYSDATE(),?,SYSDATE(),?,SYSDATE(),?)");
        	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, functionMst.getFuncCode());
                    ps.setString(2, functionMst.getCorpCode());
                    ps.setString(3, functionMst.getVipFlag());
                    ps.setString(4, functionMst.getOvernightFlag());
                    ps.setString(5,  functionMst.getExecFreq());
                    ps.setString(6, functionMst.getDayOfWeek());
                    ps.setString(7, functionMst.getDayOfMonth());
                    ps.setString(8, functionMst.getAuthorizeStatus());
                    ps.setString(9, functionMst.getActiveStatus());
                    ps.setString(10, functionMst.getOperationFlag());
                    ps.setString(11, functionMst.getCreatedBy());
                    ps.setString(12, functionMst.getAuthorizedBy());
                    ps.setString(13, functionMst.getLastUpdatedBy());
                }
            });
        } catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	

	@Override
	public int checkFunctionDuplicate(String corpCode) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(0) FROM(SELECT CORP_CODE FROM ").append(DBConstants.FUNCTION_MST).append(" UNION SELECT CORP_CODE FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			sql.append(" WHERE CORP_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { corpCode }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<FunctionMst> searchFunction(SearchDataTable<FunctionMst> searchDataTable) {
		List<FunctionMst> results = null;
		StringBuilder sql = new StringBuilder();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLETMP)){
				orderColumns = new String[]{"a.EFFECTIVE_DATE", "a.CORP_CODE", "c.CORP_NAME", "a.EFFECTIVE_DATE", "a.AUTHORIZE_STATUS"};
			}else{
				orderColumns = new String[]{"a.CORP_CODE", "a.CORP_CODE", "c.CORP_NAME", "a.EFFECTIVE_DATE", "a.AUTHORIZE_STATUS"};
			}
			if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLETMP)){
				sql.append("SELECT a.CORP_CODE, a.EFFECTIVE_DATE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG, a.ACTIVE_STATUS, c.CORP_NAME FROM ");
				sql.append(DBConstants.FUNCTION_TMP);
				sql.append(" a LEFT JOIN ").append(DBConstants.CORPORATION_MST).append(" c ON a.CORP_CODE = c.CORP_CODE");
				if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
					sql.append(" WHERE a.AUTHORIZE_STATUS = 'W' ");
				}
			}else if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLEMST)){
				sql.append(" SELECT a.CORP_CODE, a.EFFECTIVE_DATE, a.ACTIVE_STATUS, ");
				sql.append(" (CASE WHEN b.AUTHORIZE_STATUS IS NOT NULL THEN b.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS, ");
				sql.append(" (CASE WHEN b.OPERATION_FLAG IS NOT NULL THEN b.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG, ");
				sql.append("c.CORP_NAME");
				sql.append(" FROM ");
				sql.append(DBConstants.FUNCTION_MST).append(" a LEFT JOIN ").append(DBConstants.FUNCTION_TMP).append(" b ");
				sql.append(" ON a.CORP_CODE = b.CORP_CODE ");
				sql.append(" LEFT JOIN ").append(DBConstants.CORPORATION_MST).append(" c ON c.CORP_CODE = a.CORP_CODE");
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getFuncCode())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getFuncCode() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		            }
		        }, new RowMapper<FunctionMst>() {
				 
					@Override
					public FunctionMst mapRow(ResultSet rs, int numRow) throws SQLException {
						FunctionMst func = new FunctionMst();
						func.setCorpCode(rs.getString("CORP_CODE"));
						func.setEffectiveDateStr(Convert.parseString(rs.getDate("EFFECTIVE_DATE")));
						func.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						func.setOperationFlag(rs.getString("OPERATION_FLAG"));
						func.setActiveStatus(rs.getString("ACTIVE_STATUS"));
						func.setCorpName(rs.getString("CORP_NAME"));
						return func;
					}
			 
			    });
		}catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results;
	}
	
	@Override
	public int countFunctionFilter(SearchDataTable<FunctionMst> searchDataTable) {
		List<FunctionMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {
		sql.append("SELECT DISTINCT CORP_CODE FROM ");
		if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLETMP)){
			sql.append(DBConstants.FUNCTION_TMP);
		}else if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLEMST)){
			sql.append(DBConstants.FUNCTION_MST);
		}
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
			where.add(" CORP_CODE LIKE ?");
		}
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getFuncCode())){
			where.add(" FUNC_CODE LIKE ?");
		}
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getActiveStatus())){
			where.add(" AUTHORIZE_STATUS = ?");
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
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())) {
	                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getCorpCode() + "%");
	                }
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getFuncCode())) {
	                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getFuncCode() + "%");
	                }
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getActiveStatus())) {
	                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getActiveStatus());
	                }
	            }
	        }, new RowMapper<FunctionMst>() {
				 
					@Override
					public FunctionMst mapRow(ResultSet rs, int numRow) throws SQLException {
						FunctionMst function = new FunctionMst();
						function.setCorpCode(rs.getString("CORP_CODE"));
						return function;
					}
			 
			    });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results.size();
	}
	
	@Override
	public int countFunctionTotal(SearchDataTable<FunctionMst> searchDataTable) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(DISTINCT CORP_CODE) FROM ");
			if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLETMP)){
				sql.append(DBConstants.FUNCTION_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.FUNCTIONTABLEMST)){
				sql.append(DBConstants.FUNCTION_MST);
			}
			result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void insertFunctionTmp(FunctionMst functionMst) {
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.FUNCTION_TMP);
	    	sql.append(" (FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE");
	    	sql.append(", ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG ");
	    	sql.append(", CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE(), ?, SYSDATE(), ?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, functionMst.getFuncCode());
	                ps.setString(2, functionMst.getCorpCode());
	                ps.setString(3, functionMst.getVipFlag()==null ? "N" : functionMst.getVipFlag());
	                ps.setString(4, functionMst.getOvernightFlag()==null ? "N" : functionMst.getOvernightFlag());
	                ps.setString(5, functionMst.getExecFreq());
	                ps.setString(6, functionMst.getDayOfWeek());
	                ps.setString(7, functionMst.getDayOfMonth());
	                if(functionMst.getEffectiveDate() != null){
	                	ps.setDate(8, new java.sql.Date(functionMst.getEffectiveDate().getTime()));
	                }else{
	                	ps.setNull(8, java.sql.Types.DATE);
	                }
	                ps.setString(9, functionMst.getActiveStatus());
	                ps.setString(10, functionMst.getAuthorizeStatus());
	                ps.setString(11, functionMst.getOperationFlag());
	                ps.setString(12,functionMst.getCreatedBy());
	                ps.setString(13,functionMst.getLastUpdatedBy());
	                
	            }
	        });
    	} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void copyToFunctionTmp(FunctionMst functionMst) {
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.FUNCTION_TMP).append(" (FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS,");
			sql.append( "REJECT_REASON, OPERATION_FLAG, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT FUNC_CODE, CORP_CODE, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, functionMst.getVipFlag());
	            	ps.setString(2,  functionMst.getOvernightFlag());
	            	ps.setString(3, functionMst.getOperationFlag());
	            	ps.setString(4, functionMst.getExecFreq());
	            	ps.setString(5, functionMst.getDayOfWeek());
	            	ps.setString(6, functionMst.getDayOfMonth());
	            	ps.setDate(7, new java.sql.Date(functionMst.getEffectiveDate().getTime()));
	            	ps.setString(8, functionMst.getActiveStatus());
	            	ps.setString(9, functionMst.getAuthorizeStatus());
	            	ps.setString(10, functionMst.getOperationFlag());
	            	ps.setString(11, functionMst.getLastUpdatedBy());
	            	ps.setString(12, functionMst.getCorpCode());
	            }
	        });
			
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	
	/*Update Function Temp*/
	@Override
	public void updateFunctionTmp(FunctionMst functionMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.FUNCTION_TMP);
			sql.append(" SET FUNC_CODE = ?, VIP_FLAG = ?, OVERNIGHT_FLAG = ?, EXEC_FREQ = ?, DAY_OF_WEEK = ?, DAY_OF_MONTH = ?, EFFECTIVE_DATE = ?,  ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, functionMst.getFuncCode());
	            	ps.setString(2, functionMst.getVipFlag()==null ? "N" : functionMst.getVipFlag());
	            	ps.setString(3, functionMst.getOvernightFlag()==null ? "N" : functionMst.getOvernightFlag());
	            	ps.setString(4, functionMst.getExecFreq());
	            	ps.setString(5, functionMst.getDayOfWeek());
	            	ps.setString(6, functionMst.getDayOfMonth());
	            	ps.setDate(7, new java.sql.Date(functionMst.getEffectiveDate().getTime()));
	            	ps.setString(8, functionMst.getActiveStatus());
	            	ps.setString(9, functionMst.getAuthorizeStatus());
	            	ps.setString(10, functionMst.getOperationFlag());
	            	ps.setString(11, functionMst.getLastUpdatedBy());
	            	ps.setString(12, functionMst.getCorpCode());
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	/* End Update Function Temp*/

	@Override
	@Transactional
	public void copyToFunctionTmpDelete(FunctionMst functionMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.FUNCTION_TMP).append(" (FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, ");
			sql.append(" SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE, ACTIVE_STATUS, ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ?  FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, functionMst.getAuthorizeStatus());
	            	ps.setString(2, functionMst.getOperationFlag());
	            	ps.setString(3, functionMst.getLastUpdatedBy());
	            	ps.setString(4, functionMst.getCorpCode());
	            }
	        });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}
	
	/* Delete Function Master and Temp */
	@Override
	public void deleteFunctionMstCorpCode(String corpCode) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_MST).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void deleteFunctionTmpCorpCode(String corpCode) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_TMP).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	/* End Delete Function Master and Temp */
	
	
	@Override
	public void copyToFunctionMst(FunctionMst functionMst) {
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.FUNCTION_MST).append(" (FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG,");
			sql.append(" SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT  FUNC_CODE, CORP_CODE, VIP_FLAG, OVERNIGHT_FLAG, EXEC_FREQ, DAY_OF_WEEK, DAY_OF_MONTH, EFFECTIVE_DATE, ACTIVE_STATUS , ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), ?, SYSDATE(), ? FROM ");
			sql.append(DBConstants.FUNCTION_TMP);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, functionMst.getAuthorizeStatus());
	            	ps.setString(2, functionMst.getOperationFlag());
	            	ps.setString(3, functionMst.getAuthorizedBy());
	            	ps.setString(4, functionMst.getLastUpdatedBy());
	            	ps.setString(5, functionMst.getCorpCode());
	            }
	        });
			
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	

	@Override
	public FunctionMst getFunctionTmpByCorpCode(String corpCode) {
		FunctionMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.FUNCTION_TMP);
			sql.append(" WHERE CORP_CODE = ? ");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode }, new FunctionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public FunctionMst getFunctionMstByCorpCode(String corpCode) {
		FunctionMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			sql.append(" WHERE CORP_CODE = ? ");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode }, new FunctionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void updateFunctionTmpToFunctionMst(FunctionMst functionMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_MST).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { functionMst.getCorpCode()});
	    	
			// INSERT NEW
			this.copyToFunctionMst(functionMst);
			
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_TMP).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { functionMst.getCorpCode()});
	    	transactionManager.commit(status);
    	}catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
    	}
	}
	
	@Override
	public void updateAutorizeStatus(FunctionMst functionMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.FUNCTION_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, functionMst.getAuthorizeStatus());
	            	ps.setString(2, functionMst.getAuthorizedBy());
	            	ps.setString(3, functionMst.getRejectReason());
	            	ps.setString(4, functionMst.getCorpCode());
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void updateEffectiveDate(String corpCode) {
		java.util.Date d = new java.util.Date();
		int days = d.getHours() > 17 ? 2 : 1 ;
		java.util.Calendar c = java.util.Calendar.getInstance(); 
		c.setTime(d); 
		c.add(java.util.Calendar.DATE, days);
		d = c.getTime();
		java.sql.Date dd = new java.sql.Date(d.getTime());
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.FUNCTION_TMP).append(" SET EFFECTIVE_DATE = (CASE WHEN EFFECTIVE_DATE < ? THEN ? ELSE EFFECTIVE_DATE END)  ");
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setDate(1, dd);
	            	ps.setDate(2, dd);
	            	ps.setString(3, corpCode);
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public int countFunctionMst() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public int countFuctionTmp() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.FUNCTION_TMP);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public void deleteAllFunctionTmp() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_TMP);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public void deleteAllFunctionMst() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.FUNCTION_MST);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
}
