package com.edulab.subscription.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.dto.ProductResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.exception.SubscriptionException;
import com.edulab.subscription.service.MemberService;
import com.edulab.subscription.service.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/subscription")
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private MemberService memberServiceImpl;

	@ApiOperation(value = "Gets Product List", notes = "Returns Products configured in the System")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "Products Not Configured"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/products")
	public ResponseEntity<List<ProductResponse>> getProducts(@RequestBody Member member) throws Exception {
		
		try {
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			List<ProductResponse> productResponseList = productServiceImpl.findAllProducts();

			//Check if we have empty offer list
			if(productResponseList == null || productResponseList.size() == 0) {
				throw new SubscriptionException("Products Not Configured");
			}
			
			
			return new ResponseEntity<List<ProductResponse>>(productResponseList,HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Products not configured");
			throw e;
		}
				
	}
	
	@ApiOperation(value = "Gets Product Details", notes = "Returns Product details for the Passed Product Code")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "Products Not Configured"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/productDetailsByCode/{productCode}")
	public ResponseEntity<ProductResponse> getProductDetails(@RequestBody Member member,@PathVariable String productCode) throws Exception {
				
		try {
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			ProductResponse productResponse = productServiceImpl.findProductByCode(productCode);

			//Check if we have empty offer list
			if(productResponse == null) {
				throw new SubscriptionException("Product Not Configured");
			}
			
			return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.OK);
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
			logger.error("Product for passed product code not found");
			throw e;
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Product for passed product code not found, raising exception 222 ");
			throw e;
		}
				
	}
	
	@ApiOperation(value = "Gets Product which is not bought by user", notes = "Gets Product which is not bought by user")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "No Product Found for Member"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/productsNotPurchased/{member_id}")
	public ResponseEntity<List<ProductResponse>> getproductsNotPurchasedDetails(@RequestBody Member member,@PathVariable String member_id) throws Exception {
		
		try {
			logger.info("getproductsNotPurchasedDetails Start...");
			
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			
			logger.info("member_id  :::" + member_id);
			
			List<ProductResponse> productResponseList = productServiceImpl.getproductsNotPurchasedDetails(member_id);
			//Check if we have empty offer list
			if(productResponseList == null) {
				throw new SubscriptionException("Product Not Found");
			}
			
			logger.info("getproductsNotPurchasedDetails End....");
			
			return new ResponseEntity<List<ProductResponse>>(productResponseList,HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("No Product Found for Member");
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("No Product Found for Member");
			throw e;
		}
				
	}
	
}
