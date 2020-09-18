package com.pluralsight.corejava8.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunInterfaceEx200220 {
	
	//Definition of Function interface
	//Sample implementation1 of Function interface
	static Function<String,String> funEx1 = (s) -> {
		
		return s.toUpperCase().concat("Pune") ;
	};
	
	//Sample implementation2 of Function interface
	static Function<String,String> funEx2 = (s) -> {
		
		return s.toLowerCase();
	};
	
	//Function interface...Take input as List and return Map
	static Function<List<Student>,Map<String,Double>> funEx3 = (students) -> {
		
		Map<String,Double> studentGradeMap = new HashMap<>();
		
		//Passed parameter students is a list, loop over it
		students.forEach((student) -> {
			studentGradeMap.put(student.getName(), student.getGpa());
		});
		
		return studentGradeMap;
		
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to Java 8, "
				+ "FunctionalInterface examples, Started 20022020...");
		
		functionInterface();
		
		biFunctionExample();

	}

	private static void biFunctionExample() {
		// TODO Auto-generated method stub
		
		System.out.println("Hi...We are in BiFunction example....");
		
	}

	private static void functionInterface() {
		// TODO Auto-generated method stub
		System.out.println(funEx1.apply("Hi Amit, Welcome to Java8"));
		
		System.out.println(funEx1.andThen(funEx2).apply("Hello World"));
		
		//Call funEx3
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		Map<String,Double> studentGradeMap = funEx3.apply(studentList);
		
		System.out.println("Map...." + studentGradeMap);
		
		//Write a sample for loop
		
	}

}
