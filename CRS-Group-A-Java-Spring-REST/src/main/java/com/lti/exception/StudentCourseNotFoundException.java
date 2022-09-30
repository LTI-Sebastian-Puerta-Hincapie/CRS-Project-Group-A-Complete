package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
	
	public StudentCourseNotFoundException(String message) {
		System.out.println(message);
	}
	
	public StudentCourseNotFoundException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentCourseNotFoundException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
