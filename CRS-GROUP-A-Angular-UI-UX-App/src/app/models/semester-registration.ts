export class SemesterRegistration {

    private studentId:number;
	private adminId:number;
	private registrationId:number;
	private approvalStatus:number;
	private comments:String;
	
	constructor(
		registrationId:number,
        studentId:number, 
        adminId:number, 
        approvalStatus:number,
		comments:String) {
 
		this.registrationId = registrationId;		
		this.studentId = studentId;
		this.adminId = adminId;
		this.approvalStatus = approvalStatus;
		this.comments = comments;
	}

	public getApprovalStatus():number {
		return this.approvalStatus;
	}

	public setApprovalStatus(approvalStatus:number) {
		this.approvalStatus = approvalStatus;
	}

	public getStudentId():number {
		return this.studentId;
	}

	public setStudentId(studentId:number) {
		this.studentId = studentId;
	}

	public  getAdminId():number {
		return this.adminId;
	}

	public setAdminId(adminId:number) {
		this.adminId = adminId;
    }

	public getRegistrationId():number {
		return this.registrationId;
	}

	public setRegistrationId(registrationId:number) {
		this.registrationId = registrationId;
	}
	
	public getComments():String {
		return this.comments;
	}

	public setComments(comments:String) {
		this.comments = comments;
	}	
}
