package com.lti.bean;

import org.springframework.stereotype.Component;

@Component
public class RegisteredCourse {
	
	private int CourseId;
	private int StudentId;
	private int RegisteredStatus;
	private String Grade;
	
	public RegisteredCourse() {}
	
	public RegisteredCourse(int courseId, int studentId, int registeredStatus, String grade) {

		CourseId = courseId;
		StudentId = studentId;
		RegisteredStatus = registeredStatus;
		Grade = grade;
	}
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return CourseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return StudentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	/**
	 * @return the registeredStatus
	 */
	public int getRegisteredStatus() {
		return RegisteredStatus;
	}
	/**
	 * @param registeredStatus the registeredStatus to set
	 */
	public void setRegisteredStatus(int registeredStatus) {
		RegisteredStatus = registeredStatus;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}	
}

