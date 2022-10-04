package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Professor;

public class ProfessorMapper implements RowMapper<Professor>{

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Professor professor = new Professor(
				rs.getInt("Id"),
				rs.getString("Name"),
				rs.getInt("DepartmentId"),
				rs.getString("Email"),
				rs.getString("Phone"),
				rs.getString("Address"));
		
		return professor;
	}
}
