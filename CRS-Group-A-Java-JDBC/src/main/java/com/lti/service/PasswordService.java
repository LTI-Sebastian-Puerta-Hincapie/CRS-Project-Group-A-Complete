package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.dao.PasswordDAO;
import com.lti.dao.PasswordDAOImpl;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;
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
	
	private UserDAO userdao;
	private PasswordDAO passwordDAO;
	private UserService userService;
	
	public PasswordService() {
		
		userdao = new UserDAOImpl();
		passwordDAO = new PasswordDAOImpl();
		userService = new UserService();
	}
	
	@Override
	public void updatePassword(String username, String currentPassword, String newPassword) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException {
		
		User user = userService.Login(username, currentPassword);

		if (user != null) {
			
			passwordDAO.updatePassword(username, newPassword);
		}
		
		System.out.println("\n--Password has been updated--");
		
	}

}
