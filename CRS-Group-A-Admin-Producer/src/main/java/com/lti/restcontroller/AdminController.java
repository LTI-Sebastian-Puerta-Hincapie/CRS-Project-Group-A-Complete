package com.lti.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lti.service.AdminService;
import com.lti.dto.Course;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.SemesterRegistrationExistsException;
import com.lti.exception.UserNotFoundException;

@RestController
@CrossOrigin
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminservice;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/admin/addprofessor")
	@ResponseBody
	public ResponseEntity addProfessor(@RequestBody Professor professor) {	
		logger.info("From the addProfessor controller method");
		adminservice.addProfessor(professor);
		return new ResponseEntity(professor, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.PUT,
			value = "/admin/updateprofessor")
	@ResponseBody
	public ResponseEntity updateProfessor(@RequestBody Professor professor) {	
		logger.info("From the updateProfessor controller method");
		adminservice.updateProfessor(professor);
		return new ResponseEntity(professor, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.DELETE,
			value = "/admin/deleteprofessor/{id}")
	@ResponseBody
	public ResponseEntity deleteProfessor(@PathVariable("id") int professorId) {	
		logger.info("From the deleteprofessor controller method");
		adminservice.deleteProfessor(professorId);
		return new ResponseEntity("Professor successfully deleted", HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/admin/generatereportcard/{id}")
	public ResponseEntity<List<Grade>> generateReportCard(@PathVariable("id") int id) {
		logger.info("From the generateReportCard method");
		List<Grade> reportCard;

		reportCard = adminservice.generateReportCard(id);

		return new ResponseEntity<List<Grade>>(reportCard, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.PUT,
			value = "/admin/approve/{studentID}/{approvalStatus}")
	public ResponseEntity approveStudentRegistration(@PathVariable("studentID") int studentID, @PathVariable("approvalStatus") int approvalStatus) {
		try {
			adminservice.approveStudentRegistration(studentID, approvalStatus);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/admin/createregistration")
	@ResponseBody
	public ResponseEntity<SemesterRegistration> createStudentRegistration(@RequestBody SemesterRegistration semesterRegistration) throws SemesterRegistrationExistsException, UserNotFoundException {
		
		SemesterRegistration registration = adminservice.createStudentRegistration(semesterRegistration);
		return new ResponseEntity<SemesterRegistration>(registration, HttpStatus.CREATED);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/admin/getregistration/{studentId}")
	@ResponseBody
	public ResponseEntity getSemesterRegistration(@PathVariable("studentId") int studentId) {
		SemesterRegistration reg;
		try {
			reg = adminservice.getSemesterRegistration(studentId);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(reg, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/admin/addcourse")
	@ResponseBody
	public ResponseEntity addCourse(@RequestBody Course course) {
		try {
			adminservice.addCourse(course);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.DELETE,
			value = "/admin/removecourse/{courseId}")
	@ResponseBody
	public ResponseEntity removeCourse(@PathVariable("courseId") int courseId) throws CourseNotFoundException {
		adminservice.removeCourse(courseId);
		return new ResponseEntity(courseId, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.PUT,
			value = "/admin/updatecourse/{courseId}/{courseName}/{description}")
	@ResponseBody
	public ResponseEntity updateCourse(
			@PathVariable("courseId") int courseId, 
			@PathVariable("courseName") String courseName, 
			@PathVariable("description") String description) throws CourseNotFoundException {
		Course course = new Course(courseId,courseName,description);
		adminservice.updateCourse(courseId,courseName,description);
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/admin/viewcourses/{id}")
	@ResponseBody
	public ResponseEntity<List<Course>> viewCourses(@PathVariable("id") int id) {
		
		List<Course> courses = adminservice.viewCourses(id);
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "/admin/checkavailable/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> checkAvailability(@PathVariable("id") int id) throws CourseNotFoundException {
		
		Boolean available = adminservice.checkAvailability(id);
		return new ResponseEntity<Boolean>(available, HttpStatus.OK);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity courseNotFoundHandler() {
		return new ResponseEntity("Course is not in course list", HttpStatus.NOT_FOUND);
	}
}
