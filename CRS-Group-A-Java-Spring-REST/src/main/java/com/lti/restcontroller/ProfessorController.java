package com.lti.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.bean.Response;
import com.lti.exception.NoEnrolledStudentsFoundException;
import com.lti.exception.ProfessorNotFoundException;
import com.lti.exception.ProfessorNotRegisteredForCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentNotFoundException;
import com.lti.service.ProfessorServiceOperation;

@RestController
public class ProfessorController {

	@Autowired
	ProfessorServiceOperation professorServiceOperation;
	
	private String SUCCESS = "SUCCESS";

	/**
	 * API to get professor information by professor Id
	 * @param professorId
	 * @return Professor
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/professors/{professorId}")
	public @ResponseBody Response<Professor> getProfessorInformation(@PathVariable("professorId") String professorId) {
		
		Professor professor = null;
		try {
		professor = professorServiceOperation.getProfessor(Integer.parseInt(professorId));
		}catch(ProfessorNotFoundException pe) {
			//Sending no content status as professor is not available in DB
			return new Response<Professor>(professor, HttpStatus.NO_CONTENT, pe.getMessage());
		}catch(Exception e) {
			return new Response<Professor>(professor, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return new Response<Professor>(professor, HttpStatus.OK, SUCCESS);

	}

	/**
	 * API to view enrolled student list by course Id
	 * @param courseId
	 * @return CourseEnrollment list
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, 
			value = "/enrolled/students/{courseId}")
	@ResponseBody
	public Response<List<CourseEnrollment>> viewEnrolledStudents(@PathVariable("courseId") String courseId) {

		List<CourseEnrollment> courseEnrollmentList= null;
		try {
		 courseEnrollmentList = professorServiceOperation
				.viewEnrolledStudents(Integer.parseInt(courseId));
		 
		}catch(NoEnrolledStudentsFoundException ex) {
			return new Response<List<CourseEnrollment>>(courseEnrollmentList, HttpStatus.NO_CONTENT, ex.getMessage());
		}catch(Exception e) {
			return new Response<List<CourseEnrollment>>(courseEnrollmentList, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

		return new Response<List<CourseEnrollment>>(courseEnrollmentList, HttpStatus.OK, SUCCESS);
	}

	/**
	 * API that returns list of courses offered by a professor
	 * @param professorId
	 * @return CourseCatalog list
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, 
			value = "/courses/professor/{professorId}")
	@ResponseBody
	public Response<List<CourseCatalog>> getProfessorCourses(@PathVariable("professorId") String professorId) {

		List<CourseCatalog> courseEnrollmentList = null;
		try {
		courseEnrollmentList = professorServiceOperation
				.getProfessorCourses(Integer.parseInt(professorId));
		} catch(ProfessorNotRegisteredForCourseException pe) {
			return new Response<List<CourseCatalog>>(courseEnrollmentList, HttpStatus.NO_CONTENT, pe.getMessage());
		}catch (Exception e) {
			return new Response<List<CourseCatalog>>(courseEnrollmentList, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return new Response<List<CourseCatalog>>(courseEnrollmentList, HttpStatus.OK, SUCCESS);
	}
	
	/**
	 * API to offer grades to a student by professor for a registered course
	 * @param studentId
	 * @param grade
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, 
			value = "/add/grades/{studentId}")
	@ResponseBody
	public Response<Boolean> addGrades(@PathVariable("studentId") String studentId, 
			@RequestBody Grade grade) {

		try {
			professorServiceOperation.addGrades(Integer.parseInt(studentId),
					 grade.getCourse().getCourseId(), grade.getGrade());
		} catch (NumberFormatException e) {
			return new Response<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST, e.getMessage());
		} catch ( StudentNotFoundException  se) {
			return new Response<Boolean>(Boolean.FALSE, HttpStatus.NO_CONTENT, se.getMessage());
		}catch ( StudentCourseNotFoundException sce) {
			return new Response<Boolean>(Boolean.FALSE, HttpStatus.NO_CONTENT, sce.getMessage());
		}catch ( StudentCourseRegistrationNotFoundException ce) {
			return new Response<Boolean>(Boolean.FALSE, HttpStatus.NO_CONTENT, ce.getMessage());
		}catch (Exception e) {
			return new Response<Boolean>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

		return new Response<Boolean>(Boolean.TRUE, HttpStatus.CREATED, SUCCESS);
	}

}
