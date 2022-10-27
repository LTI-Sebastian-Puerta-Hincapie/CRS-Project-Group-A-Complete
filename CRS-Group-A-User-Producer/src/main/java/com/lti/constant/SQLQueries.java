package com.lti.constant;

public class SQLQueries {
	
	// STUDENT
	public static final String SELECT_GRADES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, rc.Grade "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	public static final String SELECT_STUDENT_COURSES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, c.Description "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "  ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	

	// USER
	public static final String SELECT_USER_BY_USERNAME = 
			"SELECT * FROM users WHERE Username = ?";
	
	public static final String SELECT_ALL_USERS = 
			"SELECT * FROM users";
	
	public static final String SELECT_USER_BY_USERID= 
			"SELECT * FROM users WHERE Id = ?";
		
	// PASSWORD
	public static final String UPDATE_USER_PASSWORD =
			"UPDATE users SET Password = ? WHERE Username = ? ";
	
	// ADMIN
	public static final String SELECT_SEMESTER_REGISTRATION_BY_STUDENTID = 
			"SELECT * FROM semesterregistration WHERE StudentId = ?";
	
	public static final String SELECT_ENROLLMENT_COURSE_CATALOG_BY_COURSEID = 
			"SELECT Enrolled FROM coursecatalog WHERE Id = ?";
	
	public static final String UPDATE_ENROLLMENT_COURSE_CATALOG_BY_COURSEID = 
			"UPDATE coursecatalog SET Enrolled = ? WHERE Id = ?";
	
	public static final String INSERT_PROFESSOR = 
			"insert into professors values(?,?,?,?,?,?)";
	
	public static final String UPDATE_SEMESTERREGISTRATION_APPROVALSTATUS_BY_STUDENTID = 
			"UPDATE semesterregistration SET ApprovalStatus = ?, Comment = ? WHERE StudentId = ?";
	
	public static final String INSERT_SEMESTERREGISTRATION = 
			"insert into semesterregistration(StudentId,ApprovalStatus,AdminId,Comment) values(?,?,?,?)";
	
	public static final String INSERT_COURSE = 
			"insert into course values(?,?,?)";
	
	public static final String DELETE_COURSE_BY_COURSEID = 
			"DELETE from course where CourseID=?";
	
	public static final String UPDATE_COURSE_BY_COURSEID = 
			"UPDATE course SET CourseName=?, Description=? WHERE CourseID=?";
	
	public static final String SELECT_COURSECATALOG_BY_COURSEID = 
			"SELECT * From coursecatalog WHERE Id = ?";
}
