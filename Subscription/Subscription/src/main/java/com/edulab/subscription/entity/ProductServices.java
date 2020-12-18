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
@Table(name = "Product_Services")
public class ProductServices implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_service_id")
	private long productServiceId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_id")
	private ServiceMaster serviceMaster;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	/*
	 * @OneToOne(mappedBy = "prodServicess") private SubscriptionPlanProd
	 * subsPlanProd;
	 */

	public long getProductServiceId() {
		return productServiceId;
	}

	public void setProductServiceId(long productServiceId) {
		this.productServiceId = productServiceId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ServiceMaster getServiceMaster() {
		return serviceMaster;
	}

	public void setServiceMaster(ServiceMaster serviceMaster) {
		this.serviceMaster = serviceMaster;
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

	/*
	 * public SubscriptionPlanProd getSubsPlanProd() { return subsPlanProd; }
	 * 
	 * public void setSubsPlanProd(SubscriptionPlanProd subsPlanProd) {
	 * this.subsPlanProd = subsPlanProd; }
	 */
	
	
}
