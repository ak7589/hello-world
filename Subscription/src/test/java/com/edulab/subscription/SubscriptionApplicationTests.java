package com.edulab.subscription;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edulab.subscription.entity.OrderDetail;
import com.edulab.subscription.entity.Orders;
import com.edulab.subscription.entity.Product;
import com.edulab.subscription.entity.ProductServices;
import com.edulab.subscription.repos.OrderDetailRepository;
import com.edulab.subscription.repos.OrderRepository;
import com.edulab.subscription.repos.ProductRepository;

@SpringBootTest
class SubscriptionApplicationTests {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllOfferings() {
		
		
		List<Product> productList = productRepository.findAll();
		
		System.out.println("SubscriptionPlan List Size ::: " + productList.size());
		
		productList.forEach(prod -> {
			System.out.println("Product Name : " + prod.getProductName());
			System.out.println("Product Desc : " + prod.getProductDesc());
			
			 List<ProductServices> productServicesList = prod.getProductServiceList();
			 
			 productServicesList.forEach(prodService -> {
				 System.out.println(prodService.getService().getServiceName());
				 System.out.println(prodService.getService().getServiceDesc());
				
			 });
			 
		});
	}
	
	
	@Test
	public void testOrders() {
		
		//Populate Orders table
		Orders order = new Orders();
		
		order.setMemberId("kk9876");
		order.setActive('Y');
		
		LocalDateTime datetime1 = LocalDateTime.now(); 
		 
		order.setStartDate(datetime1);
		order.setEndDate(datetime1);
		
		//Populate OrderDetail table
		
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		//Order1
		OrderDetail orderDetail1 = new OrderDetail();
		
		orderDetail1.setOrder(order);
		orderDetail1.setProductId(1);
		
		//Order2
		OrderDetail orderDetail2 = new OrderDetail();
				
		orderDetail2.setOrder(order);
		orderDetail2.setProductId(2);
		
		//Order3
		OrderDetail orderDetail3 = new OrderDetail();
						
		orderDetail3.setOrder(order);
		orderDetail3.setProductId(3);
		
		//Add to OrderDetailList
		orderDetailList.add(orderDetail1);
		orderDetailList.add(orderDetail2);
		orderDetailList.add(orderDetail3);
		
		
		orderDetailRepository.saveAll(orderDetailList);
		
	}
	

}
