package com.lti.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Course;
import com.lti.dto.Grade;
import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.dto.StudentCourse;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.exception.StudentMissingFeePaymentException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentPaymentRecordNotFoundException;
import com.lti.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired 
	private StudentService studentService;
	
	/**
	 * This controller method registers a student to a specific course
	 * @param studentCourse of type StudentCourse object
	 * @throws StudentCourseNotFoundException is thrown when a specific course for a student is not found
	 * @throws CourseNotRegisteredException is thrown when a course has not been registered for a specific student
	 * @return ResponseEntity returns a status
	 */
//	@ExceptionHandler({CourseNotRegisteredException.class, StudentCourseNotFoundException.class})
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.PUT,
		    value = "/student/registercourse")
	@ResponseBody
		public ResponseEntity registerForCourse(@RequestBody RegisteredCourse registeredCourse) throws CourseNotRegisteredException, StudentCourseNotFoundException{
					
			logger.info("From the registerForCourse controller method");
			studentService.registerForCourse(registeredCourse);	
			return new ResponseEntity(HttpStatus.OK);
		}
	
	/**
	 * This controller method registers a student to a specific course
	 * @param studentCourse of type StudentCourse object
	 * @throws StudentCourseNotFoundException is thrown when a specific course for a student is not found
	 * @throws CourseNotRegisteredException is thrown when a course has not been registered for a specific student
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.PUT,
		    value = "/student/unregistercourse")
	@ResponseBody
		public ResponseEntity unRegisterForCourse(@RequestBody RegisteredCourse registeredCourse) throws CourseNotRegisteredException, StudentCourseNotFoundException{
					
			logger.info("From the registerForCourse controller method");
			studentService.unRegisterForCourse(registeredCourse);	
			return new ResponseEntity(HttpStatus.OK);
		}
	
	/**
	 * This controller method adds a course for a specific student
	 * @param registeredCourse of type RegisteredCourse object
	 * @throws StudentAddCourseException is thrown when a course has not been added
	 * @return ResponseEntity returns a status
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/student/addcourse")
	@ResponseBody
		public ResponseEntity addCourse(@RequestBody RegisteredCourse registeredCourse) throws StudentAddCourseException 
		{
			
		    logger.info("From the addCourse controller method");
		    studentService.addCourse(registeredCourse);
			return new ResponseEntity(HttpStatus.CREATED);
		}
	
	/**
	 * This controller method drops a course for a specific student
	 * @param studentCourse of type StudentCourse object
	 * @throws StudentNotFoundException is thrown when a student is not found
	 * @throws StudentDropCourseException is thrown when a course has not been dropped
	 * @return ResponseEntity returns a status
	 */
//	@ExceptionHandler({StudentDropCourseException.class, StudentCourseNotFoundException.class})
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.DELETE,
		    value = "/student/dropcourse")
	@ResponseBody
		public ResponseEntity dropCourse(@RequestBody RegisteredCourse registeredCourse) throws StudentDropCourseException, StudentCourseNotFoundException
		{				
		    logger.info("From the dropCourse controller method");
		    studentService.dropCourse(registeredCourse.getStudentId(), registeredCourse.getCourseId());
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	
	/**
	 * This controller method displays course grades for a specific student
	 * @param studentId of type int 
	 * @throws StudentCourseNotFoundException is thrown when there aren't any courses for a specific student
	 * @return ResponseEntity<List<Grade> returns a status with a list of grades
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}/viewgrades")
	@ResponseBody
		public ResponseEntity<List<Grade>> viewGrades(@PathVariable("id") int studentId) throws StudentCourseNotFoundException
		{
				
		    logger.info("From the viewGrades controller method");
		    List<Grade> grades = studentService.viewGrades(studentId);
			return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
		}
	
	/**
	 * This controller method gets a specific student by studentId
	 * @param studentId of type int 
	 * @throws StudentNotFoundException is thrown when a student is not found
	 * @return ResponseEntity<Student> returns a status with student data
	 */
//	@ExceptionHandler({StudentNotFoundException.class})
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/{id}")
	@ResponseBody
		public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId) throws StudentNotFoundException{
			
		    logger.info("From the getStudent controller method");
		    Student student = studentService.getStudent(studentId);
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
			
		    logger.info("From the getStudentCourses controller method");
			return new ResponseEntity<List<Course>>(studentService.getStudentCourses(studentId), HttpStatus.OK);
		}
	
	/**
	 * This controller method gets all courses 
	 * @return ResponseEntity<List<Course>> returns a status with a list of courses
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/courses")
	@ResponseBody
		public ResponseEntity<List<Course>> getCourses(){
			
		    logger.info("From the getCourses controller method");
			return new ResponseEntity<List<Course>>(studentService.getCourses(), HttpStatus.OK);
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
			
		    logger.info("From the getStudentRegisteredCourses controller method");
			return new ResponseEntity<List<RegisteredCourse>>(studentService.getStudentRegisteredCourses(studentId), HttpStatus.OK);
		}
	
	/**
	 * This controller method gets a list of registered courses for a specific student
	 * @param studentId of type int 
	 * @return ResponseEntity<List<RegisteredCourse>> returns a status with a list of registered courses
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/student/registeredcourses")
	@ResponseBody
		public ResponseEntity<List<RegisteredCourse>> getRegisteredCourses(){
			
		    logger.info("From the getStudentRegisteredCourses controller method");
			return new ResponseEntity<List<RegisteredCourse>>(studentService.getRegisteredCourses(), HttpStatus.OK);
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
				
		    logger.info("From the getStudentFee controller method");
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
			
		    logger.info("From the generateFee controller method");
			studentService.generatePayment(studentId);
			return new ResponseEntity("Payment bill generated for student", HttpStatus.OK);
		}
	
	/**
	 * This controller method pays fee due
	 * @param studentId of type int 
	 * @param paymentMethod of type String
	 * @throws StudentMissingFeePaymentException is thrown when payment due has not been paid
	 * @throws StudentPaymentRecordNotFoundException is thrown when a payment bill is not found for a specific student
	 * @return ResponseEntity returns a status
	 */
//	@ExceptionHandler({StudentMissingFeePaymentException.class, StudentPaymentRecordNotFoundException.class})
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.PUT,
		    value = "/student/{id}/payfee/{paymentMethod}")
	@ResponseBody
		public ResponseEntity payFee(
				@PathVariable("id") int studentId, 
				@PathVariable("paymentMethod") String paymentMethod) throws StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException
		{
				
		    logger.info("From the payFee controller method");
		    studentService.payFee(studentId, paymentMethod);
			return new ResponseEntity("Payment was successful", HttpStatus.OK);
		}
}
