package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class StudentMissingFeePaymentException extends Exception {
	
	public StudentMissingFeePaymentException() {
		System.out.println("\nStudent missing fee payment");
	}
	
	public StudentMissingFeePaymentException(String message) {
		System.out.println(message);
	}
	
	public StudentMissingFeePaymentException(Throwable cause) {
		System.out.println(cause);
	}
	
	public StudentMissingFeePaymentException(String message, Throwable cause) {
		System.out.println(message);
		System.out.println(cause);
	}
}
