package com.lti.bean;

import org.springframework.stereotype.Component;

/**
 * @author Sebastian
 *
 */

@Component
public class Grade {
	
	private String grade;
	private Course course;
	
	public Grade(String grade, Course course) {
		
		this.grade = grade;
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
