package com.luv2code.springboot.cruddemo.rest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.EmployeeErrorResponse;
import com.luv2code.springboot.cruddemo.entity.EmployeeNotFoundException;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees3")
	public ResponseEntity<List<Employee>> findAll3() {
		
		List<Employee> empList = employeeService.findAll();
		
		 HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
		    headers.add("Custom-Header", "foo2");
		
		return new ResponseEntity<List<Employee>>(empList,headers,HttpStatus.OK);
		//return employeeService.findAll();
	}
	
	// produces =MediaType.APPLICATION_JSON_VALUE
	// produces = MediaType.APPLICATION_XML_VALUE
	
	@GetMapping(value = "/employees4", produces =  MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Employee findAll4() {
		
		List<Employee> empList = employeeService.findAll();
		
		Employee emp1 = empList.get(0);
		
		return emp1;
		//return employeeService.findAll();
	}
	
	@GetMapping("/employees5")
	public ResponseEntity<List<Employee>> findAll5() {
		
		List<Employee> empList = new ArrayList<>();
		
		if(empList.size() == 0) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		
		else {
			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	
	}
	
	@GetMapping("/employees2")
	public ResponseEntity<String> findAll2() {
		
		//return employeeService.findAll();
		List<Employee> empList = employeeService.findAll();
		
		Employee[] empArray = empList.toArray(new Employee[0]);
		
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
		
		//return new ResponseEntity<>("contact page", httpHeaders, HttpStatus.OK);
        return new ResponseEntity<>(Arrays.toString(empArray), httpHeaders, HttpStatus.OK);
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			//throw new EmployeeNotFoundException("Employee Not Found" + employeeId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee_Not_Found");
			//throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			//throw new RuntimeException("Employee id not found - " + employeeId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee_Not_Found");
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleExcpetion(EmployeeNotFoundException ex) {

		EmployeeErrorResponse error = new EmployeeErrorResponse();

		error.setResStatus(HttpStatus.NOT_FOUND.value());
		// error.setResMessage("Employee Not Found");
		error.setResMessage(ex.getErrorMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
	 
	
}










