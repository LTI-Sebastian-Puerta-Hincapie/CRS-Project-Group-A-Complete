package com.lti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

/**
 * @author Sebastian
 *
 */

@Component
public class Payment implements Serializable {
	
	private int paymentId;
	private int studentId;
	private int paymentAmount;
	private LocalDate dueDate;
	private String semester;
	private int isPaid;
	private String paymentMethod;
	
	public Payment() {}
	
	public Payment(int studentId, int paymentAmount, LocalDate dueDate, String semester) {

		this.studentId = studentId;
		this.paymentAmount = paymentAmount;
		this.dueDate = dueDate;
		this.semester = semester;
	}
	
	public Payment(
			int paymentId, 
			int paymentAmount,
			int studentId, 
			LocalDate dueDate, 
			String semester, 
			String paymentMethod,
			int isPaid) {

		this.paymentId = paymentId;
		this.studentId = studentId;
		this.paymentAmount = paymentAmount;
		this.dueDate = dueDate;
		this.semester = semester;
		this.paymentMethod = paymentMethod;
		this.isPaid = isPaid;
	}
	
	/**
	 * @return the isPaid
	 */
	public int getIsPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setIsPaid(int isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	 * @return the paymentAmount
	 */
	public int getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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
}
