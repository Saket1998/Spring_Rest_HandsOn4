package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		LOGGER.info("START Controller getAllEmployees()");
		LOGGER.info("END Controller getAllEmployees()");
		return employeeService.getAllEmployees() ;
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("START Controller updateEmployee()");
		LOGGER.info("END Controller updateEmployee()");
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id)throws EmployeeNotFoundException{
		LOGGER.info("START Controller deleteEmployee()");
		employeeService.deleteEmployee(id);
		LOGGER.info("END Controller deleteEmployee()");
	}
	
	@GetMapping("/employees/{id}")
	public Employee checkEmployee(@PathVariable int id)throws EmployeeNotFoundException{
		LOGGER.info("START Controller checkEmployee()");
		LOGGER.info("END Controller checkEmployee()");
		return employeeService.checkEmployee(id);
	}
}
