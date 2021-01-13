package com.edulab.subscription.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public class ProductServiceImpl implements ProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductResponse> findAllProducts() {


		try {
			List<Product> productList = productRepository.findAll();

			// List of OfferingResponse to be returned to Client
			List<ProductResponse> productResponseList = new ArrayList<>();

			productList.forEach(prod -> {
				productResponseList.add(populateProductResponse(prod, false));
			});

			return productResponseList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred while getting all products", e);
			throw e;
		}
	}

	@Override
	public ProductResponse findProductByCode(String productCode) throws Exception {
		
		
		try {
			Optional<Product> productRes = productRepository.findByProductCode(productCode);
			
			if(productRes.isPresent()) {
				Product product = productRes.get();
				return populateProductResponse(product, true);
			}
			else {
				logger.error("Product for passed product code not found, raising exception");
				throw new Exception("Product Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred while getting all products", e);
			throw new ResourceNotFoundException("Product Not Found");
		}
		
		
	}
	
	@Override
	public List<ProductResponse> getproductsNotPurchasedDetails(String member_id) throws ResourceNotFoundException {
		try {
			List<Product> product = productRepository.getproductsNotPurchasedDetails(member_id);
			List<ProductResponse> productResponseList = new ArrayList<>();
			product.forEach(prod -> {
				productResponseList.add(populateProductResponse(prod, false));
			});

			return productResponseList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error occurred while getting all products", e);
			throw new ResourceNotFoundException("Error while retrieving product for Member");
		}
	}
	
	

	private ProductResponse populateProductResponse(Product product, boolean populateServiceName) {

		ProductResponse productResponse = new ProductResponse();

		productResponse.setProductName(product.getProductName());
		productResponse.setProductCode(product.getProductCode());
		productResponse.setProductDesc(product.getProductDesc());
		productResponse.setProductPrice(product.getPrice().doubleValue());
		productResponse.setProductPriceUnit(product.getPriceUnit());
		productResponse.setProductCategory(product.getProductCategory().getCategoryName());
		productResponse.setValidity(product.getProductValidity());
		productResponse.setValidityUnit(product.getProductValidityUnit());

		if (populateServiceName) {
			List<ProductServices> productServicesList = product.getProductServiceList();

			List<ServiceDetail> prodDetailList = new ArrayList<>();

			productServicesList.forEach(service -> {

				ServiceDetail prodDtl = new ServiceDetail();

				prodDtl.setServiceName(service.getService().getServiceName());
				prodDtl.setServiceDesc(service.getService().getServiceDesc());
				prodDtl.setLevelName(service.getService().getLevelName());
				prodDtl.setExamFlag(service.getService().getExamFlag());
				prodDtl.setExamDay(service.getService().getExamDay());
				prodDtl.setExamQuantity(service.getService().getExamQuantity());
				prodDtl.setAccessType(service.getServiceScope().getScopeMaster().getScopeName());

				prodDetailList.add(prodDtl);

			});

			productResponse.setServiceList(prodDetailList);
		}
		return productResponse;

	}

}
