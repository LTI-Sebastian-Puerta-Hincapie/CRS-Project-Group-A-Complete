package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lti.bean.User;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class SemesterRegistrationNotApprovedException extends Exception {
	
	public SemesterRegistrationNotApprovedException(User user) {
		System.out.println("\nThe registration for " + user.getUsername() + " has not been approved");
	}
	
	public SemesterRegistrationNotApprovedException(String message) {
		System.out.println(message);
	}
	
	public SemesterRegistrationNotApprovedException(Throwable cause) {
		System.out.println(cause);
	}
	
	public SemesterRegistrationNotApprovedException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
