package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.BillDetail;

public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

}
