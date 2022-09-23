package com.lti.service;

import com.lti.bean.User;
import com.lti.dao.PasswordDAO;
import com.lti.dao.PasswordDAOImpl;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.UserNotFoundException;

/**
 * @author  Rehmath
 *
 */

public class PasswordService implements PasswordServiceOperation {
	
	private UserDAO userdao;
	private PasswordDAO passwordDAO;
	
	public PasswordService() {
		
		userdao = new UserDAOImpl();
		passwordDAO = new PasswordDAOImpl();
		
	}
		
	
	@Override
	public void updatePassword(String username, String password){
		
		passwordDAO.updatePassword(username, password);
		
		System.out.println("\n--New password saved--");
		
	}

	@Override
	public User validateUser(String username, String password)
			throws UserNotFoundException, IncorrectPasswordException {
		
		User user = userdao.LoginDAO(username);
		if(user == null) {
			
			throw new UserNotFoundException();
		}
		else if(!password.equals(user.getPassword())) {
			
			throw new IncorrectPasswordException();
		}
		System.out.println("\n--User credentials are correct--");
		return user;
	
	}

}
