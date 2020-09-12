package com.testprgs;

import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {

	private Integer number1;
	private Integer number2;
	
	
	public Adder(Integer number1, Integer number2) {
		this.number1 = number1;
		this.number2 = number2;
	}


	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return (number1 + number2);
	}

}
