package com.lti.exception;

public class PaymentBillNotCreatedException extends Exception {

	public PaymentBillNotCreatedException() {
		System.out.println("\nPayment bill not created");
	}
	
	public PaymentBillNotCreatedException(String e) {
		System.out.println(e);
	}
}
