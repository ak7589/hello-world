package com.testprgs.designpattern.strategy;

public class TestStrategyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShoppingCart cart1 = new ShoppingCart(new CardPayment());
		
		cart1.makePayment();
		
		ShoppingCart cart2 = new ShoppingCart(new NetbankingPayment());
		
		cart2.makePayment();

	}

}
