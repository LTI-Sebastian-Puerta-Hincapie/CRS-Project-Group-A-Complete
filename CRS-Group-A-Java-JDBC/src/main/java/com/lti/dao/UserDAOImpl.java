package com.lti.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.User;
import com.lti.mapper.UserMapper;

/**
 * @author Sebastian 
 *
 */

@SuppressWarnings("deprecation")
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
	   
		JdbcTemplate db = jdbcTemplateObject.jdbcTemplate();
	   return db.queryForObject(
			   SQLQueries.SELECT_USER_BY_USERID, 
			   new Object[]{userId}, 
			   new UserMapper());
	}

	@Override
	public List<User> GetUsers() {
		
	   List<User> users = jdbcTemplateObject.jdbcTemplate().query(
			   SQLQueries.SELECT_ALL_USERS,  
			   new UserMapper());
	
	   return users;
	}
}
