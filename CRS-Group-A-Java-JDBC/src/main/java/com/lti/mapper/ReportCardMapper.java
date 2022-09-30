package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;


public class ReportCardMapper implements RowMapper<ArrayList<String>>{
	@Override
    public ArrayList<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
		ArrayList<String> reportCard = new ArrayList<String>();
		reportCard.add(String.valueOf(rs.getInt("CourseID")));
		reportCard.add(rs.getString("CourseName"));
		reportCard.add(rs.getString("Grade"));
        return reportCard;
    }
}
