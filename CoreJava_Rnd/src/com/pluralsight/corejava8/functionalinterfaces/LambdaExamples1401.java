package com.pluralsight.corejava8.functionalinterfaces;

public class LambdaExamples1401 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core Java 8....");
		
		testLambdaExample1();

	}

	private static void testLambdaExample1() {
		// TODO Auto-generated method stub
		
		FindSum findSumLambdaImnple = (o1,o2) -> {
			return(o1+o2);
		};
		
		System.out.println("Testing FindSum Lambda Implementation : " + findSumLambdaImnple.addition(5, 8));
		
	}

}
