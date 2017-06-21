package com.kbank.lms.soap.ws.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

class DataUtil {
	private static final Logger LOGGER= Logger.getLogger(DataUtil.class);

	private DataUtil() { }

public static String toDateTimeFormat(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(d);
	}
public static Timestamp convertStringToTimestampDate(String dateInString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		/**String dateInString = "13/4/2011 14:12:34" */;
		Date dateUtil = new Date();
		Timestamp dateRes = new java.sql.Timestamp(dateUtil.getTime());

		try {

			dateUtil = formatter.parse(dateInString);
			dateRes = new java.sql.Timestamp(dateUtil.getTime());

		} catch (ParseException e) {
			LOGGER.error(e);
			return new java.sql.Timestamp(new Date().getTime());
		}	
		return dateRes;
	}

	static boolean isEmptyOrNull(String value) {
		boolean flag = true;
		if (value == null || value.length() == 0)
			return flag;
		else
			return false;			
	}

}
