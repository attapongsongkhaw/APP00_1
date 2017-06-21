package com.kbank.lms.model;

import java.io.Serializable;
import java.util.Date;

public class InstructionMst extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7007060891818020172L;
	
	private String clientCode;
	private String clientName;
	private int instructionId;
	private String instructionName;
	private int memberAccountId;
	private String memberAccount;
	private int masterAccountId;
	private String masterAccount;
	private int priority;
	private int level;
	private String direction;
	private double minBalance;
	private double maxBalance;
	private double sweepRate;
	private double deficitRate;
	private Date effectiveDate;
	private String activeStatus;
	private String authorizeStatus;
	private String rejectReason;
	private String operationFlag;
	private Date syncDate;
	private String syncStatus;
	private String syncMessage;
	private String effectiveDateStr;
	
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getInstructionId() {
		return instructionId;
	}
	public void setInstructionId(int instructionId) {
		this.instructionId = instructionId;
	}
	public String getInstructionName() {
		return instructionName;
	}
	public void setInstructionName(String instructionName) {
		this.instructionName = instructionName;
	}
	public int getMemberAccountId() {
		return memberAccountId;
	}
	public void setMemberAccountId(int memberAccountId) {
		this.memberAccountId = memberAccountId;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public int getMasterAccountId() {
		return masterAccountId;
	}
	public void setMasterAccountId(int masterAccountId) {
		this.masterAccountId = masterAccountId;
	}
	public String getMasterAccount() {
		return masterAccount;
	}
	public void setMasterAccount(String masterAccount) {
		this.masterAccount = masterAccount;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public double getMaxBalance() {
		return maxBalance;
	}
	public void setMaxBalance(double maxBalance) {
		this.maxBalance = maxBalance;
	}
	public double getSweepRate() {
		return sweepRate;
	}
	public void setSweepRate(double sweepRate) {
		this.sweepRate = sweepRate;
	}
	public double getDeficitRate() {
		return deficitRate;
	}
	public void setDeficitRate(double deficitRate) {
		this.deficitRate = deficitRate;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
	public String getEffectiveDateStr() {
		return effectiveDateStr;
	}
	public void setEffectiveDateStr(String effectiveDateStr) {
		this.effectiveDateStr = effectiveDateStr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
