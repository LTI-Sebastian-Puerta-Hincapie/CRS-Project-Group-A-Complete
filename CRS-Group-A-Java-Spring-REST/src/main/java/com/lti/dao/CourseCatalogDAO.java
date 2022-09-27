/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;

/**
 * @author Sebastian
 *
 */
public interface CourseCatalogDAO {
	
	/**
	 * This method list all available courses in the course catalog
	 * @return List<CourseCatalog> returns a list of courses with course details
	 */
	public List<CourseCatalog> ListOfAllCoursesDAO();
}
