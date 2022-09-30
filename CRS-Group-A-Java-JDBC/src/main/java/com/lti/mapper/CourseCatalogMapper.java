package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;

public class CourseCatalogMapper implements RowMapper<CourseCatalog> {

	@Override
	public CourseCatalog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
