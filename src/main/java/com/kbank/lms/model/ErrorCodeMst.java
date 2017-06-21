package com.kbank.lms.model;

import java.io.Serializable;

public class ErrorCodeMst implements Serializable {

	private static final long serialVersionUID = -5965865437676529271L;
	
	private String errorCode;
	private String errorMsgEn;
	private String errorMsgTh;
	private String errorMsgDesc;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsgEn() {
		return errorMsgEn;
	}
	public void setErrorMsgEn(String errorMsgEn) {
		this.errorMsgEn = errorMsgEn;
	}
	public String getErrorMsgTh() {
		return errorMsgTh;
	}
	public void setErrorMsgTh(String errorMsgTh) {
		this.errorMsgTh = errorMsgTh;
	}
	public String getErrorMsgDesc() {
		return errorMsgDesc;
	}
	public void setErrorMsgDesc(String errorMsgDesc) {
		this.errorMsgDesc = errorMsgDesc;
	}
	
	
}
