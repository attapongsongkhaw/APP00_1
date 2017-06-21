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

import com.kbank.lms.datatable.Order;
import com.kbank.lms.datatable.SearchDataTable;
import com.kbank.lms.model.VisitPathMst;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.DBConstants;

@Repository("visitPathDao")
public class VisitPathDaoImpl implements VisitPathDao {

	private JdbcTemplate jdbcTemplate; 
	private static final Logger logger = Logger.getLogger(VisitPathDaoImpl.class);
	
	@Autowired 
    @Qualifier("transactionManager") 
    private PlatformTransactionManager transactionManager;
	
	@Autowired
	private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = (JdbcTemplate) namedParameterJdbcTemplate.getJdbcOperations();
	}
	
	@Override
	public int countVisitPathFilter(SearchDataTable<VisitPathMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		try {		
			sql.append("SELECT COUNT(0) FROM (SELECT a.MEMBER_ACCOUNT_ID FROM ");
			if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLETMP)){
				sql.append(DBConstants.VISIT_PATH_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLEMST)){
				sql.append(DBConstants.VISIT_PATH_MST);
			}
			sql.append(" a ");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				sql.append(" INNER JOIN ").append(DBConstants.ACCOUNT_MST);
				sql.append(" b ON a.MEMBER_ACCOUNT_ID = b.ACCOUNT_ID AND b.ACTIVE_STATUS = 'Y'");
				sql.append(" INNER JOIN ").append(DBConstants.CORPORATION_MST);
				sql.append(" c ON b.CORP_CODE = c.CORP_CODE AND c.ACTIVE_STATUS = 'Y'");
				where.add(" c.CORP_CODE = ?");
			}
			where.add(" a.ACTIVE_STATUS = 'Y'");
			where.add(new StringBuilder(" CASE WHEN (? = '' || ? IS NULL) THEN 1=1 ELSE a.MEMBER_ACCOUNT_ID IN (SELECT ACCOUNT_ID FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE ACCOUNT_NO LIKE ? ) END").toString());
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			sql.append(" GROUP BY a.MEMBER_ACCOUNT_ID) d");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{
						searchDataTable.getDataSearch().getCorpCode(),
						searchDataTable.getDataSearch().getMemberAccountNo(),
						searchDataTable.getDataSearch().getMemberAccountNo(),
						"%" + searchDataTable.getDataSearch().getMemberAccountNo() + "%"
				}, Integer.class);
			}else{
				results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{
						searchDataTable.getDataSearch().getMemberAccountNo(),
						searchDataTable.getDataSearch().getMemberAccountNo(),
						"%" + searchDataTable.getDataSearch().getMemberAccountNo() + "%"
				}, Integer.class);
			}
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}

	@Override
	public List<VisitPathMst> searchVisitPath(SearchDataTable<VisitPathMst> searchDataTable) {
		List<VisitPathMst> results = null;
		StringBuilder sql = new StringBuilder();
		List<String> where = new ArrayList<>();
		StringBuilder order = new StringBuilder();
		String[] orderColumns = null;
		try {
			if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLETMP)){
				orderColumns = new String[]{ "a.ACCOUNT_NO", "a.ACCOUNT_NO", "a.ACCOUNT_NAME_TH", "a.ACCOUNT_NAME_EN"};
			}else if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLEMST)){
				orderColumns = new String[]{ "a.ACCOUNT_NO", "a.ACCOUNT_NO", "a.ACCOUNT_NAME_TH", "a.ACCOUNT_NAME_EN"};
			}
			sql.append("SELECT b.MEMBER_ACCOUNT_ID, a.ACCOUNT_NO, a.ACCOUNT_NAME_TH, a.ACCOUNT_NAME_EN FROM ").append(DBConstants.ACCOUNT_MST).append(" a INNER JOIN ");
			if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLETMP)){
				sql.append(DBConstants.VISIT_PATH_TMP);
				
			}else if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLEMST)){
				sql.append(DBConstants.VISIT_PATH_MST);
			}
			sql.append(" b ON a.ACCOUNT_ID = b.MEMBER_ACCOUNT_ID AND b.ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				sql.append(" INNER JOIN ").append(DBConstants.CORPORATION_MST);
				sql.append(" c ON a.CORP_CODE = c.CORP_CODE AND c.ACTIVE_STATUS = 'Y'");
				where.add(" c.CORP_CODE = ?");
			}
			where.add(" a.ACTIVE_STATUS = 'Y'");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getMemberAccountNo())){
				where.add(" a.ACCOUNT_NO LIKE ? AND b.MEMBER_ACCOUNT_ID = a.ACCOUNT_ID");
			}
			if(!where.isEmpty()){
				sql.append(" WHERE ");
				for(String strWhere : where){
					sql.append(strWhere).append(" AND ");
				}
				sql = new StringBuilder(sql.substring(0, sql.length() - 4));
			}
			sql.append(" GROUP BY a.ACCOUNT_NO ");
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
		                    preparedStatement.setString(i++, searchDataTable.getDataSearch().getCorpCode());
		                }
		            	if (StringUtils.isNotBlank(searchDataTable.getDataSearch().getMemberAccountNo())) {
		                    preparedStatement.setString(i++, "%" + searchDataTable.getDataSearch().getMemberAccountNo() + "%");
		                }
		            }
		        }, new RowMapper<VisitPathMst>() {
				 
					@Override
					public VisitPathMst mapRow(ResultSet rs, int numRow) throws SQLException {
						VisitPathMst visit = new VisitPathMst();
						visit.setMemberAccountId(rs.getInt("MEMBER_ACCOUNT_ID"));
						visit.setMemberAccountNo(rs.getString("ACCOUNT_NO"));
						visit.setMemberAccountNameEn(rs.getString("ACCOUNT_NAME_EN"));
						visit.setMemberAccountNameTh(rs.getString("ACCOUNT_NAME_TH"));
						return visit;
					}
			    });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return results;
	}
	
	@Override
	public int countVisitPathTotal(SearchDataTable<VisitPathMst> searchDataTable) {
		int results = 0;
		StringBuilder sql = new StringBuilder();
		try {		
			sql.append("SELECT COUNT(0) FROM (SELECT a.MEMBER_ACCOUNT_ID FROM ");
			if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLETMP)){
				sql.append(DBConstants.VISIT_PATH_TMP);
			}else if(searchDataTable.getTableType().equals(Constants.VISITPATHTABLEMST)){
				sql.append(DBConstants.VISIT_PATH_MST);
			}
			sql.append(" a ");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				sql.append(" INNER JOIN ").append(DBConstants.ACCOUNT_MST);
				sql.append(" b ON a.MEMBER_ACCOUNT_ID = b.ACCOUNT_ID AND b.ACTIVE_STATUS = 'Y' ");
				sql.append(" INNER JOIN ").append(DBConstants.CORPORATION_MST);
				sql.append(" c ON b.CORP_CODE = c.CORP_CODE AND c.ACTIVE_STATUS = 'Y'");
				sql.append(" WHERE c.CORP_CODE = ? AND a.ACTIVE_STATUS = 'Y'");
			}else{
				sql.append(" WHERE a.ACTIVE_STATUS = 'Y'");
			}
			sql.append(" GROUP BY a.MEMBER_ACCOUNT_ID) d");
			if(StringUtils.isNotBlank(searchDataTable.getDataSearch().getCorpCode())){
				results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{ searchDataTable.getDataSearch().getCorpCode() }, Integer.class);
			}else{
				results = jdbcTemplate.queryForObject(sql.toString(), new Object[]{}, Integer.class);
			}
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }	
		return results;
	}

	@Override
	public List<VisitPathMst> getVisitPathDetail(int accountId, String type) {
		List<VisitPathMst> results = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT VISIT_SEQ, ACCUM_SEQ, FROM_ACCOUNT_ID, TO_ACCOUNT_ID, ");
			sql.append(" (SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE FROM_ACCOUNT_ID = ACCOUNT_ID AND ACTIVE_STATUS = 'Y') FROM_ACCOUNT_NO, ");
			sql.append(" (SELECT ACCOUNT_NO FROM ").append(DBConstants.ACCOUNT_MST).append(" WHERE TO_ACCOUNT_ID = ACCOUNT_ID AND ACTIVE_STATUS = 'Y') TO_ACCOUNT_NO FROM ");
			if(type.equals(Constants.VISITPATHTABLETMP)){
				sql.append(DBConstants.VISIT_PATH_TMP);
			}else if(type.equals(Constants.VISITPATHTABLEMST)){
				sql.append(DBConstants.VISIT_PATH_MST);
			}
			sql.append(" WHERE MEMBER_ACCOUNT_ID = ? AND ACTIVE_STATUS = 'Y' ORDER BY VISIT_SEQ ASC");
			results = jdbcTemplate.query(sql.toString(), new PreparedStatementSetter() {
		            @Override
		            public void setValues(PreparedStatement preparedStatement) throws
		                    SQLException {
		            	preparedStatement.setInt(1, accountId);
		            }
		        }, new RowMapper<VisitPathMst>() {
				 
					@Override
					public VisitPathMst mapRow(ResultSet rs, int numRow) throws SQLException {
						VisitPathMst visit = new VisitPathMst();
						visit.setVisitSeq(rs.getInt("VISIT_SEQ"));
						visit.setAccumSeq(rs.getInt("ACCUM_SEQ"));
						visit.setFromAccountId(rs.getInt("FROM_ACCOUNT_ID"));
						visit.setFromAccountNo(rs.getString("FROM_ACCOUNT_NO"));
						visit.setToAccountId(rs.getInt("TO_ACCOUNT_ID"));
						visit.setToAccountNo(rs.getString("TO_ACCOUNT_NO"));
						return visit;
					}
			    });
		}catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
		return results;
	}

}
