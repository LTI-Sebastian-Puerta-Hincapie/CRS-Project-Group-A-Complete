package com.lti.exception;

public class UnableToViewStudentGradesException extends Exception {
	
	public UnableToViewStudentGradesException() {
		System.out.println("\nUnable to view student grades");
	}
	
	public UnableToViewStudentGradesException(String e) {
		System.out.println(e);
	}
}
