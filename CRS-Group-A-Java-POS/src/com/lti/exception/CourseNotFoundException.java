package com.lti.exception;

public class CourseNotFoundException extends Exception {
	
	public CourseNotFoundException() {
		System.out.println("\nCourse not found");
	}
	
	public CourseNotFoundException(String e) {
		System.out.println(e);
	}
}
