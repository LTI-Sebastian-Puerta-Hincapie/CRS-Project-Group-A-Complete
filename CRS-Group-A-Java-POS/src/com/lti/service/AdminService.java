package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
import com.lti.bean.Student;
import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;

/**
 * @author Sebastian
 *
 */

public class AdminService implements AdminServiceOperation {

	private AdminDAO admindao;
	
	public AdminService() {
		admindao = new AdminDAOImpl();
	}

	public void generateReportCard(int studentID) {
		admindao.generateReportCardDAO(studentID);
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
	
	public void removeCourse(int id) {
		admindao.removeCourseDAO(id);
	}
	
	public void updateCourse(int id, String name, String description) {
		admindao.updateCourseDAO(id, name, description); 
	}
	
	public void checkAvailability(int id) {
		admindao.checkAvailabilityDAO(id);
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
