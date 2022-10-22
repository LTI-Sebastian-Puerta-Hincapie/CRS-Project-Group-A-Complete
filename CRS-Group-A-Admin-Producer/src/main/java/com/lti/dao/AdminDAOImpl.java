package com.lti.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.SemesterRegistration;
import com.lti.exception.CourseNotFoundException;
import com.lti.mapper.CourseCatalogMapper;
import com.lti.mapper.CourseMapper;
import com.lti.mapper.GradeMapper;
import com.lti.mapper.SemesterRegistrationMapper;

@SuppressWarnings("deprecation")
@Repository
public class AdminDAOImpl implements AdminDAO{
    
    Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
    
    @Autowired
    private JDBCConfiguration jdbcTemplateObject;
    
	
	@Override
	public List<Grade> generateReportCardDAO(int studentID) {
		logger.info("in generateReportCardDAO");
		return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_GRADES_BY_STUDENTID, 
				new Object[] {studentID},
				new GradeMapper());
		
	}

	@Override
	public void addProfessorDAO(Professor professor) {
		
		try {
			jdbcTemplateObject.jdbcTemplate().update(SQLQueries.INSERT_PROFESSOR, professor.getId(), professor.getName(), professor.getDepartmentId(),professor.getEmail(),professor.getPhone(),professor.getAddress());
		} catch(Exception e) {
			System.out.println("Professor has not been added"); 
		}
	}
	
	@Override
	public void updateProfessorDAO(Professor professor) {
		
		try {
			jdbcTemplateObject.jdbcTemplate().update(
					SQLQueries.INSERT_PROFESSOR, 
					professor.getId(),
					professor.getName(), 
					professor.getDepartmentId(),
					professor.getEmail(),
					professor.getPhone(),
					professor.getAddress());
		} catch(Exception e) {
			System.out.println("Professor has not been updated"); 
		}
	}
	
	@Override
	public void deleteProfessorDAO(int professorId) {
		
		try {
			jdbcTemplateObject.jdbcTemplate().update(SQLQueries.DELETE_PROFESSOR, professorId);
		} catch(Exception e) {
			System.out.println("Professor has not been deleted"); 
		}
	}
	
	@Override
	public void approveStudentRegistrationDAO(int studentID, int approvalStatus) {
		try{
			jdbcTemplateObject.jdbcTemplate().update(
					SQLQueries.UPDATE_SEMESTERREGISTRATION_APPROVALSTATUS_BY_STUDENTID, 
					approvalStatus,
					"Approved",
					studentID);
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void createStudentRegistrationDAO(SemesterRegistration semesterRegistration) {
		try {
			jdbcTemplateObject.jdbcTemplate().update(
					SQLQueries.INSERT_SEMESTERREGISTRATION, 
					semesterRegistration.getStudentId(), 
					semesterRegistration.getApprovalStatus(), 
					semesterRegistration.getAdminId(), 
					semesterRegistration.getComments());
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	@Override
	public void addCourseDAO(Course course) {
		try{
			jdbcTemplateObject.jdbcTemplate().update(SQLQueries.INSERT_COURSE, course.getCourseId(), course.getCourseName(), course.getDescription());
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	

	@Override
	public void removeCourseDAO(int id) throws CourseNotFoundException {
		try{
			jdbcTemplateObject.jdbcTemplate().update(SQLQueries.DELETE_COURSE_BY_COURSEID, id);
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourseDAO(int id, String name, String description) throws CourseNotFoundException {
		try{
			jdbcTemplateObject.jdbcTemplate().update(SQLQueries.UPDATE_COURSE_BY_COURSEID, name, description, id);
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	@Override
	public Boolean checkAvailabilityDAO(int id){
		try{
			CourseCatalog course = jdbcTemplateObject.jdbcTemplate().queryForObject(
					SQLQueries.SELECT_COURSECATALOG_BY_COURSEID, 
					new Object[] {id},
					new CourseCatalogMapper());
			if(course.getEnrolled() < course.getCapacity()) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> viewCourses(int studentID) {
		System.out.println("Student " + studentID + " is registered for the following courses:");
			return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_STUDENT_COURSES_BY_STUDENTID, 
				new Object[] {studentID},
				new CourseMapper());
	}

	@Override
	public SemesterRegistration getSemesterRegistrationDAO(int studentId) {
		
		SemesterRegistration registration = null;
		   try {
				registration = jdbcTemplateObject.jdbcTemplate().queryForObject(
						SQLQueries.SELECT_SEMESTER_REGISTRATION_BY_STUDENTID, 
						new Object[] {studentId},
						new SemesterRegistrationMapper());
		   } catch(IncorrectResultSizeDataAccessException e){
		      //Handle errors for Class.forName
		      return null;
		   }
		
		return registration;
	}

	@Override
	public void updateCourseCatalogEnrollmentForCourseDAO(int courseId) {
	/*
	   int totalEnrolled = 0;
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.SELECT_ENROLLMENT_COURSE_CATALOG_BY_COURSEID);
	      stmt.setInt(1,courseId);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	    	  totalEnrolled = rs.getInt("Enrolled");
	      }
		  
	      stmt = conn.prepareStatement(SQLQueries.UPDATE_ENROLLMENT_COURSE_CATALOG_BY_COURSEID);
	      stmt.setInt(1, totalEnrolled + 1);
	      stmt.setInt(2,courseId);
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }	*/	
	}

}
