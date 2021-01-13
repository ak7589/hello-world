package com.edulab.subscription.service;

import java.util.List;

import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;


public interface ProductService {
	
	public List<ProductResponse>  findAllProducts();

	public ProductResponse findProductByCode(String productCode) throws Exception;

	public List<ProductResponse> getproductsNotPurchasedDetails(String member_id) throws ResourceNotFoundException;

	
}
