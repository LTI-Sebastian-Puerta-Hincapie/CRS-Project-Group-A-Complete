package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constant.SQLQueries;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.mapper.CourseCatalogMapper;

/**
 * @author Sebastian
 *
 */

public class CourseCatalogDAOImpl implements CourseCatalogDAO {
	
	Logger logger = LoggerFactory.getLogger(CourseCatalogDAOImpl.class);
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	
	@Override
	public List<CourseCatalog> ListOfAllCoursesDAO() {
		
       logger.info("From the listOfAllCoursesDAO method");
	   return jdbcTemplateObject.jdbcTemplate().query(
				SQLQueries.SELECT_ALL_COURSES, 
				new CourseCatalogMapper()); 	
	}

}
