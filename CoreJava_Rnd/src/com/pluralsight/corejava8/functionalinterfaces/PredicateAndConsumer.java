package com.pluralsight.corejava8.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateAndConsumer {

	Predicate<Student> p1 = (student) -> student.getGradeLevel() >=3 ;
	Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9 ;
	BiConsumer<Student, List<String>> b1 = (student, activities) -> {
		System.out.println(student + " : " + activities);
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PredicateAndConsumer test = new PredicateAndConsumer();
		test.printNameAndActivities();
		
	}

	public void printNameAndActivities() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach((student -> {
			if(p1.and(p2).test(student)) {
				b1.accept(student, student.getActivities());
			}
		}));
	}

}
