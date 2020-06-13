package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

public class Skill {

	private static final Logger LOGGER = LoggerFactory.getLogger(Skill.class);

	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@Size(min=1,max=30)
	private String name;

	public Skill() {
		LOGGER.debug("Inside Skill Constructor");
	}

	public Skill(@NotNull int id, @NotNull @Size(min = 1, max = 30) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		LOGGER.debug("Set Skill ID : {}",id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Set Skill Name : {}",name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
}
