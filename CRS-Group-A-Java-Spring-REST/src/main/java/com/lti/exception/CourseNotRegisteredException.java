package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CourseNotRegisteredException extends Exception {
	
	public CourseNotRegisteredException() {
		System.out.println("\nCourse not registered");
	}
	
	public CourseNotRegisteredException(String message) {
		System.out.println(message);
	}
	
	public CourseNotRegisteredException(Throwable cause) {
		System.out.println(cause);
	}
	
	public CourseNotRegisteredException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
