package com.lti.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

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
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lti.service.AdminService;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
import com.lti.exception.CourseNotFoundException;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "/admin/addprofessor")
	@ResponseBody
	public ResponseEntity addProfessor(@RequestBody Professor professor) {
		try {
			adminservice.addProfessor(professor);
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity(professor, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "admin/generatereportcard/{id}")
	public ResponseEntity generateReportCard(@PathVariable("id") int id) {
		ArrayList<ArrayList<String>> reportCard;
		try {
			reportCard = adminservice.generateReportCard(id);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(reportCard, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "admin/approve/{studentID}/{approvalStatus}")
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
			value = "admin/createregistration")
	@ResponseBody
	public ResponseEntity createStudentRegistration(@RequestBody SemesterRegistration semesterRegistration) {
		try {
			adminservice.createStudentRegistration(semesterRegistration);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(semesterRegistration, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "admin/getregistration/{studentId}")
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
			value = "admin/addcourse")
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
			value = "admin/removecourse/{courseId}")
	@ResponseBody
	public ResponseEntity removeCourse(@PathVariable("courseId") int courseId) throws CourseNotFoundException {
		adminservice.removeCourse(courseId);
		return new ResponseEntity(courseId, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST,
			value = "admin/updatecourse/{courseId}/{courseName}/{description}")
	@ResponseBody
	public ResponseEntity updateCourse(@PathVariable("courseId") int courseId, @PathVariable("courseName") String courseName, @PathVariable("description") String description) throws CourseNotFoundException {
		Course course = new Course(courseId,courseName,description);
		adminservice.updateCourse(courseId,courseName,description);
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.GET,
			value = "admin/checkavailability/{id}")
	@ResponseBody
	public ResponseEntity checkAvailability(@PathVariable("id") int id) {
		Boolean available;
		try {
			available = adminservice.checkAvailability(id);
		}catch(CourseNotFoundException ce) {
			return new ResponseEntity("Course not in course list", HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(available, HttpStatus.OK);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity courseNotFoundHandler() {
		return new ResponseEntity("Course is not in course list", HttpStatus.NOT_FOUND);
	}
}
