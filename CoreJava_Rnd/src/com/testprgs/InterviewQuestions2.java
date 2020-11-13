package com.testprgs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQuestions2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to coding practice...");
		
		//Question no 1
		/*
		 * Below method is ti check if a number passed is odd or even
		 */
		int number1 = 24;
		boolean flag = checkOddOrEven(number1);
		
		System.out.println(flag);
		
		//Question no 2
		/*
		 * I have string of numbers in list, process this list and
		 * return list of just even numbers
		 */
		processStringListAndReturnIntList();
		
		//Question no 3
		/*
		 * Show the example of functional interface and its implementation
		 * using Lambda expression
		 */
		
		demoLambda();

	}

	private static void demoLambda() {
		// TODO Auto-generated method stub
		
		FunInterfaceExample funIntfaceImpl = (I) -> System.out.println("Value Passed " + I);
		
		funIntfaceImpl.show(999);
		
	}

	private static void processStringListAndReturnIntList() {
		// TODO Auto-generated method stub
		
		List<String> strList = new ArrayList<>();
		
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		strList.add("7");
		strList.add("8");
		
		List<Integer> intList = strList.stream()
				.map(num -> Integer.parseInt(num))
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		
		//Print the list of Integers
		System.out.println("Printing list of integers using lambda exp...");
		intList.forEach(num -> System.out.println(num));
		
		
	}

	private static boolean checkOddOrEven(int nbr) {
		// TODO Auto-generated method stub
		
		boolean retval = false;
		
		if ( (nbr % 2) == 0 )
		{
			retval = true;
		}
				
		return retval;
		
	}

}
