package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.SemesterRegistration;

public class SemesterRegistrationMapper implements RowMapper<SemesterRegistration> {

	@Override
	public SemesterRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
