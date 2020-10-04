package com.amit.springdata.springdatajparnd.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.amit.springdata.springdatajparnd.entity.Product;
import java.lang.String;
import java.util.List;

//public interface ProductRepository extends CrudRepository<Product, Integer> {
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	List<Product> findByName(String name);
	List<Product> findByNameAndDesc(String name, String desc);
	List<Product> findByPriceGreaterThan(double price);
	List<Product> findByDescContains(String contains);
	List<Product> findByPriceIsBetween(Double price1, Double price2);
	List<Product> findByDescLike(String pattern);
	
	Page<Product> findAll(Pageable pageable);
	
}
