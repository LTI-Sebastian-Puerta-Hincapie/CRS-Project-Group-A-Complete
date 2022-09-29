package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfessorNotRegisteredForCourseException extends Exception {
	

	/**
	 * Rehmath
	 */
	private static final long serialVersionUID = -1946488512729061998L;
	Logger logger = LoggerFactory.getLogger(ProfessorNotRegisteredForCourseException.class);
	
	public ProfessorNotRegisteredForCourseException() {
		logger.error("\\n Professor not registered for course ");
		System.out.println("\n Professor not registered for course ");
	}
	
	public ProfessorNotRegisteredForCourseException(String e) {
		
		System.out.println(e);
	}
	
}
