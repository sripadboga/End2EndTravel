package com.lp.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lookup_item_data_table")
public class LookupItemDataEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "my_seq1", sequenceName = "lookup_item_data_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq1")
	@Column(name = "lookup_item_id")
	private Long lookupItemId;

	@Column(name = "lookup_item_name")
	private String lookupItemName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_id", nullable = false)
	private LookupDataEntity lookupId;

	@Column(name = "active_flag")
	private Character activeFlag;

	@Column(name = "created_user")
	private String createdUser;

	@Column(name = "ip_address")
	private String ipValue;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
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
