package com.kbank.lms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CorporationMst extends BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2157571553725447243L;
		
	private String corpCode;
	private String corpName;
	private String cisId;
	private String taxpayerNo;
	private String taxpayerName;
	private String chargeFlag;
	private String chargeAccount;
	private String chargeType;
	private String chargeFreq;
	private String chargeDate;
	private BigDecimal chargeAmount;
	private Date effectiveDate;
	private String activeStatus;
	private String authorizeStatus;
	private String rejectReason;
	private String operationFlag;
	private String accountSA;
	private String accountCA;
	private String ummCompanyStatus;
	private String ummServiceStatus;
	private Timestamp ummSyncDate;
	private String visitPathFlag;
	
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCisId() {
		return cisId;
	}
	public void setCisId(String cisId) {
		this.cisId = cisId;
	}
	public String getTaxpayerNo() {
		return taxpayerNo;
	}
	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo;
	}
	public String getTaxpayerName() {
		return taxpayerName;
	}
	public void setTaxpayerName(String taxpayerName) {
		this.taxpayerName = taxpayerName;
	}
	public String getChargeFlag() {
		return chargeFlag;
	}
	public void setChargeFlag(String chargeFlag) {
		this.chargeFlag = chargeFlag;
	}
	public String getChargeAccount() {
		return chargeAccount;
	}
	public void setChargeAccount(String chargeAccount) {
		this.chargeAccount = chargeAccount;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeFreq() {
		return chargeFreq;
	}
	public void setChargeFreq(String chargeFreq) {
		this.chargeFreq = chargeFreq;
	}
	public String getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(String chargeDate) {
		this.chargeDate = chargeDate;
	}
	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
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
	public String getUmmCompanyStatus() {
		return ummCompanyStatus;
	}
	public void setUmmCompanyStatus(String ummCompanyStatus) {
		this.ummCompanyStatus = ummCompanyStatus;
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
	public String getAccountSA() {
		return accountSA;
	}
	public void setAccountSA(String accountSA) {
		this.accountSA = accountSA;
	}
	public String getAccountCA() {
		return accountCA;
	}
	public void setAccountCA(String accountCA) {
		this.accountCA = accountCA;
	}
	public String getVisitPathFlag() {
		return visitPathFlag;
	}
	public void setVisitPathFlag(String visitPathFlag) {
		this.visitPathFlag = visitPathFlag;
	}
	@Override
	public String toString() {
		return "CorporationMst [corpCode=" + corpCode + ", corpName=" + corpName + ", cisId=" + cisId + ", taxpayerNo="
				+ taxpayerNo + ", taxpayerName=" + taxpayerName + ", chargeFlag=" + chargeFlag + ", chargeAccount="
				+ chargeAccount + ", chargeType=" + chargeType + ", chargeFreq=" + chargeFreq + ", chargeDate="
				+ chargeDate + ", chargeAmount=" + chargeAmount + ", effectiveDate=" + effectiveDate + ", activeStatus="
				+ activeStatus + ", authorizeStatus=" + authorizeStatus + ", rejectReason=" + rejectReason
				+ ", operationFlag=" + operationFlag + ", ummCompanyStatus=" + ummCompanyStatus + ", ummServiceStatus="
				+ ummServiceStatus + ", ummSyncDate=" + ummSyncDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeStatus == null) ? 0 : activeStatus.hashCode());
		result = prime * result + ((authorizeStatus == null) ? 0 : authorizeStatus.hashCode());
		result = prime * result + ((chargeAccount == null) ? 0 : chargeAccount.hashCode());
		result = prime * result + ((chargeAmount == null) ? 0 : chargeAmount.hashCode());
		result = prime * result + ((chargeDate == null) ? 0 : chargeDate.hashCode());
		result = prime * result + ((chargeFlag == null) ? 0 : chargeFlag.hashCode());
		result = prime * result + ((chargeFreq == null) ? 0 : chargeFreq.hashCode());
		result = prime * result + ((chargeType == null) ? 0 : chargeType.hashCode());
		result = prime * result + ((cisId == null) ? 0 : cisId.hashCode());
		result = prime * result + ((corpCode == null) ? 0 : corpCode.hashCode());
		result = prime * result + ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result + ((effectiveDate == null) ? 0 : effectiveDate.hashCode());
		result = prime * result + ((operationFlag == null) ? 0 : operationFlag.hashCode());
		result = prime * result + ((rejectReason == null) ? 0 : rejectReason.hashCode());
		result = prime * result + ((taxpayerName == null) ? 0 : taxpayerName.hashCode());
		result = prime * result + ((taxpayerNo == null) ? 0 : taxpayerNo.hashCode());
		result = prime * result + ((ummCompanyStatus == null) ? 0 : ummCompanyStatus.hashCode());
		result = prime * result + ((ummServiceStatus == null) ? 0 : ummServiceStatus.hashCode());
		result = prime * result + ((ummSyncDate == null) ? 0 : ummSyncDate.hashCode());
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
		CorporationMst other = (CorporationMst) obj;
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
		if (chargeAccount == null) {
			if (other.chargeAccount != null)
				return false;
		} else if (!chargeAccount.equals(other.chargeAccount))
			return false;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (chargeDate == null) {
			if (other.chargeDate != null)
				return false;
		} else if (!chargeDate.equals(other.chargeDate))
			return false;
		if (chargeFlag == null) {
			if (other.chargeFlag != null)
				return false;
		} else if (!chargeFlag.equals(other.chargeFlag))
			return false;
		if (chargeFreq == null) {
			if (other.chargeFreq != null)
				return false;
		} else if (!chargeFreq.equals(other.chargeFreq))
			return false;
		if (chargeType == null) {
			if (other.chargeType != null)
				return false;
		} else if (!chargeType.equals(other.chargeType))
			return false;
		if (cisId == null) {
			if (other.cisId != null)
				return false;
		} else if (!cisId.equals(other.cisId))
			return false;
		if (corpCode == null) {
			if (other.corpCode != null)
				return false;
		} else if (!corpCode.equals(other.corpCode))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (effectiveDate == null) {
			if (other.effectiveDate != null)
				return false;
		} else if (!effectiveDate.equals(other.effectiveDate))
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
		if (taxpayerName == null) {
			if (other.taxpayerName != null)
				return false;
		} else if (!taxpayerName.equals(other.taxpayerName))
			return false;
		if (taxpayerNo == null) {
			if (other.taxpayerNo != null)
				return false;
		} else if (!taxpayerNo.equals(other.taxpayerNo))
			return false;
		if (ummCompanyStatus == null) {
			if (other.ummCompanyStatus != null)
				return false;
		} else if (!ummCompanyStatus.equals(other.ummCompanyStatus))
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
		return true;
	}
	
	
	
}
