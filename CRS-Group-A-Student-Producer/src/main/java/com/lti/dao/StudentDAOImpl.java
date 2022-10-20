package com.lti.dao;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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
   
	/**
	 * This method registers a student to a specific course
	 * @param student of type Student
	 * @param userId of type int
	 */
	@Override
	public void registerForCourseDAO(Student student, int courseId) {
		
		logger.info("From the registerForCourseDAO method");
		jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID, 
				student.getId(), 
				courseId);
	}

	/**
	 * This method registers a student to a specific course
	 * @param student of type Student
	 * @param courseId of type int
	 * @return int returns the course id of the course just added
	 */
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

	/**
	 * This method drops a course for a specific student
	 * @param student of type Student
	 * @param courseId of type int
	 */
	@Override
	public void dropCourseDAO(Student student, int courseId) {
		
       logger.info("From the dropCourseDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
			SQLQueries.DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID, 
			student.getId(),
			courseId); 
	}

	/**
	 * This method gets a list of grades for a specific student
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return RegisteredCourse returns a registered course
	 */
	@Override
	public List<Grade> viewGradesDAO(int studentId) {
		
		logger.info("From the viewGradesDAO method");
		List<Grade> grades = null;
		try {
			grades = jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_GRADES_BY_STUDENTID, 
				new Object[] {studentId},
				new GradeMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return grades;
	}

	/**
	 * This method updates the payment status for a specific student
	 * @param studentId of type int
	 * @param paymentMethod of type String
	 */
	@Override
	public void payFeeDAO(int studentId, String paymentMethod) {
		
	   logger.info("From the payFeeDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
			SQLQueries.UPDATE_PAYMENT_BY_STUDENTID, 
			new Object[] {1,paymentMethod,studentId});	
	}	   
	
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
	 * This method gets all courses for a specific student
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return List<Course> returns a list of courses
	 */
	@Override
	public List<Course> getStudentCoursesDAO(int studentId) {
		
		logger.info("From the getStudentCourseDAO method");
		List<Course> courses = null;
		try {
			courses = jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_STUDENT_COURSES_BY_STUDENTID, 
				new Object[] {studentId},
				new CourseMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return courses;
	}

	/**
	 * This method gets a list of registered students
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return List<RegisteredCourse> returns a list of registered courses
	 */
	@Override
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId) {
		
		logger.info("From the getStudentRegisteredCoursesDAO method");
		List<RegisteredCourse> rcourses = null;
		try {
			rcourses = jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID, 
				new Object[] {studentId},
				new RegisteredCourseMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return rcourses;
	}
	
	/**
	 * This method gets a list of registered courses
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return List<RegisteredCourse> returns a list of registered courses
	 */
	@Override
	public List<RegisteredCourse> getRegisteredCoursesDAO() {
		
		logger.info("From the getStudentRegisteredCoursesDAO method");
		List<RegisteredCourse> rcourses = null;
		try {
			rcourses = jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_REGISTERED_COURSES, 
				new RegisteredCourseMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return rcourses;
	}

	/**
	 * This method generates a bill for a specific student
	 * @param studentId of type int
	 * @param payment of type Payment
	 */
	@Override
	public void generatePaymentDAO(int studentId, Payment payment) {
		
	   logger.info("From the generatePaymentDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
			SQLQueries.DELETE_PAYMENT_FOR_STUDENT_COURSES, 
			studentId);
	   
	    jdbcTemplateObject.jdbcTemplate().update(
			SQLQueries.INSERT_PAYMENT_FOR_STUDENT_COURSES, 
			new Object[] { 
					payment.getPaymentAmount(), 
					studentId, Date.valueOf(payment.getDueDate()), 
					payment.getSemester()});
	}

	/**
	 * This method gets a list of registered courses with more details
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return List<CourseCatalog> returns a list of courses with details from the course catalog
	 */
	@Override
	public List<CourseCatalog> getRegisteredCourseDataDAO(int studentId) {
		
		logger.info("From the getRegisteredCourseDataDAO method");
		List<CourseCatalog> courses = null;
		try {
			courses = jdbcTemplateObject.jdbcTemplate().query(
					SQLQueries.SELECT_REGISTERED_COURSE_DATA_BY_STUDENTID, 
					new Object[] {studentId},
					new CourseCatalogMapper());
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return courses;
	}

	/**
	 * This method gets/view the bill for the semester
	 * @param studentId of type int
	 * @exception IncorrectResultSizeDataAccessException is caught when there no matching data
	 * @return Payment returns a payment
	 */
	@Override
	public Payment getFeeDAO(int studentId) {
		
	   logger.info("From the getFeeDAO method");
	   Payment payment = null;
	   try {
		   payment = jdbcTemplateObject.jdbcTemplate().queryForObject(
				SQLQueries.SELECT_PAYMENT_BY_STUDENTID, 
				new Object[] {studentId},
				new PaymentMapper());
	   } catch(IncorrectResultSizeDataAccessException e) {
		   return null;
	   }
	   return payment;
	}

	/**
	 * This method add a student registration
	 * @param studentId of type int
	 */
	@Override
	public void addStudentSemesterRegistrationDAO(int studentId) {
		
		logger.info("From the addStudentSemesterRegistrationDAO method");
	   jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.INSERT_STUDENT_SEMESTER_REGISTRATION, 
				studentId);
	}
}
