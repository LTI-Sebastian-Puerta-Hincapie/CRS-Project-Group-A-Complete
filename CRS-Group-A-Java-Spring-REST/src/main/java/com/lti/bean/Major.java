package com.lti.bean;

import org.springframework.stereotype.Component;

/**
 * @author Sebastian
 *
 */

@Component
public class Major {

	private int majorId;
	private String majorName;
	private String description;
	
	public Major() {}
	
	public Major(int majorId, String majorName, String description) {
		
		this.majorId = majorId;
		this.majorName = majorName;
		this.description = description;
	}
	
	/**
	 * @return the majorId
	 */
	public int getMajorId() {
		return majorId;
	}
	/**
	 * @param majorId the majorId to set
	 */
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	/**
	 * @return the majorName
	 */
	public String getMajorName() {
		return majorName;
	}
	/**
	 * @param majorName the majorName to set
	 */
	public void setMajorName(String majorName) {
		this.majorName = majorName;
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
