package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.Bills;

public interface BillsRepository extends JpaRepository<Bills, Integer> {

}
