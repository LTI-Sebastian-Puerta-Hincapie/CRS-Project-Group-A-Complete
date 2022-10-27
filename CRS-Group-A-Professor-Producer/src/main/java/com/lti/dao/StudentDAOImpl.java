package com.lti.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.mapper.RegisteredCourseMapper;
import com.lti.mapper.StudentMapper;

/**
 * @author Sebastian
 *
 */

@SuppressWarnings("deprecation")
@Repository
public class StudentDAOImpl implements StudentDAO {
	  
	Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	
	/**
	 * This method gets a specific student
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return Student returns a student
	 */
	@Override
	public Student getStudentDAO(int studentId) {
		
		logger.info("From the getStudentDAO method");
		Student student = null;
		try {
			student = jdbcTemplateObject.jdbcTemplate().queryForObject(
					SQLQueries.SELECT_STUDENT_BY_STUDENTID, 
					new Object[] {studentId},
					new StudentMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return student;
	}
	
	/**
	 * This method gets a specific registered course for a specific student
	 * @param student of type Student
	 * @param courseId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return RegisteredCourse returns a registered course
	 */
	@Override
	public RegisteredCourse getCourseDAO(Student student, int courseId) {
		
		logger.info("From the getCourseDAO method");
		RegisteredCourse registeredCourse = null;
		try {
			registeredCourse = jdbcTemplateObject.jdbcTemplate().queryForObject(
				SQLQueries.SELECT_STUDENT_COURSE, 
				new Object[]{ courseId, student.getId() },
				new RegisteredCourseMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		
		return registeredCourse;
	}
   
}