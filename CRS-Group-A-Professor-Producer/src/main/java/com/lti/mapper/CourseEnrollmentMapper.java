package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.CourseEnrollment;

public class CourseEnrollmentMapper implements RowMapper<CourseEnrollment> {

	@Override
	public CourseEnrollment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CourseEnrollment courseEnrollment = new CourseEnrollment(
				rs.getInt("CourseId"),
				null,
				rs.getInt("studentId"), rs.getString("Name"));
		
		return courseEnrollment;
	}

}
