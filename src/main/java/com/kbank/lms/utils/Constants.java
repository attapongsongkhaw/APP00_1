package com.kbank.lms.utils;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class Constants {
	
	public static final String SUCCESS = "1";
	public static final Key SECRET = MacProvider.generateKey(SignatureAlgorithm.HS256);
	private static final byte[] SECRETBYTES = SECRET.getEncoded();
	public static final String BASE64SECRETBYTES = Base64.getEncoder().encodeToString(getSecretBytes());
	//public static final int expireTimeToken = 60; // 60 seconds
	public static final int EXPIRETIMETOKEN = 31536000;
	public static final String CHECKER = "CHECKER";
	public static final String MAKER = "MAKER";
	public static final String VIEWER = "VIEWER";
	public static final String CORPTABLEMST = "MST";
	public static final String CORPTABLETMP = "TMP";
	public static final String CLIENTTABLEMST = "MST";
	public static final String CLIENTTABLETMP = "TMP";
	public static final String ACCOUNTTABLEMST = "MST";
	public static final String ACCOUNTTABLETMP = "TMP";
	public static final String FUNCTIONTABLEMST = "MST";
	public static final String FUNCTIONTABLETMP = "TMP";
	public static final String INSTRUCTIONTABLEMST = "MST";
	public static final String INSTRUCTIONTABLETMP = "TMP";
	public static final String VISITPATHTABLETMP = "TMP";
	public static final String VISITPATHTABLEMST = "MST";
	public static final String USERTABLEMST = "MST";
	public static final String USERTABLETMP = "TMP";
	public static final String INTERESTTABLEMST = "MST";
	public static final String INTERESTTABLETMP = "TMP";
	public static final String SAVING = "SAVING";
	public static final String CURRENT = "CURRENT";
	public static final String LMS_SERVICE_CODE = "LMS";
	public static final String RQ_APP_ID = "746";
	public static final String USER_APP_ID = "LMS00001";
	public static final String TERMINAL_ID = "A04LMS01";
	public static final String SOURCE_SYSTEM = "746";
	public static final String PENDING = "Pending for Auth";
	public static final String DRAFT = "Draft";
	public static final String REJECT = "Auth Rejected";
	public static final String ENABLE = "ENABLE";
	public static final String DISABLE = "DISABLE";
	
	private Constants() {
	}
	
	public static byte[] getSecretBytes() {
	    return SECRETBYTES;
	}
}
