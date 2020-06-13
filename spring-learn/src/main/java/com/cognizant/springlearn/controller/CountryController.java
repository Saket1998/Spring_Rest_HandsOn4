package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START getCountryIndia()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("END getCountryIndia()");
		return context.getBean("in",Country.class);
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START getAllCountries()");
		LOGGER.info("END getAllCountries()");
		return countryService.getAllCountries();
	}
	
	@GetMapping("/countries/{code}") 
	public Country getCountry(@PathVariable String code)throws CountryNotFoundException {
		LOGGER.debug("Country Code : {} ",code);
		return countryService.getCountry(code);
	}
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START addCountry()");
		LOGGER.info("END addCountry()");
		return countryService.addCountry(country);
	}
}
