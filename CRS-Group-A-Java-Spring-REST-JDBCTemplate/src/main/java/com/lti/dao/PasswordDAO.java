package com.lti.dao;

/**
 * @author Rehmath  
 *
 */
public interface PasswordDAO {
	
	
	/**
	 * This method updates the user password
	 * @param username of type String
	 * @param password of type String
	 */
	public void updatePassword(String username, String password);
}
