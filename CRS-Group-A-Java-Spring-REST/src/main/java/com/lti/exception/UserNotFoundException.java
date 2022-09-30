package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		System.out.println("\nUser not found");
	}
	
	public UserNotFoundException(String message) {
		System.out.println(message);
	}
	
	public UserNotFoundException(Throwable cause) {
		System.out.println(cause);
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
