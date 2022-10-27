package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.dto.Student;


public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student(
				rs.getInt("Id"),
				rs.getString("Name"),
				rs.getInt("MajorId"),
				rs.getString("Email"),
				rs.getString("Phone"),
				rs.getString("Address"));
		return student;
	}

}
