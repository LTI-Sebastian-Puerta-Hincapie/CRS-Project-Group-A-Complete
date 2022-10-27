export class CourseEnrollment {

    courseId:number;
    courseName:string;
    studentId:number;
    studentName:string;
      
	constructor(courseId:number, courseName:string, studentId:number, studentName:string) {

		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	getCourseName():string {
		return this.courseName;
	}

	setCourseName(courseName:string) {
		this.courseName = courseName;
	}

	getCourseId():number {
		return this.courseId;
	}

	setCourseId(courseId:number) {
		this.courseId = courseId;
	}

    getStudentId():number {
		return this.studentId;
	}

	setStudentId(studentId:number) {
		this.studentId = studentId;
	}

	getStudentName():string {
		return this.studentName;
	}

	setStudentName(studentName:string) {
		this.studentName = studentName;
	}
}
