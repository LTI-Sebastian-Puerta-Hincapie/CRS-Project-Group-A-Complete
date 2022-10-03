package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.SemesterRegistration;

public class SemesterRegistrationMapper implements RowMapper<SemesterRegistration> {

	@Override
	public SemesterRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SemesterRegistration semesterRegistration = new SemesterRegistration(
				rs.getInt("RegistrationId"),
				rs.getInt("StudentId"),
				rs.getInt("ApprovalStatus"),
				rs.getInt("AdminId"),
				rs.getString("Comment"));
		return semesterRegistration;
	}

}
