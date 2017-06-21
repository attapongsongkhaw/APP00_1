package com.kbank.lms.model;

import java.io.Serializable;
import java.util.Date;

public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1068937473707289917L;

	private Date createdDate;
	private String createdBy;
	private Date authorizedDate;
	private String authorizedBy;
	private Date lastUpdatedDate;
	private String lastUpdatedBy;
	private String authorizedStr;
	private String operationFlagStr;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getAuthorizedDate() {
		return authorizedDate;
	}
	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}
	public String getAuthorizedBy() {
		return authorizedBy;
	}
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getAuthorizedStr() {
		return authorizedStr;
	}
	public void setAuthorizedStr(String authorizedStr) {
		this.authorizedStr = authorizedStr;
	}
	public String getOperationFlagStr() {
		return operationFlagStr;
	}
	public void setOperationFlagStr(String operationFlagStr) {
		this.operationFlagStr = operationFlagStr;
	}
}
