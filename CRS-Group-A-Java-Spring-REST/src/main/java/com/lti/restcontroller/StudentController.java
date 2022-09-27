package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.StudentService;

@RestController
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/registerforcourse")
		@ResponseBody
			public void registerForCourse(){
				
				
				
				
			}
	
}
