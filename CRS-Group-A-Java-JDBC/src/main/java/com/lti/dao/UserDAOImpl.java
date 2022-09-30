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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.User;
import com.lti.mapper.EmployeeMapper;
import com.lti.mapper.UserMapper;
import com.lti.utils.DBUtils;

/**
 * @author Sebastian 
 *
 */

@Repository
public class UserDAOImpl implements UserDAO {
		
	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;

	@Override
	public User LoginDAO(String username) {
		
	   User user = jdbcTemplateObject.jdbcTemplate().queryForObject(
			   SQLQueries.SELECT_USER_BY_USERNAME, 
			   new Object[]{username}, 
			   new UserMapper());
	
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
