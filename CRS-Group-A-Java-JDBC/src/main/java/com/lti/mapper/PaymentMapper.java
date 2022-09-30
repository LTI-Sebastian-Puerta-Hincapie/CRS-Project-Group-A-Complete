package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Payment;
import com.lti.dto.RegisteredCourse;

public class PaymentMapper implements RowMapper<Payment>  {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
