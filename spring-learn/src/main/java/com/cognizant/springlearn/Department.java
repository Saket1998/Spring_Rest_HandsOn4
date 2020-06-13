package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

public class Department {

	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);

	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@Size(min=1,max=30)
	private String name;

	public Department() {
		LOGGER.debug("Inside Department Constructor");
	}

	public Department(@NotNull int id, @NotNull @Size(min = 1, max = 30) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		LOGGER.debug("Set Department ID : {}",id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Set Department Name : {}",name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
