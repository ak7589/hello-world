package com.edulab.subscription.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Service_Scope")
public class ServiceScopes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long serviceScopeId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_id")
	private Services service;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="scope_master_id")
	private ScopeMaster scopeMaster;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;

	public long getServiceScopeId() {
		return serviceScopeId;
	}

	public void setServiceScopeId(long serviceScopeId) {
		this.serviceScopeId = serviceScopeId;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public ScopeMaster getScopeMaster() {
		return scopeMaster;
	}

	public void setScopeMaster(ScopeMaster scopeMaster) {
		this.scopeMaster = scopeMaster;
	}

	public LocalDateTime getSysCreatedDate() {
		return sysCreatedDate;
	}

	public void setSysCreatedDate(LocalDateTime sysCreatedDate) {
		this.sysCreatedDate = sysCreatedDate;
	}

	public LocalDateTime getSysUpdatedDate() {
		return sysUpdatedDate;
	}

	public void setSysUpdatedDate(LocalDateTime sysUpdatedDate) {
		this.sysUpdatedDate = sysUpdatedDate;
	}

}
