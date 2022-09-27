package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;

/**
 * @author Sebastian
 *
 */

public class CourseCatalogDAOImpl implements CourseCatalogDAO {
	
	private static final String SELECT_ALL_COURSES = "SELECT * FROM coursecatalog";
	
	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost/crs-group-a";
	
	//  Database credentials
	final String USER = "root";
	final String PASS = "root";
	
	private Connection conn = null;
	private PreparedStatement stmt = null;

	@Override
	public List<CourseCatalog> ListOfAllCoursesDAO() {
		
	   List<CourseCatalog> courses = new ArrayList<CourseCatalog>();
	   try {
		   
		  Class.forName("com.mysql.jdbc.Driver");			
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  stmt = conn.prepareStatement(SELECT_ALL_COURSES);
	      ResultSet rs = stmt.executeQuery();
	      while(rs.next()) {
	    	  int id = rs.getInt("Id");
	    	  int professorId = rs.getInt("ProfessorId");
	    	  int departmentId = rs.getInt("DepartmentId");
	    	  String prerequisite = rs.getString("Prerequisite");
	    	  int credits = rs.getInt("Credits");
	    	  int capacity = rs.getInt("Capacity");
	    	  int enrolled = rs.getInt("Enrolled");
	    	  String semester = rs.getString("Semester");
	    	  
	    	  
	    	  CourseCatalog course = new CourseCatalog(id, professorId, 
	    			  departmentId, prerequisite, credits, capacity, enrolled, semester);
	    	  courses.add(course);
	      }
	
	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } finally {
	      //finally block used to close resources
		  try {
		     if(stmt!=null)
		        stmt.close();
		  } catch(SQLException se2){}// nothing we can do
		  try {
		     if(conn!=null)
		        conn.close();
		  } catch(SQLException se){
		     se.printStackTrace();
		  } 
	   } 
	   
	   return courses;
	}

}
