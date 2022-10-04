package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentPaymentRecordNotFoundException extends Exception {

	public StudentPaymentRecordNotFoundException() {
		System.out.println("\nStudent payment record not found");
	}
	
	public StudentPaymentRecordNotFoundException(String message) {
		System.out.println(message);
	}
	
	public StudentPaymentRecordNotFoundException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentPaymentRecordNotFoundException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
