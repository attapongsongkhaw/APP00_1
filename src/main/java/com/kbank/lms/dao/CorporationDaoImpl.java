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
import com.kbank.lms.mapper.CorporationRowMapper;
import com.kbank.lms.model.AccountMst;
import com.kbank.lms.model.CorporationMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("corporationDao")
public class CorporationDaoImpl implements CorporationDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(CorporationDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
    
	@Override
	public void insertCorporationMst(CorporationMst corporationMst) {
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.CORPORATION_MST);
	    	sql.append(" (CORP_CODE, CORP_NAME, CIS_ID");
	    	sql.append(", TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT");
	    	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE ");
	    	sql.append(", CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY ");
	    	sql.append(", UMM_COMPANY_STATUS ,UMM_SERVICE_STATUS, UMM_SYNC_DATE ) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?,SYSDATE(),? ,? , ? , ? )");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getCorpCode());
	                ps.setString(2, corporationMst.getCorpName());
	                ps.setString(3, corporationMst.getCisId());
	                ps.setString(4, corporationMst.getTaxpayerNo());
	                ps.setString(5, corporationMst.getTaxpayerName());
	                ps.setString(6, corporationMst.getChargeFlag());
	                ps.setString(7, corporationMst.getChargeAccount());
	                ps.setString(8, corporationMst.getChargeType());
	                ps.setString(9, corporationMst.getChargeFreq());
	                ps.setString(10, corporationMst.getChargeDate());
	                ps.setBigDecimal(11, corporationMst.getChargeAmount());
	                ps.setString(12, corporationMst.getAuthorizeStatus());
	                ps.setString(13, corporationMst.getActiveStatus());
	                ps.setString(14, corporationMst.getOperationFlag());
	                ps.setString(15, corporationMst.getCreatedBy());
	                ps.setString(16, corporationMst.getAuthorizedBy());
	                ps.setString(17, corporationMst.getLastUpdatedBy());
	                /** UMM set value ***/
	                ps.setString(18, corporationMst.getUmmCompanyStatus());
	                ps.setString(19, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(20, corporationMst.getUmmSyncDate());
	            }
	        });
    	}catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
	}

	@Override
	public int checkCorpDuplicate(String corpCode) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT COUNT(0) FROM(");
			sql.append(" SELECT CORP_CODE FROM ");
			sql.append(DBConstants.CORPORATION_MST).append(" WHERE ACTIVE_STATUS = 'Y' ");
			sql.append(" UNION ");
			sql.append(" SELECT CORP_CODE FROM ");
			sql.append(DBConstants.CORPORATION_TMP).append(" WHERE ACTIVE_STATUS = 'Y' ");
			sql.append(")a WHERE CORP_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { corpCode }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public List<CorporationMst> searchCorporation(SearchDataTable<CorporationMst> searchDataTable) {
		List<CorporationMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
				orderColumns = new String[]{"a.LAST_UPDATED_DATE", "a.CORP_CODE", "a.CORP_NAME", "ACCOUNT_SA", "ACCOUNT_CA", "a.AUTHORIZE_STATUS"};
			}else{
				orderColumns = new String[]{"a.CORP_CODE", "a.CORP_CODE", "a.CORP_NAME", "ACCOUNT_SA", "ACCOUNT_CA", "a.AUTHORIZE_STATUS"};
			}
			if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
				sql.append("SELECT a.CORP_CODE, a.CORP_NAME, a.AUTHORIZE_STATUS, ");
				sql.append("(SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE a.CORP_CODE = CORP_CODE AND ACCOUNT_LEVEL = '01') ACCOUNT_SA, ");
				sql.append("(SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE a.CORP_CODE = CORP_CODE AND ACCOUNT_LEVEL = '02') ACCOUNT_CA, ");
				sql.append("a.OPERATION_FLAG, '' VISIT_PATH_FLAG FROM ");
				sql.append(DBConstants.CORPORATION_TMP).append(" a ");
			}else if(searchDataTable.getTableType().equals(Constants.CORPTABLEMST)){
				sql.append("SELECT a.CORP_CODE, a.CORP_NAME, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.AUTHORIZE_STATUS ELSE a.AUTHORIZE_STATUS END) AUTHORIZE_STATUS, ");
				sql.append("(SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE a.CORP_CODE = CORP_CODE AND ACCOUNT_LEVEL = '01') ACCOUNT_SA, ");
				sql.append("(SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE a.CORP_CODE = CORP_CODE AND ACCOUNT_LEVEL = '02') ACCOUNT_CA, ");
				sql.append("(CASE WHEN b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' || b.OPERATION_FLAG = 'D') THEN b.OPERATION_FLAG ELSE a.OPERATION_FLAG END) OPERATION_FLAG, ");
				sql.append("(CASE WHEN vi.CORP_CODE = '' || vi.CORP_CODE IS NULL THEN 'N' ELSE 'Y' END) VISIT_PATH_FLAG ");
				sql.append("FROM ");
				sql.append(DBConstants.CORPORATION_MST).append(" a LEFT JOIN ").append(DBConstants.CORPORATION_TMP).append(" b ");
				sql.append("ON b.AUTHORIZE_STATUS = 'W' AND (b.OPERATION_FLAG = 'E' OR b.OPERATION_FLAG = 'D') AND a.CORP_CODE = b.CORP_CODE ");
				sql.append("LEFT JOIN (SELECT CORP_CODE FROM (SELECT CORP_CODE FROM (SELECT MEMBER_ACCOUNT_ID FROM ").append(DBConstants.VISIT_PATH_MST).append(" GROUP BY MEMBER_ACCOUNT_ID) v INNER JOIN ");
				sql.append(DBConstants.ACCOUNT_MST).append(" ON ACCOUNT_ID = v.MEMBER_ACCOUNT_ID) s GROUP BY CORP_CODE) vi ON vi.CORP_CODE = a.CORP_CODE");
			}
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				where.add(" a.CORP_CODE LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpName())){
				where.add(" a.CORP_NAME LIKE ?");
			}
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())){
				where.add(" a.AUTHORIZE_STATUS = ?");
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
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpName())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getCorpName() + "%");
		                }
		                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
		                }
		            }
		        }, new RowMapper<CorporationMst>() {
				 
					@Override
					public CorporationMst mapRow(ResultSet rs, int numRow) throws SQLException {
						CorporationMst corp = new CorporationMst();
						corp.setCorpCode(rs.getString("CORP_CODE"));
						corp.setCorpName(rs.getString("CORP_NAME"));
						corp.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						corp.setOperationFlag(rs.getString("OPERATION_FLAG"));
						corp.setAccountSA(rs.getString("ACCOUNT_SA"));
						corp.setAccountCA(rs.getString("ACCOUNT_CA"));
						corp.setVisitPathFlag(rs.getString("VISIT_PATH_FLAG"));
						return corp;
					}
			 
			    });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results;
	}

	@Override
	public int countCorporationFilter(SearchDataTable<CorporationMst> searchDataTable) {
		List<CorporationMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {
		sql.append("SELECT CORP_CODE FROM ");
		if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
			sql.append(DBConstants.CORPORATION_TMP);
		}else if(searchDataTable.getTableType().equals(Constants.CORPTABLEMST)){
			sql.append(DBConstants.CORPORATION_MST);
		}
		where.add(" ACTIVE_STATUS = 'Y'");
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
			where.add(" CORP_CODE LIKE ?");
		}
		if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpName())){
			where.add(" CORP_NAME LIKE ?");
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
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpName())) {
	                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getCorpName() + "%");
	                }
	                if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getAuthorizeStatus())) {
	                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getAuthorizeStatus());
	                }
	            }
	        }, new RowMapper<CorporationMst>() {
				 
					@Override
					public CorporationMst mapRow(ResultSet rs, int numRow) throws SQLException {
						CorporationMst corp = new CorporationMst();
						corp.setCorpCode(rs.getString("CORP_CODE"));
						return corp;
					}
			 
			    });
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return results.size();
	}
	
	@Override
	public int countCorporationTotal(SearchDataTable<CorporationMst> searchDataTable) {
		StringBuilder sql = new StringBuilder();
		int result = 0;
		try {
			sql.append("SELECT COUNT(0) FROM ");
			if(searchDataTable.getTableType().equals(Constants.CORPTABLETMP)){
				sql.append(DBConstants.CORPORATION_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.CORPTABLEMST)){
				sql.append(DBConstants.CORPORATION_MST);
			}
			sql.append(" WHERE ACTIVE_STATUS = 'Y' AND CASE WHEN (? = '' || ? IS NULL) THEN 1 = 1 ELSE AUTHORIZE_STATUS = ? END");
			result = jdbcTemplate.queryForObject(sql.toString(), new Object[] { 
			searchDataTable.getDataSearch().getAuthorizeStatus(),
			searchDataTable.getDataSearch().getAuthorizeStatus(),
			searchDataTable.getDataSearch().getAuthorizeStatus() }, Integer.class);
		} catch (Exception e) {
    		logger.error(e);
    		throw e;
        }
		return result;
	}

	@Override
	public CorporationMst getCorporationTmpByCorpCode(String corpCode) {
		CorporationMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.CORPORATION_TMP);
			sql.append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode }, new CorporationRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(">> getCorporationTmpByCorpCode ERROR :"+ ex);
		}
		return result;
	}
	
	@Override
	public CorporationMst getCorporationMstByCorpCode(String corpCode) {
		CorporationMst result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode }, new CorporationRowMapper());
		} catch(EmptyResultDataAccessException  ex){
			logger.error(">> getCorporationMstByCorpCode ERROR :"+ ex);
		}
		return result;
	}

	@Override
	public void insertCorporationTmp(CorporationMst corporationMst) {
		try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.CORPORATION_TMP);
	    	sql.append(" (CORP_CODE, CORP_NAME, CIS_ID");
	    	sql.append(", TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT");
	    	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY ");
	    	sql.append(", UMM_COMPANY_STATUS ,UMM_SERVICE_STATUS, UMM_SYNC_DATE ) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),? , ? , ? , ? )");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getCorpCode());
	                ps.setString(2, corporationMst.getCorpName());
	                ps.setString(3, corporationMst.getCisId());
	                ps.setString(4, corporationMst.getTaxpayerNo());
	                ps.setString(5, corporationMst.getTaxpayerName());
	                ps.setString(6, corporationMst.getChargeFlag());
	                ps.setString(7, corporationMst.getChargeAccount());
	                ps.setString(8, corporationMst.getChargeType());
	                ps.setString(9, corporationMst.getChargeFreq());
	                ps.setString(10, corporationMst.getChargeDate());
	                ps.setBigDecimal(11, corporationMst.getChargeAmount());
	                ps.setString(12, corporationMst.getAuthorizeStatus());
	                ps.setString(13, corporationMst.getActiveStatus());
	                ps.setString(14, corporationMst.getOperationFlag());
	                ps.setString(15, corporationMst.getCreatedBy());
	                ps.setString(16, corporationMst.getLastUpdatedBy());
	                /** UMM set value ***/
	                ps.setString(17, corporationMst.getUmmCompanyStatus());
	                ps.setString(18, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(19, corporationMst.getUmmSyncDate());
	            }
	        });
    	}catch (Exception e) {
        	logger.error(" >> insertCorporationTmp Error !!! : "+e);
        	throw e;
        }
	}
	
	@Override
	@Transactional
	public void insertCorporationTmpWithAccount(CorporationMst corporationMst, AccountMst savingAccountMst, AccountMst currentAccountMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
    	try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.CORPORATION_TMP);
	    	sql.append(" (CORP_CODE, CORP_NAME, CIS_ID");
	    	sql.append(", TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT");
	    	sql.append(", AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getCorpCode());
	                ps.setString(2, corporationMst.getCorpName());
	                ps.setString(3, corporationMst.getCisId());
	                ps.setString(4, corporationMst.getTaxpayerNo());
	                ps.setString(5, corporationMst.getTaxpayerName());
	                ps.setString(6, corporationMst.getChargeFlag());
	                ps.setString(7, corporationMst.getChargeAccount());
	                ps.setString(8, corporationMst.getChargeType());
	                ps.setString(9, corporationMst.getChargeFreq());
	                ps.setString(10, corporationMst.getChargeDate());
	                ps.setBigDecimal(11, corporationMst.getChargeAmount());
	                ps.setString(12, corporationMst.getAuthorizeStatus());
	                ps.setString(13, corporationMst.getActiveStatus());
	                ps.setString(14, corporationMst.getOperationFlag());
	                ps.setString(15, corporationMst.getCreatedBy());
	                ps.setString(16, corporationMst.getLastUpdatedBy());
	            }
	        });
	    	sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.ACCOUNT_TMP);
	    	sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ");
	    	sql.append(" AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, savingAccountMst.getAccountNo());
	                ps.setString(2, savingAccountMst.getAccountNameTh());
	                ps.setString(3, savingAccountMst.getAccountNameEn());
	                ps.setString(4, savingAccountMst.getKbankProductCode());
	                ps.setString(5, savingAccountMst.getCisId());
	                ps.setString(6, savingAccountMst.getAccountLevel());
	                ps.setString(7, savingAccountMst.getCorpCode());
	                ps.setString(8, savingAccountMst.getClientCode());
	                ps.setString(9, savingAccountMst.getAuthorizeStatus());
	                ps.setString(10, savingAccountMst.getActiveStatus());
	                ps.setString(11, savingAccountMst.getOperationFlag());
	                ps.setString(12, savingAccountMst.getCreatedBy());
	                ps.setString(13, savingAccountMst.getLastUpdatedBy());
	            }
	        });
	    	sql = new StringBuilder();
	    	sql.append("INSERT INTO ");
	    	sql.append(DBConstants.ACCOUNT_TMP);
	    	sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ");
	    	sql.append(" AUTHORIZE_STATUS, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) VALUES ");
	    	sql.append("(?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, currentAccountMst.getAccountNo());
	                ps.setString(2, currentAccountMst.getAccountNameTh());
	                ps.setString(3, currentAccountMst.getAccountNameEn());
	                ps.setString(4, currentAccountMst.getKbankProductCode());
	                ps.setString(5, currentAccountMst.getCisId());
	                ps.setString(6, currentAccountMst.getAccountLevel());
	                ps.setString(7, currentAccountMst.getCorpCode());
	                ps.setString(8, currentAccountMst.getClientCode());
	                ps.setString(9, currentAccountMst.getAuthorizeStatus());
	                ps.setString(10, currentAccountMst.getActiveStatus());
	                ps.setString(11, currentAccountMst.getOperationFlag());
	                ps.setString(12, currentAccountMst.getCreatedBy());
	                ps.setString(13, currentAccountMst.getLastUpdatedBy());
	            }
	        });
	    	transactionManager.commit(status);
    	}catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(" >>> insertCorporationTmpWithAccount Error !!! :"+e);
        	throw e;
        }
	}

	@Override
	@Transactional
	public void copyToCorporationMst(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CORPORATION_MST).append(" (CORP_CODE, CORP_NAME, CIS_ID, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CORP_CODE, CORP_NAME, CIS_ID, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ACTIVE_STATUS, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ?, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.CORPORATION_TMP);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getOperationFlag());
	            	ps.setString(3, corporationMst.getAuthorizedBy());
	            	ps.setString(4, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_MST).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ?, SYSDATE(), ?, ACTIVE_STATUS, ?, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ");
			sql.append(DBConstants.ACCOUNT_TMP);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getAuthorizedBy());
	            	ps.setString(3, corporationMst.getOperationFlag());
	            	ps.setString(4, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_TMP).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corporationMst.getCorpCode() });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new Object[] { corporationMst.getCorpCode() });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}

	@Override
	@Transactional
	public void copyToCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CORPORATION_TMP).append(" (CORP_CODE, CORP_NAME, CIS_ID, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CORP_CODE, ?, ?, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ?, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getCorpName());
	            	ps.setString(2, corporationMst.getCisId());
	            	ps.setString(3, corporationMst.getActiveStatus());
	            	ps.setString(4, corporationMst.getAuthorizeStatus());
	            	ps.setString(5, corporationMst.getOperationFlag());
	            	ps.setString(6, corporationMst.getLastUpdatedBy());
	            	ps.setString(7, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ?, ?, ?, ?, ?, ACCOUNT_LEVEL, ?, ?, ?, AUTHORIZED_DATE, AUTHORIZED_BY, ?, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL = '01'");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, savingAccount.getAccountNo());
	            	ps.setString(2, savingAccount.getAccountNameTh());
	            	ps.setString(3, savingAccount.getAccountNameEn());
	            	ps.setString(4, savingAccount.getKbankProductCode());
	            	ps.setString(5, savingAccount.getCisId());
	            	ps.setString(6, savingAccount.getCorpCode());
	            	ps.setString(7, savingAccount.getClientCode());
	            	ps.setString(8, savingAccount.getAuthorizeStatus());
	            	ps.setString(9, savingAccount.getActiveStatus());
	            	ps.setString(10, savingAccount.getOperationFlag());
	            	ps.setString(11, savingAccount.getLastUpdatedBy());
	            	ps.setString(12, savingAccount.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ?, ?, ?, ?, ?, ACCOUNT_LEVEL, ?, ?, ?, AUTHORIZED_DATE, AUTHORIZED_BY, ?, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL = '02'");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, currentAccount.getAccountNo());
	            	ps.setString(2, currentAccount.getAccountNameTh());
	            	ps.setString(3, currentAccount.getAccountNameEn());
	            	ps.setString(4, currentAccount.getKbankProductCode());
	            	ps.setString(5, currentAccount.getCisId());
	            	ps.setString(6, currentAccount.getCorpCode());
	            	ps.setString(7, currentAccount.getClientCode());
	            	ps.setString(8, currentAccount.getAuthorizeStatus());
	            	ps.setString(9, currentAccount.getActiveStatus());
	            	ps.setString(10, currentAccount.getOperationFlag());
	            	ps.setString(11, currentAccount.getLastUpdatedBy());
	            	ps.setString(12, currentAccount.getCorpCode());
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
	@Transactional
	public void copyToCorporationTmpDelete(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
    		StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.CORPORATION_TMP).append(" (CORP_CODE, CORP_NAME, CIS_ID, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ACTIVE_STATUS, AUTHORIZE_STATUS, REJECT_REASON, OPERATION_FLAG, CREATED_DATE, CREATED_BY, AUTHORIZED_DATE, AUTHORIZED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY)");
			sql.append(" SELECT CORP_CODE, CORP_NAME, CIS_ID, TAXPAYER_NO, TAXPAYER_NAME, CHARGE_FLAG, CHARGE_ACCOUNT, CHARGE_TYPE, CHARGE_FREQ, CHARGE_DATE, CHARGE_AMOUNT, ACTIVE_STATUS, ?, NULL, ?, CREATED_DATE, CREATED_BY, SYSDATE(), AUTHORIZED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getOperationFlag());
	            	ps.setString(3, corporationMst.getLastUpdatedBy());
	            	ps.setString(4, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP).append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, AUTHORIZE_STATUS, AUTHORIZED_DATE, AUTHORIZED_BY, ACTIVE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
			sql.append(" SELECT ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, CIS_ID, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, ?, SYSDATE(), AUTHORIZED_BY, ACTIVE_STATUS, ?, CREATED_DATE, CREATED_BY, SYSDATE(), ? FROM ");
			sql.append(DBConstants.ACCOUNT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getOperationFlag());
	            	ps.setString(3, corporationMst.getLastUpdatedBy());
	            	ps.setString(4, corporationMst.getCorpCode());
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
	@Transactional
	public void updateAutorizeStatus(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE ").append(DBConstants.CORPORATION_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getAuthorizedBy());
	            	ps.setString(3, corporationMst.getRejectReason());
	            	ps.setString(4, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("UPDATE ").append(DBConstants.ACCOUNT_TMP).append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_DATE = SYSDATE(), AUTHORIZED_BY = ?, REJECT_REASON = ?");
			sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getAuthorizeStatus());
	            	ps.setString(2, corporationMst.getAuthorizedBy());
	            	ps.setString(3, corporationMst.getRejectReason());
	            	ps.setString(4, corporationMst.getCorpCode());
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
	@Transactional
	public void updateCorporationTmp(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount) {
		StringBuilder sql = new StringBuilder();
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
			sql.append("UPDATE ").append(DBConstants.CORPORATION_TMP);
			sql.append(" SET CORP_NAME = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getCorpName());
	            	ps.setString(2, corporationMst.getCisId());
	            	ps.setString(3, corporationMst.getActiveStatus());
	            	ps.setString(4, corporationMst.getAuthorizeStatus());
	            	ps.setString(5, corporationMst.getOperationFlag());
	            	ps.setString(6, corporationMst.getLastUpdatedBy());
	            	ps.setString(7, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("UPDATE ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" SET ACCOUNT_NO = ?, ACCOUNT_NAME_TH = ?, ACCOUNT_NAME_EN = ?, KBANK_PRODUCT_CODE = ?, CORP_CODE = ?, CLIENT_CODE = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('01')");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, savingAccount.getAccountNo());
	            	ps.setString(2, savingAccount.getAccountNameTh());
	            	ps.setString(3, savingAccount.getAccountNameEn());
	            	ps.setString(4, savingAccount.getKbankProductCode());
	            	ps.setString(5, savingAccount.getCorpCode());
	            	ps.setString(6, savingAccount.getClientCode());
	            	ps.setString(7, savingAccount.getCisId());
	            	ps.setString(8, savingAccount.getActiveStatus());
	            	ps.setString(9, savingAccount.getAuthorizeStatus());
	            	ps.setString(10, savingAccount.getOperationFlag());
	            	ps.setString(11, savingAccount.getLastUpdatedBy());
	            	ps.setString(12, savingAccount.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("UPDATE ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" SET ACCOUNT_NO = ?, ACCOUNT_NAME_TH = ?, ACCOUNT_NAME_EN = ?, KBANK_PRODUCT_CODE = ?, CORP_CODE = ?, CLIENT_CODE = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('02')");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, currentAccount.getAccountNo());
	            	ps.setString(2, currentAccount.getAccountNameTh());
	            	ps.setString(3, currentAccount.getAccountNameEn());
	            	ps.setString(4, currentAccount.getKbankProductCode());
	            	ps.setString(5, currentAccount.getCorpCode());
	            	ps.setString(6, currentAccount.getClientCode());
	            	ps.setString(7, currentAccount.getCisId());
	            	ps.setString(8, currentAccount.getActiveStatus());
	            	ps.setString(9, currentAccount.getAuthorizeStatus());
	            	ps.setString(10, currentAccount.getOperationFlag());
	            	ps.setString(11, currentAccount.getLastUpdatedBy());
	            	ps.setString(12, currentAccount.getCorpCode());
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
	@Transactional
	public void updateCorporationTmpForDraft(CorporationMst corporationMst, AccountMst savingAccount, AccountMst currentAccount) {
		StringBuilder sql = new StringBuilder();
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
			sql.append("UPDATE ").append(DBConstants.CORPORATION_TMP);
			sql.append(" SET CORP_NAME = ?, CIS_ID = ?, ACTIVE_STATUS = ?, AUTHORIZE_STATUS = ?, OPERATION_FLAG = ?, LAST_UPDATED_DATE = SYSDATE(), LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, corporationMst.getCorpName());
	            	ps.setString(2, corporationMst.getCisId());
	            	ps.setString(3, corporationMst.getActiveStatus());
	            	ps.setString(4, corporationMst.getAuthorizeStatus());
	            	ps.setString(5, corporationMst.getOperationFlag());
	            	ps.setString(6, corporationMst.getLastUpdatedBy());
	            	ps.setString(7, corporationMst.getCorpCode());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, CIS_ID, ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
	    	sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, savingAccount.getAccountNo());
	            	ps.setString(2, savingAccount.getAccountNameTh());
	            	ps.setString(3, savingAccount.getAccountNameEn());
	            	ps.setString(4, savingAccount.getKbankProductCode());
	            	ps.setString(5, savingAccount.getAccountLevel());
	            	ps.setString(6, savingAccount.getCorpCode());
	            	ps.setString(7, savingAccount.getClientCode());
	            	ps.setString(8, savingAccount.getCisId());
	            	ps.setString(9, savingAccount.getActiveStatus());
	            	ps.setString(10, savingAccount.getAuthorizeStatus());
	            	ps.setString(11, savingAccount.getOperationFlag());
	            	ps.setString(12, savingAccount.getCreatedBy());
	            	ps.setString(13, savingAccount.getLastUpdatedBy());
	            }
	        });
			sql = new StringBuilder();
			sql.append("INSERT INTO ").append(DBConstants.ACCOUNT_TMP);
			sql.append(" (ACCOUNT_NO, ACCOUNT_NAME_TH, ACCOUNT_NAME_EN, KBANK_PRODUCT_CODE, ACCOUNT_LEVEL, CORP_CODE, CLIENT_CODE, CIS_ID, ACTIVE_STATUS, AUTHORIZE_STATUS, OPERATION_FLAG, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY) ");
	    	sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),?,SYSDATE(),?)");
			jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	            	ps.setString(1, currentAccount.getAccountNo());
	            	ps.setString(2, currentAccount.getAccountNameTh());
	            	ps.setString(3, currentAccount.getAccountNameEn());
	            	ps.setString(4, currentAccount.getKbankProductCode());
	            	ps.setString(5, currentAccount.getAccountLevel());
	            	ps.setString(6, currentAccount.getCorpCode());
	            	ps.setString(7, currentAccount.getClientCode());
	            	ps.setString(8, currentAccount.getCisId());
	            	ps.setString(9, currentAccount.getActiveStatus());
	            	ps.setString(10, currentAccount.getAuthorizeStatus());
	            	ps.setString(11, currentAccount.getOperationFlag());
	            	ps.setString(12, currentAccount.getCreatedBy());
	            	ps.setString(13, currentAccount.getLastUpdatedBy());
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
	@Transactional
	public void deleteCorporationMstCorpCode(String corpCode) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
    	try{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_MST).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}

	@Override
	@Transactional
	public void deleteCorporationTmpCorpCode(String corpCode) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN ('01','02')");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
			sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_TMP).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corpCode });
			transactionManager.commit(status);
		}catch (Exception e) {
	    	transactionManager.rollback(status);
	    	logger.error(e);
	    	throw e;
	    }
	}

	@Override
	@Transactional
	public void updateTmpToCorporationMst(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CORPORATION_MST);
	    	sql.append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_BY = ?, AUTHORIZED_DATE = SYSDATE(), OPERATION_FLAG = ?, LAST_UPDATED_DATE = ?, LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getAuthorizeStatus());
	                ps.setString(2, corporationMst.getAuthorizedBy());
	                ps.setString(3, corporationMst.getOperationFlag());
	                ps.setDate(4, new java.sql.Date(corporationMst.getLastUpdatedDate().getTime()));
	                ps.setString(5, corporationMst.getLastUpdatedBy());
	                ps.setString(6, corporationMst.getCorpCode());
	            }
	        });
	    	sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.ACCOUNT_MST);
	    	sql.append(" SET AUTHORIZE_STATUS = ?, AUTHORIZED_BY = ?, AUTHORIZED_DATE = SYSDATE(), OPERATION_FLAG = ?, LAST_UPDATED_DATE = ?, LAST_UPDATED_BY = ?");
	    	sql.append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('01','02')");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	               ps.setString(1, corporationMst.getAuthorizeStatus());
	                ps.setString(2, corporationMst.getAuthorizedBy());
	                ps.setString(3, corporationMst.getOperationFlag());
	                ps.setDate(4, new java.sql.Date(corporationMst.getLastUpdatedDate().getTime()));
	                ps.setString(5, corporationMst.getLastUpdatedBy());
	                ps.setString(6, corporationMst.getCorpCode());
	            }
	        });
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.ACCOUNT_TMP).append(" WHERE CORP_CODE = ? AND ACCOUNT_LEVEL IN('01','02')");
			jdbcTemplate.update(sql.toString(), new Object[] { corporationMst.getCorpCode() });
	    	sql = new StringBuilder();
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_TMP).append(" WHERE CORP_CODE = ?");
			jdbcTemplate.update(sql.toString(), new Object[] { corporationMst.getCorpCode() });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(e);
        	throw e;
        }
	}

	@Override
	public void updateCorporationInformationWithUMMProfile(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CORPORATION_TMP);
	    	sql.append(" SET  CORP_NAME = ? ");
	    	sql.append("      , LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append("      , LAST_UPDATED_BY  = ? ");
	    	sql.append("      , UMM_COMPANY_STATUS  = ? ");
	    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
	    	sql.append("      , UMM_SYNC_DATE  = ? "); 
	    	sql.append(" WHERE CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getCorpName());
	                ps.setString(2, corporationMst.getLastUpdatedBy());
	                ps.setString(3, corporationMst.getUmmCompanyStatus());
	                ps.setString(4, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(5, corporationMst.getUmmSyncDate());
	                ps.setString(6, corporationMst.getCorpCode());
	            }
	        });

	        sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CORPORATION_MST);
	    	sql.append(" SET  CORP_NAME = ? ");
	    	sql.append("      , LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append("      , LAST_UPDATED_BY  = ? ");
	    	sql.append("      , UMM_COMPANY_STATUS  = ? ");
	    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
	    	sql.append("      , UMM_SYNC_DATE  = ? "); 
	    	sql.append(" WHERE CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getCorpName());
	                ps.setString(2, corporationMst.getLastUpdatedBy());
	                ps.setString(3, corporationMst.getUmmCompanyStatus());
	                ps.setString(4, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(5, corporationMst.getUmmSyncDate());
	                ps.setString(6, corporationMst.getCorpCode());
	            }
	        });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(" >>> updateCorporationInformationWithUMMProfile Error !!! : "+e);
        	throw e;
        }
		
	}
	
	@Override
	public void updateCorporationUMMStatusOnlyWithUMMProfile(CorporationMst corporationMst) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
        try{
	        StringBuilder sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CORPORATION_TMP);
	    	sql.append(" SET   ");
	    	sql.append("     LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append("      , LAST_UPDATED_BY  = ? ");
	    	sql.append("      , UMM_COMPANY_STATUS  = ? ");
	    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
	    	sql.append("      , UMM_SYNC_DATE  = ? "); 
	    	sql.append(" WHERE CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getLastUpdatedBy());
	                ps.setString(2, corporationMst.getUmmCompanyStatus());
	                ps.setString(3, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(4, corporationMst.getUmmSyncDate());
	                ps.setString(5, corporationMst.getCorpCode());
	            }
	        });

	        sql = new StringBuilder();
	    	sql.append("UPDATE ");
	    	sql.append(DBConstants.CORPORATION_MST);
	    	sql.append(" SET  ");
	    	sql.append("    LAST_UPDATED_DATE  = SYSDATE() ");
	    	sql.append("      , LAST_UPDATED_BY  = ? ");
	    	sql.append("      , UMM_COMPANY_STATUS  = ? ");
	    	sql.append("      , UMM_SERVICE_STATUS  = ? ");
	    	sql.append("      , UMM_SYNC_DATE  = ? "); 
	    	sql.append(" WHERE CORP_CODE = ?");
	    	jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, corporationMst.getLastUpdatedBy());
	                ps.setString(2, corporationMst.getUmmCompanyStatus());
	                ps.setString(3, corporationMst.getUmmServiceStatus());
	                ps.setTimestamp(4, corporationMst.getUmmSyncDate());
	                ps.setString(5, corporationMst.getCorpCode());
	            }
	        });
	    	transactionManager.commit(status);
	    }catch (Exception e) {
        	transactionManager.rollback(status);
        	logger.error(" >> updateCorporationUMMStatusOnlyWithUMMProfile Error !!! :" + e);
        	throw e;
        }
	}

	@Override
	public int countCorporationMst() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}

	@Override
	public int countCorporationTmp() {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM ");
			sql.append(DBConstants.CORPORATION_TMP);
			sql.append(" WHERE ACTIVE_STATUS = 'Y'");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
	
	@Override
	public void deleteAllCorporationTmp() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_TMP);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}

	@Override
	public void deleteAllCorporationMst() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM ").append(DBConstants.CORPORATION_MST);
			jdbcTemplate.execute(sql.toString());	
		} catch (Exception e){
			logger.error(e);
        	throw e;        
		}
	}
	
	@Override
	public int checkClientInCorporation(String corpCode) {
		int result = 0;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(0) FROM (SELECT CLIENT_CODE FROM ").append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y' UNION SELECT CLIENT_CODE FROM ");
			sql.append(DBConstants.CLIENT_TMP).append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y') a ");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { corpCode, corpCode }, Integer.class);
		} catch(Exception  ex){
			logger.error(ex);
    		throw ex;
		}
		return result;
	}
}
