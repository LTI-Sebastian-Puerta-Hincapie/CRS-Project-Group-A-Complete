package com.lti.exception;

public class NoEnrolledStudentsFoundException extends Exception {
	
	public NoEnrolledStudentsFoundException() {
		System.out.println("\nNo enrolled students");
	}
	
	public NoEnrolledStudentsFoundException(String e) {
		System.out.println(e);
	}
}
