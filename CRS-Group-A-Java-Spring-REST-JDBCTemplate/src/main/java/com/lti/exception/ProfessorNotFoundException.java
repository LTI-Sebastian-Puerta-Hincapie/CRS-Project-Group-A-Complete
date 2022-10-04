package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8295565347113515253L;
	Logger logger = LoggerFactory.getLogger(ProfessorNotFoundException.class);
	
	public ProfessorNotFoundException() {
		logger.error("Professor not found");
		System.out.println("\n Professor not found");
	}
	
	public ProfessorNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}
}
