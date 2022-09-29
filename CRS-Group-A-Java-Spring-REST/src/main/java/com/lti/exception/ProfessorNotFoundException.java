package com.lti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfessorNotFoundException extends Exception {
	
	/**
	 * Rehmath
	 */
	private static final long serialVersionUID = 8295565347113515253L;
	Logger logger = LoggerFactory.getLogger(ProfessorNotFoundException.class);
	
	public ProfessorNotFoundException() {
		logger.error("Professor not found");
		System.out.println("\n Professor not found");
	}
	
	public ProfessorNotFoundException(String e) {
		
		System.out.println(e);
	}
	
}
