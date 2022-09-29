package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class StudentDropCourseException extends Exception {
	
	public StudentDropCourseException() {
		System.out.println("\nCourse not dropped");
	}
	
	public StudentDropCourseException(String message) {
		System.out.println(message);
	}
	
	public StudentDropCourseException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentDropCourseException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
