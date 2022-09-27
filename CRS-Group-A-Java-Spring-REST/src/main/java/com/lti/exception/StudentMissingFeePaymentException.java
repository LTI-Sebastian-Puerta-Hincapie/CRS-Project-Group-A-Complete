package com.lti.exception;

public class StudentMissingFeePaymentException extends Exception {
	
	public StudentMissingFeePaymentException() {
		System.out.println("\nStudent missing fee payment");
	}
	
	public StudentMissingFeePaymentException(String e) {
		System.out.println(e);
	}
}
