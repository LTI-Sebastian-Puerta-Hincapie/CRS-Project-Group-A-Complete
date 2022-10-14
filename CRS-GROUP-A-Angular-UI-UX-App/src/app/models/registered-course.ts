export class RegisteredCourse {
	
	private CourseId: number;
	private StudentId: number;
	private RegisteredStatus: number;
	private Grade: string;
	
	constructor(courseId: number, studentId: number, registeredStatus: number, grade: string) {
		this.CourseId = courseId;
		this.StudentId = studentId;
		this.RegisteredStatus = registeredStatus;
		this.Grade = grade;
	}
	
	/**
	 * @return the courseId
	 */
	getCourseId(): number {
		return this.CourseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	setCourseId(courseId: number) {
		this.CourseId = courseId;
	}
	/**
	 * @return the studentId
	 */
	getStudentId(): number {
		return this.StudentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	setStudentId(studentId: number) {
		this.StudentId = studentId;
	}
	/**
	 * @return the registeredStatus
	 */
	getRegisteredStatus(): number {
		return this.RegisteredStatus;
	}
	/**
	 * @param registeredStatus the registeredStatus to set
	 */
	setRegisteredStatus(registeredStatus: number) {
		this.RegisteredStatus = registeredStatus;
	}
	/**
	 * @return the grade
	 */
	getGrade(): string {
		return this.Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	setGrade(grade: string) {
		this.Grade = grade;
	}	
}