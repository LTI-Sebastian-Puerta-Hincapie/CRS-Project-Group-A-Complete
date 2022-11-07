/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.dto.Course;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
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
	public List<Grade> generateReportCard(int studentID);
	
	/**
	 * This method adds a professor to the database
	 * @param professor of type Professor
	 */
	public void addProfessor(Professor professor);
	
	/**
	 * This method updates are professor
	 * @param professor of type Professor
	 */
	public void updateProfessor(Professor professor);
	
	/**
	 * This method deletes are professor
	 * @param professorId of type integer
	 */
	public void deleteProfessor(int professorId);
	
	/**
	 * This method approves the registration of a student's course
	 * @param studentID of type integer 
	 * @param approvalStatus of type integer 
	 */
	public void approveStudentRegistration(int studentID, int approvalStatus);
	
	/**
	 * Creates StudentRegistration in database
	 * @param semesterRegistration of type SemesterRegistration
	 * @return semesterRegistration
	 */
	public SemesterRegistration createStudentRegistration(SemesterRegistration semesterRegistration) throws SemesterRegistrationExistsException, UserNotFoundException;
	
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
	 * @return 
	 */
	public List<Course> viewCourses(int studentID);
	
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
