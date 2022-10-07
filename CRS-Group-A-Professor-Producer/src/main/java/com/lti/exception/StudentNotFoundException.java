package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		super("\nStudent not found");
		System.out.println("\nStudent not found");
	}
	
	public StudentNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}
	
	public StudentNotFoundException(Throwable cause) {
		super("\nStudent not found");
		System.out.println(cause);
	}
	
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		System.out.println(message);
		System.out.println(cause);
	}
}
