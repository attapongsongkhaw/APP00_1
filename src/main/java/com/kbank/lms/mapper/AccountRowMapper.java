package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.AccountMst;

public class AccountRowMapper implements RowMapper<AccountMst>{
	
	@Override
	public AccountMst mapRow(ResultSet rs, int arg1) throws SQLException {
		AccountMst account = new AccountMst();
		account.setAccountId(rs.getInt("ACCOUNT_ID"));
		account.setAccountNo(rs.getString("ACCOUNT_NO"));
		account.setAccountNameTh(rs.getString("ACCOUNT_NAME_TH"));
		account.setAccountNameEn(rs.getString("ACCOUNT_NAME_EN"));
		account.setKbankProductCode(rs.getString("KBANK_PRODUCT_CODE"));
		account.setCisId(rs.getString("CIS_ID"));
		account.setAccountLevel(rs.getString("ACCOUNT_LEVEL"));
		account.setCorpCode(rs.getString("CORP_CODE"));
		account.setClientCode(rs.getString("CLIENT_CODE"));
		account.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		account.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		account.setRejectReason(rs.getString("REJECT_REASON"));
		account.setOperationFlag(rs.getString("OPERATION_FLAG"));
		account.setCreatedDate(rs.getDate("CREATED_DATE"));
		account.setCreatedBy(rs.getString("CREATED_BY"));
		account.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		account.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		account.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		account.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		return account;
	}
}
