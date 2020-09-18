package com.pluralsight.corejava8.functionalinterfaces;

import java.util.Comparator;

public class LambdaRunnable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi Amit, Welcome to core Java 8...");
		
		implementRunnable();
		
		implementComparator();
		
		//Below method implements a SAM using Lambda expression
		implementFindSum();

	}
	
	private static void implementFindSum() {
		// TODO Auto-generated method stub
		System.out.println("Inside implementFindSum.implementComparator()");
		
		FindSum findSumLambdaImple = (int a,int b) -> {
			return (a+b);
		};
		
		System.out.println("Sum of 10 and 20 is : " + findSumLambdaImple.addition(10, 20));
	}

	public static void implementRunnable() {
		
		Runnable runLambdaImple = () -> {
			System.out.println("Runnable interface implementation by Lambda Way...");
		};
		
		Thread thd1 = new Thread(runLambdaImple);
		thd1.start();
		
	}
	
	public static void implementComparator() {
		
		
		//Lambda implementation of Comparator interface
		Comparator<Integer> comparatorLambda= (Integer a, Integer b) -> {
			return a.compareTo(b);
		};
		
		//Use above definition to compare two integers
		System.out.println("Comparison of integers 5 and 3 : " 
		+ comparatorLambda.compare(5, 3));
		
		System.out.println("Comparison of integers 10 and 11 : " 
				+ comparatorLambda.compare(10, 11));
		
		//Implement comparator interface another way
		Comparator<Integer> comparatorLambda2= (x, y) -> {
			return x.compareTo(y);
		};
		
		System.out.println("Comparison of integers 99 and 100 using 2nd lambda implementation of Comparator interface : " 
				+ comparatorLambda2.compare(10, 11));
		
	}

}
