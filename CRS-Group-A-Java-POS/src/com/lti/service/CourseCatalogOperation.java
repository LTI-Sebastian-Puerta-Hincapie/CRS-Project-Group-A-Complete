/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;

/**
 * @author Sebastian
 *
 */
public interface CourseCatalogOperation {
	
	/**
	 * This method list all available courses in the course catalog
	 * @return List<CourseCatalog> this returns a list of courses with details
	 */
	public List<CourseCatalog> ListOfAllCourses();
}
