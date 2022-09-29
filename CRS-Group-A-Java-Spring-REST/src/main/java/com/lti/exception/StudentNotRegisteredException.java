package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotRegisteredException extends Exception {
	
	public StudentNotRegisteredException() {
		
		System.out.println("\nStudent has not been registered by the system admin");
	}
	
	public StudentNotRegisteredException(String message) {
		
		System.out.println(message);
	}
	
	public StudentNotRegisteredException(Throwable cause) {
		
		System.out.println(cause);
	}
	
	public StudentNotRegisteredException(String message, Throwable cause) {
		
		System.out.println(message);
		System.out.println(cause);
	}

}
