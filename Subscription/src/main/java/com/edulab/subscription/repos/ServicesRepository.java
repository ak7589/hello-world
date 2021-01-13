package com.edulab.subscription.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {
	
	List<Services> findByServiceName(String serviceName);

}
