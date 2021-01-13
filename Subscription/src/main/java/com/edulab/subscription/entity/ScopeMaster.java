package com.edulab.subscription.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Scope_Master")
public class ScopeMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long scopeMasterId;
	
	@Column(name="name")
	private String scopeName;
	
	@Column(name="description")
	private String scopeDesc;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	@OneToOne(mappedBy = "scopeMaster")
	private ServiceScopes serviceScopes;

	public long getScopeMasterId() {
		return scopeMasterId;
	}

	public void setScopeMasterId(long scopeMasterId) {
		this.scopeMasterId = scopeMasterId;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public String getScopeDesc() {
		return scopeDesc;
	}

	public void setScopeDesc(String scopeDesc) {
		this.scopeDesc = scopeDesc;
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

	public ServiceScopes getServiceScopes() {
		return serviceScopes;
	}

	public void setServiceScopes(ServiceScopes serviceScopes) {
		this.serviceScopes = serviceScopes;
	}

}
