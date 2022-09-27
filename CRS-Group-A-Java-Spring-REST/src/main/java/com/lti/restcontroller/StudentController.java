package com.lti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.StudentService;

@RestController
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
}
