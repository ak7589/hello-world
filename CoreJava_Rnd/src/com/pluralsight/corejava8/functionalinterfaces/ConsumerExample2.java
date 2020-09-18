package com.pluralsight.corejava8.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi Amit, Welcome to core Java 8");
		
		//Below is the implementation of Consumer interface
		Consumer<String> c1 = (String s) -> {
			System.out.println(s.toUpperCase());
		};

		c1.accept("hi there, how are you");
		
		//Call a method to print each students from the student list
		//printNames();
		
		//Just print student names and their activities
		//printNamesAndActivities();
		
		//print names of students and activities if their grade is >=3
		System.out.println("-----------Print Student Names Having Grade >= 3------------------");
		printNamesAndActivitiesWithCondition();
	}

	private static void printNamesAndActivitiesWithCondition() {
		
		//Consumer interface implementation for just printing student name
		Consumer<Student> c2 = (student) -> {System.out.print(student.getName());};
				
		//Consumer interface implementation for printing student activities
		Consumer<Student> c3 = (student) -> {System.out.println(student.getActivities());};
		
		// TODO Auto-generated method stub
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student) -> {
			if(student.getGradeLevel() >=3 && student.getGpa() >=3.9 ) {
				c2.andThen(c3).accept(student);
			}
		});
		
	}

	private static void printNamesAndActivities() {
		// TODO Auto-generated method stub
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		//Consumer interface implementation for just printing student name
		Consumer<Student> c2 = (student) -> {System.out.print(student.getName());};
		
		//Consumer interface implementation for printing student activities
		Consumer<Student> c3 = (student) -> {System.out.println(student.getActivities());};
		
		
		studentList.forEach(c2.andThen(c3));
		
	}

	private static void printNames() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		
		//Lets implement a consumer interface to perform some very simple action on this list
		Consumer<Student> c2 = (student) -> {System.out.println(student);};
		
		//Call foreach method of List and pass this consumer interface
		studentList.forEach(c2);
		
	}

}
