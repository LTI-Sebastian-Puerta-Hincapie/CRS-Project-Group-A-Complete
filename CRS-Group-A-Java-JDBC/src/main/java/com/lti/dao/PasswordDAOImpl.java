package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.User;

/**
 * @author  Rehmath, Sebastian
 *
 */

public class PasswordDAOImpl implements PasswordDAO {
	
	Logger logger = LoggerFactory.getLogger(PasswordDAOImpl.class);
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
		
	/**
	 * Method to update password
     * @param username
     * @param password
     * @return
     */
	@Override
	public void updatePassword(String username, String password) {
		
       logger.info("From the updatePasswordDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.UPDATE_USER_PASSWORD, 
				new Object[] {password, username}); 	 
	}	
}
