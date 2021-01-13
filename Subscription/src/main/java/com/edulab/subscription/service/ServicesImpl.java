package com.edulab.subscription.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.ServiceResponse;
import com.edulab.subscription.entity.Services;
import com.edulab.subscription.exception.ResourceNotFoundException;
import com.edulab.subscription.repos.ServicesRepository;

@Service
public class ServicesImpl implements IServices {

	Logger logger = LoggerFactory.getLogger(ServicesImpl.class);
	
	@Autowired
	private ServicesRepository serviceRepository;

	@Override
	public List<ServiceResponse> findAllServices() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			List<Services> serviceList = serviceRepository.findAll();
			
			//Check if we have received Services from database
			if(serviceList.size() == 0) {
				throw new ResourceNotFoundException("Services Not Configured");
			}
		
			List<ServiceResponse> serviceResponseList = new ArrayList<>();
			
			serviceList.forEach(service -> {
				
				ServiceResponse serviceResponse = new ServiceResponse();
				
				serviceResponse.setServiceId(service.getServiceId());
				serviceResponse.setServiceCode(service.getCode());
				serviceResponse.setServiceName(service.getServiceName());
				serviceResponse.setServiceDesc(service.getServiceDesc());
				serviceResponse.setServiceCategory(service.getServiceCategory().getCategoryName());
				serviceResponse.setLevelNo(service.getLevelNo());
				serviceResponse.setLevelName(service.getLevelName());
				serviceResponse.setLevelDescription(service.getLevelDescription());
				
				serviceResponseList.add(serviceResponse);
				
			});
					
			return serviceResponseList;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error occurred while getting all services", e);
			throw new ResourceNotFoundException("Services Not Configured");
			
		}
	}

}
