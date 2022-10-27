export class Course {
	
	private courseId: number;
	private courseName: string;
	private description: string;
	
	constructor(courseId: number, courseName: string, description: string) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
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

	getDescription(): string {
		return this.description;
	}

	setDescription(description: string) {
		this.description = description;
	}
	
	
}
