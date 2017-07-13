package com.lp.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="lookup_data_table")
public class LookupDataEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="my_seq", sequenceName="lookup_data_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
	@Column(name="lookup_id")
	private Long lookupId;
	
	@Column(name="lookup_name")
	private String lookupName;
	
	@Column(name="active_flag")
	private Character activeFlag;
	
	@Column(name="created_user")
	private String createdUser;
	
	@Column(name="ip_address")
	private String ipValue;
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	/**
	 * @return the activeFlag
	 */
	public Character getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the ipValue
	 */
	public String getIpValue() {
		return ipValue;
	}

	/**
	 * @param ipValue the ipValue to set
	 */
	public void setIpValue(String ipValue) {
		this.ipValue = ipValue;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeFlag == null) ? 0 : activeFlag.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((ipValue == null) ? 0 : ipValue.hashCode());
		result = prime * result + ((lookupId == null) ? 0 : lookupId.hashCode());
		result = prime * result + ((lookupName == null) ? 0 : lookupName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "LookupDataEntity [lookupId=" + lookupId + ", lookupName=" + lookupName + ", activeFlag=" + activeFlag
				+ ", createdUser=" + createdUser + ", ipValue=" + ipValue + ", dateCreated=" + dateCreated + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LookupDataEntity other = (LookupDataEntity) obj;
		if (activeFlag == null) {
			if (other.activeFlag != null)
				return false;
		} else if (!activeFlag.equals(other.activeFlag))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (ipValue == null) {
			if (other.ipValue != null)
				return false;
		} else if (!ipValue.equals(other.ipValue))
			return false;
		if (lookupId == null) {
			if (other.lookupId != null)
				return false;
		} else if (!lookupId.equals(other.lookupId))
			return false;
		if (lookupName == null) {
			if (other.lookupName != null)
				return false;
		} else if (!lookupName.equals(other.lookupName))
			return false;
		return true;
	}
	
	
	
}
