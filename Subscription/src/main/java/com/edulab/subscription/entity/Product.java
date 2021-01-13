package com.edulab.subscription.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long productId;
	
	@Column(name="code")
	private String productCode;
	
	@Column(name="name")
	private String productName;
	
	@Column(name="description")
	private String productDesc;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category productCategory;
	
	@Column(name="type")
	private String productType;
	
	@Column(name="active")
	private char productActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_global_id")
	private ProductGlobal productGlobal;
		
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="price_unit")
	private String priceUnit;
	
	@Column(name="price_mode")
	private String priceMode;
	
	@Column(name="credit")
	private int credit;
	
	@Column(name="credit_unit")
	private String creditUnit;
	
	@Column(name="credit_mode")
	private String creditMode;
	
	@Column(name="free_period")
	private int freePeriod;
	
	@Column(name="free_period_unit")
	private String freePeriodUnit;
	
	@Column(name="validity")
	private Integer productValidity;
	
	@Column(name="validity_unit")
	private String productValidityUnit;
	
	@Column(name = "plan_start_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  productStartDate;
	
	@Column(name = "plan_end_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  productEndDate;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;
	
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	private List<ProductServices> productServiceList;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public char getProductActive() {
		return productActive;
	}

	public void setProductActive(char productActive) {
		this.productActive = productActive;
	}

	public ProductGlobal getProductGlobal() {
		return productGlobal;
	}

	public void setProductGlobal(ProductGlobal productGlobal) {
		this.productGlobal = productGlobal;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
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

	public String getCreditUnit() {
		return creditUnit;
	}

	public void setCreditUnit(String creditUnit) {
		this.creditUnit = creditUnit;
	}

	public String getCreditMode() {
		return creditMode;
	}

	public void setCreditMode(String creditMode) {
		this.creditMode = creditMode;
	}

	public int getFreePeriod() {
		return freePeriod;
	}

	public void setFreePeriod(int freePeriod) {
		this.freePeriod = freePeriod;
	}

	public String getFreePeriodUnit() {
		return freePeriodUnit;
	}

	public void setFreePeriodUnit(String freePeriodUnit) {
		this.freePeriodUnit = freePeriodUnit;
	}
	

	public Integer getProductValidity() {
		return productValidity;
	}

	public void setProductValidity(Integer productValidity) {
		this.productValidity = productValidity;
	}

	public String getProductValidityUnit() {
		return productValidityUnit;
	}

	public void setProductValidityUnit(String productValidityUnit) {
		this.productValidityUnit = productValidityUnit;
	}


	public LocalDateTime getProductStartDate() {
		return productStartDate;
	}

	public void setProductStartDate(LocalDateTime productStartDate) {
		this.productStartDate = productStartDate;
	}	
	

	public LocalDateTime getProductEndDate() {
		return productEndDate;
	}

	public void setProductEndDate(LocalDateTime productEndDate) {
		this.productEndDate = productEndDate;
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

	public List<ProductServices> getProductServiceList() {
		return productServiceList;
	}

	public void setProductServiceList(List<ProductServices> productServiceList) {
		this.productServiceList = productServiceList;
	}
	
		
}
