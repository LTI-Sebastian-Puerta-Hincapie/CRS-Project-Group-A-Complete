package com.lti.exception;

public class StudentNotRegisteredException extends Exception {
	
	public StudentNotRegisteredException() {
		
		System.out.println("\nStudent has not been registered by the system admin");
	}
	
	public StudentNotRegisteredException(String e) {
		
		System.out.println(e);
	}

}
