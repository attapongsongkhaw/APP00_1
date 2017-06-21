package com.kbank.lms.dao;

import java.util.Date;

import com.kbank.lms.model.SystemLog;

public interface SystemLogDao {

	public SystemLog getEodBodByDate(String logType, Date date);
}
