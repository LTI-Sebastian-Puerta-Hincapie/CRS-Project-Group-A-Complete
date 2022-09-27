package com.lti.bean;

import org.springframework.stereotype.Component;

@Component
public class SemesterRegistration {
	
	private int studentId;
	private int adminId;
	private int registrationId;
	private boolean approvalStatus;
	private String comments;
	
	public SemesterRegistration() {
	}
	
	
	
	public SemesterRegistration(int studentId, int adminId, boolean approvalStatus,
			String comments) {
		super();
		this.studentId = studentId;
		this.adminId = adminId;
		this.approvalStatus = approvalStatus;
		this.comments = comments;
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
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}



	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	/**
	 * @return the registrationId
	 */
	public int getRegistrationId() {
		return registrationId;
	}



	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}



	/**
	 * @return the approvalStatus
	 */
	public boolean isApprovalStatus() {
		return approvalStatus;
	}



	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}



	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}



	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}	
}

