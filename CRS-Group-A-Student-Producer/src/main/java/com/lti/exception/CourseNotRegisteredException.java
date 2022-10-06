package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CourseNotRegisteredException extends Exception {
	
	public CourseNotRegisteredException() {
		super("\nCourse not registered");
	}
	
	public CourseNotRegisteredException(String message) {
		super(message);
	}
	
	public CourseNotRegisteredException(Throwable cause) {
		super(cause);
	}
	
	public CourseNotRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}
}
