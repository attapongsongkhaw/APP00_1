package com.kbank.lms.soap.ws.entity;

import com.kbank.lms.model.UserMst;

public class WsUser extends UserMst {

	private static final long serialVersionUID = 1L;
	private String ummSsoID;
	public String getUmmSsoID() {
		return ummSsoID;
	}
	public void setUmmSsoID(String ummSsoID) {
		this.ummSsoID = ummSsoID;
	}

	

	
}
