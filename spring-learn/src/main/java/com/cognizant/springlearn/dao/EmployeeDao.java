package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	
	public static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>() ;
	
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST=(List<Employee>)context.getBean("employeeList");
	}

	public List<Employee> getAllEmployees(){
		LOGGER.info("START Dao getAllEmployees()");
		LOGGER.info("END Dao getAllEmployees())");
		return EMPLOYEE_LIST;
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		LOGGER.info("Inside Dao deleteEmployee()");
		Employee e=null;
		for(Employee emp:EMPLOYEE_LIST) {
			if(emp.getId()==id)
			{
				e=emp;
				EMPLOYEE_LIST.remove(e);
				break;
			}
		}
		if(e==null)
			throw new EmployeeNotFoundException();
	}
	
	public Employee checkEmployee(int id)throws EmployeeNotFoundException{
		LOGGER.info("Inside Dao checkEmployee()");
		for(Employee emp:EMPLOYEE_LIST) {
			if(emp.getId()==id)
				return emp;
		}
		throw new EmployeeNotFoundException();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Inside Dao updateEmployee()");
		for (Employee emp : EmployeeDao.EMPLOYEE_LIST) {
			if(emp.getId()==employee.getId()) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setPermanent(employee.getPermanent());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setDept(employee.getDept());
				emp.setSkill(employee.getSkill());
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}
}
