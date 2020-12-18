package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.ProductLevel;

public interface ProductLevelRepository extends JpaRepository<ProductLevel, Integer> {

}
