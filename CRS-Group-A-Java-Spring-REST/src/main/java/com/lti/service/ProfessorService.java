package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOImpl;

/**
 * @author Sebastian
 *
 */

@Service
public class ProfessorService implements ProfessorServiceOperation {
	
	private ProfessorDAO professorDao;
	private StudentDAO studentDao = null;
	
	public ProfessorService() {
		
		this.professorDao = new ProfessorDAOImpl();
		this.studentDao = new StudentDAOImpl();
	}
	
	public void addGrades(int studentId, int courseId, String grade) throws StudentNotFoundException,
	StudentCourseNotFoundException, StudentCourseRegistrationNotFoundException {

	Student student = studentDao.getStudentDAO(studentId);

	//validate whether student exists in system
	if(student == null) {
	throw new StudentNotFoundException();
	}
	RegisteredCourse registeredCourse = studentDao.getCourseDAO(student, courseId);

	//validate whether student has registered for the course
	if(registeredCourse == null) {
	throw new StudentCourseNotFoundException();
	}

	//Validate the registration status is approved or not
	if(registeredCourse.getRegisteredStatus()!=1) {
	throw new StudentCourseRegistrationNotFoundException(student.getName());
	}

	professorDao.addGradesDAO(studentId, courseId, grade);
	}
	
	public List<CourseEnrollment> viewEnrolledStudents(int courserId) {
		
		return professorDao.viewEnrolledStudentsDAO(courserId);
	}

	@Override
	public Professor getProfessor(int professorId) {

		return professorDao.getProfessorDAO(professorId);
	}

	@Override
	public List<CourseCatalog> getProfessorCourses(int professorId) {

		return professorDao.getProfessorCoursesDAO(professorId);
	}
}

