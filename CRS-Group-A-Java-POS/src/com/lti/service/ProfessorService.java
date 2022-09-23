package com.lti.service;

import java.util.List;

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

public class ProfessorService implements ProfessorServiceOperation {
	
	private ProfessorDAO professorDao;
	
	public ProfessorService() {
		
		this.professorDao = new ProfessorDAOImpl();
	}
	
	public void addGrades(int studentId, int courseId, String grade) {
		
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
