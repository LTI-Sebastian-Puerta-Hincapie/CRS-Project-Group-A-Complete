package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CourseCatalogDAO;
import com.lti.dao.CourseCatalogDAOImpl;
import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;

/**
 * @author Sebastian
 *
 */

@Service
public class CourseCatalogService implements CourseCatalogOperation {
	
	@Autowired
	private CourseCatalogDAO courseCatalogDao;

	@Override
	public List<CourseCatalog> ListOfAllCourses() {
		
		return courseCatalogDao.ListOfAllCoursesDAO();
	}

}
