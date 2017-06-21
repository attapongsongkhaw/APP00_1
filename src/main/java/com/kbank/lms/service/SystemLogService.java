package com.kbank.lms.service;

import java.util.Date;

import com.kbank.lms.model.SystemLog;

public interface SystemLogService {

	public SystemLog getEodBodByDate(String logType, Date date);
}
