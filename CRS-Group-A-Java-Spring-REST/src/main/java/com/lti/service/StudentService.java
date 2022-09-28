package com.lti.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;
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
	
	private StudentDAO studentDao;
	
	public StudentService() {
		
		studentDao = new StudentDAOImpl();
	}
	
	public void registerForCourse(Student student, int courseId) throws CourseNotRegisteredException, StudentCourseNotFoundException 
	{
		
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);
		if(course != null) {
			
			studentDao.registerForCourseDAO(student, courseId);
			
			course = studentDao.getCourseDAO(student, courseId);
			
			if(course.getRegisteredStatus() == 0) {
				throw new CourseNotRegisteredException();
			}
		}
		else {
			
			throw new StudentCourseNotFoundException();
		}
	}
	
	public void addCourse(Student student, int courseId) throws StudentAddCourseException {
		
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);	
		if(course == null) {
			int _courseId = studentDao.addCourseDAO(student, courseId);
			if(_courseId < 0) {
				throw new StudentAddCourseException();
			}
			System.out.println("\n--Course has been added --");
		}
		else System.out.println("\nCourse has already been added for this student");
	}
	
	public void dropCourse(Student student, int courseId) throws StudentDropCourseException, StudentCourseNotFoundException {
		
		RegisteredCourse course = studentDao.getCourseDAO(student, courseId);
		if(course != null) {
			
			studentDao.dropCourseDAO(student, courseId);
			
			course = studentDao.getCourseDAO(student, courseId);
			if(course != null) {
				throw new StudentDropCourseException();
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
		
		List<Grade> grades = studentDao.viewGradesDAO(studentId);
		if(grades == null) {
			throw new StudentCourseNotFoundException();
		}
		return grades;
	}
	
	public void payFee(Student student, String paymentMethod) throws StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException {
		
		System.out.println("\nYou have opted to pay: " + paymentMethod);
		
		Payment payment = studentDao.getFeeDAO(student.getId());
		if(payment != null) {
			
			studentDao.payFeeDAO(student, paymentMethod);
			
			payment = studentDao.getFeeDAO(student.getId());
			if(payment.getIsPaid() == 0) {
				
				throw new StudentMissingFeePaymentException();
			}
		} 
		else {
			
			throw new StudentPaymentRecordNotFoundException();
		}
	}
	
	@Override
	public Student getStudent(int studentId) throws StudentNotFoundException {
		
		Student student = studentDao.getStudentDAO(studentId);
		
		if(student == null) {			
			throw new StudentNotFoundException();
		}
		return student;
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {

		return studentDao.getStudentCoursesDAO(studentId);
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId) {
		
		return studentDao.getStudentRegisteredCoursesDAO(studentId);
	}

	@Override
	public void generatePayment(int studentId) {
		
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
		
		return studentDao.getRegisteredCourseDataDAO(studentId);
	}

	@Override
	public Payment getFee(int studentId) {
		
		return studentDao.getFeeDAO(studentId);
	}

	@Override
	public void addStudentSemesterRegistration(int studentId) {
		
		studentDao.addStudentSemesterRegistrationDAO(studentId);
	}

	@Override
	public RegisteredCourse getCourse(Student student, int courseId)  {

		return studentDao.getCourseDAO(student, courseId);
	}
}
