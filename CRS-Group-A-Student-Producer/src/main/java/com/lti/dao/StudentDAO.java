/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Grade;
import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentDAO {

	/**
	 * This method registers a student for a specific course 
	 * @param student of type integer
	 * @param courseId of type integer
	 */
	public void registerForCourseDAO(Student student, int courseId);
	
	/**
	 * This method adds a course for a specific student
	 * @param student of type Student
	 * @param courseId of type integer
	 * @return Integer returns the courseId
	 */
	public int addCourseDAO(Student student, int courseId);
	
	/**
	 * This method gets a course for a specific student and courseId
	 * @param student of type Student
	 * @param courseId of type integer
	 * @return RegisteredCourse returns a register course
	 */
	public RegisteredCourse getCourseDAO(Student student, int courseId);
	
	/**
	 * This method drops a course for a specific student
	 * @param student of type Student
	 * @param courseId of type integer
	 */
	public void dropCourseDAO(Student student, int courseId);
	
	/**
	 * This method view grades for a specific student and returns a list of grades
	 * @param studentId of type int
	 * @return List<Grade> returns a list of grades for a specific student
	 */
	public List<Grade> viewGradesDAO(int studentId);
	
	/**
	 * This method makes a payment for the courses that the student is registered for
	 * @param studentId of type int
	 * @param paymentMethod of type String
	 */
	public void payFeeDAO(int studentId, String paymentMethod);
	
	/**
	 * This method gets the student data 
	 * @param studentId of type integer
	 * @return Student returns a student
	 */
	public Student getStudentDAO(int studentId);
	
	/**
	 * This method gets all courses for a specific student that they have added
	 * @param studentId of type integer
	 * @return List<Course> returns a list of courses
	 */
	public List<Course> getStudentCoursesDAO(int studentId);
	
	/**
	 * This method gets all courses
	 * @return List<Course> returns a list of courses
	 */
	public List<Course> getCoursesDAO();
	
	/**
	 * This method gets all registered courses for a specific student
	 * @param studentId of type integer
	 * @return List<RegisteredCourse> returns a list of registered courses
	 */
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId);
	
	/**
	 * This method gets all registered courses 
	 * @return List<RegisteredCourse> returns a list of registered courses
	 */
	public List<RegisteredCourse> getRegisteredCoursesDAO();
	
	/**
	 * This method add payment data (amount, due date, semester, etc.) to the system
	 * @param studentId of type integer
	 * @param Payment returns a payment for a specific student
	 */
	public void generatePaymentDAO(int studentId, Payment payment);
	
	/**
	 * This method gets course data from course catalog and returns a list of courses
	 * @param studentId of type integer
	 */
	public List<CourseCatalog> getRegisteredCourseDataDAO(int studentId);
	
	/**
	 * This method gets fee/payment due for a specific student 
	 * @param studentId of type integer
	 * @return Payment
	 */
	public Payment getFeeDAO(int studentId);
	
	/**
	 * This methods adds student semester registration for admin approval
	 * @param studentId of type integer
	 */
	public void addStudentSemesterRegistrationDAO(int studentId);
}
