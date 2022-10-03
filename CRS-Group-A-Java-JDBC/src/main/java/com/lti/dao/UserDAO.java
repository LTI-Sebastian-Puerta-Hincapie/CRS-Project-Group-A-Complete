/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.dto.User;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian 
 *
 */
public interface UserDAO {
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type String
	 * @return User returns a user object
	 */
	public User LoginDAO(String username);
	
	/**
	 * This method validates the user logout
	 * @param String username
	 */
	public void LogoutDAO(String username);
	
	/**
	 * This method returns a specific user
	 * @param userId of type integer
	 * @exception UserNotFoundException is thrown when a user is not found
	 * @return User returns a user
	 */
	public User GetUser(int userId);
	
	
	/**
	 * This method returns a list of users
	 * @return List<User> returns a list of users
	 */
	public List<User> GetUsers();
}
