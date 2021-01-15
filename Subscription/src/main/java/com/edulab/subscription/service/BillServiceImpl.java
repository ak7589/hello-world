package com.edulab.subscription.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.ProdSelection;
import com.edulab.subscription.dto.ProductDto;
import com.edulab.subscription.entity.OrderDetail;
import com.edulab.subscription.entity.Orders;
import com.edulab.subscription.entity.Product;
import com.edulab.subscription.repos.OrderDetailRepository;
import com.edulab.subscription.repos.ProductRepository;
import com.edulab.subscription.service.utils.ProductUtils;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public void createOrder(ProdSelection productSelection) {
		// TODO Auto-generated method stub

		//Requesting MemberId
		
		String memberId = productSelection.getMemberId();
		
		//Populate Orders table
		Orders order = new Orders();
		
		order.setMemberId(productSelection.getMemberId());
		order.setOrderStatus("ADDED_TO_CART");
		
		LocalDateTime orderDate = LocalDateTime.now();
		order.setOrderDate(orderDate);
		
		
		//Populate OrderDetail table
		
		List<String> productCodes = new ArrayList<>();
		
		//Loop over passed product list
		List<ProductDto> prodDtoList = productSelection.getProdList();
		
		prodDtoList.forEach(prodDto -> {
			productCodes.add(prodDto.getProductCode());
		});
		
		List<Product> productList = productRepository.findByProductCodeIn(productCodes);
		
		
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		
		
		productList.forEach(prod -> {
			
			OrderDetail orderDetail = new OrderDetail();
			
			orderDetail.setOrder(order);
			orderDetail.setProductId(prod.getProductId());
			//Write code for generating transaction id
			
			//TODO --start
			orderDetail.setTransactionId(ProductUtils.getTransactionId(memberId, prod.getProductCode()));
			//TODO --end
			
			
			if(prod.getProductName().equalsIgnoreCase("PRIME") || prod.getProductName().equalsIgnoreCase("UNLIMITED"))
			{
				orderDetail.setSubscriptionFlag('Y');
			}
			orderDetail.setActiveFlag('N');
			
			//Start Date and End date is dummy -- do it later
			LocalDateTime startDate = LocalDateTime.now();
			orderDetail.setStartDate(startDate);
			
			LocalDateTime endDate = LocalDateTime.now();
			orderDetail.setEndDate(endDate);
			
			//Added orderDetail to the list
			orderDetailList.add(orderDetail);
			
		});
				
		orderDetailRepository.saveAll(orderDetailList);

		
	}

}
