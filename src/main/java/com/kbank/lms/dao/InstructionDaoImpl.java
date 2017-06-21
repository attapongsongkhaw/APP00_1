package com.kbank.lms.dao;

import java.sql.Date;
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
import com.kbank.lms.mapper.InstructionRowMapper;
import com.kbank.lms.model.InstructionMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.Convert;
import com.kbank.lms.utils.DBConstants;

@Repository("instructionDao") 
public class InstructionDaoImpl implements InstructionDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(InstructionDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
	
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
	
	@Override
	@Transactional
	public void insertInstructionMst(InstructionMst instructionMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
	    try{   	
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO ");
        	sql.append(DBConstants.INSTRUCTION_MST);
        	sql.append(" (INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, PRIORITY, LEVEL, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DEFICIT_RATE, EFFECTIVE_DATE, ACTIVE_STATUS");
        	sql.append(", AUTHORIZE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
        	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?,SYSDATE(),?)");
        	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, instructionMst.getInstructionName());
                    ps.setInt(2, instructionMst.getMemberAccountId());
                    ps.setInt(3, instructionMst.getMasterAccountId());
                    ps.setInt(4, instructionMst.getPriority());
                    ps.setInt(5, instructionMst.getLevel());
                    ps.setDouble(6, instructionMst.getMinBalance());
                    ps.setDouble(7, instructionMst.getMaxBalance());
                    ps.setDouble(8, instructionMst.getSweepRate());
                    ps.setDouble(9, instructionMst.getDeficitRate());
                    if(instructionMst.getEffectiveDate() == null){
                        ps.setNull(10, java.sql.Types.DATE); 
                    }else{
                    	ps.setDate(10, new java.sql.Date(instructionMst.getEffectiveDate().getTime()));
                    }
                    ps.setString(11, instructionMst.getActiveStatus());
                    ps.setString(12, instructionMst.getAuthorizeStatus());
                    ps.setString(13, instructionMst.getOperationFlag());
                    ps.setString(14, instructionMst.getCreatedBy());
                    ps.setString(15, instructionMst.getAuthorizedBy());
                    ps.setString(16, instructionMst.getLastUpdatedBy());
                }
            });
        	transactionManager.commit(status);
        }catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
        }
	}
	
	@Override
	public int checkInstructionDuplicate(int instructionId) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(0) FROM(SELECT INSTRUCTION_ID FROM ").append(DBConstants.INSTRUCTION_MST).append(" UNION SELECT INSTRUCTION_ID FROM ");
			sql.append(DBConstants.INSTRUCTION_MST);
			sql.append(" WHERE INSTRUCTION_ID = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { instructionId }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> searchInstruction(SearchDataTable<InstructionMst> searchDataTable) {
		List<InstructionMst> results = null;
		StringBuilder sql = new StringBuilder();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.INSTRUCTIONTABLETMP)){
				orderColumns = new String[]{"EFFECTIVE_DATE"};
			}else{
				orderColumns = new String[]{"INSTRUCTION_ID"};
			}
			if(searchDataTable.getTableType().equals(Constants.INSTRUCTIONTABLETMP)){
				sql.append("SELECT INSTRUCTION_ID, INSTRUCTION_NAME, EFFECTIVE_DATE, AUTHORIZE_STATUS, OPERATION_FLAG FROM ");
				sql.append(DBConstants.INSTRUCTION_TMP);
				if(searchDataTable.getRoleUser().equals(Constants.CHECKER)){
					sql.append(" WHERE AUTHORIZE_STATUS = 'W' ");
				}
			}else if(searchDataTable.getTableType().equals(Constants.INSTRUCTIONTABLEMST)){
				sql.append("SELECT DISTINCT INSTRUCTION_ID, INSTRUCTION_NAME, EFFECTIVE_DATE, AUTHORIZE_STATUS, OPERATION_FLAG FROM ");
				sql.append(DBConstants.INSTRUCTION_MST);
			}
			
			if(searchDataTable.getOrder().size() > 0){
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getInstructionName())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getInstructionName() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		            }
		        }, new RowMapper<InstructionMst>() {
				 
					@Override
					public InstructionMst mapRow(ResultSet rs, int numRow) throws SQLException {
						InstructionMst instruc = new InstructionMst();
						instruc.setInstructionName(rs.getString("INSTRUCTION_NAME"));
						instruc.setEffectiveDateStr(Convert.parseString(rs.getDate("EFFECTIVE_DATE")));
						instruc.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						instruc.setOperationFlag(rs.getString("OPERATION_FLAG"));
						return instruc;
					}
			 
			    });
		}catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results;
	}
	
	@Override
	public void insertInstructionTmp(InstructionMst instructionMst) {
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.INSTRUCTION_TMP);
	    	sql.append(" ( INSTRUCTION_ID, INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, LEVEL, PRIORITY ");
	    	sql.append(", DIRECTION, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DEFICIT_RATE ,EFFECTIVE_DATE ");
	    	sql.append(", ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG, SYNC_STATUS ");
	    	sql.append(", CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE(), ?)");
	        jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setInt(1, instructionMst.getInstructionId());
	                ps.setString(2, instructionMst.getInstructionName());
	                ps.setInt(3,  instructionMst.getMemberAccountId());
	                ps.setInt(4, instructionMst.getMasterAccountId());
	                ps.setInt(5, instructionMst.getLevel());
	                ps.setInt(6, instructionMst.getPriority());
	                ps.setString(7, instructionMst.getDirection());
	                ps.setDouble(8, instructionMst.getMinBalance());
	                ps.setDouble(9, instructionMst.getMaxBalance());
	                ps.setDouble(10, instructionMst.getSweepRate());
	                ps.setDouble(11, instructionMst.getDeficitRate());
	                if(instructionMst.getEffectiveDate() != null){
	                	ps.setDate(12, new java.sql.Date(instructionMst.getEffectiveDate().getTime()));
	                }else{
	                	ps.setNull(12, java.sql.Types.DATE);
	                }
	                ps.setString(13, instructionMst.getActiveStatus());
	                ps.setString(14, instructionMst.getAuthorizeStatus());
	                ps.setString(15, instructionMst.getOperationFlag());
	                ps.setString(16, instructionMst.getSyncStatus());
	                ps.setDate(17, new java.sql.Date(instructionMst.getCreatedDate().getTime()));
	                ps.setString(18, instructionMst.getCreatedBy());
	                ps.setString(19, instructionMst.getLastUpdatedBy());
	            }
	        });
    	} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void copyToInstructionTmp(InstructionMst instructionMst) {
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.INSTRUCTION_TMP).append(" ( INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, LEVEL, PRIORITY, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DEFICIT_RATE ,");
			sql.append(" EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS,");
			sql.append(" REJECT_REASON, OPERATION_FLAG, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT ?, ?, ?, LEVEL, ?, ?, ?, ?, ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.INSTRUCTION_MST);
			sql.append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, instructionMst.getInstructionName());
	            	ps.setInt(2, instructionMst.getMemberAccountId());
	            	ps.setInt(3, instructionMst.getMasterAccountId());
	            	ps.setInt(4, instructionMst.getPriority());
	            	ps.setDouble(5, instructionMst.getMinBalance());
	            	ps.setDouble(6, instructionMst.getMaxBalance());
	            	ps.setDouble(7, instructionMst.getSweepRate());
	            	ps.setDouble(8, instructionMst.getDeficitRate());
	            	ps.setDate(9, (Date) instructionMst.getEffectiveDate());
	            	ps.setString(10, instructionMst.getActiveStatus());
	            	ps.setString(11, instructionMst.getAuthorizeStatus());
	            	ps.setString(12, instructionMst.getOperationFlag());
	            	ps.setString(13, instructionMst.getLastUpdatedBy());
	            	ps.setInt(14, instructionMst.getInstructionId());
	            }
	        });
			
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	/*Update Instruction Temp*/
	@Override
	public void updateInstructionTmp(InstructionMst instructionMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.INSTRUCTION_TMP);
			sql.append(" SET INSTRUCTION_NAME = ?, MEMBER_ACCOUNT_ID = ?, MASTER_ACCOUNT_ID = ?, PRIORITY = ?, DIRECTION = ?, MIN_BALANCE = ?, MAX_BALANCE = ?, SWEEP_RATE = ?, DEFICIT_RATE =? ,");
			sql.append(" EFFECTIVE_DATE = ?,  ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, SYNC_STATUS = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, instructionMst.getInstructionName());
	            	ps.setInt(2, instructionMst.getMemberAccountId());
	            	ps.setInt(3, instructionMst.getMasterAccountId());
	            	ps.setInt(4, instructionMst.getPriority());
	            	ps.setString(5, instructionMst.getDirection());
	            	ps.setDouble(6, instructionMst.getMinBalance());
	            	ps.setDouble(7, instructionMst.getMaxBalance());
	            	ps.setDouble(8, instructionMst.getSweepRate());
	            	ps.setDouble(9, instructionMst.getDeficitRate());
	            	ps.setDate(10, (Date) instructionMst.getEffectiveDate());
	            	ps.setString(11, instructionMst.getActiveStatus());
	            	ps.setString(12, instructionMst.getAuthorizeStatus());
	            	ps.setString(13, instructionMst.getOperationFlag());
	            	ps.setString(14, instructionMst.getSyncStatus());
	            	ps.setString(15, instructionMst.getLastUpdatedBy());
	            	ps.setInt(16, instructionMst.getInstructionId());
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	} 
	
	@Override
	@Transactional
	public void copyToInstructionTmpDelete(InstructionMst instructionMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.INSTRUCTION_TMP).append(" ( INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, PRIORITY, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DIFICIT_RATE,  ");
			sql.append(" EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, ");
			sql.append(" SYN_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT ?, ?, ?, LEVEL, ?, ?, ?, ?, ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ?  FROM ");
			sql.append(DBConstants.FUNCTION_MST);
			sql.append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, instructionMst.getInstructionName());
	            	ps.setInt(2, instructionMst.getMemberAccountId());
	            	ps.setInt(3, instructionMst.getMasterAccountId());
	            	ps.setInt(4, instructionMst.getPriority());
	            	ps.setDouble(5, instructionMst.getMinBalance());
	            	ps.setDouble(6, instructionMst.getMaxBalance());
	            	ps.setDouble(7, instructionMst.getSweepRate());
	            	ps.setDouble(8, instructionMst.getDeficitRate());
	            	ps.setDate(5, (Date) instructionMst.getEffectiveDate());
	            	ps.setString(6, instructionMst.getActiveStatus());
	            	ps.setString(7, instructionMst.getAuthorizeStatus());
	            	ps.setString(8, instructionMst.getOperationFlag());
	            	ps.setString(9, instructionMst.getLastUpdatedBy());
	            	ps.setInt(10, instructionMst.getInstructionId());
	            }
	        });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}
	
	/* Delete Instruction Master and Temp */
	@Override
	public void deleteInstructionMstInstructionId(int instructionId) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_MST).append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { instructionId });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public void deleteInstructionTmpInstructionId(int instructionId) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_TMP).append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { instructionId });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void deleteInstructionTmpByCorpCode(String corpCode) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" DELETE i FROM ").append(DBConstants.INSTRUCTION_TMP).append(" i ");
			sql.append(" INNER JOIN ").append(DBConstants.ACCOUNT_MST).append(" a ON i.member_account_id = a.account_id ");
			sql.append(" WHERE a.corp_code = ? ");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	/* End Delete Instruction Master and Temp */
	
	@Override
	public void deleteInstructionTmpByCorpCodeAndOperationFlag(String corpCode, String operationFlag) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" DELETE i FROM ").append(DBConstants.INSTRUCTION_TMP).append(" i ");
			sql.append(" INNER JOIN ").append(DBConstants.ACCOUNT_MST).append(" a ON i.member_account_id = a.account_id ");
			sql.append(" WHERE a.corp_code = ? AND i.operation_flag = ? ");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode, operationFlag });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void copyToInstructionMst(InstructionMst instructionMst) {
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.INSTRUCTION_MST).append(" ( INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, LEVEL, PRIORITY, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DIFICIT_RATE, ");
			sql.append(" EFFECTIVE_DATE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG,");
			sql.append(" SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT  INSTRUCTION_NAME, MEMBER_ACCOUNT_ID, MASTER_ACCOUNT_ID, LEVEL, PRIORITY, MIN_BALANCE, MAX_BALANCE, SWEEP_RATE, DIFICIT_RATE, EFFECTIVE_DATE, ACTIVE_STATUS , ?, NULL, ?, SYNC_DATE, SYNC_STATUS, SYNC_MESSAGE, CREATED_DATE, CREATED_BY, SYSDATE(), ?, SYSDATE(), ? FROM ");
			sql.append(DBConstants.INSTRUCTION_TMP);
			sql.append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, instructionMst.getAuthorizeStatus());
	            	ps.setString(2, instructionMst.getOperationFlag());
	            	ps.setString(3, instructionMst.getAuthorizedBy());
	            	ps.setString(4, instructionMst.getLastUpdatedBy());
	            	ps.setInt(5, instructionMst.getInstructionId());
	            }
	        });
			
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public List<InstructionMst> getInstructionTmpByInstructionId(int instructionId) {
		List<InstructionMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT I.*, A.ACCOUNT_NO AS MASTER_ACCOUNT, A2.ACCOUNT_NO AS MEMBER_ACCOUNT, C.CLIENT_CODE, C.CLIENT_NAME FROM ");
			sql.append(DBConstants.INSTRUCTION_TMP).append(" I ");
			sql.append(" INNER JOIN ACCOUNT_MST A2 ON I.MEMBER_ACCOUNT_ID = A2.ACCOUNT_ID ");
			sql.append(" LEFT JOIN ACCOUNT_MST A ON I.MASTER_ACCOUNT_ID = A.ACCOUNT_ID ");
			sql.append(" LEFT JOIN CLIENT_MST C ON A2.CLIENT_CODE = C.CLIENT_CODE ");
			sql.append(" WHERE I.INSTRUCTION_ID = ? ");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { instructionId }, new InstructionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionMstByInstructionId(int instructionId) {
		List<InstructionMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT I.*, A.ACCOUNT_NO AS MASTER_ACCOUNT, A2.ACCOUNT_NO AS MEMBER_ACCOUNT, C.CLIENT_CODE, C.CLIENT_NAME FROM ");
			sql.append(DBConstants.INSTRUCTION_MST).append(" I ");
			sql.append(" INNER JOIN ACCOUNT_MST A2 ON I.MEMBER_ACCOUNT_ID = A2.ACCOUNT_ID ");
			sql.append(" LEFT JOIN ACCOUNT_MST A ON I.MASTER_ACCOUNT_ID = A.ACCOUNT_ID ");
			sql.append(" LEFT JOIN CLIENT_MST C ON A2.CLIENT_CODE = C.CLIENT_CODE ");
			sql.append(" WHERE I.INSTRUCTION_ID = ? ");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { instructionId }, new InstructionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public void updateInstructionTmpToInstructionMst(InstructionMst instructionMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_MST).append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { instructionMst.getInstructionId()});
	    	
			// INSERT NEW
			this.copyToInstructionMst(instructionMst);
			
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_TMP).append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { instructionMst.getInstructionId()});
	    	transactionManager.commit(status);
    	}catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
    	}
	}
	
	@Override
	public void updateAutorizeStatus(InstructionMst instructionMst) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.INSTRUCTION_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE INSTRUCTION_ID = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, instructionMst.getAuthorizeStatus());
	            	ps.setString(2, instructionMst.getAuthorizedBy());
	            	ps.setString(3, instructionMst.getRejectReason());
	            	ps.setInt(4, instructionMst.getInstructionId());
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public void updateAutorizeStatusByCorpCode(String corpCode, String authorizeStatus, String authorizeBy, String rejectReason) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" UPDATE ").append(DBConstants.INSTRUCTION_TMP).append(" I ");
			sql.append(" INNER JOIN ").append(DBConstants.ACCOUNT_MST).append(" A ON I.MEMBER_ACCOUNT_ID = A.ACCOUNT_ID ");
			sql.append(" SET I.AUTHORIZE_STATUS = ?, I.AUTHORIZED_DATE = SYSDATE(), I.AUTHORIZED_BY = ?, I.REJECT_REASON = ? ");
			sql.append(" WHERE A.CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, authorizeStatus);
	            	ps.setString(2, authorizeBy);
	            	ps.setString(3, rejectReason);
	            	ps.setString(4, corpCode);
	            }
	        });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}
	
	@Override
	public int countInstructionFilter(SearchDataTable<InstructionMst> searchDataTable) {
		List<InstructionMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {
		sql.append("SELECT INSTRUCTION_ID FROM ");
		sql.append(DBConstants.INSTRUCTION_MST);
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getInstructionName())){
			where.add(" INSTRUCTION_NAME LIKE ?");
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
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getInstructionName())) {
	                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getInstructionName() + "%");
	                }
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getActiveStatus())) {
	                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getActiveStatus());
	                }
	            }
	        }, new RowMapper<InstructionMst>() {
					@Override
					public InstructionMst mapRow(ResultSet rs, int numRow) throws SQLException {
						InstructionMst instruction = new InstructionMst();
						instruction.setInstructionName(rs.getString("INSTRUCTION_NAME"));
						return instruction;
					}
			 
			    });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results.size();
	}
	
	@Override
	public int countInstructionTotal(SearchDataTable<InstructionMst> searchDataTable) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(INSTRUCTION_ID) FROM ");
			if(searchDataTable.getTableType().equals(Constants.INSTRUCTIONTABLETMP)){
				sql.append(DBConstants.INSTRUCTION_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.INSTRUCTIONTABLEMST)){
				sql.append(DBConstants.INSTRUCTION_MST);
			}
			result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionByCorpCode(String corpCode) {
		List<InstructionMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT I.*, A.ACCOUNT_NO AS MASTER_ACCOUNT, A2.ACCOUNT_NO AS MEMBER_ACCOUNT, C.CLIENT_CODE, C.CLIENT_NAME FROM ");
			sql.append(DBConstants.INSTRUCTION_TMP).append(" I ");
			sql.append(" INNER JOIN ACCOUNT_MST A2 ON I.MEMBER_ACCOUNT_ID = A2.ACCOUNT_ID ");
			sql.append(" LEFT JOIN ACCOUNT_MST A ON I.MASTER_ACCOUNT_ID = A.ACCOUNT_ID ");
			sql.append(" LEFT JOIN CLIENT_MST C ON A2.CLIENT_CODE = C.CLIENT_CODE ");
			sql.append(" WHERE A2.CORP_CODE = ? ");
			sql.append(" ORDER BY I.LEVEL ASC, I.PRIORITY ASC ");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { corpCode }, new InstructionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
	@Override
	public List<InstructionMst> getInstructionMstByCorpCode(String corpCode) {
		List<InstructionMst> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT I.*, A.ACCOUNT_NO AS MASTER_ACCOUNT, A2.ACCOUNT_NO AS MEMBER_ACCOUNT, C.CLIENT_CODE, C.CLIENT_NAME FROM ");
			sql.append(DBConstants.INSTRUCTION_MST).append(" I ");
			sql.append(" INNER JOIN ACCOUNT_MST A2 ON I.MEMBER_ACCOUNT_ID = A2.ACCOUNT_ID ");
			sql.append(" LEFT JOIN ACCOUNT_MST A ON I.MASTER_ACCOUNT_ID = A.ACCOUNT_ID ");
			sql.append(" LEFT JOIN CLIENT_MST C ON A2.CLIENT_CODE = C.CLIENT_CODE ");
			sql.append(" WHERE A2.CORP_CODE = ? ");
			sql.append(" ORDER BY I.LEVEL ASC, I.PRIORITY ASC ");
			result = jdbcTemplate.query(sql.toString(),  new Object[] { corpCode }, new InstructionRowMapper());
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
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
			sql.append("UPDATE ").append(DBConstants.INSTRUCTION_TMP).append(" SET EFFECTIVE_DATE = (CASE WHEN EFFECTIVE_DATE < ? THEN ? ELSE EFFECTIVE_DATE END)  ");
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
	public int countInstructionMst() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.INSTRUCTION_MST);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public int countInstructionTmp() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.INSTRUCTION_TMP);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public void deleteAllInstructionTmp() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_TMP);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public void deleteAllInstructionMst() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.INSTRUCTION_MST);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public int countInstructionTmpByInstructionId(int instructionId) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(INSTRUCTION_ID) FROM ").append(DBConstants.INSTRUCTION_TMP);
			sql.append(" WHERE INSTRUCTION_ID = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { instructionId }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}
	
}
