import { Student } from "./student";

export class StudentCourse{	
	
	private student: Student;
	private courseId: number;
	
    constructor(student: Student, courseId: number){
        this.student = student;
        this.courseId = courseId;
    }

	getStudent(): Student {
		return this.student;
	}
	/**
	 * @param student the student to set
	 */
	setStudent(student: Student) {
		this.student = student;
	}
	/**
	 * @return the courseId
	 */
	getCourseId(): number {
		return this.courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	setCourseId(courseId: number) {
		this.courseId = courseId;
	}
}
