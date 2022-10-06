package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Course;

public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Course course = new Course(
				rs.getInt("CourseId"),
				rs.getString("CourseName"),
				rs.getString("Description"));
		return course;
	}

}
