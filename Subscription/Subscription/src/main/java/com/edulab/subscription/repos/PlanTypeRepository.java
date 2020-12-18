package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.PlanType;

public interface PlanTypeRepository extends JpaRepository<PlanType, Long> {

}
