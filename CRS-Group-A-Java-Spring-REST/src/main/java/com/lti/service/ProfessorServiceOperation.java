/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.exception.NoEnrolledStudentsFoundException;
import com.lti.exception.ProfessorNotFoundException;
import com.lti.exception.ProfessorNotRegisteredForCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentNotFoundException;

/**
 * @author Sebastian
 *
 */
public interface ProfessorServiceOperation {
	
	/**
	 * This method that add grades for a specific student 
	 * @param studentId of type integer
	 * @param courseId of type integer
	 * @param grade of type String
	 */
	public void addGrades(int studentId, int courseId, String grade)  throws StudentNotFoundException,
	StudentCourseNotFoundException, StudentCourseRegistrationNotFoundException;

	
	/**
	 * This method returns a list of all enrolled students in a specific course
	 * @param courseId of type integer
	 * @return List<CourseEnrollment> returns a list of students enrolled in a specific course
	 */
	public List<CourseEnrollment> viewEnrolledStudents(int courseId)  throws NoEnrolledStudentsFoundException;
	
	/**
	 * This method gets the professor data 
	 * @param professorId of type integer
	 * @return Professor returns a professor object
	 */
	public Professor getProfessor(int professorId)  throws ProfessorNotFoundException;
	
	/**
	 * This method gets all courses for a specific professor
	 * @param professorId of type integer
	 * @return List<CourseCatalog> returns a list of courses that the professor will be teaching
	 */
	public List<CourseCatalog> getProfessorCourses(int professorId)  throws ProfessorNotRegisteredForCourseException;
}
