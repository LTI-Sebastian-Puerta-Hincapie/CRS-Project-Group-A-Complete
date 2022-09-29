package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class SemesterRegistrationExistsException extends Exception {

	public SemesterRegistrationExistsException() {
		System.out.println("Semester registration already exists");
	}
	
	public SemesterRegistrationExistsException(String message) {
		System.out.println(message);
	}
	
	public SemesterRegistrationExistsException(Throwable cause) {
		System.out.println(cause);
	}
	
	public SemesterRegistrationExistsException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
