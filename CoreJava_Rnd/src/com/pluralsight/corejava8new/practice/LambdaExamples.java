package com.pluralsight.corejava8new.practice;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java8...");

		supplierExample();
		consumerExample();
		
	}

	private static void consumerExample() {
		// TODO Auto-generated method stub
		
		Consumer<String> consumerEx = (String t) -> System.out.println(t);
		
		consumerEx.accept("Consumer interface of Java8");
		
	}

	private static void supplierExample() {
		// TODO Auto-generated method stub
		
		System.out.println("Supplier Example Start ...");
		
		Supplier<String> varSupplier = () -> "Hello Amit, Supplier test";
		
		String str = varSupplier.get();
		
		System.out.println(str);
		
		
		System.out.println("Supplier Example End ...");
	}

}
