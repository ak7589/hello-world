package com.edulab.subscription.exception;

public class ResourceNotFoundException extends Exception 
{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 
