
package com.kbank.lms.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.log4j.Logger;
/**
 *
 * @author user
 */
public class Convert {
	
	private static final Logger logger = Logger.getLogger(Convert.class);
	
	private Convert() {
	}
	
	public static java.sql.Date parseDate( String s) {
		java.sql.Date date = null;
		try {
			if(s != null && !"".equals(s)){
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
				date = new Date(formatter.parse(s).getTime());
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return date;
	}

	public static String parseString(java.sql.Date d) {
	    String s = "";
		try {
			if(d != null){
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
				s = formatter.format(d);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return s;
	 }
  
}
