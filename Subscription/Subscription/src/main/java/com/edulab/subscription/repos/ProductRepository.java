package com.edulab.subscription.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edulab.subscription.entity.Product;

//public interface ProductRepository extends CrudRepository<Product, Long> {
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByProductName(String productName);

}
