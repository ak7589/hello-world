package com.amit.springdata.springdatajparnd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.amit.springdata.springdatajparnd.entity.Employee;
import com.amit.springdata.springdatajparnd.entity.Product;
import com.amit.springdata.springdatajparnd.repos.EmployeeRepository;
import com.amit.springdata.springdatajparnd.repos.ProductRepository;

@SpringBootTest
class SpringDataJpaRndApplicationTests { 
	
	@Autowired
	ProductRepository prodRepository;
	
	@Autowired
	EmployeeRepository empRepository;

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
		
		Product tmp = prodRepository.save(prod);
		
		assertNotNull(tmp);
		assertEquals("Iphone",tmp.getName());
	
		
	}
	
	@Test
	public void testRead() {
		Optional<Product> prodOpt = prodRepository.findById(1);
		
		if(prodOpt.isPresent()) {
			
			Product prod = prodOpt.get();
			
			assertEquals("IWatch",prod.getName());
			
		}
	}
	
	@Test
	public void testUpdate() {
		
		Optional<Product> prodOpt = prodRepository.findById(1);
		
		Product prod = null;
		if(prodOpt.isPresent()) {
			
			prod = prodOpt.get();
			
			//Update price
			prod.setPrice(1200d);
			
			//save to db
			prodRepository.save(prod);
				
		}
		
	}
	
	@Test
	public void testDelete() {
		if (prodRepository.existsById(1)) {
			prodRepository.deleteById(1);
		}
	}
	
	@Test
	public void testCount() {
		System.out.println("Total No of records : " + prodRepository.count());
	}
	
	@Test
	public void testFindByName() {
		
		List<Product> prdList = prodRepository.findByName("IWatch");
		
		System.out.println("Before forEach...");
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("After forEach...");
		System.out.println();
		
	}
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> prdList = prodRepository.findByNameAndDesc("TV", "From Samsung Inc");
		System.out.println("Before forEach...");
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("After forEach...");
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> prdList = prodRepository.findByPriceGreaterThan(1200d);
		
		System.out.println("Before forEach...");
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("After forEach...");
		
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> prdList = prodRepository.findByDescContains("LG Inc");
		
		System.out.println("Before forEach...");
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("After forEach...");
		
	}
	
	// List<Product> findByPriceIsBetween(Double price1, Double price2);
	
	@Test
	public void testFindByPriceIsBetween() {
		List<Product> prdList = prodRepository.findByPriceIsBetween(1200d,2500d);
		
		System.out.println("Before forEach...");
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("After forEach...");
	}
	
	//Page<Product> findAll(Pageable pageable);
	
	@Test
	public void testFindAllPaging() {
		//Lets first check how many records are there in DB
		long totCount = prodRepository.count();
		int no_of_recs =1;
		
		long totalPages = totCount / no_of_recs;
		
		Sort sort = Sort.by("name");
		
		for(int pageNo =0; pageNo < totalPages ;pageNo++) {
			
			Pageable pageable = PageRequest.of(pageNo, no_of_recs);
			
			Page<Product> pageProduct = prodRepository.findAll(pageable);
			
			System.out.println("Page_No ::: " + pageNo);
			pageProduct.forEach(prd -> System.out.println(prd));
			
		}
		
		
		System.out.println("Total no of records in Product table : " + totCount);
	}
	
	
	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee();
		
		emp.setFirst_name("Mahendra Singh");
		emp.setLast_name("Dhoni");
		emp.setEmail("mhdhoni@gmail.com");
		
		Employee tmp = empRepository.save(emp);
		
		assertEquals("Dhoni", tmp.getLast_name());
	}
	

}
