package com.testprgs.designpattern.strategy;

public class ShoppingCart {

	/*
	 * Shopping cart will have lots of other
	 * fields in the class. It will also have
	 * payment method which customer chooses at time
	 * of checking out / payment.
	 */
	
	Payment payMethod;

	public ShoppingCart(Payment payMethod) {
		this.payMethod = payMethod;
	}
	
	public void makePayment() {
		payMethod.pay();
	}

}
