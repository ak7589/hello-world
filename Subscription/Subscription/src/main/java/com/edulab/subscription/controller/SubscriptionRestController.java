package com.edulab.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edulab.subscription.entity.SubscriptionPlanProd;
import com.edulab.subscription.service.SubscriptionServiceImpl;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class SubscriptionRestController {
	
	@Autowired
	private SubscriptionServiceImpl subscriptionServiceImpl;

	@ApiOperation(value = "Find Current Loggedin User", notes = "Returns current user")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Not authenticated"),
			@ApiResponse(code = 403, message = "Not authorized to see user"),
			@ApiResponse(code = 404, message = "Current user not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	// @RequestMapping(method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/offering")
	//List<SubscriptionPlanProd> getOffering() {
	public String getOffering() {
		
		//return subscriptionServiceImpl.findAllOfferings();
		subscriptionServiceImpl.findAllOfferings();
		return "Testing in Progress...";
		
	}
}
