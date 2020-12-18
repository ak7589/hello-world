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
@Table(name = "Plan_Type")
public class PlanType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="plan_type_id")
	private long planTypeId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="plan_active")
	private char planActive;
	
	@Column(name="discount_id")
	private int discountId;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	//@OneToOne(mappedBy = "planType")
	//private SubscriptionPlan subscriptionPlan;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public char getPlanActive() {
		return planActive;
	}

	public void setPlanActive(char planActive) {
		this.planActive = planActive;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
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
