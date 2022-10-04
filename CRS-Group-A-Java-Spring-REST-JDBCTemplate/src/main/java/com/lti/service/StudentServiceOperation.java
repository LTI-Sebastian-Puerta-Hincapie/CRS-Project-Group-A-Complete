/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.exception.PaymentBillNotCreatedException;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Grade;
import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentMissingFeePaymentException;
import com.lti.exception.StudentPaymentRecordNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.UnableToViewStudentGradesException;

/**
 * @author Sebastian
 *
 */
public interface StudentServiceOperation {
	
	/**
	 * This method registers a student for a specific course 
	 * @param student of type Student
	 * @param courseId of type integer
	 * @exception StudentCourseRegistrationNotFoundException is thrown when a student has not been registered for a course
	 * @exception StudentCourseNotFoundException is thrown when a student course is not found
	 */
	public void registerForCourse(Student student, int courseId) throws CourseNotRegisteredException, StudentCourseNotFoundException;
	
	/**
	 * This method adds a course for a specific student
	 * @param student of type Student
	 * @param courseId of type integer
	 * @exception StudentAddCourseException is thrown when adding a course fails
	 */
	public void addCourse(Student student, int courseId) throws StudentAddCourseException;
	
	/**
	 * This method gets a course for a specific student and courseId
	 * @param student of type Student
	 * @param courseId of type integer
	 * @return RegisteredCourse returns a registered course
	 */
	public RegisteredCourse getCourse(Student student, int courseId);
	
	/**
	 * This method drops a course for a specific student
	 * @param student of type Student
	 * @param courseId of type integer
	 * @exception StudentDropCourseException when dropping course fails
	 * @exception StudentCourseNotFoundException when a course is not found
	 */
	public void dropCourse(Student student, int courseId) throws StudentDropCourseException, StudentCourseNotFoundException;
	
	/**
	 * This method view grades for a specific student and returns a list of grades
	 * @param studentId of type int
	 * @exception UnableToViewStudentGradesException is thrown when a student course is not found
	 * @return List<Grade> returns a list of grades
	 */
	public List<Grade> viewGrades(int studentId) throws StudentCourseNotFoundException;
	
	/**
	 * This method makes a payment for the courses that the student is registered for
	 * @param studentId of type int
	 * @param paymentMethod of type String
	 * @exception StudentMissingFeePaymentException is thrown when the student fee has not been paid
	 * @exception StudentPaymentRecordNotFoundException is thrown when a student payment record is not found
	 */
	public void payFee(int studentId, String paymentMethod) throws StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException;
	
	/**
	 * This method gets the student data 
	 * @param studentId of type integer
	 * @exception StudentNotFoundException is thrown when a student is not found
	 * @return Student returns a student
	 */
	public Student getStudent(int studentId) throws StudentNotFoundException;
	
	/**
	 * This method gets all courses for a specific student that they have added
	 * @param studentId of type integer
	 * @exception StudentCourseNotFoundException is thrown when a student course is not found
	 * @return List<Course> returns a list of courses
	 */
	public List<Course> getStudentCourses(int studentId) throws StudentCourseNotFoundException;
	
	/**
	 * This method gets all registered courses for a specific student
	 * @param studentId of type integer
	 * @exception CourseNotRegisteredException is thrown when a course has not been registered
	 * @return List<RegisteredCourse> returns a list of registered courses
	 */
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId) throws CourseNotRegisteredException;
	
	/**
	 * This method add payment data (amount, due date, semester, etc.) to the system
	 * @param studentId of type integer
	 * @exception PaymentBillNotCreatedException is thrown when a payment bill was not created
	 */
	public void generatePayment(int studentId) throws PaymentBillNotCreatedException;
	
	/**
	 * This method gets course data from course catalog and returns a list of courses
	 * @param studentId of type integer
	 * @exception CourseNotRegisteredException is thrown when a courses has not been registered
	 */
	public List<CourseCatalog> getRegisteredCourseData(int studentId) throws CourseNotRegisteredException;
	
	/**
	 * This method gets fee/payment due for a specific student 
	 * @param studentId of type integer
	 * @exception StudentPaymentRecordNotFoundException is thrown whena student payment record is not found
	 * @return Payment returns a payment object
	 */
	public Payment getFee(int studentId) throws StudentPaymentRecordNotFoundException;
	
	/**
	 * This methods adds student semester registration for admin approval
	 * @param studentId of type integer
	 */
	public void addStudentSemesterRegistration(int studentId);
}
