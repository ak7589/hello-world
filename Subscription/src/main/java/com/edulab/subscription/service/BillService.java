package com.edulab.subscription.service;

import java.util.List;

import com.edulab.subscription.dto.ProdSelection;
import com.edulab.subscription.entity.BillDetail;


public interface BillService {
	
	public List<BillDetail>  createOrderAndBill(ProdSelection productSelection);
	
}
