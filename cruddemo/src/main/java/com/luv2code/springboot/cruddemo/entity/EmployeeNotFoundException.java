package com.luv2code.springboot.cruddemo.entity;

public class EmployeeNotFoundException extends RuntimeException {
	
	private String errorMessage;
	

	public EmployeeNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
