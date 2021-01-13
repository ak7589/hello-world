package com.edulab.subscription.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Services")
public class Services implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long serviceId;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String serviceName;
	
	@Column(name="description")
	private String serviceDesc;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category serviceCategory;
	
	@Column(name="level_no")
	private Double levelNo;
	
	@Column(name="level_name")
	private String levelName;
	
	@Column(name="level_desc")
	private String levelDescription;
		
	@Column(name="exam_flag")
	private char examFlag;
	
	@Column(name="exam_day")
	private String examDay;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="price_unit")
	private String priceUnit;
	
	@Column(name="exam_quantity")
	private int examQuantity;
	
	@Column(name = "sys_created_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysCreatedDate;
	
	@Column(name = "sys_updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  sysUpdatedDate;

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public Category getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(Category serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public Double getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(Double levelNo) {
		this.levelNo = levelNo;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
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

	public int getExamQuantity() {
		return examQuantity;
	}

	public void setExamQuantity(int examQuantity) {
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
