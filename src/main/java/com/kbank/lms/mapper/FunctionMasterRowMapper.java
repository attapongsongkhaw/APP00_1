package com.kbank.lms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.kbank.lms.model.FuncMaster;

public class FunctionMasterRowMapper  implements RowMapper<FuncMaster>{
	
	@Override
	public FuncMaster mapRow(ResultSet rs, int arg1) throws SQLException {
		FuncMaster func = new FuncMaster();
		func.setFuncCode(rs.getString("FUNC_CODE"));
		func.setFuncName(rs.getString("FUNC_NAME"));
		func.setAllowVip(rs.getString("ALLOW_VIP"));
		func.setAllowOvernightFlag(rs.getString("ALLOW_OVERNIGHT_FLAG"));
		func.setAllowExecDaily(rs.getString("ALLOW_EXEC_DAILY"));
		func.setAllowExecDayOfWeek(rs.getString("ALLOW_EXEC_DAY_OF_WEEK"));
		func.setAllowExecDayOfMonth(rs.getString("ALLOW_EXEC_DAY_OF_MONTH"));
		func.setActiveStatus(rs.getString("ACTIVE_STATUS"));
		func.setAuthorizeStatus(rs.getString("AUTHORIZE_STATUS"));
		func.setRejectReason(rs.getString("REJECT_REASON"));
		func.setOperationFlag(rs.getString("OPERATION_FLAG"));
		return func;
	}

}

