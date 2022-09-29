package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoEnrolledStudentsFoundException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7070279410083956785L;
	Logger logger = LoggerFactory.getLogger(NoEnrolledStudentsFoundException.class);
	
	public NoEnrolledStudentsFoundException() {
		logger.error("\nNo enrolled students");
		System.out.println("\nNo enrolled students");
	}
	
	public NoEnrolledStudentsFoundException(String e) {
		System.out.println(e);
	}
}
