package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.kbank.lms.model.FunctionMst;
import com.kbank.lms.utils.Convert;

public class FunctionRowMapper  implements RowMapper<FunctionMst>{
	
	@Override
	public FunctionMst mapRow(ResultSet rs, int arg1) throws SQLException {
		FunctionMst func = new FunctionMst();
		func.setFuncCode(rs.getString("FUNC_CODE"));
		func.setCorpCode(rs.getString("CORP_CODE"));
		func.setVipFlag(rs.getString("VIP_FLAG"));
		func.setOvernightFlag(rs.getString("OVERNIGHT_FLAG"));
		func.setExecFreq(rs.getString("EXEC_FREQ"));
		func.setDayOfWeek(rs.getString("DAY_OF_WEEK"));
		func.setDayOfMonth(rs.getString("DAY_OF_MONTH"));
		func.setEffectiveDateStr(Convert.parseString(rs.getDate("EFFECTIVE_DATE")));
		func.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
		func.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		func.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		func.setRejectReason(rs.getString("REJECT_REASON"));
		func.setOperationFlag(rs.getString("OPERATION_FLAG"));
		func.setSyncDate(rs.getDate("SYNC_DATE"));
		func.setSyncStatus(rs.getString("SYNC_STATUS"));
		func.setSyncMessage(rs.getString("SYNC_MESSAGE"));
		func.setCreatedDate(rs.getDate("CREATED_DATE"));
		func.setCreatedBy(rs.getString("CREATED_BY"));
		func.setAuthorizedDate(rs.getDate("AUTHORIZED_DATE"));
		func.setAuthorizedBy(rs.getString("AUTHORIZED_BY"));
		func.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
		func.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
		return func;
	}

}

