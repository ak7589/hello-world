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
@Table(name = "Product_Level")
public class ProductLevel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="level_id")
	private long levelId;
	
	@Column(name="level_name")
	private String levelName;
	
	@Column(name="Product_name")
	private String productName;
	
	@Column(name="level_no")
	private Double levelNo;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	//@OneToOne(mappedBy = "prodLevel")
	//private Product product;

	
	public long getLevelId() {
		return levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(Double levelNo) {
		this.levelNo = levelNo;
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
	 * public Product getProduct() { return product; }
	 * 
	 * public void setProduct(Product product) { this.product = product; }
	 */
	
	

}
