package com.lti.exception;

public class StudentAddCourseException extends Exception {
	
	public StudentAddCourseException() {
		System.out.println("\nCourse was not added");
	}
	
	public StudentAddCourseException(String e) {
		System.out.println(e);
	}
}
