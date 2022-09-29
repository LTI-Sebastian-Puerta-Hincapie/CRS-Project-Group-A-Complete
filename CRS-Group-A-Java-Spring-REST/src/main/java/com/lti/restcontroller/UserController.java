package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.StudentCourse;
import com.lti.bean.UpdatePassword;
import com.lti.bean.User;
import com.lti.dao.UserDAO;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.PasswordService;
import com.lti.service.PasswordServiceOperation;
import com.lti.service.UserService;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordService passwordService;
	
	/**
	 * This controller method get a user by userId
	 * @param username of type String
	 * @param password of type String
	 * @return Response<User> returns user data
	 * @throws StudentNotRegisteredException is thrown when student does not have a registration record
	 * @throws SemesterRegistrationNotApprovedException is thrown when the semester registration has not been approved
	 * @throws IncorrectPasswordException  is thrown when an incorrect password been entered by the user
	 * @throws UserNotFoundException  is thrown when a specific user doesn't exist
	 */
	@ExceptionHandler({IncorrectPasswordException.class, SemesterRegistrationNotApprovedException.class})
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/user/{username}/{password}")
	@ResponseBody
	public ResponseEntity getUser(
			@PathVariable("username") String username, 
			@PathVariable("password") String password) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException 
	{
				
		User user = userService.Login(username, password);
		return new ResponseEntity(user.getUsername() + "has successfully logged in", HttpStatus.OK);			
	}
	
	@ExceptionHandler({UserNotFoundException.class, IncorrectPasswordException.class, SemesterRegistrationNotApprovedException.class, StudentNotRegisteredException.class})
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/user/updatepassword")
	@ResponseBody
	public ResponseEntity updatePassword(@RequestBody UpdatePassword updatePassword) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException, StudentNotRegisteredException
	{
		passwordService.updatePassword(
				updatePassword.getUsername(), updatePassword.getCurrentPassword(), updatePassword.getNewPassword());
		return new ResponseEntity("Password has been successfully updated", HttpStatus.OK);
	}
}
