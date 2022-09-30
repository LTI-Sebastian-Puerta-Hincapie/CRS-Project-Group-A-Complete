package com.lti.dao;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Grade;
import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.mapper.CourseCatalogMapper;
import com.lti.mapper.CourseMapper;
import com.lti.mapper.GradeMapper;
import com.lti.mapper.PaymentMapper;
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
   
	@Override
	public void registerForCourseDAO(Student student, int courseId) {
		
		logger.info("From the registerForCourseDAO method");
		jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID, 
				student.getId(), 
				courseId);
	}

	@Override
	public int addCourseDAO(Student student, int courseId) {
		
	   logger.info("From the addCourseDAO method");
	   return jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.INSERT_STUDENT_COURSE, 
				student.getId(),
				courseId,
				0,
				null); 
	}
	
	@Override
	public RegisteredCourse getCourseDAO(Student student, int courseId) {
		
		logger.info("From the getCourseDAO method");	
		return jdbcTemplateObject.jdbcTemplate().queryForObject(
				SQLQueries.SELECT_STUDENT_COURSE, 
				new Object[]{ courseId, student.getId() },
				new RegisteredCourseMapper());
	}

	@Override
	public void dropCourseDAO(Student student, int courseId) {
		
       logger.info("From the dropCourseDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID, 
				student.getId(),
				courseId); 		
	}

	@Override
	public List<Grade> viewGradesDAO(int studentId) {
		
		logger.info("From the viewGradesDAO method");
		return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_GRADES_BY_STUDENTID, 
				new Object[] {studentId},
				new GradeMapper());
	}

	@Override
	public void payFeeDAO(int studentId, String paymentMethod) {
		
	   logger.info("From the payFeeDAO method");
	   jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.UPDATE_PAYMENT_BY_STUDENTID, 
				new Object[] {1,paymentMethod,studentId},
				new GradeMapper());	  	
}	   
	
	@Override
	public Student getStudentDAO(int studentId) {
		
		logger.info("From the getStudentDAO method");
		return jdbcTemplateObject.jdbcTemplate().queryForObject(
					SQLQueries.SELECT_STUDENT_BY_STUDENTID, 
					new Object[] {studentId},
					new StudentMapper());	
	}

	@Override
	public List<Course> getStudentCoursesDAO(int studentId) {
		
		logger.info("From the getStudentCourseDAO method");
		return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_STUDENT_COURSES_BY_STUDENTID, 
				new Object[] {studentId},
				new CourseMapper());
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId) {
		
		logger.info("From the getStudentRegisteredCoursesDAO method");
		return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID, 
				new Object[] {studentId},
				new RegisteredCourseMapper());
	}

	@Override
	public void generatePaymentDAO(int studentId, Payment payment) {
		
	   logger.info("From the generatePaymentDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.DELETE_PAYMENT_FOR_STUDENT_COURSES, 
				studentId);
	   
		jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.INSERT_PAYMENT_FOR_STUDENT_COURSES, 
				new Object[] { payment.getPaymentAmount(), studentId, Date.valueOf(payment.getDueDate()), payment.getSemester()});	      	
	}

	@Override
	public List<CourseCatalog> getRegisteredCourseDataDAO(int studentId) {
		
		logger.info("From the getRegisteredCourseDataDAO method");
		return jdbcTemplateObject.jdbcTemplate().query(
					SQLQueries.SELECT_REGISTERED_COURSE_DATA_BY_STUDENTID, 
					new Object[] {studentId},
					new CourseCatalogMapper());
	}

	@Override
	public Payment getFeeDAO(int studentId) {
		
	   logger.info("From the getFeeDAO method");
	   return jdbcTemplateObject.jdbcTemplate().queryForObject(
				SQLQueries.SELECT_PAYMENT_BY_STUDENTID, 
				new Object[] {studentId},
				new PaymentMapper());
	}

	@Override
	public void addStudentSemesterRegistrationDAO(int studentId) {
		
	   jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.INSERT_STUDENT_SEMESTER_REGISTRATION, 
				studentId);
	}
}
