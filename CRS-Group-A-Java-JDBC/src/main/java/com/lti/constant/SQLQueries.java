package com.lti.constant;

public class SQLQueries {

	// USER
	public static final String SELECT_USER_BY_USERNAME = 
			"SELECT * FROM users WHERE Username = ?";
	
	public static final String SELECT_ALL_USERS = 
			"SELECT * FROM users";
	
	public static final String SELECT_USER_BY_USERID= 
			"SELECT * FROM users WHERE Id = ?";
	
	// STUDENT
	public static final String INSERT_STUDENT_COURSE = 
			"INSERT INTO registeredcourse (StudentId, CourseId, RegistrationStatus, Grade) "
			+ "VALUES (?, ?, ?, ?)";
	
	public static final String SELECT_STUDENT_COURSE = 
			"SELECT * FROM registeredcourse WHERE CourseId = ? AND StudentId = ?";
	
	public static final String SELECT_STUDENT_BY_STUDENTID = "SELECT * FROM students WHERE Id = ?";
	
	public static final String SELECT_STUDENT_COURSES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, c.Description "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "  ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	public static final String DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID = 
			"DELETE FROM registeredcourse WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_GRADES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, rc.Grade "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	public static final String UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID = 
			"UPDATE registeredcourse SET RegistrationStatus = 1 WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID = 
			"SELECT * FROM registeredcourse WHERE StudentId = ? AND RegistrationStatus = 1";
	
	public static final String DELETE_PAYMENT_FOR_STUDENT_COURSES = "DELETE FROM payment WHERE StudentId = ?";
	
	public static final String INSERT_PAYMENT_FOR_STUDENT_COURSES = 
			"INSERT INTO payment (PaymentAmount, StudentId, DueDate, Semester) VALUES (?, ?, ?, ?)";
	
	public static final String SELECT_REGISTERED_COURSE_DATA_BY_STUDENTID = 
			"SELECT * "
			+ "FROM registeredcourse rc "
			+ "JOIN coursecatalog cc "
			+ " ON rc.CourseId = cc.Id "
			+ "WHERE rc.StudentId = ? AND rc.RegistrationStatus = 1";
	
	public static final String SELECT_PAYMENT_BY_STUDENTID = 
			"SELECT * FROM payment WHERE StudentId = ?";
	
	public static final String UPDATE_PAYMENT_BY_STUDENTID = 
			"UPDATE payment SET IsPaid = ?, PaymentMethod = ? WHERE StudentId = ?";
	
	public static final String INSERT_STUDENT_SEMESTER_REGISTRATION = 
			"INSERT INTO semesterregistration (StudentId, ApprovalStatus, AdminId, Comment) VALUES (?, ?, ?, ?)";
	
	// PROFESSOR
	public static final String UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID = 
			"UPDATE registeredcourse SET Grade = ? WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_PROFESSOR_COURSES_BY_PROFESSORID = 
			"SELECT pc.CourseId, cc.Credits, cc.Capacity, cc.Enrolled, cc.Semester "
			+ "FROM professorcourses pc "
			+ "JOIN coursecatalog cc "
			+ " ON pc.CourseId = cc.Id "
			+ "WHERE pc.ProfessorId = ?";
	
	public static final String SELECT_PROFESSOR_BY_PROFESSORID = 
			"SELECT * FROM professors WHERE Id = ?";
	
	public static final String SELECT_STUDENT_ENROLLMENT_BY_COURSEID = 
			"SELECT pc.CourseId, rc.StudentId, s.Name "
			+ "FROM professorcourses pc "
			+ "JOIN registeredcourse rc "
			+ " ON pc.CourseId = rc.CourseId "
			+ "JOIN students s "
			+ " ON rc.StudentId = s.Id "
			+ "WHERE pc.CourseId = ?";
	
	// PASSWORD
	public static final String UPDATE_USER_PASSWORD =
			"UPDATE users SET Password = ? WHERE Username = ? ";
	
	// COURSE CATALOG
	public static final String SELECT_ALL_COURSES = "SELECT * FROM coursecatalog";
	
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
