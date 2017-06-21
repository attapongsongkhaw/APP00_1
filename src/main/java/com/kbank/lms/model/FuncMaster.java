package com.kbank.lms.model;

public class FuncMaster {
	
	private String funcCode;
	private String funcName;
	private String allowVip;
	private String allowOvernightFlag;
	private String allowExecDaily;
	private String allowExecDayOfWeek;
	private String allowExecDayOfMonth;
	private String activeStatus;
	private String authorizeStatus;
	private String rejectReason;
	private String operationFlag;
	
	private String direction;
	private String zeroBalance;
	private String minForUp;
	private String minForDown;
	
	public String getFuncCode() {
		
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public String getAllowVip() {
		return allowVip;
	}
	public void setAllowVip(String allowVip) {
		this.allowVip = allowVip;
	}
	public String getAllowOvernightFlag() {
		return allowOvernightFlag;
	}
	public void setAllowOvernightFlag(String allowOvernightFlag) {
		this.allowOvernightFlag = allowOvernightFlag;
	}
	public String getAllowExecDaily() {
		return allowExecDaily;
	}
	public void setAllowExecDaily(String allowExecDaily) {
		this.allowExecDaily = allowExecDaily;
	}
	public String getAllowExecDayOfWeek() {
		return allowExecDayOfWeek;
	}
	public void setAllowExecDayOfWeek(String allowExecDayOfWeek) {
		this.allowExecDayOfWeek = allowExecDayOfWeek;
	}
	public String getAllowExecDayOfMonth() {
		return allowExecDayOfMonth;
	}
	public void setAllowExecDayOfMonth(String allowExecDayOfMonth) {
		this.allowExecDayOfMonth = allowExecDayOfMonth;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getAuthorizeStatus() {
		return authorizeStatus;
	}
	public void setAuthorizeStatus(String authorizeStatus) {
		this.authorizeStatus = authorizeStatus;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getOperationFlag() {
		return operationFlag;
	}
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getZeroBalance() {
		return zeroBalance;
	}
	public void setZeroBalance(String zeroBalance) {
		this.zeroBalance = zeroBalance;
	}
	public String getMinForUp() {
		return minForUp;
	}
	public void setMinForUp(String minForUp) {
		this.minForUp = minForUp;
	}
	public String getMinForDown() {
		return minForDown;
	}
	public void setMinForDown(String minForDown) {
		this.minForDown = minForDown;
	}
	
}
