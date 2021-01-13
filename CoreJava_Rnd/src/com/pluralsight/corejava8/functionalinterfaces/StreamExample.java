package com.pluralsight.corejava8.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core Java...");
		
		streamExample1();
		streamExample2();

	}

	private static void streamExample2() {
		// TODO Auto-generated method stub
		
		System.out.println("streamExample2 Start ---");
		
		Stream<String> stringStream = Stream.of("One","Two","Three","Four","Five");
		
		Predicate<String> p1 = s -> s.length()>3;
		
		stringStream.filter(p1)
		.forEach(s -> System.out.println(s));
		
		
		System.out.println("streamExample2 End ---");
	}

	private static void streamExample1() {
		// TODO Auto-generated method stub
		
		System.out.println("streamExample1 Start ---");
		
		List<Integer> intList = new ArrayList<>();
		
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);
		
		/*
		 * Stream<Integer> intStream = intList.stream();
		 * 
		 * intStream.forEach((I) -> { System.out.println(I); });
		 */
		
		Stream<Integer> intStream = intList.stream();
		
		//Define a Predicate
		Predicate<Integer> p1 = (I) -> {
			if (I > 20)
				return true;
			return false;
		};
		
		//Filter operation on the stream
		Stream<Integer> filteredintStream = intStream.filter(p1);
		System.out.println("Printing filtered stream...");
		filteredintStream.forEach((I) -> {
			System.out.println(I);
		});
		System.out.println("streamExample1 End ---");
	}

}
