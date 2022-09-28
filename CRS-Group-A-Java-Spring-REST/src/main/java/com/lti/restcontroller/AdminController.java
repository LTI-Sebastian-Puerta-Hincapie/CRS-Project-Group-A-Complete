package com.lti.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lti.service.AdminService;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	@GetMapping("/admin/addprofessor/{id}/{name}/{departmentId}/{email}/{phone}/{address}")
	public ResponseEntity addProfessor(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("departmentId") int departmentId, 
										@PathVariable("email") String email, @PathVariable("phone") String phone, @PathVariable("address") String address) {
		Professor professor = new Professor(id,name,departmentId,email,phone,address);
		try {
			adminservice.addProfessor(professor);
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity(professor, HttpStatus.OK);
	}
	
	@GetMapping("admin/generatereportcard/{id}")
	public ResponseEntity generateReportCard(@PathVariable("id") int id) {
		ArrayList<ArrayList<String>> reportCard;
		try {
			reportCard = adminservice.generateReportCard(id);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(reportCard, HttpStatus.OK);
	}
	
	@GetMapping("admin/approve/{studentID}/{approvalStatus}")
	public ResponseEntity approveStudentRegistration(@PathVariable("studentID") int studentID, @PathVariable("approvalStatus") int approvalStatus) {
		try {
			adminservice.approveStudentRegistration(studentID, approvalStatus);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(true, HttpStatus.OK);
	}
	
	@GetMapping("admin/createregistration/{studentId}/{adminId}/{approvalStatus}/{comments}")
	public ResponseEntity createStudentRegistration(@PathVariable("studentId") int studentId, @PathVariable("adminId") int adminId,
													@PathVariable("approvalStatus") int approvalStatus, @PathVariable("comments") String comments) {
		Boolean approve = false;
		if(approvalStatus > 0) {
			approve = true;
		}
		SemesterRegistration reg = new SemesterRegistration(studentId,adminId,approve,comments);
		try {
			adminservice.createStudentRegistration(reg);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(reg, HttpStatus.OK);
	}
	
	@GetMapping("admin/getregistration/{studentId}")
	public ResponseEntity getSemesterRegistration(@PathVariable("studentId") int studentId) {
		SemesterRegistration reg;
		try {
			reg = adminservice.getSemesterRegistration(studentId);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(reg, HttpStatus.OK);
	}
	
	@GetMapping("admin/addcourse/{courseId}/{courseName}/{description}")
	public ResponseEntity addCourse(@PathVariable("courseId") int courseId, @PathVariable("courseName") String courseName, @PathVariable("description") String description) {
		Course course = new Course(courseId, courseName, description);
		try {
			adminservice.addCourse(course);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@GetMapping("admin/addcourse/{courseId}")
	public ResponseEntity removeCourse(@PathVariable("courseId") int courseId) {
		try {
			adminservice.removeCourse(courseId);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(courseId, HttpStatus.OK);
	}
	
	@GetMapping("admin/updatecourse/{courseId}/{courseName}/{description}")
	public ResponseEntity updateCourse(@PathVariable("courseId") int courseId, @PathVariable("courseName") String courseName, @PathVariable("description") String description) {
		Course course = new Course(courseId,courseName,description);
		try {
			adminservice.updateCourse(courseId,courseName,description);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@GetMapping("admin/checkavailability/{id}")
	public ResponseEntity updateCourse(@PathVariable("id") int id) {
		Boolean available;
		try {
			available = adminservice.checkAvailability(id);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(available, HttpStatus.OK);
	}
}
