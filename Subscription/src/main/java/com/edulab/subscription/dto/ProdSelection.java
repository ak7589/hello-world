package com.edulab.subscription.dto;

import java.util.List;

public class ProdSelection {
	
	private String memberId;
	
	private List<ProductDto> prodList;

	public ProdSelection() {
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<ProductDto> getProdList() {
		return prodList;
	}

	public void setProdList(List<ProductDto> prodList) {
		this.prodList = prodList;
	}

	@Override
	public String toString() {
		return "ProdSelection [memberId=" + memberId + ", prodList=" + prodList + "]";
	}
	
	
	
}
