package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class StudentNotFoundException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4586195422869798847L;
	Logger logger = LoggerFactory.getLogger(StudentNotFoundException.class);
	
	public StudentNotFoundException() {
		logger.error("\\nStudent not found");
		System.out.println("\nStudent not found");
	}
	
	public StudentNotFoundException(String message) {
		System.out.println(message);
	}
	
	public StudentNotFoundException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentNotFoundException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
