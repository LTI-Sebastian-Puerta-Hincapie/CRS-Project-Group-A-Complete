package com.lti.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.lti.service.UserService;

@RestController
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired 
	private StudentService studentService;
	
	/**
	 * This controller method registers a student to a specific course
	 * @param studentCourse of type StudentCourse object
	 * @exception StudentNotFoundException is thrown when a course is not found for a specific student
	 * @exception CourseNotRegisteredException is thrown when a course has not been registered for a specific student
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/registerforcourse")
	@ResponseBody
		public ResponseEntity registerForCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.registerForCourse(studentCourse.student, studentCourse.courseId);
			} catch (CourseNotRegisteredException e) {
				return new ResponseEntity(
						"Course has not been registered, courseId = " + studentCourse.courseId, HttpStatus.CONFLICT);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity(
						"Course has not been added, courseId = " + studentCourse.courseId, HttpStatus.NOT_FOUND);
			}	
			return new ResponseEntity("Course was successfully registered", HttpStatus.OK);
		}
	
	/**
	 * This controller method adds a course for a specific student
	 * @param studentCourse of type StudentCourse object
	 * @exception StudentAddCourse is thrown when a course has not been added
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/addcourse")
	@ResponseBody
		public ResponseEntity addCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.addCourse(studentCourse.student, studentCourse.courseId);
			} catch (StudentAddCourseException e) {
				return new ResponseEntity(
						"Course has not been added, courseId = " + studentCourse.courseId, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity("Course has been successfully added", HttpStatus.OK);
		}
	
	/**
	 * This controller method drops a course for a specific student
	 * @param studentCourse of type StudentCourse object
	 * @exception StudentNotFoundException is thrown when a student is not found
	 * @exception StudentDropCourseException is thrown when a course has not been dropped
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.DELETE,
		    value = "/student/dropcourse")
	@ResponseBody
		public ResponseEntity dropCourse(@RequestBody StudentCourse studentCourse){
						
			try {
				studentService.dropCourse(studentCourse.student, studentCourse.courseId);
			} catch (StudentDropCourseException e) {
				return new ResponseEntity(
						"Unable to drop course, courseId = " + studentCourse.courseId, HttpStatus.CONFLICT);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity(
						"Course has not been added, courseId = " + studentCourse.courseId, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity("Course has been successfully dropped", HttpStatus.OK);
		}
	
	/**
	 * This controller method displays course grades for a specific student
	 * @param studentId of type int 
	 * @exception StudentNotFoundException is thrown when there aren't any courses for a specific student
	 * @return ResponseEntity<List<Grade> returns a status with a list of grades
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/viewgrades")
	@ResponseBody
		public ResponseEntity<List<Grade>> viewGrades(@PathVariable("id") int studentId){
				
		    List<Grade> grades = null;
			try {
				grades = studentService.viewGrades(studentId);
			} catch (StudentCourseNotFoundException e) {
				return new ResponseEntity("No courses found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
		}
	
	/**
	 * This controller method gets a specific student by studentId
	 * @param studentId of type int 
	 * @exception StudentNotFoundException is thrown when a student is not found
	 * @return ResponseEntity<Student> returns a status with student data
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}")
	@ResponseBody
		public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId){
				
		    Student student = null;
		    try {
				student = studentService.getStudent(studentId);
			} catch (StudentNotFoundException e) {
				return new ResponseEntity("Student not found, studentId = " + studentId, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
	
	/**
	 * This controller method gets all courses for a specific student
	 * @param studentId of type int 
	 * @return ResponseEntity<List<Course>> returns a status with a list of courses
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/courses")
	@ResponseBody
		public ResponseEntity<List<Course>> getStudentCourses(@PathVariable("id") int studentId){
				
			return new ResponseEntity<List<Course>>(studentService.getStudentCourses(studentId), HttpStatus.OK);
		}	
	
	/**
	 * This controller method gets a list of registered courses for a specific student
	 * @param studentId of type int 
	 * @return ResponseEntity<List<RegisteredCourse>> returns a status with a list of registered courses
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/registeredcourses")
	@ResponseBody
		public ResponseEntity<List<RegisteredCourse>> getStudentRegisteredCourses(@PathVariable("id") int studentId){
				
			return new ResponseEntity<List<RegisteredCourse>>(studentService.getStudentRegisteredCourses(studentId), HttpStatus.OK);
		}
		
	/**
	 * This controller method gets payment due for a specific student
	 * @param studentId of type int 
	 * @return ResponseEntity<Payment> returns a status with a list of registered courses
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/getfee")
	@ResponseBody
		public ResponseEntity<Payment> getStudentFee(@PathVariable("id") int studentId){
				
			return new ResponseEntity<Payment>(studentService.getFee(studentId), HttpStatus.OK);
		}
	
	/**
	 * This controller method generates a fee for a specific student
	 * @param studentId of type int 
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/{id}/generatefee")
	@ResponseBody
		public ResponseEntity generateFee(@PathVariable("id") int studentId){
				
			studentService.generatePayment(studentId);
			return new ResponseEntity("Payment bill generated for student", HttpStatus.OK);
		}
	
	/**
	 * This controller method pays fee due
	 * @param studentId of type int 
	 * @param paymentMethod of type String
	 * @exception StudentMissingFeePaymentException is thrown when payment due has not been paid
	 * @exception StudentPaymentRecordNotFoundException is thrown when a payment bill is not found for a specific student
	 * @return ResponseEntity returns a status
	 */
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
				return new ResponseEntity(
						"Amount due has not been paid", 
						HttpStatus.CONFLICT);
			} catch (StudentPaymentRecordNotFoundException e) {
				return new ResponseEntity(
						"Payment bill not available for this student, check if student has registered for courses", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity("Payment was successful", HttpStatus.OK);
		}

}
