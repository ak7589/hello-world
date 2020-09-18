package com.pluralsight.corejava8.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample190120 {
	
	//Define a Predicate Functional Interface
	public static Predicate<Integer> p1 = (a) -> {
		return a % 2 == 0;
	};
	
	//Define above Predicate Functional Interface in new way (Divisible by 2)
	public static Predicate<Integer> p2 = (b) -> b%2 == 0;
	
	
	//Define above Predicate Functional Interface in new way (Divisible by 5)
	public static Predicate<Integer> p5 = (b) -> b%5 == 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi Amit, Welcome to core java8 - Predicate example...");
		
		testPredicateExample1();
		testPredicateAndExample();
		testPredicateOrExample();
		testPredicateNegateExample();

	}

	private static void testPredicateNegateExample() {
		// TODO Auto-generated method stub
		System.out.println("Predicate negate example for Integer Value 9 :" + p2.or(p5).negate().test(9));
		System.out.println("Predicate negate example for Integer Value 8 :" + p2.or(p5).negate().test(8));
		
	}

	private static void testPredicateOrExample() {
		// TODO Auto-generated method stub
		System.out.println("-----------PredicateOrExample Output --------------------");
		System.out.println("Predicate OR example for Integer Value 9 :" + p2.or(p5).test(9));
		System.out.println("Predicate OR example for Integer Value 8 :" + p2.or(p5).test(8));
	}

	private static void testPredicateAndExample() {
		// TODO Auto-generated method stub
		
		//Now lets test if number is both divisible by 2 and 5
		
		//Below is also known as Predicate chaining. We should always use test method to pass input
		System.out.println("Predicate and example for Integer Value 40 :" + p2.and(p5).test(40));
		System.out.println("Predicate and example for Integer Value 41 :" + p2.and(p5).test(41));
		
	}

	private static void testPredicateExample1() {
		
		
		
		System.out.println("Predicate example1 for Integer Value 20 :" + p1.test(20));
		System.out.println("Predicate example1 for Integer Value 21 :" + p1.test(21));
		
		
		
		System.out.println("Predicate example2 for Integer Value 20 :" + p2.test(20));
		System.out.println("Predicate example2 for Integer Value 21 :" + p2.test(21));
		
		
		
		
	}
	

}
