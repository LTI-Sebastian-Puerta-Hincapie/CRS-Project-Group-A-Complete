package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDAO;
import com.lti.dao.UserDAO;
import com.lti.dto.Course;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
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

	@Autowired
	private AdminDAO admindao;
	
	@Autowired
	private UserDAO userDao;

	public List<Grade> generateReportCard(int studentID) {
		return admindao.generateReportCardDAO(studentID); 
	}
	
	public void addProfessor(Professor professor) {
		admindao.addProfessorDAO(professor);
	}
	
	public void updateProfessor(Professor professor) {
		admindao.updateProfessorDAO(professor);
	}
	
	public void deleteProfessor(int professorId) {
		admindao.deleteProfessorDAO(professorId);
	}
	
	public void approveStudentRegistration(int studentID, int approvalStatus) {
		admindao.approveStudentRegistrationDAO(studentID, approvalStatus); 
	}
	
	public SemesterRegistration createStudentRegistration(SemesterRegistration semesterRegistration) throws SemesterRegistrationExistsException, UserNotFoundException {
		
		User user = userDao.GetUser(semesterRegistration.getStudentId()); 
		if(user == null) {
			
			throw new UserNotFoundException("User doesn't exists, create an account for the user first");
		}
		
		SemesterRegistration _semesterRegistration = getSemesterRegistration(semesterRegistration.getStudentId());
		if(_semesterRegistration == null) {
			
			_semesterRegistration= admindao.createStudentRegistrationDAO(semesterRegistration);
		}
		else {
			
			throw new SemesterRegistrationExistsException("Student has already been registered for the semester");
		}
		return _semesterRegistration;
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
		return available;
	}
	
	public List<Course> viewCourses(int studentID) {
		return admindao.viewCourses(studentID);
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
