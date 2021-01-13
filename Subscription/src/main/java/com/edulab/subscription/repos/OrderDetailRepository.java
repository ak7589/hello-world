package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
