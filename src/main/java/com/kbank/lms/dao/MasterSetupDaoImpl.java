package com.kbank.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kbank.lms.dao.MasterSetupDao;
import com.kbank.lms.model.FuncMaster;
import com.kbank.lms.utils.DBConstants;


@Repository("masterSetupDao")
public class MasterSetupDaoImpl implements MasterSetupDao {

	
	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(MasterSetupDaoImpl.class);
	
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
	
	@Override
	public List<Map<String, Object>> getCorporationForDropdown() {
		List<Map<String, Object>> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT CORP_CODE CODE, CORP_NAME DESCIPTION FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			sql.append(" WHERE ACTIVE_STATUS = 'Y' AND AUTHORIZE_STATUS = 'Y' ORDER BY CORP_NAME ASC");
			result = jdbcTemplate.queryForList(sql.toString());
		} catch(Exception e){
			logger.error(e);
			throw e;
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getCorporationFuncForDropdown(String corpCode) {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT CORP_CODE CODE, CORP_NAME DESCIPTION FROM ");
			sql.append(DBConstants.CORPORATION_MST);
			sql.append(" WHERE ACTIVE_STATUS = 'Y' AND AUTHORIZE_STATUS = 'Y' ");
			sql.append(" AND CORP_CODE NOT IN (SELECT CORP_CODE FROM CORP_FUNC_MST) ");
			sql.append(" AND CORP_CODE NOT IN (SELECT CORP_CODE FROM CORP_FUNC_TMP) ");
			sql.append(" OR CORP_CODE = ? ");
			sql.append(" ORDER BY CORP_NAME ASC");
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] {corpCode});
		} catch(Exception e){
			logger.error(e);
			throw e;
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getFuncMasterForDropdown() {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT FUNC_CODE CODE, FUNC_NAME NAME FROM ");
			sql.append(DBConstants.FUNCTION_MASTER);
			sql.append(" WHERE ACTIVE_STATUS = 'Y' AND AUTHORIZE_STATUS = 'Y' ");
			sql.append(" ORDER BY FUNC_CODE ASC");
			result = jdbcTemplate.queryForList(sql.toString());
		} catch(Exception e){
			logger.error(e);
			throw e;
		}
		return result;
	}
	
	@Override
	public FuncMaster getFuncMasterById(String funcCode) {
		FuncMaster result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ");
			sql.append(DBConstants.FUNCTION_MASTER);
			sql.append(" WHERE FUNC_CODE = ?");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { funcCode }, new RowMapper<FuncMaster>() {
					@Override
					public FuncMaster mapRow(ResultSet rs, int numRow) throws SQLException {
						FuncMaster func = new FuncMaster();
						func.setFuncCode(rs.getString("FUNC_CODE"));
						func.setFuncName(rs.getString("FUNC_NAME"));
						func.setAllowVip(rs.getString("ALLOW_VIP"));
						func.setAllowOvernightFlag(rs.getString("ALLOW_OVERNIGHT"));
						func.setAllowExecDaily(rs.getString("ALLOW_EXEC_DAILY"));
						func.setAllowExecDayOfWeek(rs.getString("ALLOW_EXEC_DAY_OF_WEEK"));
						func.setAllowExecDayOfMonth(rs.getString("ALLOW_EXEC_DAY_OF_MONTH"));
						func.setDirection(rs.getString("ALLOW_DIRECTION"));
						func.setZeroBalance(rs.getString("ALLOW_ZERO_BAL"));
						func.setMinForUp(rs.getString("ALLOW_MIN_FOR_UP"));
						func.setMinForDown(rs.getString("ALLOW_MIN_FOR_DOWN"));
						func.setActiveStatus(rs.getString("ACTIVE_STATUS"));
						func.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
						func.setOperationFlag(rs.getString("OPERATION_FLAG"));
						return func;
					}
			 
			    });
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);
		}
		return result;
	}

	
	
	@Override
	public List<Map<String, Object>> getLookupForDropdown(String lookupType) {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT LOOKUP_DESCRIPTION DESCIPTION, LOOKUP_CODE CODE FROM ");
			sql.append(DBConstants.LOOKUP_MST);
			sql.append(" WHERE LOOKUP_TYPE = ? AND ACTIVE_STATUS = 'Y' ORDER BY LOOKUP_CODE ASC");
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { lookupType });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getClientFromCorpForDropdown(String corpCode) {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT CLIENT_CODE CODE, CLIENT_NAME DESCIPTION FROM ");
			sql.append(DBConstants.CLIENT_MST);
			sql.append(" WHERE CORP_CODE = ? AND ACTIVE_STATUS = 'Y' ORDER BY CLIENT_CODE ASC");
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { corpCode });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getMemberAccountForDropdown(String corpCode, String clientCode) {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" select account_id as CODE, account_no as DESCRIPTION from account_mst ");
			//sql.append(" where client_code = ? ");
			sql.append(" where account_level = '01'");
			sql.append(" and active_status = 'Y' ");
			sql.append(" and kbank_product_code = 'CA' ");
			sql.append(" and account_id not in (select member_account_id from instruction_mst) ");
			sql.append(" and account_id not in (select member_account_id from instruction_tmp) ");
			
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { clientCode });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getMasterAccountForDropdown(String corpCode, String clientCode) {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" select account_id as CODE, account_no as DESCRIPTION from account_mst ");
			sql.append(" where corp_code = ? ");
			//sql.append(" and client_code = ? ");
			sql.append(" and account_level = '01'");
			sql.append(" and active_status = 'Y' ");
			sql.append(" and kbank_product_code = 'CA' ");
			sql.append(" and (account_id in (select member_account_id from instruction_mst) or client_code is null) ");
			
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { corpCode, clientCode });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
	
	@Override
	public FuncMaster getEndingBalanceByDirection(String direction) {
		FuncMaster result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ALLOW_ZERO_BAL, ALLOW_MIN_FOR_UP, ALLOW_MIN_FOR_DOWN FROM ");
			sql.append(DBConstants.FUNCTION_MASTER);
			sql.append(" WHERE ALLOW_DIRECTION = ? LIMIT 1");
			result = jdbcTemplate.queryForObject(sql.toString(),  new Object[] { direction }, new RowMapper<FuncMaster>() {
					@Override
					public FuncMaster mapRow(ResultSet rs, int numRow) throws SQLException {
						FuncMaster func = new FuncMaster();
						func.setZeroBalance(rs.getString("ALLOW_ZERO_BAL"));
						func.setMinForUp(rs.getString("ALLOW_MIN_FOR_UP"));
						func.setMinForDown(rs.getString("ALLOW_MIN_FOR_DOWN"));
						return func;
					}
			 
			    });
		} catch(EmptyResultDataAccessException  ex){
			logger.error(ex);
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getSweepRateForDropDown(String corpCode){
		List<Map<String, Object>> result = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT INTEREST_RATE RATE FROM ");
			sql.append(DBConstants.INTEREST_MST);
			sql.append(" WHERE INTEREST_TYPE='SW' ");
			sql.append(" AND CORP_CODE = ?  ");
			/*sql.append(" AND START_DATE <= CURDATE() ");
			sql.append(" AND (END_DATE >= CURDATE() OR END_DATE IS NULL) ");*/
			sql.append(" AND  ACTIVE_STATUS = 'Y' ");
			sql.append(" ORDER BY INTEREST_RATE ");
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { corpCode });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getDeficitRateForDropDown(String corpCode){
		List<Map<String, Object>> result = null;
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT INTEREST_RATE RATE FROM ");
			sql.append(DBConstants.INTEREST_MST);
			sql.append(" WHERE INTEREST_TYPE ='DF' ");
			sql.append(" AND CORP_CODE = ? ");
			/*sql.append(" AND START_DATE <= CURDATE() ");
			sql.append(" AND (END_DATE >= CURDATE() OR END_DATE IS NULL) ");*/
			sql.append(" AND ACTIVE_STATUS= 'Y' ");
			sql.append(" ORDER BY INTEREST_RATE");
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] { corpCode });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getUserRoleBankForDropdown() {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT LOOKUP_CODE CODE, LOOKUP_DESCRIPTION DESCRIPTION FROM ");
			sql.append(DBConstants.LOOKUP_MST);
			sql.append(" WHERE LOOKUP_TYPE = 'USER_ROLE_BANK' AND ACTIVE_STATUS = 'Y' AND LOOKUP_CODE NOT IN('01') ORDER BY LOOKUP_CODE ASC");			
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] {});
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getUserRoleCustForDropdown() {
		List<Map<String, Object>> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT LOOKUP_CODE CODE, LOOKUP_DESCRIPTION DESCRIPTION FROM ");
			sql.append(DBConstants.LOOKUP_MST);
			sql.append(" WHERE LOOKUP_TYPE = 'USER_ROLE_CORP' AND ACTIVE_STATUS = 'Y' ORDER BY LOOKUP_CODE ASC");			
			result = jdbcTemplate.queryForList(sql.toString(), new Object[] {});
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public Map<String, Object> getSystemMstByKey(String key) {
		Map<String, Object> result = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT CODE, VALUE FROM ");
			sql.append(DBConstants.SYSTEM_MST);
			sql.append(" WHERE CODE = ?");
			result = jdbcTemplate.queryForMap(sql.toString(), new Object[] { key });
		} catch(Exception e){
			logger.error(e);
			throw e;
		}
		return result;
	}
}
