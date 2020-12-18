package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.ServiceMaster;

public interface ServiceMasterRespository extends JpaRepository<ServiceMaster, Long> {

}
