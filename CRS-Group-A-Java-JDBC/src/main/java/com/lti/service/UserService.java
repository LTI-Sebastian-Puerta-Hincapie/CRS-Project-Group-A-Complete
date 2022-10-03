package com.lti.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;
import com.lti.dto.SemesterRegistration;
import com.lti.dto.Student;
import com.lti.dto.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian 
 *
 */

@Service
public class UserService implements UserServiceOperation {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private AdminDAO admindao;
		
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException
	{		
		User user = userdao.LoginDAO(username);
		if(user == null) {
			
			throw new UserNotFoundException(username + " doesnt' exist");
		}
		else if(!password.equals(user.getPassword())) {
			
			throw new IncorrectPasswordException("Incorrect password, entered password does not match our records");
		}
	
		
		if(user.getRoleId() == 3) {		// student
			
			SemesterRegistration registration = admindao.getSemesterRegistrationDAO(user.getId());
			
			if(registration == null) {
				
				throw new StudentNotRegisteredException(
						"Student registration not found for this user, userId: " + user.getId());
			}
			
			if(registration.getApprovalStatus() == 1) {
				
				System.out.println("\n--You have logged in--");
			}
			else {
				throw new SemesterRegistrationNotApprovedException("Student semester registration not approved");
			}
		}
		else {
			
			System.out.println("\n--You have logged in--");
		}
		return user;
	}
	
	public void Logout(String username) {
		
		System.out.println("\nYou have logged out");
	}
	
	@Override
	public User GetUser(int userId) {
		
		return userdao.GetUser(userId);
	}

	@Override
	public List<User> GetUsers() {

		return userdao.GetUsers();
	}
}
