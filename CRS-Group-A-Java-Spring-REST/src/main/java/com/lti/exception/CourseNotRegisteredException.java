package com.lti.exception;

public class CourseNotRegisteredException extends Exception {
	
	public CourseNotRegisteredException() {
		System.out.println("\nCourse not registered");
	}
	
	public CourseNotRegisteredException(String e) {
		System.out.println(e);
	}
}
