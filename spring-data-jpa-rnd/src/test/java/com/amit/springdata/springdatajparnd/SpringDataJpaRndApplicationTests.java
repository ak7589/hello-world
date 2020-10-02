package com.amit.springdata.springdatajparnd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.springdata.springdatajparnd.entity.Product;
import com.amit.springdata.springdatajparnd.repos.ProductRepository;

@SpringBootTest
class SpringDataJpaRndApplicationTests { 
	
	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		
		Product prod = new Product();
		
		prod.setId(1);
		prod.setName("Iphone");
		prod.setDesc("Phone from Apple");
		prod.setPrice(10000d);
		
		Product tmp = repository.save(prod);
		
		assertNotNull(tmp);
		assertEquals("Iphone",tmp.getName());
	
		
	}
	
	@Test
	public void testRead() {
		Optional<Product> prodOpt = repository.findById(1);
		
		if(prodOpt.isPresent()) {
			
			Product prod = prodOpt.get();
			
			assertEquals("Iphone",prod.getName());
			
		}
	}
	
	@Test
	public void testUpdate() {
		
	}

}
