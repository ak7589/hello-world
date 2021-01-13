package com.edulab.subscription.dto;

public class ProductDto {
	
	private String productCode;
	private String productName;
	
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
	
	@Override
	public String toString() {
		return "ProductDto [productCode=" + productCode + ", productName=" + productName + "]";
	}
	

}
