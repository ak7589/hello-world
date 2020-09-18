package com.pluralsight.corejava8.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	
	//Implement Consumer interface c1 here
	static Consumer<Student> c1 = (s) -> System.out.println(s);
	static Consumer<Student> c1MethodReference = System.out::println;
	static Consumer<Student> c2 = (s) -> System.out.println(s.getName());
	static Consumer<Student> c3 = (s) -> System.out.println(s.getActivities());
			
	public static void printStudents() {
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(c1);
	}
	
	public static void printNameAndActivities() {
		
		//Implement Consumer interface c1 here
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(c2.andThen(c3));
	}
	
	public static void printNameAndActivitiesWithCondition() {
		
		System.out.println("########################## Inside printNameAndActivitiesWithCondition###############################");
		//Implement Consumer interface c1 here
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student -> {
			if(student.getGradeLevel() >=3) {
				c1.andThen(c2).accept(student);;
			}
		}));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to Java 8 ...");
		
		Consumer<String> c1 = (s) -> {
			System.out.println(s.toUpperCase());
		};

		c1.accept("timepass");
		
		//Print all Students here
		printStudents();
		
		//Print Just Student names and their activities here
		printNameAndActivities();
		
		//Print name and activities with condition
		printNameAndActivitiesWithCondition();
		
	}

}
