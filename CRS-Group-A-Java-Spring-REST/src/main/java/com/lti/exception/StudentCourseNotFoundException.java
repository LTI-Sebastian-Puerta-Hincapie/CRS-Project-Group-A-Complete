package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentCourseNotFoundException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8166946139652595565L;
	Logger logger = LoggerFactory.getLogger(StudentCourseNotFoundException.class);
	
	public StudentCourseNotFoundException() {
		logger.error("\\nStudent course not found");
		System.out.println("\nStudent course not found");
	}
	
	public StudentCourseNotFoundException(String e) {
		System.out.println(e);
	}
}
