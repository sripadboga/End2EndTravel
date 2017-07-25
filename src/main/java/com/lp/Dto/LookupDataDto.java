package com.lp.Dto;

import java.util.List;

public class LookupDataDto {

	private Long lookupId;
	
	private String lookupName;
	
	private Character activeFlag;
	
	private String createdUser;
	
	private String ipValue;
	
	private String dateCreated;
	
	private List<LookupItemDataDto> lookupItemData;

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
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

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<LookupItemDataDto> getLookupItemData() {
		return lookupItemData;
	}

	public void setLookupItemData(List<LookupItemDataDto> lookupItemData) {
		this.lookupItemData = lookupItemData;
	}
	
}
