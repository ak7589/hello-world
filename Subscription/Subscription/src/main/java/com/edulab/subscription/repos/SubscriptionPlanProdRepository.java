package com.edulab.subscription.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.SubscriptionPlanProd;


public interface SubscriptionPlanProdRepository extends JpaRepository<SubscriptionPlanProd, Long> {
	
	List<SubscriptionPlanProd> findByPlanId(Long planId);
	
}
