package com.kbank.lms.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserMst extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5648636922061850345L;
	private String userId;
	private String firstName;
	private String lastName;
	private String corpCode;
	private String userGroup;
	private String userRole;
	private String loggedOn; 
	private int lockoutCounter; 
	private Timestamp LastLoggedOn;
	private Timestamp LastLoggedOff;
	private String activeStatus;
	private String authorizeStatus;
	private String rejectReason;
	private String operationFlag;
	private String ummUserStatus;
	private String ummServiceStatus;
	private Timestamp ummSyncDate;
	private String clientCode;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getLoggedOn() {
		return loggedOn;
	}
	public void setLoggedOn(String loggedOn) {
		this.loggedOn = loggedOn;
	}
	public int getLockoutCounter() {
		return lockoutCounter;
	}
	public void setLockoutCounter(int lockoutCounter) {
		this.lockoutCounter = lockoutCounter;
	}
	public Timestamp getLastLoggedOn() {
		return LastLoggedOn;
	}
	public void setLastLoggedOn(Timestamp lastLoggedOn) {
		LastLoggedOn = lastLoggedOn;
	}
	public Timestamp getLastLoggedOff() {
		return LastLoggedOff;
	}
	public void setLastLoggedOff(Timestamp lastLoggedOff) {
		LastLoggedOff = lastLoggedOff;
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
	public String getUmmUserStatus() {
		return ummUserStatus;
	}
	public void setUmmUserStatus(String ummUserStatus) {
		this.ummUserStatus = ummUserStatus;
	}
	public String getUmmServiceStatus() {
		return ummServiceStatus;
	}
	public void setUmmServiceStatus(String ummServiceStatus) {
		this.ummServiceStatus = ummServiceStatus;
	}
	public Timestamp getUmmSyncDate() {
		return ummSyncDate;
	}
	public void setUmmSyncDate(Timestamp ummSyncDate) {
		this.ummSyncDate = ummSyncDate;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
	@Override
	public String toString() {
		return "UserMst [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", corpCode="
				+ corpCode + ", userGroup=" + userGroup + ", userRole=" + userRole + ", loggedOn=" + loggedOn
				+ ", lockoutCounter=" + lockoutCounter + ", LastLoggedOn=" + LastLoggedOn + ", LastLoggedOff="
				+ LastLoggedOff + ", activeStatus=" + activeStatus + ", authorizeStatus=" + authorizeStatus
				+ ", rejectReason=" + rejectReason + ", operationFlag=" + operationFlag + ", ummUserStatus=" + ummUserStatus
				+ ", ummServiceStatus=" + ummServiceStatus + ", ummSyncDate=" + ummSyncDate + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LastLoggedOff == null) ? 0 : LastLoggedOff.hashCode());
		result = prime * result + ((LastLoggedOn == null) ? 0 : LastLoggedOn.hashCode());
		result = prime * result + ((activeStatus == null) ? 0 : activeStatus.hashCode());
		result = prime * result + ((authorizeStatus == null) ? 0 : authorizeStatus.hashCode());
		result = prime * result + ((corpCode == null) ? 0 : corpCode.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + lockoutCounter;
		result = prime * result + ((loggedOn == null) ? 0 : loggedOn.hashCode());
		result = prime * result + ((operationFlag == null) ? 0 : operationFlag.hashCode());
		result = prime * result + ((rejectReason == null) ? 0 : rejectReason.hashCode());
		result = prime * result + ((ummServiceStatus == null) ? 0 : ummServiceStatus.hashCode());
		result = prime * result + ((ummSyncDate == null) ? 0 : ummSyncDate.hashCode());
		result = prime * result + ((ummUserStatus == null) ? 0 : ummUserStatus.hashCode());
		result = prime * result + ((userGroup == null) ? 0 : userGroup.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		UserMst other = (UserMst) obj;
		if (LastLoggedOff == null) {
			if (other.LastLoggedOff != null)
				return false;
		} else if (!LastLoggedOff.equals(other.LastLoggedOff))
			return false;
		if (LastLoggedOn == null) {
			if (other.LastLoggedOn != null)
				return false;
		} else if (!LastLoggedOn.equals(other.LastLoggedOn))
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
		if (corpCode == null) {
			if (other.corpCode != null)
				return false;
		} else if (!corpCode.equals(other.corpCode))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lockoutCounter != other.lockoutCounter)
			return false;
		if (loggedOn == null) {
			if (other.loggedOn != null)
				return false;
		} else if (!loggedOn.equals(other.loggedOn))
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
		if (ummServiceStatus == null) {
			if (other.ummServiceStatus != null)
				return false;
		} else if (!ummServiceStatus.equals(other.ummServiceStatus))
			return false;
		if (ummSyncDate == null) {
			if (other.ummSyncDate != null)
				return false;
		} else if (!ummSyncDate.equals(other.ummSyncDate))
			return false;
		if (ummUserStatus == null) {
			if (other.ummUserStatus != null)
				return false;
		} else if (!ummUserStatus.equals(other.ummUserStatus))
			return false;
		if (userGroup == null) {
			if (other.userGroup != null)
				return false;
		} else if (!userGroup.equals(other.userGroup))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}	
}
