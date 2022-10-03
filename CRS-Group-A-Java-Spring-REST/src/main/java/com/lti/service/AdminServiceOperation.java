/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.SemesterRegistrationExistsException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Jonathan
 *
 */
public interface AdminServiceOperation {
	
	/**
	 * This method generates a report card for the student
	 * @param studentID of type integer
	 */
	public ArrayList<ArrayList<String>> generateReportCard(int studentID);
	
	/**
	 * This method adds a professor to the database
	 * @param professor of type Professor
	 */
	public void addProfessor(Professor professor);
	
	/**
	 * This method approves the registration of a student's course
	 * @param studentID of type integer 
	 * @param approvalStatus of type integer 
	 */
	public void approveStudentRegistration(int studentID, int approvalStatus);
	
	/**
	 * Creates StudentRegistration in database
	 * @param semesterRegistration of type SemesterRegistration
	 */
	public void createStudentRegistration(SemesterRegistration semesterRegistration) throws SemesterRegistrationExistsException, UserNotFoundException;
	
	/**
	 * This method adds a course to the course list
	 * @param course of type Course
	 */
	public void addCourse(Course course);
	
	/**
	 * This method removes the course from the course list
	 * @param courseId of type integer
	 * @throws CourseNotFoundException 
	 */
	public void removeCourse(int courseId) throws CourseNotFoundException;
	
	/**
	 * This method updates a course's information in the course list
	 * @param courseId of type integer
	 * @param courseName of type String
	 * @param description of type String
	 * @throws CourseNotFoundException 
	 */
	public void updateCourse(int courseId, String courseName, String description) throws CourseNotFoundException;
	
	/**
	 * This method checks if a course is available for enrollment
	 * @param courseId of type integer
	 * @throws CourseNotFoundException 
	 */
	public Boolean checkAvailability(int courseId) throws CourseNotFoundException;
	
	/**
	 * This method checks the list of courses a student is registered to
	 * @param studentID of type integer
	 */
	public void viewCourses(int studentID);
	
	/**
	 * This method checks the list of courses a student is registered to
	 * @param studentId of type integer
	 * @return SemesterRegistration returns a list of registered students for the semester
	 */
	public SemesterRegistration getSemesterRegistration(int studentId);
	
	/**
	 * This method updates the enrollment count in the course catalog for a specific course
	 * @param courseId of type integer
	 * @return SemesterRegistration returns a list of registered students for the semester
	 */
	public void updateCourseCatalogEnrollmentForCourse(int courseId);
}
