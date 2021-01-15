package com.edulab.subscription.service;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.dto.PriceResponse;
import com.edulab.subscription.dto.ProdSelection;


public interface BillService {
	
	public void createOrder(ProdSelection productSelection);
	
}
