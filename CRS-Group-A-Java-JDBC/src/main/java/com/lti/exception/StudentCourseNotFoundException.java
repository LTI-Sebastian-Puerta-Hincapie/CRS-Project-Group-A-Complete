package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentCourseNotFoundException extends Exception {
	
	public StudentCourseNotFoundException() {
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
