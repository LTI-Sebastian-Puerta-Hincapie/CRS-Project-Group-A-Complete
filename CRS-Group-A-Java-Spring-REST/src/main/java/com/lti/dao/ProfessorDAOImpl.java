package com.lti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.constant.SQLQueries;
import com.lti.exception.NoEnrolledStudentsFoundException;
import com.lti.exception.ProfessorNotFoundException;
import com.lti.exception.ProfessorNotRegisteredForCourseException;
import com.lti.utils.DBUtils;


public class ProfessorDAOImpl implements ProfessorDAO {
	
	Logger logger = LoggerFactory.getLogger(ProfessorDAOImpl.class);
    
    public List<Grade> addGradesDAO(String student, int courseId, String grade) {
        // TODO Auto-generated method stub
    	 try {  
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID);
		      
		      //TODO: Update the Professor interfaces + classes to pass in a Grade (String)
		      stmt.setString(1, grade);
		      stmt.setString(2,student);
		      stmt.setInt(3, courseId);
		      stmt.executeUpdate();	
		    
		   } catch(SQLException se){
			   logger.error("JDBC exception occured while adding grades",se);
		   } catch(Exception e){
			   logger.error("Generic exception occured while adding grades",e);
		   }
	

        return null;
    }
    
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	@Override
	public void addGradesDAO(int studentId, int courseId, String grade) {
		
	   try {  
		   
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID);
		      
		      //TODO: Update the Professor interfaces + classes to pass in a Grade (String)
		      stmt.setString(1, grade);
		      stmt.setInt(2,studentId);
		      stmt.setInt(3, courseId);
		      stmt.executeUpdate();	
		    
		   } catch(SQLException se){
			   logger.error("JDBC exception occured while adding grades",se);
		   } catch(Exception e){
			   logger.error("Generic exception occured while adding grades",e);
		   }
	}


	@Override
	public List<CourseEnrollment> viewEnrolledStudentsDAO(int courseId) {
		
		List<CourseEnrollment> courseEnrollment = new ArrayList<CourseEnrollment>();
		CourseEnrollment courseEnrollmentEntry; 
		   try {  
				  conn = DBUtils.getConnection();
				  
			      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_ENROLLMENT_BY_COURSEID);
			      
			    
			      
			      //TODO: Update the Professor interfaces + classes to pass in a Grade (String)
			      stmt.setInt(1, courseId);
			      ResultSet rs = stmt.executeQuery();
			    
			      while(rs.next()) {
			    	  int _courseId = rs.getInt("CourseId");
			    	  int studentId = rs.getInt("studentId");
			    	  String studentName = rs.getString("Name");
			    	  courseEnrollmentEntry = new CourseEnrollment(_courseId, studentId, studentName);
			    	  courseEnrollment.add(courseEnrollmentEntry);
			      }
			      
		   } catch(SQLException se){
					   logger.error("JDBC exception occured while fetching enrolled students",se);
				   } catch(Exception e){
					   logger.error("Generic exception occured fetching enrolled students",e);
				   }
		   
		   return courseEnrollment;
	}

	@Override
	public Professor getProfessorDAO(int professorId) {
		
		Professor professor = null;
		   try {  
				  conn = DBUtils.getConnection();
				  
			      stmt = conn.prepareStatement(SQLQueries.SELECT_PROFESSOR_BY_PROFESSORID);
			      stmt.setInt(1,professorId);
			      ResultSet rs = stmt.executeQuery();
			      
			      if(rs.next()) {
			    	  int id = rs.getInt("Id");
			    	  String name = rs.getString("Name");
			    	  int departmentId = rs.getInt("DepartmentId");
			    	  String email = rs.getString("Email");
			    	  String phone = rs.getString("Phone");
			    	  String address = rs.getString("Address");
			    	  professor = new Professor(id, name, departmentId, email, phone, address);
			      }
			    
		   } catch(SQLException se){
			   logger.error("JDBC exception occured while fetching professor details",se);
		   } catch(Exception e){
			   logger.error("Generic exception occured fetching professor details",e);
		   }
		   return professor;
	}

	@Override
	public List<CourseCatalog> getProfessorCoursesDAO(int professorId) {
		
		List<CourseCatalog> courses = new ArrayList<CourseCatalog>();
		CourseCatalog course = null;
		
	   try {  
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_PROFESSOR_COURSES_BY_PROFESSORID);
		      
		      //TODO: Update the Professor interfaces + classes to pass in a Grade (String)
		      stmt.setInt(1,professorId);
		      ResultSet rs = stmt.executeQuery();	
		     
		      
		      while(rs.next()) {
		    	  
		    	  int courseId = rs.getInt("CourseId");
		    	  int credits = rs.getInt("Credits");
		    	  int capacity = rs.getInt("Capacity");
		    	  int enrolled = rs.getInt("Enrolled");
		    	  String semester = rs.getString("Semester");
		    	  course = new CourseCatalog(courseId, 0, 0, null, credits, capacity, enrolled, semester);
		    	  courses.add(course);
		      }
		    
	   } catch(SQLException se){
		   logger.error("JDBC exception occured while fetching course catalog by professor",se);
	   } catch(Exception e){
		   logger.error("Generic exception occured fetching course catalog by professor",e);
	   }
	   
	   return courses;
	}

}

