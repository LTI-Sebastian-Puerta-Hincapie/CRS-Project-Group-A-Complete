package com.lti.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SemesterRegistration implements Serializable {
	
	private int studentId;
	private int adminId;
	private int registrationId;
	private int approvalStatus;
	private String comments;
	
	public SemesterRegistration() {}

	public SemesterRegistration(int studentId, int adminId, int approvalStatus,
			String comments) {

		this.studentId = studentId;
		this.adminId = adminId;
		this.approvalStatus = approvalStatus;
		this.comments = comments;
	}
	
	public SemesterRegistration(int registrationId, int studentId, int adminId, int approvalStatus,
			String comments) {

		this.registrationId = registrationId;
		this.studentId = studentId;
		this.adminId = adminId;
		this.approvalStatus = approvalStatus;
		this.comments = comments;
	}

	
	
	/**
	 * @return the approvalStatus
	 */
	public int getApprovalStatus() {
		return approvalStatus;
	}

	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
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

