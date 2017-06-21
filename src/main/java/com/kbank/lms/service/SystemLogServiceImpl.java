package com.kbank.lms.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kbank.lms.dao.SystemLogDao;
import com.kbank.lms.model.SystemLog;

@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {

	@Autowired
	@Qualifier("systemLogDao")
	private SystemLogDao systemLogDao;
	
	private static final Logger logger = Logger.getLogger(SystemLogServiceImpl.class);
	
	@Override
	public SystemLog getEodBodByDate(String logType, Date date) {
		SystemLog result = null;
		try {
			result = systemLogDao.getEodBodByDate(logType, date);
		} catch(Exception ex){
			logger.error(ex);
			throw ex;
		}
		return result;
	}
}
