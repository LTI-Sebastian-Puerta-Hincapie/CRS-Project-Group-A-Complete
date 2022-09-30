package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.RegisteredCourse;

public class RegisteredCourseMapper implements RowMapper<RegisteredCourse> {

	@Override
	public RegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
