package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
import com.lti.bean.Student;
import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;
import com.lti.exception.CourseNotFoundException;

/**
 * @author Sebastian
 *
 */

@Service
public class AdminService implements AdminServiceOperation {

	private AdminDAO admindao;
	
	public AdminService() {
		admindao = new AdminDAOImpl();
	}

	public ArrayList<ArrayList<String>> generateReportCard(int studentID) {
		return admindao.generateReportCardDAO(studentID);
	}
	
	public void addProfessor(Professor professor) {
		admindao.addProfessorDAO(professor);
	}
	
	public void approveStudentRegistration(int studentID, int approvalStatus) {
		admindao.approveStudentRegistrationDAO(studentID, approvalStatus); 
	}
	
	public void createStudentRegistration(SemesterRegistration semesterRegistration) {
		admindao.createStudentRegistrationDAO(semesterRegistration);
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
