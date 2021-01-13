package com.edulab.subscription.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.service.MemberService;
import com.edulab.subscription.service.SubscriptionServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionRestController {
	
	Logger logger = LoggerFactory.getLogger(SubscriptionRestController.class);
	
	@Autowired
	private SubscriptionServiceImpl subscriptionServiceImpl;
	
	@Autowired
	private MemberService memberServiceImpl;

	@ApiOperation(value = "Gets Offer List", notes = "Returns Offers configured in the System")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "Offer Not Configured"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/offering")
	public ResponseEntity<List<ProductResponse>> getOffering(@RequestBody Member member) throws Exception {
		
	
		try {
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			List<ProductResponse> productResponseList = subscriptionServiceImpl.findAllProducts();
			
			return new ResponseEntity<List<ProductResponse>>(productResponseList,HttpStatus.OK);
			
		}catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Offers not configured");
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Offers not configured");
			throw e;
		}
				
	}
	
}
