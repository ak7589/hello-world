package com.amit.springdata.springdatajparnd;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.springdata.springdatajparnd.entity.CreditCard;
import com.amit.springdata.springdatajparnd.entity.Student;
import com.amit.springdata.springdatajparnd.repos.PaymentRepository;

@SpringBootTest
class PaymentTest { 
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreditCardPayment() {
		
		CreditCard ccCardPayment = new CreditCard();
		
		ccCardPayment.setId(100);
		ccCardPayment.setAmount(12345d);
		ccCardPayment.setCreditcard("4407876512349876");
		
		paymentRepository.save(ccCardPayment);
		
		
	}
	
	@Test
	public void testAllCreditCardPayment() {
		
		CreditCard ccCardPayment1 = new CreditCard();

		ccCardPayment1.setId(200);
		ccCardPayment1.setAmount(23456d);
		ccCardPayment1.setCreditcard("4407876512349877");
		
		CreditCard ccCardPayment2 = new CreditCard();

		ccCardPayment2.setId(300);
		ccCardPayment2.setAmount(3456d);
		ccCardPayment2.setCreditcard("4407876512349876");
		
		List<CreditCard> cardPaymentList = new ArrayList<>();
		
		cardPaymentList.add(ccCardPayment1);
		cardPaymentList.add(ccCardPayment2);
		
		
		paymentRepository.saveAll(cardPaymentList);
		
		
	}
	
	@Test
	public void testGetAllCreditPayments() {
		
		String card = "4407876512349876";
		List<CreditCard> cardPaymentList = paymentRepository
												.findAllPaymentsNative(card);
		
		cardPaymentList.forEach(cardNo -> System.out.println(cardNo));
		
		cardPaymentList.forEach(cardNo -> {
			System.out.println(cardNo.getCreditcard());
			System.out.println(cardNo.getAmount());
		});
	}
	
	
	
}
