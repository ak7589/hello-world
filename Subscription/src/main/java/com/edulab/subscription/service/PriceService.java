package com.edulab.subscription.service;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.dto.PriceResponse;
import com.edulab.subscription.dto.ProdSelection;


public interface PriceService {
	
	public PriceResponse getPrice(ProdSelection productSelection);
	
}
