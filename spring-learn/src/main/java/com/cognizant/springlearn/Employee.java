package com.cognizant.springlearn;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@Size(min=1,max=30)
	private String name;
	
	@NotNull
	@Min(value=0)
	private double salary;
	
	@NotNull
	private String permanent;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy") 
	Date dateOfBirth;
	
	@NotNull 
	private Department dept;
	
	@NotNull
	private Skill skill;
	
	public Employee() {
		LOGGER.debug("Inside Employee Constructor");
	}

	public Employee(@NotNull int id, @NotNull @Size(min = 1, max = 30) String name, @NotNull @Min(0) double salary,
			@NotNull String permanent, Date dateOfBirth, @NotNull Department dept, @NotNull Skill skill) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.dept = dept;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		LOGGER.debug("Set Employee id : {}",id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Set Employee name : {}",name);
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		LOGGER.debug("Set Employee salary : {}",salary);
		this.salary = salary;
	}

	public String getPermanent() {
		return permanent;
	}

	public void setPermanent(String permanent) {
		LOGGER.debug("Set Employee type : {}",permanent);
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		LOGGER.debug("Set Employee dob : {}",dateOfBirth);
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		LOGGER.debug("Set Department : {}",dept);
		this.dept = dept;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		LOGGER.debug("Set Skill : {}",skill);
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", dept=" + dept + ", skill=" + skill + "]";
	}

}
