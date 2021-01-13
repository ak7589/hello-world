package com.edulab.subscription.controller.rest;

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
import com.edulab.subscription.dto.ServiceResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.service.MemberService;
import com.edulab.subscription.service.ServicesImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/subscription")
public class ServiceController {
	
	Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServicesImpl serviceImpl;
	
	@Autowired
	private MemberService memberServiceImpl;

	@ApiOperation(value = "Gets Service List", notes = "Returns all Services configured in the System")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request, Member not found"),
			@ApiResponse(code = 401, message = "Member Not Authorized"),
			@ApiResponse(code = 404, message = "Products Not Configured"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/services")
	public ResponseEntity<List<ServiceResponse>> getProducts(@RequestBody Member member) throws Exception {
		
		try {
			//Check if we have a valid member
			if(!memberServiceImpl.isValidMember(member)) {
				throw new Exception("Member Not Found");
			}
			
			List<ServiceResponse> serviceResponseList = serviceImpl.findAllServices();

						
			return new ResponseEntity<List<ServiceResponse>>(serviceResponseList,HttpStatus.OK);
			
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
