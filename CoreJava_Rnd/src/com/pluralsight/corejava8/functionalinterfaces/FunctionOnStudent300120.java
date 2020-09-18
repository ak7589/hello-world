package com.pluralsight.corejava8.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionOnStudent300120 {

	//Define a Function interface which will take input as Student list 
	//and return Map
	static Function<List<Student>,Map<String,Double>> getStudentMap = (students) -> {
		
		//Define a Map first
		Map<String,Double>  studentGpaMap = new HashMap<>();
		
		
		//Loop over the passed list of students and populate the Map
		students.forEach((student -> {
			
			//We can put a condition here from our previous Predicate implementation
			if(PredicateStudentEx210120.chkStudentGrade.test(student)) {
				studentGpaMap.put(student.getName(), student.getGpa());
			}
			
			
		}));
		
		return studentGpaMap;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core Java...");
		
		//List<Student> studentList = StudentDataBase.getAllStudents();
		
		//System.out.println(studentList);
		
		//Lets test the above define Function implementation
		
		Map<String,Double> testStudentGpaMap = getStudentMap.apply(StudentDataBase.getAllStudents());
		
		//Print the above received Map
		System.out.println(testStudentGpaMap);
		

	}

}
