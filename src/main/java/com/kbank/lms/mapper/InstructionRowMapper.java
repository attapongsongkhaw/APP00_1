package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.dao.CorporationDao;
import com.kbank.lms.model.InstructionMst;
import com.kbank.lms.utils.Convert;

public class InstructionRowMapper  implements RowMapper<InstructionMst>{
	
	@Autowired
	@Qualifier("corporationDao")
	private CorporationDao corporationDao;
	
	@Override
	public InstructionMst mapRow(ResultSet rs, int arg1) throws SQLException {
		InstructionMst instruc = new InstructionMst();
		instruc.setClientCode(rs.getString("CLIENT_CODE"));
		instruc.setClientName(rs.getString("CLIENT_NAME"));
		instruc.setInstructionId(rs.getInt("INSTRUCTION_ID"));
		instruc.setInstructionName(rs.getString("INSTRUCTION_NAME"));
		instruc.setMemberAccountId(rs.getInt("MEMBER_ACCOUNT_ID"));
		instruc.setMemberAccount(rs.getString("MEMBER_ACCOUNT"));
		instruc.setMasterAccountId(rs.getInt("MASTER_ACCOUNT_ID"));
		instruc.setMasterAccount(rs.getString("MASTER_ACCOUNT"));
		instruc.setLevel(rs.getInt("LEVEL"));
		instruc.setPriority(rs.getInt("PRIORITY"));
		instruc.setDirection(rs.getString("DIRECTION"));
		instruc.setMinBalance(rs.getDouble("MIN_BALANCE"));
		instruc.setMaxBalance(rs.getDouble("MAX_BALANCE"));
		instruc.setSweepRate(rs.getDouble("SWEEP_RATE"));
		instruc.setDeficitRate(rs.getDouble("DEFICIT_RATE"));
		instruc.setEffectiveDateStr(Convert.parseString(rs.getDate("EFFECTIVE_DATE")));
		instruc.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		instruc.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		instruc.setRejectReason(rs.getString("REJECT_REASON"));
		instruc.setOperationFlag(rs.getString("OPERATION_FLAG"));
		instruc.setSyncDate(rs.getDate("SYNC_DATE"));
		instruc.setSyncStatus(rs.getString("SYNC_STATUS"));
		instruc.setSyncMessage(rs.getString("SYNC_MESSAGE"));
		instruc.setCreatedDate(rs.getDate("CREATED_DATE"));
		instruc.setCreatedBy(rs.getString("CREATED_BY"));
		instruc.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		instruc.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		instruc.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		instruc.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		return instruc;
	}

}

