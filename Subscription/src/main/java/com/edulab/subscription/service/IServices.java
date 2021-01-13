package com.edulab.subscription.service;

import java.util.List;

import com.edulab.subscription.dto.ServiceResponse;
import com.edulab.subscription.exception.ResourceNotFoundException;

public interface IServices {
	
	public List<ServiceResponse>  findAllServices() throws ResourceNotFoundException;

}
