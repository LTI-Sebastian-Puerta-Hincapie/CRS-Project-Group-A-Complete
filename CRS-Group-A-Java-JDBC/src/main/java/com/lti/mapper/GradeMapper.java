package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Course;
import com.lti.dto.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Course course = new Course();
		course.setCourseId(rs.getInt("CourseId"));
		course.setCourseName(rs.getString("CourseName"));
		
		Grade grade = new Grade(
				rs.getString("Grade"),
				course);
		
		return grade;
	}

}
