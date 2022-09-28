package com.lti.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.bean.StudentCourse;
import com.lti.bean.User;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.exception.StudentMissingFeePaymentException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentPaymentRecordNotFoundException;
import com.lti.service.StudentService;

@RestController
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/registerforcourse")
	@ResponseBody
		public ResponseEntity registerForCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.registerForCourse(studentCourse.student, studentCourse.courseId);
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
		public ResponseEntity addCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.addCourse(studentCourse.student, studentCourse.courseId);
			} catch (StudentAddCourseException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(HttpStatus.OK);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.DELETE,
		    value = "/student/dropcourse")
	@ResponseBody
		public ResponseEntity dropCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.dropCourse(studentCourse.student, studentCourse.courseId);
			} catch (StudentDropCourseException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(HttpStatus.OK);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/viewgrades")
	@ResponseBody
		public List<Grade> viewGrades(@PathVariable("id") int studentId){
				
		    List<Grade> grades = null;
			try {
				grades = studentService.viewGrades(studentId);
			} catch (StudentCourseNotFoundException e) {
				return null;
			}
			return grades;
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}")
	@ResponseBody
		public Student getStudent(@PathVariable("id") int studentId){
				
		    Student student = null;
		    try {
				student = studentService.getStudent(studentId);
			} catch (StudentNotFoundException e) {
				return null;
			}
			return student;
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/courses")
	@ResponseBody
		public List<Course> getStudentCourses(@PathVariable("id") int studentId){
				
			return studentService.getStudentCourses(studentId);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/registeredcourses")
	@ResponseBody
		public List<RegisteredCourse> getStudentRegisteredCourses(@PathVariable("id") int studentId){
				
			return studentService.getStudentRegisteredCourses(studentId);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/getfee")
	@ResponseBody
		public Payment getStudentFee(@PathVariable("id") int studentId){
				
			return studentService.getFee(studentId);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/{id}/generatefee")
	@ResponseBody
		public ResponseEntity generateFee(@PathVariable("id") int studentId){
				
			studentService.generatePayment(studentId);
			return new ResponseEntity(HttpStatus.OK);
		}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/{id}/payfee/{paymentMethod}")
	@ResponseBody
		public ResponseEntity payFee(
				@PathVariable("id") int studentId, 
				@PathVariable("paymentMethod") String paymentMethod){
				
			try {
				studentService.payFee(studentId, paymentMethod);
			} catch (StudentMissingFeePaymentException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} catch (StudentPaymentRecordNotFoundException e) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(HttpStatus.OK);
		}

}
