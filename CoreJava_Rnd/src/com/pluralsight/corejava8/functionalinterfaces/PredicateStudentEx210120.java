package com.pluralsight.corejava8.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentEx210120 {

	static Predicate<Student> chkStudentGrade = (student) -> student.getGradeLevel()>=3;
	static Predicate<Student> chkStudentGpa = (student) -> student.getGpa() >= 3.9;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, Welcome to core java 8...");
		
		chkGradeAndPrintStudents();
		chkGpaAndPrintStudents();
		chkGradeAndGpa();
		
	}


	private static void chkGradeAndGpa() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		System.out.println("Applying Grade And Gpa filter through and condition----------");
		
		//Apply chkStudentGrade predicate on the student list
		studentList.forEach((student -> {
			if(chkStudentGpa.and(chkStudentGrade).test(student)) {
				System.out.println(student);
			}
		}));
		
	}


	private static void chkGpaAndPrintStudents() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		System.out.println("Applying GPA filter----------");
		
		//Apply chkStudentGrade predicate on the student list
		studentList.forEach((student -> {
			if(chkStudentGpa.test(student)) {
				System.out.println(student);
			}
		}));
		
	}


	private static void chkGradeAndPrintStudents() {
		// TODO Auto-generated method stub
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		//Apply chkStudentGrade predicate on the student list
		studentList.forEach((student -> {
			if(chkStudentGrade.test(student)) {
				System.out.println(student);
			}
		}));
	}

}
