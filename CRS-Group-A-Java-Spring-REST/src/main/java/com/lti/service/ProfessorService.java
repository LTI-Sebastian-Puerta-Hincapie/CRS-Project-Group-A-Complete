package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Professor;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOImpl;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;
import com.lti.exception.NoEnrolledStudentsFoundException;
import com.lti.exception.ProfessorNotFoundException;
import com.lti.exception.ProfessorNotRegisteredForCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentNotFoundException;

/**
 * @author Sebastian, Rehmath
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

		// validate whether student exists in system
		if (student == null) {
			throw new StudentNotFoundException();
		}

		RegisteredCourse registeredCourse = studentDao.getCourseDAO(student, courseId);

		// validate whether student has registered for the course
		if (registeredCourse == null) {
			throw new StudentCourseNotFoundException();
		}

		// Validate the registration status is approved or not
		if (registeredCourse.getRegisteredStatus() != 1) {
			throw new StudentCourseRegistrationNotFoundException(student.getName());
		}

		professorDao.addGradesDAO(studentId, courseId, grade);
	}
	
	public List<CourseEnrollment> viewEnrolledStudents(int courserId) throws NoEnrolledStudentsFoundException{
		
		List<CourseEnrollment> courseEnrollmentList = professorDao.viewEnrolledStudentsDAO(courserId);
		
		if(courseEnrollmentList==null || courseEnrollmentList.isEmpty()) {
			throw new NoEnrolledStudentsFoundException();
		}
		
		return courseEnrollmentList;
		
	}

	@Override
	public Professor getProfessor(int professorId) throws ProfessorNotFoundException{

		Professor professor = professorDao.getProfessorDAO(professorId);
		
		if(professor == null) {
			throw new ProfessorNotFoundException();
		}
		
		return professor;
	}

	@Override
	public List<CourseCatalog> getProfessorCourses(int professorId) throws ProfessorNotRegisteredForCourseException{

		List<CourseCatalog> catalogList = professorDao.getProfessorCoursesDAO(professorId);
		
		if(catalogList==null || catalogList.isEmpty()) {
			throw new ProfessorNotRegisteredForCourseException();
		}
		
		return catalogList;
	}
}
