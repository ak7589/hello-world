package com.pluralsight.corejava8new.streamslambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java8...");

		//Below methods are just the example if istantiation or
		// implementation of functional interface
		supplierExample();
		consumerExample();
		predicateExample();
		functionExample();
		runnableExample();
		
		//Below are the example of usage of lambda in manipulation 
		//of data
		filterDataInList();
		functionMappingExample();
		
		//Some chaining examples
		chainingExamples();
		
		//Comparator example
		comparatorExample();
		
		//Comparator chaining example
		comparatorExample2();
		
	}

	private static void comparatorExample2() {
		// TODO Auto-generated method stub
		
		System.out.println("comparatorExample2 Start ---");
		
		User user1 = new User("Amit",43);
		User user2 = new User("Gunjan",42);
		User user3 = new User("Vidut",41);
		User user4 = new User("Arjun",41);
		
		List<User> userList = new ArrayList<>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		
		Comparator<User> cmpName = (o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName());
		
		Comparator<User> cmpAge = (o1,o2) -> Integer.compare(o1.getAge(), o2.getAge());
		
		Comparator<User> nameThenAge =  cmpName.thenComparing(cmpAge);
		
		Comparator<User> ageThenName = cmpAge.thenComparing(cmpName);
		
		//Test reversed function
		Comparator<User> nameThenAgeReversed = nameThenAge.reversed();
		
		userList.sort(nameThenAge);
		
		System.out.println(userList);
		
		//userList.sort(ageThenName);
		
		//Test comparator received after applying reversed method
		userList.sort(nameThenAgeReversed);
		
		System.out.println(userList);
		
		System.out.println("comparatorExample2 End ---");
		
		
	}

	private static void comparatorExample() {
		// TODO Auto-generated method stub
		
		System.out.println("comparatorExample Start---");
		
		List<String> strList = new ArrayList<>();
		
		strList.add("One");
		strList.add("Two");
		strList.add("Three");
		strList.add("Four");
		strList.add("Five");
		strList.add("Six");
		strList.add("Seven");
		strList.add("Eight");
		
		//Comparator implementation
		Comparator<String> cmp1 = ( o1, o2) -> o1.compareTo(o2);
		
		//Sort list as per defined comparator
		strList.sort(cmp1);
		
		
		strList.forEach(s -> System.out.println(s));
		
		//Write a comparator to sort the string length wise
		Comparator<String> cmp2 = (o1,o2) -> {
			
			if(o1.length() < o2.length()) {
				return -1;
			} 
			else if(o1.length() > o2.length()) {
				return 1;
			}
			else {
				return 0;
			}
			
		};
		
		//Write one more comparator for comparing length of two Strings
		
		Comparator<String> cmp3 = (o1,o2) -> {
			
			return (Integer.compare(o1.length(),o2.length()));
			
		};
		
		//Again sort the above list using the above comparator
		//strList.sort(cmp2);
		strList.sort(cmp3);
		
		System.out.println("Printing strList after applying cmp2 sort ---");
		System.out.println(strList);
		
		
		System.out.println("comparatorExample End---");
		
	}

	private static void chainingExamples() {
		// TODO Auto-generated method stub
		
		System.out.println("Chaining example start ---");
		
		Consumer<String> c1 = (s) -> System.out.println(s); 
		Consumer<String> c2 = (s) -> System.out.println(s);
		
		Consumer<String> c3 = (s) -> {
			c1.accept(s);
			c2.accept(s);
		};
		
		c3.accept("Hello Hi");
		
		//Example of chaining of two consumers
		c1.andThen(c2).accept("Hello Hi");
		
		//Now try chaining predicates
		
		System.out.println("Chaining example end ---");
	}

	private static void functionMappingExample() {
		// TODO Auto-generated method stub
		
		System.out.println("functionMappingExample Start ---");
		
		List<User> userList = new ArrayList<>();
		
		User user1 = new User("Amit");
		User user2 = new User("Gunjan");
		User user3 = new User("Vidut");
		
		userList.add(user1); 
		userList.add(user2);
		userList.add(user3);
		
		//Loop over userList and print users
		userList.forEach((u) -> System.out.println(u));
		
		//Function to map User object to User name (Sting)
		
		Function<User,String> getUserName = (u) -> u.getFirstName();
		
		//Define list of name of users
		List<String> userNameList = new ArrayList<>();
		
		userList.forEach((u) -> {
			userNameList.add(u.getFirstName());
		});
		
		//Now print user names
		userNameList.forEach((s) -> System.out.println(s));
		
		System.out.println("functionMappingExample End ---");
		
	}

	private static void filterDataInList() {
		// TODO Auto-generated method stub
		
		System.out.println("filterDataInList Start ----");
		
		List<String> strList = new ArrayList<>();
		
		//Add data to the list
		strList.add("One");
		strList.add("Two");
		strList.add("Three");
		strList.add("Four");
		strList.add("Five");
		
		//Browse over the list using forEach method of the collection
		strList.forEach((s) -> {
			System.out.println(s);
		});
		
		//Write a predicate and use in the removeIf method of the collection
		
		Predicate<String> p1 = (s) ->  s.startsWith("T");
		
		strList.removeIf(p1);
		
		System.out.println("Print filterDataInList after calling removeIf method ----");
		strList.forEach((s) -> {
			System.out.println(s);
		});
		
		System.out.println("filterDataInList End ----");
		
	}

	private static void runnableExample() {
		// TODO Auto-generated method stub
		
		Runnable runThread1 = () -> System.out.println("Thread1 running");
		
		runThread1.run();
		
	}

	private static void functionExample() {
		// TODO Auto-generated method stub
		
		Function<String, String> funcExample = (String t) -> t.toUpperCase();
		
		
		System.out.println(funcExample.apply("amit"));
		
	}

	private static void predicateExample() {
		// TODO Auto-generated method stub
		
		Predicate<String> testStrLen = (String t) -> t.length() > 3;
		
		System.out.println("Predicate Result1 : " + testStrLen.test("Amit"));
		
		
		System.out.println("Predicate Result2 : " + testStrLen.test("Ab"));
		
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
