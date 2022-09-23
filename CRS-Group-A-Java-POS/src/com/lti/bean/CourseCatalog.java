package com.lti.bean;

import java.util.ArrayList;

/**
 * @author Sebastian
 *
 */

public class CourseCatalog {
	
	private ArrayList<Course> courses;
	
	private int id;
	private int professorId;
	private int departmentId;
	private String prerequisites;
	private int credits;
	private int capacity;
	private int enrolled;
	private String semester;
		
	public CourseCatalog(int id, int professorId, int departmentId, 
			String prerequisites, int credits, int capacity, int enrolled, String semester) {
		
		this.id = id;
		this.professorId = professorId;
		this.departmentId = departmentId;
		this.prerequisites = prerequisites;
		this.credits = credits;
		this.capacity = capacity;
		this.enrolled = enrolled;
		this.semester = semester;
	}
	
	public CourseCatalog() {
		
		courses = new ArrayList<Course>();
	}
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the prerequisites
	 */
	public String getPrerequisites() {
		return prerequisites;
	}

	/**
	 * @param prerequisites the prerequisites to set
	 */
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the enrolled
	 */
	public int getEnrolled() {
		return enrolled;
	}

	/**
	 * @param enrolled the enrolled to set
	 */
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}
