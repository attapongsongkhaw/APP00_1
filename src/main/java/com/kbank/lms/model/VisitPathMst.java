package com.kbank.lms.model;

import java.io.Serializable;
import java.util.Date;

public class VisitPathMst extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -7727639460529664545L;
	
	private int memberAccountId;
	private String memberAccountNo;
	private String memberAccountNameTh;
	private String memberAccountNameEn;
	private int visitSeq;
	private int accumSeq;
	private int fromAccountId;
	private String fromAccountNo;
	private int toAccountId;
	private String toAccountNo;
	private Date effectiveDate;
	private String activeStatus;
	private Date syncDate;
	private String syncStatus;
	private String corpCode;
	
	public int getMemberAccountId() {
		return memberAccountId;
	}
	public void setMemberAccountId(int memberAccountId) {
		this.memberAccountId = memberAccountId;
	}
	public String getMemberAccountNo() {
		return memberAccountNo;
	}
	public void setMemberAccountNo(String memberAccountNo) {
		this.memberAccountNo = memberAccountNo;
	}
	public String getMemberAccountNameTh() {
		return memberAccountNameTh;
	}
	public void setMemberAccountNameTh(String memberAccountNameTh) {
		this.memberAccountNameTh = memberAccountNameTh;
	}
	public String getMemberAccountNameEn() {
		return memberAccountNameEn;
	}
	public void setMemberAccountNameEn(String memberAccountNameEn) {
		this.memberAccountNameEn = memberAccountNameEn;
	}
	public int getVisitSeq() {
		return visitSeq;
	}
	public void setVisitSeq(int visitSeq) {
		this.visitSeq = visitSeq;
	}
	public int getAccumSeq() {
		return accumSeq;
	}
	public void setAccumSeq(int accumSeq) {
		this.accumSeq = accumSeq;
	}
	public int getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(String fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public int getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
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
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
}
