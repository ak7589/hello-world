package com.edulab.subscription.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.ProdSelection;
import com.edulab.subscription.dto.ProductDto;
import com.edulab.subscription.entity.BillDetail;
import com.edulab.subscription.entity.Bills;
import com.edulab.subscription.entity.OrderDetail;
import com.edulab.subscription.entity.Orders;
import com.edulab.subscription.entity.Product;
import com.edulab.subscription.repos.BillDetailRepository;
import com.edulab.subscription.repos.OrderDetailRepository;
import com.edulab.subscription.repos.ProductRepository;
import com.edulab.subscription.service.utils.ProductUtils;

@Service
public class BillServiceImpl implements BillService {
	
	Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	BillDetailRepository billDetailRepository;

	
	@Override
	public List<BillDetail>  createOrderAndBill(ProdSelection productSelection) {
		// TODO Auto-generated method stub

		//Requesting MemberId
		
		try {
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
			List<BillDetail> billDetailList = new ArrayList<>();
			
			
			productList.forEach(prod -> {
				
				OrderDetail orderDetail = new OrderDetail();
				BillDetail billDetail = new BillDetail();
				
				orderDetail.setOrder(order);
				
				//Set Product Id in orderDetail
				orderDetail.setProductId(prod.getProductId());
				//Set Product Id in billDetail
				billDetail.setProductId(prod.getProductId());
				
				
				//Write code for generating transaction id
				orderDetail.setTransactionId(ProductUtils.getTransactionId(memberId, prod.getProductCode()));
				
				//Set transaction id in BillDetail also
				billDetail.setTransactionId(orderDetail.getTransactionId());
				
				
				if(prod.getProductName().equalsIgnoreCase("PRIME") || prod.getProductName().equalsIgnoreCase("UNLIMITED"))
				{
					orderDetail.setSubscriptionFlag('Y');
					billDetail.setSubscriptionFlag('Y');
				}
				else {
					orderDetail.setSubscriptionFlag('N');
					billDetail.setSubscriptionFlag('N');
				}
				
				orderDetail.setActiveFlag('N');
				
				//Set Price of the product
				billDetail.setPriceCharged(prod.getPrice());
				
				//Start Date and End date is dummy -- do it later
				LocalDateTime startDate = LocalDateTime.now();
				orderDetail.setStartDate(startDate);
				
				LocalDateTime endDate = LocalDateTime.now();
				orderDetail.setEndDate(endDate);
				
				//Product expiry date in the Bill detail table
				//TODO -- Complete logic
				billDetail.setProductExpiryDate(endDate);
				
				//Added orderDetail to the list
				orderDetailList.add(orderDetail);
				
				//Add billDetail to the billDetailList
				billDetailList.add(billDetail);
				
			});
			
			//Save record in Orders and Order_Detail table
			List<OrderDetail> orderDetailRecords = orderDetailRepository.saveAll(orderDetailList);
			
			logger.info("Order ID ::: " + orderDetailRecords.get(0).getOrder().getOrderId());
			
			//Create Bill table record now
			Bills bill = new Bills();
			
			//Set Order_ID
			bill.setOrder_id(orderDetailRecords.get(0).getOrder().getOrderId());
			//Set Member_Id
			bill.setMemberId(memberId);
			
			//Calculate total Bill after summing individual price of all products
			double totalBill = billDetailList.stream()
								.mapToDouble(billDetail -> billDetail.getPriceCharged().doubleValue())
								.sum();
			
			//Set Bill amount
			bill.setAmount(new BigDecimal(totalBill));
			
			//Set bill status - initial status is PENDING
			bill.setStatus("PENDING");
			
			//TODO ::: ---
			//Set all dates in the Bill table
			bill.setBillDate(orderDate);
			bill.setDueDate(orderDate);
			
			//Set bill object in the all BillDetail objects
			for(BillDetail billDetail : billDetailList) {
				billDetail.setBills(bill);
			}
	
			//Save record in Bills and Bill_Detail table
			List<BillDetail> billRecords = billDetailRepository.saveAll(billDetailList);
			
			return billRecords;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error occurred while saving order details", e);
			throw e;
		}

		
	}

}
