package com.lti.exception;

public class CourseNotFoundException extends Exception {
	
	public CourseNotFoundException() {
		super("\nCourse not found");
	}
	
	public CourseNotFoundException(String e) {
		super(e);
	}
}
