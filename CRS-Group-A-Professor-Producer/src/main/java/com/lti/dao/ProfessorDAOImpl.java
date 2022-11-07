package com.lti.dao;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.CourseCatalog;
import com.lti.dto.CourseEnrollment;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.mapper.CourseCatalogMapper;
import com.lti.mapper.CourseEnrollmentMapper;
import com.lti.mapper.ProfessorMapper;

@SuppressWarnings("deprecation")
@Service
public class ProfessorDAOImpl implements ProfessorDAO {
	
	Logger logger = LoggerFactory.getLogger(ProfessorDAOImpl.class);
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
    
	public List<Grade> addGradesDAO(String studentId, int courseId, String grade) {
		
		
		try {
		jdbcTemplateObject.jdbcTemplate().update(SQLQueries.UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID,
				new Object[] { grade, studentId, courseId });
		}catch (Exception e) {
		}
		
		return null;
	
	}
	
	@Override
	public void addGradesDAO(int studentId, int courseId, String grade) {
		
		try {
		jdbcTemplateObject.jdbcTemplate().update(
				SQLQueries.UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID, 
				new Object[] { grade, studentId, courseId});	
		}catch (Exception e) {
		}
		
	
	}

	@Override
	public List<CourseEnrollment> viewEnrolledStudentsDAO(int courseId) {
		
		logger.info("From the viewEnrolledStudentsDAO method");
		
		try {
		return jdbcTemplateObject.jdbcTemplate().query(SQLQueries.SELECT_STUDENT_ENROLLMENT_BY_COURSEID,
				new Object[] {courseId}, new CourseEnrollmentMapper());
		}catch (Exception e) {
		}
		
		return null;
		
		}

	@Override
	public Professor getProfessorDAO(int professorId) {
		
		logger.info("From the getProfessorDAO method");
		Professor professor = null;
		try {
			professor = jdbcTemplateObject.jdbcTemplate().queryForObject(
					SQLQueries.SELECT_PROFESSOR_BY_PROFESSORID, 
					new Object[] {professorId},
					new ProfessorMapper());
		} catch (Exception e) {
			return null;
		}	
		return professor;
	}
	
	@Override
	public List<Professor> getProfessorsDAO() {
		
		logger.info("From the getProfessorsDAO method");
		List<Professor> professors = null;
		try {
			professors = jdbcTemplateObject.jdbcTemplate().query(SQLQueries.SELECT_PROFESSORS, new ProfessorMapper());
		} catch (Exception e) {
			return null;
		}	
		return professors;
	}

	@Override
	public List<CourseCatalog> getProfessorCoursesDAO(int professorId) {
		
		logger.info("From the getProfessorCoursesDAO method");
		
		List<CourseCatalog> courses = null;
		
		try {
			courses = jdbcTemplateObject.jdbcTemplate().query(
					SQLQueries.SELECT_PROFESSOR_COURSES_BY_PROFESSORID, 
					new Object[] {professorId},
					new CourseCatalogMapper());
		} catch (Exception e) {
			return null;
		}		
		return courses;
		
	}

}

