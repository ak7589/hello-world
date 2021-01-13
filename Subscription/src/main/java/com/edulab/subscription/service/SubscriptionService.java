package com.edulab.subscription.service;

import java.util.List;

import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;


public interface SubscriptionService {
	
	public List<ProductResponse>  findAllProducts() throws ResourceNotFoundException;
	
}
