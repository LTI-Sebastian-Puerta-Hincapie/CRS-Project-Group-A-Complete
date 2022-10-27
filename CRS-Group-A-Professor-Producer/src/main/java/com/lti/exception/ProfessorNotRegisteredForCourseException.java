package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ProfessorNotRegisteredForCourseException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1946488512729061998L;
	Logger logger = LoggerFactory.getLogger(ProfessorNotRegisteredForCourseException.class);
	
	public ProfessorNotRegisteredForCourseException() {
		super("\\n Professor not registered for course ");
		logger.error("\\n Professor not registered for course ");
		System.out.println("\n Professor not registered for course ");
	}
	
	public ProfessorNotRegisteredForCourseException(String e) {
		super(e);
		System.out.println(e);
	}
}
