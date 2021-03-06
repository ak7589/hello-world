package com.amit.springdata.springdatajparnd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class CreditCard extends Payment {
	
	@Column(name="cardnumber")
	private String creditcard;
	
	public CreditCard() {
		
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	
	  @Override public String toString() { return "CreditCard [creditcard=" +
	  creditcard + "]" + " Payment ID : " + this.getId() + " Amt : " + this.getAmount() ; }
	 
	

}
