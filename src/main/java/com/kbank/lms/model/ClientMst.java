package com.kbank.lms.model;

import java.io.Serializable;

public class ClientMst extends BaseDomain implements Serializable{

	private static final long serialVersionUID = -8062766623564485484L;	
	
	private String clientCode;
	private String clientName;
	private String corpCode;
	private String cisId;
	private String activeStatus;
	private String operationFlag;
	private String rejectReason;
	private String authorizeStatus;
	
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
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCisId() {
		return cisId;
	}
	public void setCisId(String cisId) {
		this.cisId = cisId;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getOperationFlag() {
		return operationFlag;
	}
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getAuthorizeStatus() {
		return authorizeStatus;
	}
	public void setAuthorizeStatus(String authorizeStatus) {
		this.authorizeStatus = authorizeStatus;
	}
	@Override
	public String toString() {
		return "ClientMst [clientCode=" + clientCode + ", clientName=" + clientName + ", corpCode=" + corpCode
				+ ", cisId=" + cisId + ", activeStatus=" + activeStatus + ", operationFlag=" + operationFlag
				+ ", rejectReason=" + rejectReason + ", authorizeStatus=" + authorizeStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeStatus == null) ? 0 : activeStatus.hashCode());
		result = prime * result + ((authorizeStatus == null) ? 0 : authorizeStatus.hashCode());
		result = prime * result + ((cisId == null) ? 0 : cisId.hashCode());
		result = prime * result + ((clientCode == null) ? 0 : clientCode.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((corpCode == null) ? 0 : corpCode.hashCode());
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
		ClientMst other = (ClientMst) obj;
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
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (corpCode == null) {
			if (other.corpCode != null)
				return false;
		} else if (!corpCode.equals(other.corpCode))
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
