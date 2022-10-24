export class CourseEnrollment {

    private courseId:number;
    private studentId: number;
    private studentName: string;



	constructor(courseId:number, studentId: number, studentName: string) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.studentName = studentName;
	}

    /**
     * Getter $courseId
     * @return {number}
     */
	public get $courseId(): number {
		return this.courseId;
	}

    /**
     * Setter $courseId
     * @param {number} value
     */
	public set $courseId(value: number) {
		this.courseId = value;
	}

    /**
     * Getter $studentId
     * @return {number}
     */
	public get $studentId(): number {
		return this.studentId;
	}

    /**
     * Setter $studentId
     * @param {number} value
     */
	public set $studentId(value: number) {
		this.studentId = value;
	}

    /**
     * Getter $studentName
     * @return {string}
     */
	public get $studentName(): string {
		return this.studentName;
	}

    /**
     * Setter $studentName
     * @param {string} value
     */
	public set $studentName(value: string) {
		this.studentName = value;
	}

}
