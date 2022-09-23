package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.constant.SQLQueries;
import com.lti.utils.DBUtils;

/**
 * @author Sebastian
 *
 */

public class StudentDAOImpl implements StudentDAO {
	  
	private Connection conn = null;
	private PreparedStatement stmt = null;
   

	@Override
	public void registerForCourseDAO(Student student, int courseId) {
		
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	}

	@Override
	public int addCourseDAO(Student student, int courseId) {
		
	   int _courseId = -1;
	   try {
		   
		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.INSERT_STUDENT_COURSE);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.setInt(3, 0);
	      stmt.setString(4, null);
	      stmt.executeUpdate();	
	      
	      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_COURSE);
	      stmt.setInt(1, courseId);
	      stmt.setInt(2, student.getId());
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	    	  _courseId = rs.getInt("CourseId");
	      }
	    
	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } 	
	   
	   return _courseId;
	}
	
	@Override
	public RegisteredCourse getCourseDAO(Student student, int courseId) {
		
		RegisteredCourse rcourse = null;
	   try {
		   
		  conn = DBUtils.getConnection();

	      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_COURSE);
	      stmt.setInt(1, courseId);
	      stmt.setInt(2, student.getId());
	      ResultSet rs = stmt.executeQuery();
	      
	      if(rs.next()) {
	    	  int _courseId = rs.getInt("CourseId");
	    	  int studentId = rs.getInt("StudentId");
	    	  int registeredStatus = rs.getInt("RegistrationStatus");
	    	  String grade = rs.getString("Grade");
	    	  rcourse = new RegisteredCourse(_courseId, studentId, registeredStatus, grade);
	      }
	    
	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } 	
	   
	   return rcourse;
	}

	@Override
	public void dropCourseDAO(Student student, int courseId) {
		
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }		
	}

	@Override
	public List<Grade> viewGradesDAO(Student student) {
		
		List<Grade> grades = new ArrayList<Grade>();
		Grade grade = null;
		Course course = null;
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_GRADES_BY_STUDENTID);
		      stmt.setInt(1,student.getId());
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int id = rs.getInt("CourseId");
		    	  String name = rs.getString("CourseName");
		    	  String _grade = rs.getString("Grade");
		    	  
		    	  course = new Course(id, name, null);
		    	  grade = new Grade(_grade, course);
		    	  grades.add(grade);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return grades;
	}

	@Override
	public void payFeeDAO(Student student, String paymentMethod) {
		
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(SQLQueries.UPDATE_PAYMENT_BY_STUDENTID);
	      stmt.setInt(1, 1);
	      stmt.setString(2, paymentMethod);
	      stmt.setInt(3,student.getId());
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }		  	
}	   
	
	@Override
	public Student getStudentDAO(int studentId) {
		
		Student student = null;
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		    	  int id = rs.getInt("Id");
		    	  String name = rs.getString("Name");
		    	  int majorId = rs.getInt("MajorId");
		    	  String email = rs.getString("Email");
		    	  String phone = rs.getString("Phone");
		    	  String address = rs.getString("Address");
		    	  student = new Student(id, name, majorId, email, phone, address);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return student;
	}

	@Override
	public List<Course> getStudentCoursesDAO(int studentId) {
		
		List<Course> courses = new ArrayList<Course>();
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_COURSES_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int id = rs.getInt("CourseId");
		    	  String name = rs.getString("CourseName");
		    	  courses.add(new Course(id, name, null));
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return courses;
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId) {
		
		List<RegisteredCourse> rcourses = new ArrayList<RegisteredCourse>();
		
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  
		    	  int courseId = rs.getInt("CourseId");
		    	  int _studentId = rs.getInt("StudentId");
		    	  int registrationStatus = rs.getInt("RegistrationStatus");
		    	  String grade = rs.getString("Grade");
		    	  rcourses.add(new RegisteredCourse(courseId, _studentId, registrationStatus, grade));
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return rcourses;
	}

	@Override
	public void generatePaymentDAO(int studentId, Payment payment) {
		
	   try {
			  conn = DBUtils.getConnection();
			  
			  // delete existing payment data
		      stmt = conn.prepareStatement(SQLQueries.DELETE_PAYMENT_FOR_STUDENT_COURSES);
		      stmt.setInt(1, studentId);
		      stmt.executeUpdate();
			  
		      // add new
		      stmt = conn.prepareStatement(SQLQueries.INSERT_PAYMENT_FOR_STUDENT_COURSES);
		      stmt.setInt(1, payment.getPaymentAmount());
		      stmt.setInt(2, studentId);
		      stmt.setDate(3,Date.valueOf(payment.getDueDate()));
		      stmt.setString(4, payment.getSemester());
		      stmt.executeUpdate();

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }	
	}

	@Override
	public List<CourseCatalog> getRegisteredCourseDataDAO(int studentId) {
		
		List<CourseCatalog> courses = new ArrayList<CourseCatalog>();
		CourseCatalog course = null;
		
		   try {
				  conn = DBUtils.getConnection();
				  
			      stmt = conn.prepareStatement(SQLQueries.SELECT_REGISTERED_COURSE_DATA_BY_STUDENTID);
			      stmt.setInt(1,studentId);
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()) {
			    	  
			    	  int courseId = rs.getInt("Id");
			    	  int professorId = rs.getInt("ProfessorId");
			    	  int departmentId = rs.getInt("DepartmentId");
			    	  String prerequisite = rs.getString("Prerequisite");
			    	  int credits = rs.getInt("Credits");
			    	  int capacity = rs.getInt("Capacity");
			    	  int enrolled = rs.getInt("Enrolled");
			    	  String semester = rs.getString("Semester");	
			    	  
			    	  course = new CourseCatalog(courseId, professorId, departmentId, 
			    			  prerequisite, credits, capacity , enrolled, semester);
			    	  courses.add(course);
			      }

			   } catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   } catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
		
		return courses;
	}

	@Override
	public Payment getFeeDAO(int studentId) {
		
	   Payment payment = null;
		
	   try {
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_PAYMENT_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {

		    	  int paymentAmount = rs.getInt("PaymentAmount");
		    	  int _studentId = rs.getInt("StudentId");
		    	  LocalDate date = rs.getDate("DueDate").toLocalDate();
		    	  String semester = rs.getString("Semester");
		    	  int isPaid = rs.getInt("IsPaid");
		    	  String paymentMethod = rs.getString("PaymentMethod");
		    	  
		    	  payment = new Payment(_studentId, paymentAmount, date, semester);
		    	  payment.setIsPaid(isPaid);
		    	  payment.setPaymentMethod(paymentMethod);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		return payment;
	}

	@Override
	public void addStudentSemesterRegistrationDAO(int studentId) {
		
	   try {
			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.INSERT_STUDENT_SEMESTER_REGISTRATION);
		      stmt.setInt(1,studentId);
		      stmt.setInt(2,0);
		      stmt.setString(3,null);
		      stmt.setString(4, null);
		      stmt.executeUpdate();

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	}
}
