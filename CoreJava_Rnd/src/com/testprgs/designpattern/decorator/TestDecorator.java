package com.testprgs.designpattern.decorator;

public class TestDecorator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleIcecream icecream = new SimpleIcecream();
		
		icecream.makeIcecream();
		
		HoneyDecorator icecream2 = new HoneyDecorator(icecream);
		
		icecream2.makeIcecream();
		

	}

}
