package com.kbank.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import com.kbank.lms.model.SystemLog;
import com.kbank.lms.utils.DBConstants;

@Repository("systemLogDao")
public class SystemLogDaoImpl implements SystemLogDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(SystemLogDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
    
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
    
	@Override
	public SystemLog getEodBodByDate(String logType, Date date) {
		StringBuilder sql = new StringBuilder();
		SystemLog results = null;
		try {
			sql.append("SELECT LOG_DATE, LOG_TYPE, LOG_FILE_GOOD, LOG_FILE_REJECT, LOG_NAME_GOOD, LOG_NAME_REJECT, CREATED_DATE, CREATED_BY, LAST_UPDATED_DATE, LAST_UPDATED_BY FROM ").append(DBConstants.SYSTEM_LOG);
			sql.append(" WHERE LOG_TYPE = ? AND LOG_DATE = ?");
			results = jdbcTemplate.queryForObject(sql.toString(), new Object[] { logType, new java.sql.Date(date.getTime()) },
					new RowMapper<SystemLog>() {
					
					@Override
					public SystemLog mapRow(ResultSet rs, int numRow) throws SQLException {
						SystemLog log = new SystemLog();
						log.setLogDate(rs.getDate("LOG_DATE"));
						log.setLogType(rs.getString("LOG_TYPE"));
						log.setLogFileGood(rs.getBinaryStream("LOG_FILE_GOOD"));
						log.setLogFileReject(rs.getBinaryStream("LOG_FILE_REJECT"));
						log.setLogNameGood(rs.getString("LOG_NAME_GOOD"));
						log.setLogNameReject(rs.getString("LOG_NAME_REJECT"));
						log.setCreatedDate(rs.getDate("CREATED_DATE"));
						log.setCreatedBy(rs.getString("CREATED_BY"));
						log.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
						log.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
						return log;
					}
			    });
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return results;
	}

}
