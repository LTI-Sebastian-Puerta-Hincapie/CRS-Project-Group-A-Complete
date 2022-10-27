/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import com.lti.dto.Course;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
import com.lti.exception.CourseNotFoundException;

/**
 * @author Jonathan
 *
 */
public interface AdminDAO {

	/**
	 * This method generates a report card for the student
	 * @param StudentID of type integer
	 */
	public List<Grade> generateReportCardDAO(int StudentID);
	
	/**
	 * This method adds a professor to the database
	 * @param professor of type Professor
	 */
	public void addProfessorDAO(Professor professor);
	
	/**
	 * This method approves the registration of a student's course
	 * @param studentID of type integer 
	 * @param approvalStatus of type integer
	 */
	public void approveStudentRegistrationDAO(int studentID, int approvalStatus);
	
	/**
	 * Creates StudentRegistration in database
	 * @param semesterRegistration of type SemesterRegistration
	 */
	public void createStudentRegistrationDAO(SemesterRegistration semesterRegistration);
	
	/**
	 * This method adds a course to the course list
	 * @param course of type Course
	 */
	public void addCourseDAO(Course course);
	
	/**
	 * This method removes the course from the course list
	 * @param courseId of type integer
	 */
	public void removeCourseDAO(int courseId) throws CourseNotFoundException;
	
	/**
	 * This method updates a course's information in the course list
	 * @param courseId of type integer
	 * @param courseName of type String
	 * @param description of type String
	 */
	public void updateCourseDAO(int courseId, String courseName, String description) throws CourseNotFoundException;
	
	/**
	 * This method checks if a course is available for enrollment
	 * @param courseId of type integer
	 */
	public Boolean checkAvailabilityDAO(int courseId);
	
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
	public SemesterRegistration getSemesterRegistrationDAO(int studentId);
	
	/**
	 * This method updates the enrollment count in the course catalog for a specific course
	 * @param courseId of type integer
	 * @return SemesterRegistration returns a list of registered students for the semester
	 */
	public void updateCourseCatalogEnrollmentForCourseDAO(int courseId);
	
}
