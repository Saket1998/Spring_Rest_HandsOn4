package com.cognizant.springlearn.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees(){
		LOGGER.info("START Service getAllEmployees()");
		LOGGER.info("END Service getAllEmployees())");
		return employeeDao.getAllEmployees() ;
	}
	
	public void deleteEmployee(int id)throws EmployeeNotFoundException{
		LOGGER.info("START Service deleteEmployee()");
		employeeDao.deleteEmployee(id);
		LOGGER.info("END Service deleteEmployee())");
	}
	
	public Employee checkEmployee(int id)throws EmployeeNotFoundException{
		LOGGER.info("START Service checkEmployee()");
		LOGGER.info("END Service checkEmployee())");
		return employeeDao.checkEmployee(id);
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("START Service updateEmployee()");
		LOGGER.info("END Service updateEmployee())");
		return employeeDao.updateEmployee(employee);
	}
}
