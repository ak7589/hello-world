package com.amit.springdata.springdatajparnd;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class SpringDataJpaRndApplicationTests { 
	

	
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
}
