package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;
import com.lti.dto.Admin;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
import com.lti.dto.Student;
import com.lti.dto.User;
import com.lti.dto.Grade;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.SemesterRegistrationExistsException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian
 *
 */

@Service
public class AdminService implements AdminServiceOperation {

	private AdminDAO admindao;
	private UserService userService;

	public AdminService() {
		
		admindao = new AdminDAOImpl();
		userService = new UserService();
	} 

	public List<Grade> generateReportCard(int studentID) {
		return admindao.generateReportCardDAO(studentID); 
	}
	
	public void addProfessor(Professor professor) {
		admindao.addProfessorDAO(professor);
	}
	
	public void approveStudentRegistration(int studentID, int approvalStatus) {
		admindao.approveStudentRegistrationDAO(studentID, approvalStatus); 
	}
	
	public void createStudentRegistration(SemesterRegistration semesterRegistration) throws SemesterRegistrationExistsException, UserNotFoundException {
		
		User user = userService.GetUser(semesterRegistration.getStudentId());
		if(user == null) {
			
			throw new UserNotFoundException("User doesn't exists, create an account for the user first");
		}
		
		SemesterRegistration _semesterRegistration = getSemesterRegistration(semesterRegistration.getStudentId());
		if(_semesterRegistration == null) {
			
			admindao.createStudentRegistrationDAO(semesterRegistration);
		}
		else {
			
			throw new SemesterRegistrationExistsException("Student has already been registered for the semester");
		}
	}
	
	public void addCourse(Course course) {
		admindao.addCourseDAO(course);
	}
	
	public void removeCourse(int id) throws CourseNotFoundException {
		admindao.removeCourseDAO(id);
	}
	
	public void updateCourse(int id, String name, String description) throws CourseNotFoundException {
		admindao.updateCourseDAO(id, name, description); 
	}
	
	public Boolean checkAvailability(int id) throws CourseNotFoundException {
		Boolean available = admindao.checkAvailabilityDAO(id);
		if(available) {
			return available;
		}
		else {
			throw new CourseNotFoundException();
		}
	}
	
	public void viewCourses(int studentID) {
		admindao.viewCourses(studentID);
	}

	@Override
	public SemesterRegistration getSemesterRegistration(int studentId) {
		
		return admindao.getSemesterRegistrationDAO(studentId);
	}

	@Override
	public void updateCourseCatalogEnrollmentForCourse(int courseId) {
		
		admindao.updateCourseCatalogEnrollmentForCourseDAO(courseId);		
	}
}
