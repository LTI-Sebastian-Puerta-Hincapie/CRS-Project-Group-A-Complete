package com.lti.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Grade;
import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.PaymentBillNotCreatedException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.exception.StudentMissingFeePaymentException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentPaymentRecordNotFoundException;

/**
 * @author Sebastian
 *
 */

@Service
public class StudentService implements StudentServiceOperation {
	
	Logger logger = LoggerFactory.getLogger(StudentService.class);
	private StudentDAO studentDao;
	
	public StudentService() {
		
		studentDao = new StudentDAOImpl();
	}
	
	public void registerForCourse(Student student, int courseId) throws CourseNotRegisteredException, StudentCourseNotFoundException 
	{
		logger.info("From registerForCourse service method");
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);
		if(course != null) {
			
			studentDao.registerForCourseDAO(student, courseId);
			
			course = studentDao.getCourseDAO(student, courseId);
			
			if(course.getRegisteredStatus() == 0) {
				throw new CourseNotRegisteredException(
						"\nCourse not registered, courseId: " + courseId + " studentId: " + student.getId());
			}
		}
		else {
			
			throw new StudentCourseNotFoundException(
					"\nCourse not found, courseId: " + courseId + " studentId: " + student.getId());
		}
	}
	
	public void addCourse(Student student, int courseId) throws StudentAddCourseException {
		
		logger.info("From addCourse service method");
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);	
		if(course == null) {
			int _courseId = studentDao.addCourseDAO(student, courseId);
			if(_courseId < 0) {
				throw new StudentAddCourseException(
						"\nCourse was not added, courseId: " + courseId + " studentId: " + student.getId());
			}
			System.out.println("\n--Course has been added --");
		}
		else System.out.println("\nCourse has already been added for this student");
	}
	
	public void dropCourse(Student student, int courseId) throws StudentDropCourseException, StudentCourseNotFoundException {
		
		logger.info("From dropCourse service method");
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);
		if(course != null) {
			
			studentDao.dropCourseDAO(student, courseId);
			
			course = studentDao.getCourseDAO(student, courseId);
			if(course != null) {
				throw new StudentDropCourseException(
						"\nUnable to drop course, courseId: " + courseId + " studentId: " + student.getId());
			}
			else {
				System.out.println("\nCourse has been dropped");
			}
		}
		else {
			throw new StudentCourseNotFoundException();
		}
	}

	public List<Grade> viewGrades(int studentId) throws StudentCourseNotFoundException {
		
		logger.info("From viewGrades service method");
		List<Grade> grades = studentDao.viewGradesDAO(studentId);
		if(grades == null) {
			throw new StudentCourseNotFoundException("Grades are not available because no courses were found for this student");
		}
		return grades;
	}
	
	public void payFee(int studentId, String paymentMethod) throws StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException {
		
		logger.info("From payFee service method");
		System.out.println("\nYou have opted to pay: " + paymentMethod);
		
		Payment payment = studentDao.getFeeDAO(studentId);
		if(payment != null) {
			
			studentDao.payFeeDAO(studentId, paymentMethod);
			
			payment = studentDao.getFeeDAO(studentId);
			if(payment.getIsPaid() == 0) {
				
				throw new StudentMissingFeePaymentException("Fee amount has not been paid");
			}
		} 
		else {
			
			throw new StudentPaymentRecordNotFoundException("Payment bill not available for this student, check if student has registered for courses");
		}
	}
	
	@Override
	public Student getStudent(int studentId) throws StudentNotFoundException {
		
		logger.info("From getStudent service method");
		Student student = studentDao.getStudentDAO(studentId);
		
		if(student == null) {			
			throw new StudentNotFoundException("Student not found, studentId: " + studentId);
		}
		return student;
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {

		logger.info("From getStudentCourses service method");
		return studentDao.getStudentCoursesDAO(studentId);
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId) {
		
		logger.info("From getStudentRegisteredCourses service method");
		return studentDao.getStudentRegisteredCoursesDAO(studentId);
	}

	@Override
	public void generatePayment(int studentId) {
		
		logger.info("From generatePayment service method");
		List<CourseCatalog> courses = getRegisteredCourseData(studentId);
		int totalCredits = 0;
		int COST_PER_CREDIT = 1125;
		
		for(CourseCatalog course : courses) {
			
			totalCredits += course.getCredits();
		}
		
		int amount = COST_PER_CREDIT * totalCredits;
		Payment payment = new Payment(studentId, amount, LocalDate.now().plusDays(30), "Fall 2022");
		studentDao.generatePaymentDAO(studentId, payment);
	}

	@Override
	public List<CourseCatalog> getRegisteredCourseData(int studentId) {
		
		logger.info("From getRegisteredCourseData service method");
		return studentDao.getRegisteredCourseDataDAO(studentId);
	}

	@Override
	public Payment getFee(int studentId) {
		
		logger.info("From getFee service method");
		return studentDao.getFeeDAO(studentId);
	}

	@Override
	public void addStudentSemesterRegistration(int studentId) {
		
		logger.info("From addStudentSemesterRegistration service method");
		studentDao.addStudentSemesterRegistrationDAO(studentId);
	}

	@Override
	public RegisteredCourse getCourse(Student student, int courseId)  {

		logger.info("From getCourse service method");
		return studentDao.getCourseDAO(student, courseId);
	}
}
