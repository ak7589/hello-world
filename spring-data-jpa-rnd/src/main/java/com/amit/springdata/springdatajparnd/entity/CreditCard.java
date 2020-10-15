package com.amit.springdata.springdatajparnd.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
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

	@Override
	public String toString() {
		return "CreditCard [creditcard=" + creditcard + "]";
	}
	

}
