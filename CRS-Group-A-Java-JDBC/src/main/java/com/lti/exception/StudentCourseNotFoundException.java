package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentCourseNotFoundException extends Exception {
	
	public StudentCourseNotFoundException() {
		super("\nStudent course not found");
		System.out.println("\nStudent course not found");
	}
	
	public StudentCourseNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}
	
	public StudentCourseNotFoundException(Throwable cause) {
		super("\nStudent course not found");
		System.out.println(cause);
	}
	
	public StudentCourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
		System.out.println(message);
		System.out.println(cause);
	}
}
