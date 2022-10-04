package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEnrolledStudentsFoundException extends Exception {
	
	public NoEnrolledStudentsFoundException() {
		super("\nNo enrolled students");
		System.out.println("\nNo enrolled students");
	}
	
	public NoEnrolledStudentsFoundException(String e) {
		super(e);
		System.out.println(e);
	}
}
