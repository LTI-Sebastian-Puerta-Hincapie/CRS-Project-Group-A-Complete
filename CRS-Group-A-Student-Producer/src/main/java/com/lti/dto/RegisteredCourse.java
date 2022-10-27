package com.lti.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RegisteredCourse implements Serializable {
	
	private int courseId;
	private String courseName;
	private int studentId;
	private int registeredStatus;
	private String grade;
	
	public RegisteredCourse() {}
	
	public RegisteredCourse(int courseId, String courseName, int studentId, int registeredStatus, String grade) {

		this.courseName = courseName;
		this.courseId = courseId;
		this.studentId = studentId;
		this.registeredStatus = registeredStatus;
		this.grade = grade;
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
	 * @return the registeredStatus
	 */
	public int getRegisteredStatus() {
		return registeredStatus;
	}
	/**
	 * @param registeredStatus the registeredStatus to set
	 */
	public void setRegisteredStatus(int registeredStatus) {
		this.registeredStatus = registeredStatus;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	
}

