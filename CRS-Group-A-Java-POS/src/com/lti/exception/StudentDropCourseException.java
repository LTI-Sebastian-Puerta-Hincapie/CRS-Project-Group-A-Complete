package com.lti.exception;

public class StudentDropCourseException extends Exception {
	
	public StudentDropCourseException() {
		System.out.println("\nCourse not dropped");
	}
	
	public StudentDropCourseException(String e) {
		System.out.println(e);
	}
}
