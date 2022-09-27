package com.lti.exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		System.out.println("\nStudent not found");
	}
	
	public StudentNotFoundException(String e) {
		System.out.println(e);
	}
}
