package com.amit.springdata.springdatajparnd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.springdata.springdatajparnd.entity.Check;
import com.amit.springdata.springdatajparnd.entity.CreditCard;
import com.amit.springdata.springdatajparnd.entity.Payment;
import com.amit.springdata.springdatajparnd.entity.Student;
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
	
	//Test to find my amount
	@Test
	public void testfindByAmount(){
		List<Payment> paymentList = paymentRepository.findByAmount(3456);
		
		System.out.println("Payment List Size : " + paymentList.size());
		
		/*
		 * List<CreditCard> creditCardList = (List<CreditCard>) paymentList.stream()
		 * .filter(payment -> payment.getMode().equalsIgnoreCase("cc"))
		 * .collect(Collectors.toList());
		 */
		
		List<CreditCard> cardList = new ArrayList<>();
		List<Check> checkList = new ArrayList<>();
		
		paymentList.forEach(pay -> {
			//System.out.println(pay);
			
			if(pay.getMode().equalsIgnoreCase("cc")) {
				cardList.add((CreditCard)pay);
			}
			else if(pay.getMode().equalsIgnoreCase("ch")) {
				checkList.add((Check)pay);
			}
		});
		
		//Now print CreditCard List
		cardList.forEach(card -> System.out.println(card));
		
		//Print check list
		checkList.forEach(check -> System.out.println(check));
		
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
	public void testsaveAllCreditCardPayment() {
		
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
	public void testfindAllCreditCardPayments() {
		
		List<CreditCard> creditCardPaytList = paymentRepository.findAllCreditCardPayments();
		
		creditCardPaytList.forEach(card -> {
			System.out.println("ID : " + card.getId());
			System.out.println("Amount : " + card.getAmount());
			System.out.println("card-Number : " + card.getCreditcard());
			System.out.println("-------------------------");
			
		});
		
	}
	
	@Test
	public void testfindPaymentsForCreditCard() {
		List<CreditCard> creditCardPaytList = paymentRepository
												.findPaymentsForCreditCard("4407876512349876");
		
		creditCardPaytList.forEach(card -> {
			System.out.println("ID : " + card.getId());
			System.out.println("Amount : " + card.getAmount());
			System.out.println("card-Number : " + card.getCreditcard());
			System.out.println("-------------------------");
			
		});
		
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
	
	@Test
	public void testfindAllCheckPayments() {
		List<Check> checkList = paymentRepository.findAllCheckPayments();
		
		checkList.forEach(chk -> {
			System.out.println("ID : " + chk.getId());
			System.out.println("Amount : " + chk.getAmount());
			System.out.println("chk-Number : " + chk.getChecknumber());
			System.out.println("-------------------------");
			
		});
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
