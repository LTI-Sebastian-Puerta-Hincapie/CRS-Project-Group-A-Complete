package com.lti.bean;

import org.springframework.stereotype.Component;

@Component
public class CourseEnrollment {
	
    private int courseId;
    private int studentId;
    private String studentName;
    
    public CourseEnrollment() {}
      
	public CourseEnrollment(int courseId, int studentId, String studentName) {

		this.courseId = courseId;
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
    
   
}
