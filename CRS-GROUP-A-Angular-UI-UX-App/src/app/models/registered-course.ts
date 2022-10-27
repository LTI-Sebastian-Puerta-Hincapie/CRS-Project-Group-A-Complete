export class RegisteredCourse {
	
	private courseId: number;
	private courseName:string;
	private studentId: number;
	private registeredStatus: number;
	private grade: string;
	
	constructor(courseId: number, courseName:string, studentId: number, registeredStatus: number, grade: string) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
		this.registeredStatus = registeredStatus;
		this.grade = grade;
	}
	
	getCourseId(): number {
		return this.courseId;
	}

	setCourseId(courseId: number) {
		this.courseId = courseId;
	}

	getCourseName(): string {
		return this.courseName;
	}

	setCourseName(courseName: string) {
		this.courseName = courseName;
	}

	getStudentId(): number {
		return this.studentId;
	}

	setStudentId(studentId: number) {
		this.studentId = studentId;
	}

	getRegisteredStatus(): number {
		return this.registeredStatus;
	}

	setRegisteredStatus(registeredStatus: number) {
		this.registeredStatus = registeredStatus;
	}

	getGrade(): string {
		return this.grade;
	}

	setGrade(grade: string) {
		this.grade = grade;
	}	
}