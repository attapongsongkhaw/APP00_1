package com.kbank.lms.soap.ws.entity;

import com.kbank.lms.model.CorporationMst;

public class WsCorporationTemp extends CorporationMst {

	private static final long serialVersionUID = 1L;

	private String corparationParentCode;

	public String getCorparationParentCode() {
		return corparationParentCode;
	}

	public void setCorparationParentCode(String corparationParentCode) {
		this.corparationParentCode = corparationParentCode;
	}	


}
