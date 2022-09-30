package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;

public class PaymentMapper implements RowMapper<Payment>  {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Payment payment = new Payment(
				rs.getInt("PaymentId"),
				rs.getInt("PaymentAmount"),
				rs.getInt("StudentId"),
				rs.getDate("DueDate").toLocalDate(),
				rs.getString("Semester"),
				rs.getString("PaymentMethod"),
				rs.getInt("IsPaid"));
		return payment;
	}

}
