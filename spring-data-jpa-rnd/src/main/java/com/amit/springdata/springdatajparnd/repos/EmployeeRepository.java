package com.amit.springdata.springdatajparnd.repos;

import org.springframework.data.repository.CrudRepository;

import com.amit.springdata.springdatajparnd.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
