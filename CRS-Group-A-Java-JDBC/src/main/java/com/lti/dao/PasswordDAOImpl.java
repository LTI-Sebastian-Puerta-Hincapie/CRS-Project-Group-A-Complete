package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.constant.SQLQueries;
import com.lti.dto.User;
import com.lti.utils.DBUtils;

/**
 * @author  Rehmath
 *
 */

public class PasswordDAOImpl implements PasswordDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	
	/**
	 * Method to update password
     * @param username
     * @param password
     * @return
     */
	@Override
	public void updatePassword(String username, String password) {
		
		try {	   	
			  conn = DBUtils.getConnection();
		      stmt = conn.prepareStatement(SQLQueries.UPDATE_USER_PASSWORD);
		      stmt.setString(1, password);
		      stmt.setString(2, username);
		      stmt.executeUpdate();
		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } 
		  
	}
	
	
}
