package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

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
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/usersx/{username}/{password}")
//	public ResponseEntity getUser_x(
//			@PathVariable("username") String username, 
//			@PathVariable("password") String password) {}
	
	@RequestMapping(
			produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/users/{username}/{password}")
	@ResponseBody
	public ResponseEntity<User> getUser(
			@PathVariable("username") String username, 
			@PathVariable("password") String password) {
				
		User user = null;
		try {
			user = userService.Login(username, password);
		} catch (UserNotFoundException e) {	
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} catch (IncorrectPasswordException e) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} catch (SemesterRegistrationNotApprovedException e) {	
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} catch (StudentNotRegisteredException e) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<User>(user, HttpStatus.OK);			
	}
}
