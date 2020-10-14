package com.amit.springdata.springdatajparnd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.amit.springdata.springdatajparnd.entity.Employee;
import com.amit.springdata.springdatajparnd.entity.Product;
import com.amit.springdata.springdatajparnd.entity.Student;
import com.amit.springdata.springdatajparnd.repos.EmployeeRepository;
import com.amit.springdata.springdatajparnd.repos.ProductRepository;
import com.amit.springdata.springdatajparnd.repos.StudentRepository;

@SpringBootTest
class StudentTest { 
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateStudents() {
		
		Student stud1 = new Student();
		
		stud1.setFirstName("Amit");
		stud1.setLastName("Kumar");
		stud1.setScore(75);
		
		Student stud2 = new Student();
		
		stud2.setFirstName("Gunjan");
		stud2.setLastName("Kumar");
		stud2.setScore(88);
		
		studentRepository.save(stud1);
		studentRepository.save(stud2);
		
	}
	
	@Test
	public void testGetAllStudents() {
		
		long totalStudentCount = studentRepository.count();
		
		//This is our first JPQL
		List<Student> studentList = studentRepository.findAllStudents();
		
		assertEquals(totalStudentCount,studentList.size());
	}
	
	@Test
	public void testStudentPartialData() {
		
		List<Object[]> objectArray = studentRepository.findPartialDataStudents();
		
		for(Object[] objArray : objectArray) {
			
			System.out.println(objArray[0]);
			System.out.println(objArray[1]);
			System.out.println("-------------------------");
			
		}
		
		
	}
	
	@Test
	public void testfindAllStudentsByFirstName() {
	
		List<Student> studentList = studentRepository.findAllStudentsByFirstName("Amit");
		
		studentList.forEach(student -> System.out.println(student));
	}
	
	@Test
	public void testfindStudentsForGivenScores() {
		List<Student> studentList = studentRepository.findStudentsForGivenScores(70, 80);
		studentList.forEach(student -> System.out.println(student));
		
	}
	
	@Test
	@Transactional
	public void testdeleteStudentByFirstName() {
		
		studentRepository.deleteStudentByFirstName("Amit");
	}
	
	//Test native query...
	@Test
	public void testfindAllStudentsNative() {
		List<Student> studentList = studentRepository.findAllStudentsNative();
		
		studentList.forEach(student -> System.out.println(student));
		
	}

	@Test
	public void testfindStudentByName(){
		
		List<Student> studList = studentRepository.findStudentByName("Amit");
		
		studList.forEach(student -> System.out.println(student));
		
		
	}
}
