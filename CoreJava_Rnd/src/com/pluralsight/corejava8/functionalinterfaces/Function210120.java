package com.pluralsight.corejava8.functionalinterfaces;

import java.util.function.Function;

public class Function210120 {

	static Function<String,String> fun1 = (name) -> name.toUpperCase();
	
	
	static Function<String,String> fun2 = (param) -> {
		return (param.toUpperCase());
	};
	
	static Function<String,String> fun3 = (param) -> {
		return (param.concat(" Default "));
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, Welcome to Java 8");
		
		System.out.println("Calling First FunctionInterface : " + fun1.apply("my name is amit"));
		
		testFun1();
	}

	private static void testFun1() {
		// TODO Auto-generated method stub
		
		System.out.println("Inside testFun1");
		
		//Call your implemented functional interface
		System.out.println("Test fun2 : " + fun2.apply("happy sarswati puja"));
		
		System.out.println("Test fun2 and fun3 : " + fun2.andThen(fun3).apply("happpy sarswati puja"));
		
		System.out.println("Test fun2 and fun3 111 " + fun2.compose(fun3).apply("happpy sarswati puja"));
		
	}

}
