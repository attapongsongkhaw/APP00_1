package com.kbank.lms.soap.ws.entity;

import java.io.Serializable;


public class WsUserResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean	isSuccess;
	private String	code;
	private String	message;
	private String detail;

	public WsUserResult(DefinedResult errorFieldCheckFail) {
		if ((errorFieldCheckFail == null) || (errorFieldCheckFail == DefinedResult.SUCCESS)) {
			isSuccess = true;
			code = "";
			message = DefinedResult.SUCCESS.getErrorDescription();
		}
		else {
			isSuccess = false;
			code = errorFieldCheckFail.getErrorCode();
			message = errorFieldCheckFail.getErrorDescription();
		}
	}
	

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		if(detail!= null){
			return message + ", "+ detail;
		}else{
			return message;
		}
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	//--------------------------------------------- Inner class
	
	public enum DefinedResult {
				
		SUCCESS(								"WS000000", "Success"),
		ERROR_UNDEFINED(						"WS999999", "Undefined error"),
		
		ERROR_INVALID_INPUT_PARAMETER(			"WS000001",	"Invalid Input Parameter"),
		ERROR_INVALID_INPUT_DATATYPE(			"WS000002",	"Invalid Input Data Type"),
		
		ERROR_USER_EXIST(						"WS002001", "Cann't create user. Because user is exist."),
		ERROR_USER_NOT_FOUND(					"WS002002", "Not Found User."),
		ERROR_COMP_NOT_FOUND(					"WS0020021", "Not Found Company."),
		ERROR_CANT_DELETE(						"WS002003", "Cann't Delete User."),
		ERROR_FIELD_CHECK_FAIL(					"WS002004", "Mandatory Field check fail."),
//		ERROR_CANT_DELETE_PENDING_USER_FOUND(	"WS002005", "Cann't delete user because found pending request of this user in system."),
		ERROR_CREATE_USER_FAIL(					"WS002006", "Create User Failed"),
		ERROR_EDIT_USER_FAIL(					"WS002007", "Edit User Failed"),
		ERROR_CANT_DELETE_TXN_Found(			"WS002008", "Cann't delete user because found pending transaction(s) which waiiting for process from this user in system.");

		private String errorCode;
		private String errorDesc;
		
		private DefinedResult(String code, String desc) {
			errorCode = code;
			errorDesc = desc;
		}
		
		public String getErrorCode() {
			return errorCode;
		}
		
		public String getErrorDescription() {
			return errorDesc;
		}
	}
	
}
