package com.edulab.subscription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.exception.SubscriptionErrorResponse;
import com.edulab.subscription.exception.SubscriptionException;

@ControllerAdvice
public class SubscriptionRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> handleException(SubscriptionException exc) {
		
		// Create SubscriptionErrorResponse
		
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();
		
		error.setResStatus(HttpStatus.NOT_FOUND.value());
		error.setResMessage(exc.getErrorMessage());
				
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> handleException(Exception exc) {
		
		// Create SubscriptionErrorResponse
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();
		
		error.setResStatus(HttpStatus.BAD_REQUEST.value());
		error.setResMessage(exc.getMessage());
		
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	//extra
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<SubscriptionErrorResponse> handleAccessDenied(Exception exc) {
		
		// Create SubscriptionErrorResponse
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();
		
		error.setResStatus(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value());
		//error.setResMessage(exc.getMessage());
		error.setResMessage("Not Authorized");
		
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
	
	@ExceptionHandler
	public ResponseEntity<SubscriptionErrorResponse> handleException(ResourceNotFoundException exc) {
		
		// Create SubscriptionErrorResponse
		
		SubscriptionErrorResponse error = new SubscriptionErrorResponse();
		
		error.setResStatus(HttpStatus.NOT_FOUND.value());
		error.setResMessage(exc.getMessage());
				
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
