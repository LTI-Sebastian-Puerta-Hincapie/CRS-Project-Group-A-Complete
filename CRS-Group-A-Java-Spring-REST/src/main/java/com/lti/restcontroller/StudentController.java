package com.lti.restcontroller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
}
