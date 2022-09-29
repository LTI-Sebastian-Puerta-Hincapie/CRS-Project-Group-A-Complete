package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentAddCourseException extends Exception {
	
	public StudentAddCourseException() {
		System.out.println("\nCourse was not added");
	}
	
	public StudentAddCourseException(String message) {
		System.out.println(message);
	}
	
	public StudentAddCourseException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentAddCourseException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
