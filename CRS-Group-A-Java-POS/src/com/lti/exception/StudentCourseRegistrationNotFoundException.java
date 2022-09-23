package com.lti.exception;

public class StudentCourseRegistrationNotFoundException extends Exception {
	
	public StudentCourseRegistrationNotFoundException() {
		System.out.println("\nStudent has not been registered");
	}
	
	public StudentCourseRegistrationNotFoundException(String e) {
		System.out.println(e);
	}
}
