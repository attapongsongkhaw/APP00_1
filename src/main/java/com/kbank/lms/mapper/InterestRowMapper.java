package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.kbank.lms.model.InterestMst;

public class InterestRowMapper implements RowMapper<InterestMst> {

	@Override
	public InterestMst mapRow(ResultSet rs, int arg1) throws SQLException {
		InterestMst interestMst = new InterestMst();
		interestMst.setInterestType(rs.getString("INTEREST_TYPE"));
		interestMst.setInterestRate(rs.getBigDecimal("INTEREST_RATE"));
		interestMst.setCorpCode(rs.getString("CORP_CODE"));
		interestMst.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		interestMst.setRejectReason(rs.getString("REJECT_REASON"));
		interestMst.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		interestMst.setOperationFlag(rs.getString("OPERATION_FLAG"));
		interestMst.setCreatedDate(rs.getDate("CREATED_DATE"));
		interestMst.setCreatedBy(rs.getString("CREATED_BY"));
		interestMst.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		interestMst.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		interestMst.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		interestMst.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		return interestMst;
	}
}
