package com.kbank.lms.common;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.BadSqlGrammarException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kbank.lms.model.MapErrorMsg;
import com.kbank.lms.utils.AppUtils;
import com.kbank.lms.utils.DBConstants;

public class LMSException  extends Exception implements Serializable {

	private static final long serialVersionUID = 3927473807823586178L;
	private int errorCode;
	private String errorMessageEn;
	private String errorMessageTh;
	private int errorLineNumber;
	
	private static final Logger logger = Logger.getLogger(LMSException.class);
	
	public LMSException() {
        super();
    }
	
	public LMSException(String message) {
	    super(message);
	}
	
	public LMSException(int errorCode) {
		this.errorCode = errorCode;
		setErrorMessageFromDB();
	}
	
	public LMSException(String message, int errorCode) {
	    super(message);
	    this.errorCode = errorCode;
	}
	 
	public LMSException(Exception exception) {
		if(exception instanceof LMSException){
			this.setErrorMessageTh(exception.getMessage());
		}else if(exception instanceof WebServiceException){
			this.setErrorMessageTh(exception.getMessage());
		}else{
			this.setErrorCode(exception);
			setErrorMessageFromDB();
		}
	}
	
	public LMSException(List<MapErrorMsg> maps, int errorCode){
		this.errorCode = errorCode;
		setErrorMessageFromDB();
		String msg = this.getErrorMessageTh();
		for(MapErrorMsg error : maps){
			msg = msg.replaceAll(error.getVariable(), (error.getText() == null) ? "" : error.getText());
		}
		this.setErrorMessageTh(msg);
	}
	
	public LMSException(MapErrorMsg map, int errorCode){
		this.errorCode = errorCode;
		setErrorMessageFromDB();
		String msg = this.getErrorMessageTh();
		msg = msg.replace(map.getVariable(), (map.getText() == null) ? "" : map.getText());
		this.setErrorMessageTh(msg);
	}
	
	private void setErrorMessageFromDB(){
		if(this.getErrorCode() == 0000) return;
		StringBuilder sql = new StringBuilder();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		DataSource ds = null; 
		try{
			AppUtils app = new AppUtils();
			ds = app.getDataSource();
		    conn = ds.getConnection();
			sql.append("SELECT ERROR_CODE, ERROR_MSG_EN, ERROR_MSG_TH, ERROR_DESC FROM ");
			sql.append(DBConstants.ERROR_CODE_MST);
			sql.append(" WHERE ERROR_CODE = ?");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, this.getErrorCode());
			rs = stmt.executeQuery();
			while(rs.next()){
				this.setErrorMessageEn(rs.getString("ERROR_MSG_EN"));
				this.setErrorMessageTh(rs.getString("ERROR_MSG_TH"));
			}
		}catch(Exception ex){
			logger.error(ex);
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					logger.error(e);
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}
	}
	

	@Override
	public String getMessage() {
		return this.getErrorMessageTh();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Exception ex) {
		if(ex instanceof NullPointerException){
	    	this.errorCode = 999;
	    } else if(ex instanceof IOException){
			this.errorCode = 999;
		} else if (ex instanceof BadSqlGrammarException){ 
			this.errorCode = 999;
	    } else if (ex instanceof SQLException){
	    	this.errorCode = 999;
	    }  else if(ex instanceof ServletException){
	    	this.errorCode = 999;
	    } else if(ex instanceof JsonProcessingException){
	    	this.errorCode = 999;
	    } else{
	    	this.errorCode = 999;
	    }
	}
	
	public String getErrorMessageEn() {
		return errorMessageEn;
	}

	public void setErrorMessageEn(String errorMessageEn) {
		this.errorMessageEn = errorMessageEn;
	}

	public String getErrorMessageTh() {
		return errorMessageTh;
	}

	public void setErrorMessageTh(String errorMessageTh) {
		this.errorMessageTh = errorMessageTh;
	}

	public int getErrorLineNumber() {
		return errorLineNumber;
	}

	public void setErrorLineNumber(int errorLineNumber) {
		this.errorLineNumber = errorLineNumber;
	}
}