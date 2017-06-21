package com.kbank.lms.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

public class SystemLog extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 6596658376111724111L;
	private Date logDate;
	private String logType;
	private transient InputStream logFileGood;
	private transient InputStream logFileReject;
	private String logNameGood;
	private String logNameReject;
	
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public InputStream getLogFileGood() {
		return logFileGood;
	}
	public void setLogFileGood(InputStream logFileGood) {
		this.logFileGood = logFileGood;
	}
	public InputStream getLogFileReject() {
		return logFileReject;
	}
	public void setLogFileReject(InputStream logFileReject) {
		this.logFileReject = logFileReject;
	}
	public String getLogNameGood() {
		return logNameGood;
	}
	public void setLogNameGood(String logNameGood) {
		this.logNameGood = logNameGood;
	}
	public String getLogNameReject() {
		return logNameReject;
	}
	public void setLogNameReject(String logNameReject) {
		this.logNameReject = logNameReject;
	}
}
