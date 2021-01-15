package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
