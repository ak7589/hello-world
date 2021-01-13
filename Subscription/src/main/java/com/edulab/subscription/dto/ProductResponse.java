package com.edulab.subscription.dto;

import java.util.List;

public class ProductResponse {
	
	private String productName;
	private String productCode;
	private String productDesc;
	private Double productPrice;
	private String productPriceUnit;
	private String productCategory;
	private int validity;
	private String validityUnit;
	
	private List<ServiceDetail> serviceList;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPriceUnit() {
		return productPriceUnit;
	}

	public void setProductPriceUnit(String productPriceUnit) {
		this.productPriceUnit = productPriceUnit;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getValidityUnit() {
		return validityUnit;
	}

	public void setValidityUnit(String validityUnit) {
		this.validityUnit = validityUnit;
	}

	public List<ServiceDetail> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ServiceDetail> serviceList) {
		this.serviceList = serviceList;
	}
	
	
}
