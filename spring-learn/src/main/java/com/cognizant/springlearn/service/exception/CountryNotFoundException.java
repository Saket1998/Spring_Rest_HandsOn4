package com.cognizant.springlearn.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Country Not found")
public class CountryNotFoundException extends Exception{

}
