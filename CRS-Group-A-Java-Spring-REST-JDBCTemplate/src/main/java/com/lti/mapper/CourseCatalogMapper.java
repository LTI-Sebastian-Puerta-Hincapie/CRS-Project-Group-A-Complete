package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;

public class CourseCatalogMapper implements RowMapper<CourseCatalog> {

	@Override
	public CourseCatalog mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CourseCatalog courseCatalog = new CourseCatalog(
				rs.getInt("Id"),
				rs.getInt("ProfessorId"),
				rs.getInt("DepartmentId"),
				rs.getString("Prerequisite"),
				rs.getInt("Credits"),
				rs.getInt("Capacity"),
				rs.getInt("Enrolled"),
				rs.getString("Semester"));
		return courseCatalog;
	}
}
