package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.RegisteredCourse;

public class RegisteredCourseMapper implements RowMapper<RegisteredCourse> {

	@Override
	public RegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RegisteredCourse registeredCourse = new RegisteredCourse(
				rs.getInt("CourseId"),
				rs.getString("CourseName"),
				rs.getInt("StudentId"),
				rs.getInt("RegistrationStatus"), 
				rs.getString("Grade"));
		return registeredCourse;
	}

}
