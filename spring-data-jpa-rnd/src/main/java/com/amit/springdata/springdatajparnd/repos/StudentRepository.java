package com.amit.springdata.springdatajparnd.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amit.springdata.springdatajparnd.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	//Below is the example of JPQL
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("Select ST.firstName, ST.lastName from Student ST")
	List<Object[]> findPartialDataStudents();
	
	@Query("from Student where firstName = :name")
	List<Student> findAllStudentsByFirstName(@Param("name") String firstName);
	
	@Query("from Student where score > :min and score < :max")
	List<Student> findStudentsForGivenScores(@Param("min")int min,@Param("max")int max);
	
	@Modifying
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentByFirstName(@Param("firstName")String firstName);
	
	//Native Query example
	
	@Query(value="select * from student",nativeQuery=true)
	List<Student> findAllStudentsNative();
	
	//Native Query example with parameter example
	
	@Query(value="select * from student where fname = :name",nativeQuery=true)
	List<Student> findStudentByName(@Param("name") String firstName);
	
}
