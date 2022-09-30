package com.lti.service;

import com.lti.dto.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Rehmath
 *
 */
public interface PasswordServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type String
	 * @param currentPassword of type String
	 * @param newPassword of type String
	 * @exception UserNotFoundException is thrown when a user is not found
	 * @exception IncorrectPasswordException is thrown when the user input does not match the stored password
	 */
	public void updatePassword(String username, String currentPassword, String newPassword) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException;
}
