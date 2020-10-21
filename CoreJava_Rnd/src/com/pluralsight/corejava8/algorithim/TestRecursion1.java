package com.pluralsight.corejava8.algorithim;

import java.util.ArrayList;
import java.util.List;

public class TestRecursion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Amit, Welcome to core Java...");
		
		//Example for the demo of recursion
		foo(4);
		
		//Calculate a factorial value
		int n = 6;
		int val = factorial(n);
		System.out.println("Value of factorial + " + n + " Is :" + val);
		
		//calculate value of fibonacci series
		//Declare a list of int's to hold fibonacci value
		List<Integer> intList = new ArrayList<>();
		
		for (int index = 0; index <= 8; index++) {

			intList.add(fibonacci(index));
		}
		
		//Print fibonacci series
		System.out.println("Fibonacci series for up to 8 element is ...");
		System.out.println(intList);
		
		

	}

	// 0, 1 , 1, 2, 3, 5 , 8, 13 
	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		
		int value = fibonacci(n-2) + fibonacci(n-1);
		
		return value;
		
	}

	private static int factorial(int n) {
		// TODO Auto-generated method stub
		
		int retval = -1;
		
		if (n == 1)
			retval =  1;
		else
			retval =  n * factorial(n-1);
		
		return retval;
		
	}

	private static void foo(int i) {
		// TODO Auto-generated method stub
		
		if (i < 1)
			return;
		else 
			foo(i-1);
		
		System.out.println("foo passed argumen : " + i);
		
	}

}
