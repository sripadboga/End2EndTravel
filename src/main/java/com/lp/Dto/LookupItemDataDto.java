package com.lp.Dto;

import java.util.Date;

import com.lp.Entity.LookupDataEntity;

public class LookupItemDataDto {

	private Long lookupItemId;
	
	private String lookupItemName;
	
	private LookupDataEntity lookupId;
	
	private Character activeFlag;
	
	private String createdUser;
	
	private String ipValue;
	
	private Date dateCreated;

	public Long getLookupItemId() {
		return lookupItemId;
	}

	public void setLookupItemId(Long lookupItemId) {
		this.lookupItemId = lookupItemId;
	}

	public String getLookupItemName() {
		return lookupItemName;
	}

	public void setLookupItemName(String lookupItemName) {
		this.lookupItemName = lookupItemName;
	}

	public LookupDataEntity getLookupId() {
		return lookupId;
	}

	public void setLookupId(LookupDataEntity lookupId) {
		this.lookupId = lookupId;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getIpValue() {
		return ipValue;
	}

	public void setIpValue(String ipValue) {
		this.ipValue = ipValue;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	 
}
