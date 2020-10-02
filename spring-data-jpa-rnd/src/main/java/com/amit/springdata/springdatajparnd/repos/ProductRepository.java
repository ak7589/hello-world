package com.amit.springdata.springdatajparnd.repos;

import org.springframework.data.repository.CrudRepository;

import com.amit.springdata.springdatajparnd.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
