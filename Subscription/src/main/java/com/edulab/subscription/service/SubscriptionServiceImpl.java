package com.edulab.subscription.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.dto.ServiceDetail;
import com.edulab.subscription.entity.Product;
import com.edulab.subscription.entity.ProductServices;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.repos.ProductRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductResponse>  findAllProducts() throws ResourceNotFoundException {

		try {
			List<Product> productList = productRepository.findAll();
			
			if(productList.size() == 0) {
				throw new ResourceNotFoundException("Offers Not Configured");
			}
					
			//List of OfferingResponse to be returned to Client
			List<ProductResponse> productResponseList = new ArrayList<>();
			
			productList.forEach(prod -> {
			  
			  ProductResponse productResponse = new ProductResponse();
			  
			  productResponse.setProductName(prod.getProductName());
			  productResponse.setProductCode(prod.getProductCode());
			  productResponse.setProductDesc(prod.getProductDesc());
			  productResponse.setProductPrice(prod.getPrice().doubleValue());
			  productResponse.setProductPriceUnit(prod.getPriceUnit());
			  productResponse.setProductCategory(prod.getProductCategory().getCategoryName());
			  productResponse.setValidity(prod.getProductValidity());
			  productResponse.setValidityUnit(prod.getProductValidityUnit());
			  
			  List<ProductServices> productServicesList = prod.getProductServiceList();
			  
			  List<ServiceDetail> prodDetailList = new ArrayList<>();
			  
			  productServicesList.forEach(service -> {
				  
				  ServiceDetail prodDtl = new  ServiceDetail();
			  
			  prodDtl.setServiceName( service.getService().getServiceName());
			  prodDtl.setServiceDesc(service.getService().getServiceDesc());
			  prodDtl.setLevelName(service.getService().getLevelName());
			  prodDtl.setExamFlag(service.getService().getExamFlag());
			  prodDtl.setExamDay(service.getService().getExamDay());
			  prodDtl.setExamQuantity(service.getService().getExamQuantity());
			  prodDtl.setAccessType(service.getServiceScope().getScopeMaster().getScopeName());
			  
			  prodDetailList.add(prodDtl);
			  
			  });
			  
			  productResponse.setServiceList(prodDetailList);
			  
			  logger.info("---------------------------------");
			  
			  productResponseList.add(productResponse);
			  
			  });
			 

			return productResponseList;
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error("Error occurred while getting all Offers", e);
			throw new ResourceNotFoundException("Offers Not Configured");
		}
	}
	
	
}
