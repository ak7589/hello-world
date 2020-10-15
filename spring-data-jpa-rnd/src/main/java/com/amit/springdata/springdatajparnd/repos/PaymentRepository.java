package com.amit.springdata.springdatajparnd.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amit.springdata.springdatajparnd.entity.CreditCard;
import com.amit.springdata.springdatajparnd.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{
	
	@Query(value="select * from Payment where cardnumber = :card",nativeQuery=true)
	List<CreditCard> findAllPaymentsNative(@Param("card") String cardNumber);

}
