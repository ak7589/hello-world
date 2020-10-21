package com.amit.springdata.springdatajparnd;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.springdata.springdatajparnd.entity.Check;
import com.amit.springdata.springdatajparnd.entity.CreditCard;
import com.amit.springdata.springdatajparnd.repos.CheckRepository;
import com.amit.springdata.springdatajparnd.repos.PaymentRepository;

@SpringBootTest
class PaymentTest { 
	
	@Autowired
	PaymentRepository paymentRepository;
	CheckRepository checkRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testInsertCreditCardPayment() {
		
		CreditCard ccCardPayment = new CreditCard();
		
		ccCardPayment.setId(100);
		ccCardPayment.setAmount(12345d);
		ccCardPayment.setCreditcard("4407876512349876");
		
		paymentRepository.save(ccCardPayment);
		
		
	}
	
	@Test
	public void testsaveAllCheckPayments() {
		Check checkPayment1 = new Check();
		
		checkPayment1.setId(500);
		checkPayment1.setAmount(1234d);
		checkPayment1.setChecknumber("5346A");
		
		Check checkPayment2 = new Check();
		
		checkPayment2.setId(700);
		checkPayment2.setAmount(3456d);
		checkPayment2.setChecknumber("7865B");
		
		List<Check> chkPymtLst = new ArrayList<>();
		
		chkPymtLst.add(checkPayment1);
		chkPymtLst.add(checkPayment2);
		
		paymentRepository.saveAll(chkPymtLst);
	}
	
	
	
}
