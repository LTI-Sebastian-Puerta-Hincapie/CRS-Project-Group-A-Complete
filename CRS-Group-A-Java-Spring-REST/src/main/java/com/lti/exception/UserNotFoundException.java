package com.lti.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		System.out.println("\nUser not found");
	}
	
	public UserNotFoundException(String e) {
		System.out.println(e);
	}
}
