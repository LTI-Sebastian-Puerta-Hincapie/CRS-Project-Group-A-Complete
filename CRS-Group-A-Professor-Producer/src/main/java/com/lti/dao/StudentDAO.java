/**
 * 
 */
package com.lti.dao;

import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentDAO {
	
	/**
	 * This method gets the student data 
	 * @param studentId of type integer
	 * @return Student returns a student
	 */
	public Student getStudentDAO(int studentId);
	
	
	/**
	 * This method gets a course for a specific student and courseId
	 * @param student of type Student
	 * @param courseId of type integer
	 * @return RegisteredCourse returns a register course
	 */
	public RegisteredCourse getCourseDAO(Student student, int courseId);
	
}
