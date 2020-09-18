package com.pluralsight.corejava8.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample300120 {

	static BiFunction<List<Student>, Predicate<Student>, Map<String,Double> > biFunctionEx1
	        = (students,studentPredicate) -> {
	
	  	//Define a Map first
	   	Map<String,Double>  studentGpaMap = new HashMap<>();
	   	
	   	//Loop overs Students list
	   	students.forEach((student) -> {
	   		
	   		if(studentPredicate.test(student)) {
	   			studentGpaMap.put(student.getName(), student.getGpa());
	   		}
	   		
	   	});
	   	
		return studentGpaMap;
	};
	
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, Welcome to core java...");
		
		Map<String,Double>  studentGpaMap = BiFunctionExample300120.biFunctionEx1.apply(StudentDataBase.getAllStudents(),
				PredicateStudentEx210120.chkStudentGpa);
		
		//Now print the Map returned
		System.out.println(studentGpaMap);
	}

}
