package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.PasswordDAO;
import com.lti.dao.PasswordDAOImpl;
import com.lti.dto.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;

/**
 * @author  Rehmath
 *
 */

@Service
public class PasswordService implements PasswordServiceOperation {
	
	@Autowired
	private PasswordDAOImpl passwordDAO;
	@Autowired
	private UserService userService;
	
	@Override
	public void updatePassword(String username, String currentPassword, String newPassword) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException {
		
		User user = userService.updateLogin(username, currentPassword);

		if (user != null) {
			
			passwordDAO.updatePassword(username, newPassword);
		}
		
		System.out.println("\n--Password has been updated--");
		
	}

}
