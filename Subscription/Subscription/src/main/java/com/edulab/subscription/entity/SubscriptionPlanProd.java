package com.edulab.subscription.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription_Plan_Prod")
public class SubscriptionPlanProd implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subs_plan_prod_id")
	private long subsPlanProdId;
	
	@Column(name="plan_id", insertable=false , updatable=false)
	private long planId;
	
	//plan_id foreign key
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plan_id")
	private SubscriptionPlan subsPlan;
		
	//product_id foreign key
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	
	//product_service_id foreign key
	//@OneToOne(cascade=CascadeType.ALL)
	//@OneToMany
	//private List<ProductServices> prodServicesList;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_service_id")
	ProductServices productServices;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;

	public long getSubsPlanProdId() {
		return subsPlanProdId;
	}

	public void setSubsPlanProdId(long subsPlanProdId) {
		this.subsPlanProdId = subsPlanProdId;
	}

	public SubscriptionPlan getSubsPlan() {
		return subsPlan;
	}

	public void setSubsPlan(SubscriptionPlan subsPlan) {
		this.subsPlan = subsPlan;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public ProductServices getProductServices() {
		return productServices;
	}

	public void setProductServices(ProductServices productServices) {
		this.productServices = productServices;
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

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	
	
	
}
