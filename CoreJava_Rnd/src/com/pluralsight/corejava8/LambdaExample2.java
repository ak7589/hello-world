package com.pluralsight.corejava8;

import java.util.Comparator;

public class LambdaExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi Amit, Welcome to core Java8...");

		//Old type implementation of Comparator interface prior to Java8
		Comparator<Integer> oldComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		};
			
	    //Now that Comparator interface has been implemented lets test it
		System.out.println("Result of comparison of 8 and 5 is : " + oldComparator.compare(8,5));
		System.out.println("Result of comparison of 8 and 5 is : " + oldComparator.compare(1,12));
		System.out.println("Result of comparison of 8 and 5 is : " + oldComparator.compare(4,4));
		
		//New type implementation (Lambda expression)
		
		Comparator<Integer> newComparator = (o1,o2) -> {
			
			return o1.compareTo(o2);
		};
		
		System.out.println("Result of comparison using new comparator :  98 and 99 is : " + newComparator.compare(98,99));
			
			
	};
	
}
