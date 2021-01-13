package com.edulab.subscription.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.PriceResponse;
import com.edulab.subscription.dto.ProdSelection;
import com.edulab.subscription.dto.ProductDto;
import com.edulab.subscription.entity.Product;
import com.edulab.subscription.repos.ProductRepository;

@Service
public class PriceServiceImpl implements PriceService {
	
	Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public PriceResponse getPrice(ProdSelection productSelection) {
		// TODO Auto-generated method stub
		
		logger.info("Product Selection By Member : " + productSelection);
		
		List<ProductDto> productDto = productSelection.getProdList();
		
		List<String> productCodes = new ArrayList<>();
		
		
		productDto.forEach(prodDto -> {
			productCodes.add(prodDto.getProductCode());
		});
		
		List<Product> productList = productRepository.findByProductCodeIn(productCodes);
		
		logger.info("Product List Size ::: " + productList.size());
		
		List<Long> productIds = new ArrayList<>();
		
		productList.forEach(prod -> {
			productIds.add(prod.getProductId());
		});
		
		//DO Price calculation
		
		double price = 0.0;
		//Write a normal for-each loop
		for(Product tmpProd : productList) {
			
			logger.info("Product Name " + tmpProd.getProductName() + " : Price : " + tmpProd.getPrice().doubleValue() );
			price += tmpProd.getPrice().doubleValue();
		}
		
		PriceResponse priceResponse = new PriceResponse();
		
		priceResponse.setTotalPrice(price);
		priceResponse.setPriceUnit(productList.get(0).getPriceUnit());
		
		logger.info("Final Price : " + price);
		
		return priceResponse;
	}

}
