package com.lti.exception;

import com.lti.bean.User;

public class SemesterRegistrationNotApprovedException extends Exception {
	
	public SemesterRegistrationNotApprovedException(User user) {
		System.out.println("\nThe registration for " + user.getUsername() + " has not been approved");
	}
	
	public SemesterRegistrationNotApprovedException(String e) {
		System.out.println(e);
	}
}
