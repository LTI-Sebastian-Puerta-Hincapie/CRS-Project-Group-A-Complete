package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOImpl;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.CourseEnrollment;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentNotFoundException;

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

