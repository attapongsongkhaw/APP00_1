package com.kbank.lms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

public class AppUtils {

	private static final Logger logger = Logger.getLogger(AppUtils.class);
	
	public static String accountNoFormat(String str){
		String result = str;
		if(str.length() == 10){
			String str1 = str.substring(0, 3).concat("-");
			String str2 = str.substring(3, 4).concat("-");
			String str3 = str.substring(5, 9).concat("-");
			String str4 = str.substring(9, 10);
			result = str1.concat(str2).concat(str3).concat(str4);
		}
		return result;
	}
	
	public DataSource getDataSource() {
		Properties prop = new Properties();
		DataSource ds = null; 
		InputStream  file =  null;
		JndiObjectFactoryBean jndiObjectFactoryBean = null;
		try{
			file =  getClass().getClassLoader().getResourceAsStream("app.properties");
			prop.load(file);
			String connectionString = prop.getProperty("lms.datasource.primary.jndiName");
			jndiObjectFactoryBean = new JndiObjectFactoryBean();
		    jndiObjectFactoryBean.setJndiName(connectionString);
		    jndiObjectFactoryBean.afterPropertiesSet();
		    ds = (DataSource) jndiObjectFactoryBean.getObject();			
		}catch(Exception ex){
			logger.error(ex);
		}finally{
			if(file != null){
				try {
					file.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return ds;
	}
	
	public static String genUniqueRequestId(){
		String appId = "746";
		String result = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYMMDD");
			Date date = new Date();
			result = appId + "_" + dateFormat.format(date) + "_" + new Date().getTime();
		} catch(Exception ex){
			logger.error(ex);
		}
		return result;
	}
	
	public static String checkNull(Object obj){
		if(obj == null){
			return "";
		}else{
			return obj.toString();
		}
	}
	
	public static HttpsUrlConnectionMessageSender connectSSLWebService(String keyStore, String keyStorePassword, String trustStore, String trustStorePassword, String SSLcontext){
		HttpsUrlConnectionMessageSender messageSender = null;
		try {
			KeyStore ks = KeyStore.getInstance("JKS");
	        
	        File pKeyFile = new File(keyStore);
	        InputStream keyInput = new FileInputStream(pKeyFile);
	        ks.load(keyInput, keyStorePassword.toCharArray());
	        logger.info("Loaded keystore: " + keyInput);
	        
	        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        keyManagerFactory.init(ks, keyStorePassword.toCharArray());
	
	        KeyStore ts = KeyStore.getInstance("JKS");
	        File tKeyFile = new File(trustStore);
	        InputStream tKeyInput = new FileInputStream(tKeyFile);
	        ts.load(tKeyInput, trustStorePassword.toCharArray());
	        logger.info("Loaded trustStore: " + tKeyInput);
	       
	        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        trustManagerFactory.init(ts);
	
	        messageSender = new HttpsUrlConnectionMessageSender();
	        messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
	        messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());
	
	        SSLContext context = SSLContext.getInstance(SSLcontext);
	        context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
	        SSLSocketFactory sockFact = context.getSocketFactory();
	        messageSender.setSslSocketFactory(sockFact);
	        /*messageSender.setHostnameVerifier((hostname, sslSession) -> {
	            if (hostname.equals("localhost")) {
	                return true;
	            }
	            return false;
	        });*/
		} catch(Exception ex){
			logger.error(ex);
		}
		return messageSender;
	}
	
	public static String getErrorMsgWs(String errorCode, String errorMsg){
		return "[" + errorCode + "] " + errorMsg;	
	}
	
	public static String getErrorMsgWs(Integer errorCode, String errorMsg){
		return "[" + errorCode + "] " + errorMsg;	
	}
}
