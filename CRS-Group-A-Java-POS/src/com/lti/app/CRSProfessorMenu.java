package com.lti.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Professor;
import com.lti.bean.User;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.service.ProfessorService;

public class CRSProfessorMenu {
	
	private Scanner scan;
	private User user;
	private Professor professor;
	private ProfessorService professorService;
	
	public CRSProfessorMenu(Scanner scan, User user) {
		
		this.scan = scan;
		this.user = user;
		
		professor = new Professor();
		professorService = new ProfessorService();

	}
	
	public void menu() {
		
		// need to get professor from db - create professor instance
		professor = professorService.getProfessor(user.getId());
		
		// init.
		int courseId = -1;
		List<CourseCatalog> courses = null;
		List<CourseEnrollment> courseEnrollment = null;
		
		LocalDateTime t = LocalDateTime.now();
		String pattern = "MMMM dd yyyy hh:mm:ss a";
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);
		System.out.println("\nWelcome " + professor.getName() + " - login time: " + t.format(dateFormat));

		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Add Grades");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Back (previous menu)");
			System.out.print("\n-> ");
			
			String professorSelection = scan.nextLine();
			if(professorSelection == "") {
				professorSelection = scan.nextLine();
			}
			
			professorSelection = professorSelection
					.toLowerCase()
					.replaceAll("^\\s+", "")
					.replaceAll("\\s+$", "");
			
			switch(professorSelection) {
				case "1":
					professorSelection = "add grades";
					break;
				case "2":
					professorSelection = "view enrolled students";
					break;
				default:
					break;
			}
			
			Boolean professor_back = false;
			
			switch(professorSelection) {
				case "add grades":
					
					System.out.println("\nList of courses: ");
					courses = professorService.getProfessorCourses(professor.getId());
					System.out.format("%16s%16s%16s%16s%16s\n", 
							"COURSEID",
							"CREDITS",
							"CAPACITY",
							"ENROLLED",
							"SEMESTER");
					for(CourseCatalog course : courses) {
						System.out.format("%16s%16s%16s%16s%16s\n", 
								course.getId(),
								course.getCredits(),
								course.getCapacity(),
								course.getEnrolled(),
								course.getSemester());
					}
					
					
					// prompt professor to select a course
					System.out.print("\nSelect a course by ID: ");
					courseId = scan.nextInt();
					
					courseEnrollment = professorService.viewEnrolledStudents(courseId);
					System.out.format("%16s%16s%16s\n", 
							"COURSEID",
							"STUDENTID",
							"STUDENTNAME");
					for(CourseEnrollment entry : courseEnrollment) {
						System.out.format("%16s%16s%16s\n", 
								entry.getCourseId(),
								entry.getStudentId(),
								entry.getStudentName());
					}
					
					// prompt professor to select a student
					System.out.print("\nSelect a student by ID: ");
					int studentId = scan.nextInt();
					
					// prompt professor to enter a grade for that student
					System.out.print("\n\nEnter grade for this student: ");
					String grade = scan.nextLine();
					while(grade == "" || grade == null) {
						grade = scan.nextLine();
					}
								
					professorService.addGrades(studentId, courseId, grade);
					
					break;
				case "view enrolled students":
	
					System.out.println("\nList of courses: ");
					courses = professorService.getProfessorCourses(professor.getId());
					System.out.format("%16s%16s%16s%16s%16s\n", 
							"COURSEID",
							"CREDITS",
							"CAPACITY",
							"ENROLLED",
							"SEMESTER");
					for(CourseCatalog course : courses) {
						System.out.format("%16s%16s%16s%16s%16s\n", 
								course.getId(),
								course.getCredits(),
								course.getCapacity(),
								course.getEnrolled(),
								course.getSemester());
					}
					
					
					// prompt professor to select a course
					System.out.print("\nSelect a course by ID: ");
					courseId = scan.nextInt();
					
					System.out.println("Current course enrollment: ");
					courseEnrollment = professorService.viewEnrolledStudents(courseId);
					System.out.format("%16s%16s%16s\n", 
							"COURSEID",
							"STUDENTID",
							"STUDENTNAME");
					for(CourseEnrollment entry : courseEnrollment) {
						System.out.format("%16s%16s%16s\n", 
								entry.getCourseId(),
								entry.getStudentId(),
								entry.getStudentName());
					}
					break;
				case "back":
					professor_back = true;
					break;
				default:
					System.out.println("Incorrect input, try again");
					continue;
			}
			if(professor_back) break;		//   exit from professor menu while loop
		}
	}
}
