package com.pluralsight.corejava8.ThreadExamples;

public class CounterTwoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Method main runs in the thread : " +
		                  Thread.currentThread().getName());
		
		CounterTwo counter1 = new CounterTwo("CounterA");
		CounterTwo counter2 = new CounterTwo("CounterB");
		
		System.out.println("Exit from Main method");

	}

}
