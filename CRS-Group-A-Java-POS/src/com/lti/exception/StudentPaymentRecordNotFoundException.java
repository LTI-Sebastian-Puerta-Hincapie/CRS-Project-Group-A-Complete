package com.lti.exception;

public class StudentPaymentRecordNotFoundException extends Exception {

	public StudentPaymentRecordNotFoundException() {
		System.out.println("\nStudent payment record not found");
	}
	
	public StudentPaymentRecordNotFoundException(String e) {
		System.out.println(e);
	}
}
