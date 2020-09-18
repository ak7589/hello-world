package com.pluralsight.corejava8.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample180120 {
	
	//Define Consumer interface for printing student names
	public static Consumer<Student> c2 = (student) -> {
				System.out.println(student.getName());
	};
	
	//Define Consumer interface for printing student activities
	public static Consumer<Student> c3 = (student) -> {
					System.out.println(student.getActivities());
	};
	
	//Define Consumer interface for printing whole student class, which will basicallly use
	//toString method of Student class
	public static Consumer<Student> c4 = (student) -> {
		System.out.println(student);
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java8 example...");
		
		printStudentNames();
		System.out.println("---------------------------------------");
		printStudentNamesAndActivities();
		System.out.println("------------Printing With Condiition---------------------------");
		printStudentNamesAndActivitiesWithCondition();

	}

	private static void printStudentNamesAndActivitiesWithCondition() {
		// TODO Auto-generated method stub
		List<Student> students = StudentDataBase.getAllStudents();
		students.forEach((t) -> {
			if(t.getGradeLevel() >=3  && t.getGpa() >=3.9) {
				c2.andThen(c3).andThen(c4).accept(t);
			}
		});
	}

	private static void printStudentNamesAndActivities() {
		// TODO Auto-generated method stub
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(c2.andThen(c3)); //This is example of consumer chaining
	}

	private static void printStudentNames() {
		// TODO Auto-generated method stub
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(c2);
	}

}
