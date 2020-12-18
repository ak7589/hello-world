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
@Table(name = "Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private ProductCategory prodCategory;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="level_id")
	private ProductLevel prodLevel;
	
	@Column(name="exam_flag")
	private char examFlag;
	
	@Column(name="exam_day")
	private String examDay;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="exam_quantity")
	private long examQuantity;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(ProductCategory prodCategory) {
		this.prodCategory = prodCategory;
	}

	public ProductLevel getProdLevel() {
		return prodLevel;
	}

	public void setProdLevel(ProductLevel prodLevel) {
		this.prodLevel = prodLevel;
	}

	public char getExamFlag() {
		return examFlag;
	}

	public void setExamFlag(char examFlag) {
		this.examFlag = examFlag;
	}

	public String getExamDay() {
		return examDay;
	}

	public void setExamDay(String examDay) {
		this.examDay = examDay;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getExamQuantity() {
		return examQuantity;
	}

	public void setExamQuantity(long examQuantity) {
		this.examQuantity = examQuantity;
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
