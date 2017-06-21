package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.ClientMst;

public class ClientRowMapper  implements RowMapper<ClientMst>{
	
	@Override
	public ClientMst mapRow(ResultSet rs, int arg1) throws SQLException {
		ClientMst client = new ClientMst();
		client.setClientCode(rs.getString("CLIENT_CODE"));
		client.setClientName(rs.getString("CLIENT_NAME"));
		client.setCorpCode(rs.getString("CORP_CODE"));
		client.setCisId(rs.getString("CIS_ID"));
		client.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		client.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		client.setRejectReason(rs.getString("REJECT_REASON"));
		client.setOperationFlag(rs.getString("OPERATION_FLAG"));
		client.setCreatedDate(rs.getDate("CREATED_DATE"));
		client.setCreatedBy(rs.getString("CREATED_BY"));
		client.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		client.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		client.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		client.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		return client;
	}

}

