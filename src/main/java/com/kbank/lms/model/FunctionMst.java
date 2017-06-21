package com.kbank.lms.model;

import java.io.Serializable;
import java.util.Date;

public class FunctionMst extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -8431326586009545909L;
	
	private String corpCode;
	private String funcCode;
	private String execFreq;
	private String dayOfWeek;
	private String dayOfMonth;
	private String vipFlag;
	private String overnightFlag;
	private Date effectiveDate;
	private String effectiveDateStr;
	
	private InstructionMst instructionList;
	private String activeStatus;
	private String authorizeStatus;
	private String rejectReason;
	private String operationFlag;
	private Date syncDate;
	private String syncDateStr;
	private String syncStatus;
	private String syncMessage;
	private String corpName;
	
	public String getEffectiveDateStr() {
		return effectiveDateStr;
	}
	public void setEffectiveDateStr(String effectiveDateStr) {
		this.effectiveDateStr = effectiveDateStr;
	}
	public String getSyncDateStr() {
		return syncDateStr;
	}
	public void setSyncDateStr(String syncDateStr) {
		this.syncDateStr = syncDateStr;
	}
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}
	public String getOvernightFlag() {
		return overnightFlag;
	}
	public void setOvernightFlag(String overnightFlag) {
		this.overnightFlag = overnightFlag;
	}
	public String getExecFreq() {
		return execFreq;
	}
	public void setExecFreq(String execFreq) {
		this.execFreq = execFreq;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public InstructionMst getInstructionList() {
		return instructionList;
	}
	public void setInstructionList(InstructionMst instructionList) {
		this.instructionList = instructionList;
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
	public Date getSyncDate() {
		return syncDate;
	}
	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getSyncMessage() {
		return syncMessage;
	}
	public void setSyncMessage(String syncMessage) {
		this.syncMessage = syncMessage;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
}
