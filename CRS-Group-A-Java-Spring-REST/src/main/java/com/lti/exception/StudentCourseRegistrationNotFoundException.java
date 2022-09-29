package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentCourseRegistrationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3305753611230244459L;
	Logger logger = LoggerFactory.getLogger(StudentCourseRegistrationNotFoundException.class);
	
	public StudentCourseRegistrationNotFoundException() {
		logger.error("\\nStudent has not been registered");
		System.out.println("\nStudent has not been registered");
	}
	
	public StudentCourseRegistrationNotFoundException(String e) {
		System.out.println(e);
	}
}
