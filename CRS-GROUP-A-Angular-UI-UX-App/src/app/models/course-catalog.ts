export class CourseCatalog {
    private id: number;
    private professorID: number;
    private departmentID: number;
    private prerequisites: string;
    private credits: number;
    private capacity: number;
    private enrolled: number;
    private semester: string;

    constructor(id: number, professorID: number, departmentID: number, prerequisites: string, credits: number, capacity: number, enrolled: number, semester: string){
        this.id = id;
        this.professorID = professorID;
        this.departmentID = departmentID;
        this.prerequisites = prerequisites;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolled = enrolled;
        this.semester = semester;
    }

    getID(): number{
        return this.id;
    }

    setID(id: number){
        this.id = id;
    }

    getProfessorID(): number{
        return this.professorID;
    }

    setProfessorID(professorID: number){
        this.professorID = professorID;
    }

    getDepartmentID(): number{
        return this.departmentID;
    }

    setDepartmentID(departmentID: number){
        this.departmentID = departmentID;
    }

    getPrerequisites(): string{
        return this.prerequisites;
    }

    setPrerequisites(prerequisites: string){
        this.prerequisites = prerequisites;
    }

    getCredits(): number{
        return this.credits;
    }

    setCredits(credits: number){
        this.credits = credits;
    }

    getCapacity(): number {
		return this.capacity;
	}

	setCapacity(capacity: number) {
		this.capacity = capacity;
	}

	getEnrolled() {
		return this.enrolled;
	}

	setEnrolled(enrolled: number) {
		this.enrolled = enrolled;
	}

	getSemester(): string {
		return this.semester;
	}

	setSemester(semester: string) {
		this.semester = semester;
	}
}