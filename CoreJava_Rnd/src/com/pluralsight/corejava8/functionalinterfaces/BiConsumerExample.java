package com.pluralsight.corejava8.functionalinterfaces;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi Amit, Welcome to core Java 8...");

		BiConsumer<String,String> biConsumerImple = (a,b) -> {
			System.out.println("a : " + a + ", b : " + b);
		};
		
		biConsumerImple.accept("Java 7", "Java 8");
		
		//Implement multiplication
		BiConsumer<Integer,Integer> multiply = (a,b) -> {
			System.out.println("Multiply Result : " + (a*b));
		};
		
		//Implement division
		BiConsumer<Integer,Integer> division = (a,b) -> {
			System.out.println("Division Result : " + (a/b));
		};
		
		multiply.accept(5, 3);
		multiply.andThen(division).accept(20, 5);
	}

}
