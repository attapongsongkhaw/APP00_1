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
import com.kbank.lms.mapper.ClientRowMapper;
import com.kbank.lms.model.ClientMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {
	
	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(ClientDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
    
	@Override
	public void insertClientMst(ClientMst clientMst) {
	    try{
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO ");
        	sql.append(DBConstants.CLIENT_MST);
        	sql.append(" (CLIENT_CODE, CLIENT_NAME, CORP_CODE, CIS_ID");
        	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
        	sql.append("(?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?,SYSDATE(),?)");
        	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, clientMst.getClientCode());
                    ps.setString(2, clientMst.getClientName());
                    ps.setString(3, clientMst.getCorpCode());
                    ps.setString(4, clientMst.getCisId());
                    ps.setString(5, clientMst.getAuthorizeStatus());
                    ps.setString(6, clientMst.getActiveStatus());
                    ps.setString(7, clientMst.getOperationFlag());
                    ps.setString(8, clientMst.getCreatedBy());
                    ps.setString(9, clientMst.getAuthorizedBy());
                    ps.setString(10, clientMst.getLastUpdatedBy());
                }
            });
        }catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}

	@Override
	public int checkClientDuplicate(String clientCode){
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM(SELECT CLIENT_CODE FROM ").append(DBConstants.CLIENT_MST).append(" UNION SELECT CLIENT_CODE FROM ");
			sql.append(DBConstants.CLIENT_TMP);
			sql.append(")a WHERE CLIENT_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { clientCode }, Integer.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return result;
	}
	
	@Override
	public List<ClientMst> searchClient(SearchDataTable<ClientMst> searchDataTable) {
		List<ClientMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.CLIENTTABLETMP)){
				orderColumns = new String[]{ "a.LAST_UPDATED_DATE", "a.CLIENT_CODE", "a.CLIENT_NAME", "a.AUTHORIZE_STATUS"};
			}else if(searchDataTable.getTableType().equals(Constants.CLIENTTABLEMST)){
				orderColumns = new String[]{ "a.CLIENT_CODE", "a.CLIENT_CODE", "a.CLIENT_NAME", "a.AUTHORIZE_STATUS"};
			}
			if(searchDataTable.getTableType().equals(Constants.CLIENTTABLETMP)){
				sql.append("SELECT a.CLIENT_CODE, a.CLIENT_NAME, a.CORP_CODE, a.AUTHORIZE_STATUS, a.OPERATION_FLAG FROM ");
				sql.append(DBConstants.CLIENT_TMP).append(" a ");
			}else if(searchDataTable.getTableType().equals(Constants.CLIENTTABLEMST)){
				sql.append("SELECT a.CLIENT_CODE, a.CLIENT_NAME, a.CORP_CODE, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG ");
				sql.append(" FROM ");
				sql.append(DBConstants.CLIENT_MST).append(" a LEFT JOIN ").append(DBConstants.CLIENT_TMP).append(" b ");
				sql.append("ON b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' OR b.OPERATION_FLAG = 'D') AND a.CLIENT_CODE = b.CLIENT_CODE ");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientCode())){
				where.add(" CLIENT_CODE LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientName())){
				where.add(" CLIENT_NAME LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				where.add(" AUTHORIZE_STATUS = ?");
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientCode())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getClientCode() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientName())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getClientName() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		            }
		        }, new RowMapper<ClientMst>() {
				 
					@Override
					public ClientMst mapRow(ResultSet rs, int numRow) throws SQLException {
						ClientMst client = new ClientMst();
						client.setClientCode(rs.getString("CLIENT_CODE"));
						client.setClientName(rs.getString("CLIENT_NAME"));
						client.setCorpCode(rs.getString("CORP_CODE"));
						client.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						client.setOperationFlag(rs.getString("OPERATION_FLAG"));
						return client;
					}
			 
			    });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return results;
	}
	
	@Override
	public int countClientFilter(SearchDataTable<ClientMst> searchDataTable) {
		List<ClientMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {		
			sql.append("SELECT CLIENT_CODE FROM ");
			if(searchDataTable.getTableType().equals(Constants.CLIENTTABLETMP)){
				sql.append(DBConstants.CLIENT_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.CLIENTTABLEMST)){
				sql.append(DBConstants.CLIENT_MST);
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientCode())){
				where.add(" CLIENT_CODE LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientName())){
				where.add(" CLIENT_NAME LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientCode())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getClientCode() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getClientName())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getClientName() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		            }
		        }, new RowMapper<ClientMst>() {
					 
						@Override
						public ClientMst mapRow(ResultSet rs, int numRow) throws SQLException {
							ClientMst client = new ClientMst();
							client.setClientCode(rs.getString("CLIENT_CODE"));
							return client;
						}
				  
				    });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results.size();
	}
	
	@Override
	public int countClientTotal(SearchDataTable<ClientMst> searchDataTable) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(0) FROM ");
			if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
				sql.append(DBConstants.CLIENT_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.CORPTABLEMST)){
				sql.append(DBConstants.CLIENT_MST);
			}
			sql.append(" WHERE CASE WHEN (? = '' || ? IS NULL) THEN 1 = 1 ELSE AUTHORIZE_STATUS = ? END");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { 
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus(),
					searchDataTable.getDataSearch().getAuthorizeStatus() }, Integer.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return result;
	}
	
	@Override
	public void insertClientTmp(ClientMst clientMst) {
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.CLIENT_TMP);
	    	sql.append(" ( CLIENT_CODE, CLIENT_NAME, CORP_CODE,  CIS_ID");
	    	sql.append(", ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG ");
	    	sql.append(", CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, clientMst.getClientCode());
	                ps.setString(2, clientMst.getClientName());
	                ps.setString(3, clientMst.getCorpCode());
	                ps.setString(4, clientMst.getCisId());
	                ps.setString(5, clientMst.getActiveStatus());
	                ps.setString(6, clientMst.getAuthorizeStatus());
	                ps.setString(7, clientMst.getOperationFlag());
	                ps.setString(8, clientMst.getCreatedBy());
	                ps.setString(9, clientMst.getLastUpdatedBy());
	            }
	        });
    	}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	
	@Override
	public void copyToClientTmp(ClientMst clientMst){
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CLIENT_TMP).append(" (CLIENT_CODE, CLIENT_NAME, CIS_ID, CORP_CODE, ACTIVE_STATUS, AUTHORIZE_STATUS,");
			sql.append( "REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CLIENT_CODE, ?, ?, CORP_CODE, ?, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, clientMst.getClientName());
	            	ps.setString(2, clientMst.getCisId());
	            	ps.setString(3, clientMst.getActiveStatus());
	            	ps.setString(4, clientMst.getAuthorizeStatus());
	            	ps.setString(5, clientMst.getOperationFlag());
	            	ps.setString(6, clientMst.getLastUpdatedBy());
	            	ps.setString(7, clientMst.getClientCode());
	            }
	        });
			
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	
	
	/*Update Client Temp*/
	@Override
	public void updateClientTmp(ClientMst clientMst){
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.CLIENT_TMP);
			sql.append(" SET CLIENT_NAME = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, clientMst.getClientName());
	            	ps.setString(2, clientMst.getCisId());
	            	ps.setString(3, clientMst.getActiveStatus());
	            	ps.setString(4, clientMst.getAuthorizeStatus());
	            	ps.setString(5, clientMst.getOperationFlag());
	            	ps.setString(6, clientMst.getLastUpdatedBy());
	            	ps.setString(7, clientMst.getClientCode());
	            }
	        });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	/* End Update Client Temp*/
	
	
	@Override
	@Transactional
	public void copyToClientTmpDelete(ClientMst clientMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CLIENT_TMP).append(" (CLIENT_CODE, CLIENT_NAME, CIS_ID, CORP_CODE, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, ");
			sql.append("CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CLIENT_CODE, CLIENT_NAME, CIS_ID, CORP_CODE, ACTIVE_STATUS, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, clientMst.getAuthorizeStatus());
	            	ps.setString(2, clientMst.getOperationFlag());
	            	ps.setString(3, clientMst.getLastUpdatedBy());
	            	ps.setString(4, clientMst.getClientCode());
	            }
	        });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}
	
	/* Delete Client Master and Temp */
	@Override
	public void deleteClientMstClientCode(String clientCode){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CLIENT_MST).append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { clientCode });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}

	@Override
	public void deleteClientTmpClientCode(String clientCode){
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.CLIENT_TMP).append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { clientCode });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	/* End Delete Client Master and Temp */
	
	
	@Override
	public void copyToClientMst(ClientMst clientMst){
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CLIENT_MST).append(" (CLIENT_CODE,  CLIENT_NAME, CORP_CODE, CIS_ID, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CLIENT_CODE,  CLIENT_NAME, CORP_CODE, CIS_ID, ACTIVE_STATUS, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ?, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.CLIENT_TMP);
			sql.append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, clientMst.getAuthorizeStatus());
	            	ps.setString(2, clientMst.getOperationFlag());
	            	ps.setString(3, clientMst.getAuthorizedBy());
	            	ps.setString(4, clientMst.getClientCode());
	            }
	        });	
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	

	@Override
	public ClientMst getClientByClientCodeTmp(String clientCode){
		ClientMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.CLIENT_TMP);
			sql.append(" WHERE CLIENT_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { clientCode }, new ClientRowMapper());
		}catch (EmptyResultDataAccessException e) {
        	logger.error(e);
        }
		return result;
	}
	
	@Override
	public ClientMst getClientByClientMst(String clientCode){
		ClientMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CLIENT_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { clientCode }, new ClientRowMapper());
		}catch (EmptyResultDataAccessException e) {
        	logger.error(e);
        }
		return result;
	}
	
	@Override
	public void updateClientTmpToClientMst(ClientMst clientMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CLIENT_MST);
	    	sql.append(" SET CLIENT_NAME = ?, CIS_ID = ?");
	    	sql.append(", AUTHORIZE_STATUS = ?, AUTHORIZED_BY = ?, AUTHORIZED_DATE = SYSDATE(), ACTIVE_STATUS = ?, OPERATION_FLAG = ? ");
	    	//sql.append(", CREATED_DATE = ?, CREATED_BY = ?, LAST_UPDATED_DATE = ?, LAST_UPDATED_BY = ?"); // comment create date,by veerayoot after unit test
	    	sql.append(", LAST_UPDATED_DATE = SYSDATE() , LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CLIENT_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, clientMst.getClientName());
	                ps.setString(2, clientMst.getCisId());
	                ps.setString(3, clientMst.getAuthorizeStatus());
	                ps.setString(4, clientMst.getAuthorizedBy());
	                ps.setString(5, clientMst.getActiveStatus());
	                ps.setString(6, clientMst.getOperationFlag());
	                ps.setString(7, clientMst.getLastUpdatedBy());
	                ps.setString(8, clientMst.getClientCode());
	            }
	        });
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CLIENT_TMP).append(" WHERE CLIENT_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { clientMst.getClientCode() });
	    	transactionManager.commit(status);
    	}catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
        }
	}
	
	@Override
	public void updateAutorizeStatus(ClientMst clientMst){
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE ").append(DBConstants.CLIENT_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE CLIENT_CODE = ?");
				jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, clientMst.getAuthorizeStatus());
	            	ps.setString(2, clientMst.getAuthorizedBy());
	            	ps.setString(3, clientMst.getRejectReason());
	            	ps.setString(4, clientMst.getClientCode());
	            }
	        });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
	}
	
	@Override
	public int countClientMst() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.CLIENT_MST);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}

	@Override
	public int countClientTmp() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.CLIENT_TMP);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public void deleteAllClientTmp() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.CLIENT_TMP);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public void deleteAllClientMst() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.CLIENT_MST);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public String getCisByClientCode(String clientCode) {
		String result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CIS_ID FROM ");
			sql.append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CLIENT_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { clientCode }, String.class);
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return result;
	}
	
}
