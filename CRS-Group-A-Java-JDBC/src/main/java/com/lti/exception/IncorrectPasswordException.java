package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException extends Exception {
	
	public IncorrectPasswordException() {
		System.out.println("\nEntered password does not match existing password");
	}
	
	public IncorrectPasswordException(String message) {
		System.out.println(message);
	}
	
	public IncorrectPasswordException(Throwable cause) {
		System.out.println(cause);
	}
	
	public IncorrectPasswordException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
