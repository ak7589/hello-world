package com.edulab.subscription.controller.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edulab.subscription.dto.Member;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.service.MemberService;
import com.edulab.subscription.service.ServicesImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/subscription")
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ServicesImpl serviceImpl;
	
	@Autowired
	private MemberService memberServiceImpl;

	
	
	@ApiOperation(value = "Gets Service for the passed service code", notes = "Returns Service for the passed service code")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "Service Not Configured"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/testing/{testId}")
	public ResponseEntity<String> getServiceByCode(
			@RequestBody Member member,@PathVariable String testId,
			@RequestParam(required=false) Map<String,String> qparams) throws Exception {
		
		try {
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			logger.info("TestID Received ::::: " + testId);
			
			if(!qparams.isEmpty()) 
			{
				qparams.forEach((a,b) -> {
					logger.info("Value of Key ::: " + a);
					logger.info("Value of Key-Value ::: " + b);
				});
			}
			else {
				logger.info("Query Parameeter not passed...Consider all Records");
			}
			
			
			
									
			return new ResponseEntity<String>("This is Just a Test",HttpStatus.OK);
			
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
			logger.error("Services not configured");
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Services not configured");
			throw e;
		}
				
	}
	
	
}
