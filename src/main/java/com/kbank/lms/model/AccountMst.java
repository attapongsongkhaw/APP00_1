package com.kbank.lms.model;

import java.io.Serializable;

public class AccountMst extends BaseDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7649912125244356652L;
	
	private int accountId;
	private String accountNo;
	private String accountNameTh;
	private String accountNameEn;
	private String kbankProductCode;
	private String cisId;
	private String accountLevel;
	private String corpCode;
	private String clientCode;
	private String activeStatus;
	private String rejectReason;
	private String operationFlag;
	private String authorizeStatus;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountNameTh() {
		return accountNameTh;
	}
	public void setAccountNameTh(String accountNameTh) {
		this.accountNameTh = accountNameTh;
	}
	public String getAccountNameEn() {
		return accountNameEn;
	}
	public void setAccountNameEn(String accountNameEn) {
		this.accountNameEn = accountNameEn;
	}
	public String getKbankProductCode() {
		return kbankProductCode;
	}
	public void setKbankProductCode(String kbankProductCode) {
		this.kbankProductCode = kbankProductCode;
	}
	public String getCisId() {
		return cisId;
	}
	public void setCisId(String cisId) {
		this.cisId = cisId;
	}
	public String getAccountLevel() {
		return accountLevel;
	}
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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
	public String getAuthorizeStatus() {
		return authorizeStatus;
	}
	public void setAuthorizeStatus(String authorizeStatus) {
		this.authorizeStatus = authorizeStatus;
	}
	@Override
	public String toString() {
		return "AccountMst [ accountNo=" + accountNo + ", accountNameTh=" + accountNameTh
				+ ", accountNameEn=" + accountNameEn + ", kbankProductCode=" + kbankProductCode + ", cisId=" + cisId
				+ ", accountLevel=" + accountLevel + ", corpCode=" + corpCode + ", clientCode=" + clientCode
				+ ", activeStatus=" + activeStatus + ", rejectReason=" + rejectReason + ", operationFlag="
				+ operationFlag + ", authorizeStatus=" + authorizeStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountLevel == null) ? 0 : accountLevel.hashCode());
		result = prime * result + ((accountNameEn == null) ? 0 : accountNameEn.hashCode());
		result = prime * result + ((accountNameTh == null) ? 0 : accountNameTh.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + ((activeStatus == null) ? 0 : activeStatus.hashCode());
		result = prime * result + ((authorizeStatus == null) ? 0 : authorizeStatus.hashCode());
		result = prime * result + ((cisId == null) ? 0 : cisId.hashCode());
		result = prime * result + ((clientCode == null) ? 0 : clientCode.hashCode());
		result = prime * result + ((corpCode == null) ? 0 : corpCode.hashCode());
		result = prime * result + ((kbankProductCode == null) ? 0 : kbankProductCode.hashCode());
		result = prime * result + ((operationFlag == null) ? 0 : operationFlag.hashCode());
		result = prime * result + ((rejectReason == null) ? 0 : rejectReason.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountMst other = (AccountMst) obj;
		if (accountLevel == null) {
			if (other.accountLevel != null)
				return false;
		} else if (!accountLevel.equals(other.accountLevel))
			return false;
		if (accountNameEn == null) {
			if (other.accountNameEn != null)
				return false;
		} else if (!accountNameEn.equals(other.accountNameEn))
			return false;
		if (accountNameTh == null) {
			if (other.accountNameTh != null)
				return false;
		} else if (!accountNameTh.equals(other.accountNameTh))
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (activeStatus == null) {
			if (other.activeStatus != null)
				return false;
		} else if (!activeStatus.equals(other.activeStatus))
			return false;
		if (authorizeStatus == null) {
			if (other.authorizeStatus != null)
				return false;
		} else if (!authorizeStatus.equals(other.authorizeStatus))
			return false;
		if (cisId == null) {
			if (other.cisId != null)
				return false;
		} else if (!cisId.equals(other.cisId))
			return false;
		if (clientCode == null) {
			if (other.clientCode != null)
				return false;
		} else if (!clientCode.equals(other.clientCode))
			return false;
		if (corpCode == null) {
			if (other.corpCode != null)
				return false;
		} else if (!corpCode.equals(other.corpCode))
			return false;
		if (kbankProductCode == null) {
			if (other.kbankProductCode != null)
				return false;
		} else if (!kbankProductCode.equals(other.kbankProductCode))
			return false;
		if (operationFlag == null) {
			if (other.operationFlag != null)
				return false;
		} else if (!operationFlag.equals(other.operationFlag))
			return false;
		if (rejectReason == null) {
			if (other.rejectReason != null)
				return false;
		} else if (!rejectReason.equals(other.rejectReason))
			return false;
		return true;
	}
	
	
	
}
