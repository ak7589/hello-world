package com.amit.springdata.springdatajparnd.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amit.springdata.springdatajparnd.entity.Check;
import com.amit.springdata.springdatajparnd.entity.CreditCard;
import com.amit.springdata.springdatajparnd.entity.Payment;
import com.amit.springdata.springdatajparnd.entity.Student;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	//finder method to get all type of payments for a particular payment
	List<Payment> findByAmount(double amount);
	
	// JPQL Query example for fetching all check payments
	@Query("from Check")
	List<Check> findAllCheckPayments();
	
	// JPQL Query example for fetching all credit card payments
	@Query("from CreditCard")
	List<CreditCard> findAllCreditCardPayments();
	
	//JPQL Query for finding all payments for a given Credit card
	@Query("from CreditCard where cardnumber = :card")
	List<CreditCard> findPaymentsForCreditCard(@Param("card")String cardNo);

	// Native Query example
	@Query(value = "select * from Payment where cardnumber = :card", nativeQuery = true)
	List<CreditCard> findAllPaymentsNative(@Param("card") String cardNumber);
}
