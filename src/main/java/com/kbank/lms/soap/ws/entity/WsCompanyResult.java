package com.kbank.lms.soap.ws.entity;


import java.io.Serializable;

public class WsCompanyResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean	isSuccess;
	private String	code;
	private String	message;
	private String detail;

	public WsCompanyResult(DefinedResult error) {
		if ((error == null) || (error == DefinedResult.SUCCESS)) {
			isSuccess = true;
			code = "";
			message = DefinedResult.SUCCESS.getErrorDescription();
		}
		else {
			isSuccess = false;
			code = error.getErrorCode();
			message = error.getErrorDescription();
		}
	}
	
	public String getCode() {
		return code;
	}

	public boolean isSuccess() {
		return isSuccess;
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
		
		ERROR_COMPANY_EXIST(					"WS001001", "Can't create company. The company is exist."),
		ERROR_COMPANY_NOT_FOUND(				"WS001002", "Company not found"),
		ERROR_CANT_DELETE(						"WS001003", "Can't Delete Company."),
		ERROR_FIELD_CHECK_FAIL(					"WS001004", "Mandatory Field check fail."),
//		ERROR_CANT_DELETE_PENDING_COMP_FOUND(	"WS001005", "Can't delete company because found pending record of this company in system."),
		ERROR_CREATE_COMP_FAIL(					"WS001006", "Create Company Failed"),
		ERROR_EDIT_COMP_FAIL(					"WS001007", "Edit Company Failed"),
		ERROR_CANT_DELETE_USER_FOUND(			"WS001008", "Can't delete company because found active user(s) of this company in system."),
		ERROR_CANT_DELETE_SUB_COMP_FOUND(		"WS001009", "Can't delete company because found active subsidiary company(s) of this company in system."),
		ERROR_CANT_DELETE_TXN_Found(			"WS001010", "Can't delete company because found pending transaction(s) of this company in system.");

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

