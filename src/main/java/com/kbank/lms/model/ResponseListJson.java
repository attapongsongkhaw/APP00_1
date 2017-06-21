package com.kbank.lms.model;

import java.util.List;

public class ResponseListJson<T, J> {

	private T master;
	private List<J> list;
	
	public T getMaster() {
		return master;
	}
	public void setMaster(T master) {
		this.master = master;
	}
	public List<J> getList() {
		return list;
	}
	public void setList(List<J> list) {
		this.list = list;
	}
	
}
