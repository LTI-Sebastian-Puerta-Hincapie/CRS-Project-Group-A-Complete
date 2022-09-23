package com.lti.exception;

public class StudentCourseNotFoundException extends Exception {
	
	public StudentCourseNotFoundException() {
		System.out.println("\nStudent course not found");
	}
	
	public StudentCourseNotFoundException(String e) {
		System.out.println(e);
	}
}
