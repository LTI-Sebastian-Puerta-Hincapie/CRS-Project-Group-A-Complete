package com.lti.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Course;
import com.lti.dto.CourseCatalog;
import com.lti.dto.CourseEnrollment;
import com.lti.dto.Grade;
import com.lti.dto.Professor;
import com.lti.dto.Student;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.StudentNotFoundException;
import com.lti.service.ProfessorServiceOperation;

@RestController
public class ProfessorController {

	@Autowired
	ProfessorServiceOperation professorServiceOperation;

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/professors/{professorId}")
	@ResponseBody
	public ResponseEntity<Professor> getUser(@PathVariable("professorId") String professorId) {
		
		Professor professor = null;
		
		professor = professorServiceOperation.getProfessor(Integer.parseInt(professorId));
		
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, 
			value = "/enrolled/students/{courseId}")
	@ResponseBody
	public ResponseEntity<List<CourseEnrollment>> viewEnrolledStudents(@PathVariable("courseId") String courseId) {

		List<CourseEnrollment> courseEnrollmentList = professorServiceOperation
				.viewEnrolledStudents(Integer.parseInt(courseId));

		return new ResponseEntity<List<CourseEnrollment>>(courseEnrollmentList, HttpStatus.OK);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, 
			value = "/courses/professor/{professorId}")
	@ResponseBody
	public ResponseEntity<List<CourseCatalog>> getProfessorCourses(@PathVariable("professorId") String professorId) {

		List<CourseCatalog> courseEnrollmentList = professorServiceOperation
				.getProfessorCourses(Integer.parseInt(professorId));

		return new ResponseEntity<List<CourseCatalog>>(courseEnrollmentList, HttpStatus.OK);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, 
			value = "/add/grades/{studentId}")
	@ResponseBody
	public ResponseEntity<Boolean> addGrades(@PathVariable("studentId") String studentId, 
			@RequestBody Grade grade) {

		// TODO exception handling
		try {
			professorServiceOperation.addGrades(Integer.parseInt(studentId),
					 grade.getCourse().getCourseId(), grade.getGrade());
		} catch (NumberFormatException | StudentNotFoundException | StudentCourseNotFoundException
				| StudentCourseRegistrationNotFoundException e) {
			return new ResponseEntity(Boolean.FALSE, HttpStatus.OK);
		}

		return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);
	}
}
