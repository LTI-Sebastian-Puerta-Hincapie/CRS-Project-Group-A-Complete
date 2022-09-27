/**
 * 
 */
package com.lti.service;

import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian
 *
 */
public interface UserServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type integer
	 * @param password of type integer
	 * @exception UserNotFoundException is thrown when a user is not found
	 * @exception IncorrectPasswordException is thrown when a user inputs an incorrect password
	 * @exception SemesterRegistrationNotApprovedExceptionS is thrown when a student registration has not been approved by the admin
	 * @exception StudentNotRegisteredException is thrown when a student has not been registered by the system admin
	 * @return User returns a user
	 */
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException;
	
	/**
	 * This method validates the user logout
	 * @param username of type String
	 */
	public void Logout(String username);
}
