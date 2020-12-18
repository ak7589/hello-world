package com.edulab.subscription.service;

import java.util.List;

import com.edulab.subscription.entity.SubscriptionPlanProd;


public interface SubscriptionService {
	
	public List<SubscriptionPlanProd> findAllOfferings();

}
