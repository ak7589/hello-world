package com.amit.springdata.springdatajparnd.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amit.springdata.springdatajparnd.entity.Check;

public interface CheckRepository extends CrudRepository<Check, Integer>{
	
	List<Check> findByChecknumber(String checkNumber);
}
