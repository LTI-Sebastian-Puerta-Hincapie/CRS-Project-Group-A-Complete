package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.StudentCourse;
import com.lti.bean.User;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.service.StudentService;

@RestController
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/registerforcourse")
	@ResponseBody
		public ResponseEntity registerForCourse(@RequestBody StudentCourse data){
						
			try {
				studentService.registerForCourse(data.student, data.courseId);
			} catch (CourseNotRegisteredException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}	
			return new ResponseEntity(HttpStatus.OK);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/addcourse")
	@ResponseBody
		public ResponseEntity addCourse(@RequestBody StudentCourse data){
						
			try {
				studentService.addCourse(data.student, data.courseId);
			} catch (StudentAddCourseException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(HttpStatus.OK);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.DELETE,
		    value = "/student/dropcourse")
	@ResponseBody
		public ResponseEntity dropCourse(@RequestBody StudentCourse data){
						
			try {
				studentService.dropCourse(data.student, data.courseId);
			} catch (StudentDropCourseException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(HttpStatus.OK);
		}

}
