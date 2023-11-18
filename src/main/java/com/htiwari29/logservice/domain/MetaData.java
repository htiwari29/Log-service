package com.htiwari29.logservice.domain;

public class MetaData {

	private String parentResourceId;

	public MetaData(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	public String getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

}
