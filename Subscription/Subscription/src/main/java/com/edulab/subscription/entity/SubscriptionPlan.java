package com.edulab.subscription.entity;

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
@Table(name = "Subscription_Plan")
public class SubscriptionPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="plan_id")
	private long planId;
	
	//@Column(name="plan_type_id")
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plan_type_id")
	private PlanType planType;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="price_mode")
	private String priceMode;
	
	@Column(name="credit")
	private int credit;
	
	@Column(name="credit_mode")
	private String creditMode;
	
	@Column(name="free_period")
	private String freePeriod;
	
	@Column(name="discount")
	private Double discount;
	
	@Column(name = "plan_start_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  planStartDate;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
		
	
	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPriceMode() {
		return priceMode;
	}

	public void setPriceMode(String priceMode) {
		this.priceMode = priceMode;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCreditMode() {
		return creditMode;
	}

	public void setCreditMode(String creditMode) {
		this.creditMode = creditMode;
	}

	public String getFreePeriod() {
		return freePeriod;
	}

	public void setFreePeriod(String freePeriod) {
		this.freePeriod = freePeriod;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public LocalDateTime getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDateTime planStartDate) {
		this.planStartDate = planStartDate;
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
