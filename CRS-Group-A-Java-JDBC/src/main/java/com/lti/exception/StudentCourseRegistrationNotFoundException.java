package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentCourseRegistrationNotFoundException extends Exception {
	
	public StudentCourseRegistrationNotFoundException() {
		super("\nStudent has not been registered");
		System.out.println("\nStudent has not been registered");
	}
	
	public StudentCourseRegistrationNotFoundException(String e) {
		super(e);
		System.out.println(e);
	}
}
