package com.edulab.subscription.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.dto.PriceResponse;
import com.edulab.subscription.dto.ProdSelection;
import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.exception.SubscriptionException;
import com.edulab.subscription.service.BillServiceImpl;
import com.edulab.subscription.service.MemberService;
import com.edulab.subscription.service.PriceServiceImpl;
import com.edulab.subscription.service.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/subscription")
public class BillController {
	
	Logger logger = LoggerFactory.getLogger(BillController.class);
	
		
	@Autowired
	private MemberService memberServiceImpl;
	
	@Autowired
	private BillServiceImpl billServiceImpl;

	
	@PostMapping("/generatebill")
	public ResponseEntity<String> generateBill(@RequestBody ProdSelection productSelection) throws Exception {
		
		try {
			
			System.out.println("Product Selection From Customer ..." + productSelection);
			
			//PriceResponse priceResponse = priceServiceImpl.getPrice(productSelection);
			
			//return new ResponseEntity<PriceResponse>(priceResponse,HttpStatus.OK);
			
			billServiceImpl.createOrder(productSelection);
			
			return new ResponseEntity<String>("generateBill in BillController",HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Products not configured");
			throw e;
		}
				
	}
	
}
