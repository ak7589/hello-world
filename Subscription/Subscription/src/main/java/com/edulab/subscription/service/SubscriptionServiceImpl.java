package com.edulab.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.entity.SubscriptionPlanProd;
import com.edulab.subscription.repos.SubscriptionPlanProdRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionPlanProdRepository subsPlanProdRepository;

	@Override
	public List<SubscriptionPlanProd> findAllOfferings() {

		List<SubscriptionPlanProd> subsPlanProdList = subsPlanProdRepository.findAll();

		System.out.println("SubscriptionPlanProd Size ::: " + subsPlanProdList.size());

		subsPlanProdList.forEach(tmp -> {

			System.out.println("Subs_Plan_Prod_Id ::: " + tmp.getSubsPlanProdId());
			System.out.println("Plan Name : " + tmp.getSubsPlan().getPlanType().getPlanName());
			System.out.println("Plan_Active : " + tmp.getSubsPlan().getPlanType().getPlanActive());
			System.out.println("Product Associated : " + tmp.getProduct().getProductName());
			System.out.println("Product Level : " + tmp.getProduct().getProdLevel().getLevelName());
			System.out.println("Product Category : " + tmp.getProduct().getProdCategory().getCategoryName());
			System.out.println(
					"Associated Product Service Name: " + tmp.getProductServices().getServiceMaster().getServiceName());
			System.out.println("Associated Product Service Description : "
					+ tmp.getProductServices().getServiceMaster().getServiceDesc());

			System.out.println("----------------------------------------------------------------------------");

		});

		return subsPlanProdList;
	}

}
