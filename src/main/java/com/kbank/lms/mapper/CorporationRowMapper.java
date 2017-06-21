package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.CorporationMst;

public class CorporationRowMapper implements RowMapper<CorporationMst>{
	
	@Override
	public CorporationMst mapRow(ResultSet rs, int arg1) throws SQLException {
		CorporationMst corp = new CorporationMst();
		corp.setCorpCode(rs.getString("CORP_CODE"));
		corp.setCorpName(rs.getString("CORP_NAME"));
		corp.setCisId(rs.getString("CIS_ID"));
		corp.setTaxpayerNo(rs.getString("TAXPAYER_NO"));
		corp.setTaxpayerName(rs.getString("TAXPAYER_NAME"));
		corp.setChargeFlag(rs.getString("CHARGE_FLAG"));
		corp.setChargeAccount(rs.getString("CHARGE_ACCOUNT"));
		corp.setChargeType(rs.getString("CHARGE_TYPE"));
		corp.setChargeFreq(rs.getString("CHARGE_FREQ"));
		corp.setChargeDate(rs.getString("CHARGE_DATE"));
		corp.setChargeAmount(rs.getBigDecimal("CHARGE_AMOUNT"));
		corp.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		corp.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		corp.setRejectReason(rs.getString("REJECT_REASON"));
		corp.setOperationFlag(rs.getString("OPERATION_FLAG"));
		corp.setCreatedDate(rs.getDate("CREATED_DATE"));
		corp.setCreatedBy(rs.getString("CREATED_BY"));
		corp.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		corp.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		corp.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		corp.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		corp.setUmmCompanyStatus(rs.getString("UMM_COMPANY_STATUS"));
		corp.setUmmServiceStatus(rs.getString("UMM_SERVICE_STATUS"));
		corp.setUmmSyncDate(rs.getTimestamp("UMM_SYNC_DATE"));
		return corp;
	}

}
