package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.User;
import com.lti.dao.UserDAO;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.UserService;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * This controller method get a user by userId
	 * @param username of type String
	 * @param password of type String
	 * @return Response<User> returns user data
	 */
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/user/{username}/{password}")
	@ResponseBody
	public ResponseEntity getUser(
			@PathVariable("username") String username, 
			@PathVariable("password") String password) {
				
		User user = null;
		try {
			user = userService.Login(username, password);
		} catch (UserNotFoundException e) {	
			return new ResponseEntity(user.getUsername() + " doesn't exist", HttpStatus.NOT_FOUND);
		} catch (IncorrectPasswordException e) {
			return new ResponseEntity("Incorrect password entered", HttpStatus.UNAUTHORIZED);
		} catch (SemesterRegistrationNotApprovedException e) {	
			return new ResponseEntity("Student semester registration not approved", HttpStatus.UNAUTHORIZED);
		} catch (StudentNotRegisteredException e) {
			return new ResponseEntity("Student has not been registered", HttpStatus.UNAUTHORIZED);
		}
	
		return new ResponseEntity(user.getUsername() + "has successfully logged in", HttpStatus.OK);			
	}
}
