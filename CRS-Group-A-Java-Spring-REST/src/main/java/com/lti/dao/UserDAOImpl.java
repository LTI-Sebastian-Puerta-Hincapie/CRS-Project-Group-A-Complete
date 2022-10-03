package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lti.bean.User;
import com.lti.constant.SQLQueries;
import com.lti.utils.DBUtils;

/**
 * @author Sebastian 
 *
 */

@Repository
public class UserDAOImpl implements UserDAO {
		
	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	private Connection conn = null;
	private PreparedStatement stmt = null;

	@Override
	public User LoginDAO(String username) {
		
	   User user = null;
	   try {
		   	
		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.SELECT_USER_BY_USERNAME);
	      stmt.setString(1, username);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	    	  int id = rs.getInt("Id");
	    	  String _username = rs.getString("Username");
	    	  String password = rs.getString("Password");
	    	  int roleId = rs.getInt("RoleId");
	    	  user = new User(id, _username, password, roleId);
	      }
	      
		  logger.info("From LoginDAO method");
		  
	   } catch(SQLException se){
	      se.printStackTrace();
	      logger.error(se.getLocalizedMessage());
	   } catch(Exception e){
	      e.printStackTrace();
	      logger.error(e.getLocalizedMessage());
	   } 
	   
	   return user;
	}

	@Override
	public void LogoutDAO(String username) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User GetUser(int userId) {

		   User user = null;
		   try {
			   	
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_USER_BY_USERID);
		      stmt.setInt(1, userId);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		    	  int id = rs.getInt("Id");
		    	  String _username = rs.getString("Username");
		    	  String password = rs.getString("Password");
		    	  int roleId = rs.getInt("RoleId");
		    	  user = new User(id, _username, password, roleId);
		      }
		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } 
		   
		   return user;
	}

	@Override
	public List<User> GetUsers() {
		
		   List<User> users = new ArrayList<User>();
		   try {
			   	
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_ALL_USERS);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int id = rs.getInt("Id");
		    	  String _username = rs.getString("Username");
		    	  String password = rs.getString("Password");
		    	  int roleId = rs.getInt("RoleId");
		    	  users.add(new User(id, _username, password, roleId));
		      }
		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } 
		   
		   return users;
	}
}
