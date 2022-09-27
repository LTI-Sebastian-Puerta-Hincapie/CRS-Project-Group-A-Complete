package com.lti.bean;

import org.springframework.stereotype.Component;

/**
 * @author Sebastian
 *
 */

@Component
public class Department {
	
	private int departmentId;
	private String departmentName;
	private String description;
	
	public Department(int departmentId, String departmentName, String description) {
		
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.description = description;
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
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
