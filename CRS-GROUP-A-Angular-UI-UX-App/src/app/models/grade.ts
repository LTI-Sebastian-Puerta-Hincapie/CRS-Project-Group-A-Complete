import { Course } from "./Course";

export class Grade{
	
	private grade: string;
	private course: Course;
	
	constructor(grade: string, course: Course) {
		
		this.grade = grade;
		this.course = course;
	}

	getGrade(): string {
		return this.grade;
	}

	setGrade(grade: string) {
		this.grade = grade;
	}

	getCourse(): Course {
		return this.course;
	}

	setCourse(course: Course) {
		this.course = course;
	}
	
	
}