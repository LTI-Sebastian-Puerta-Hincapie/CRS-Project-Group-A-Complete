package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public StudentNotFoundException(String e) {
		System.out.println(e);
	}
}
