export class Payment {
	
	private paymentId: number;
	private studentId: number;
	private paymentAmount: number;
	private dueDate: Date;
	private semester: string;
	private isPaid: number;
	private paymentMethod: string;
	
	constructor(
			paymentId: number, 
			paymentAmount: number,
			studentId: number, 
			dueDate: Date, 
			semester: string, 
			paymentMethod: string,
			isPaid: number) {

		this.paymentId = paymentId;
		this.studentId = studentId;
		this.paymentAmount = paymentAmount;
		this.dueDate = dueDate;
		this.semester = semester;
		this.paymentMethod = paymentMethod;
		this.isPaid = isPaid;
	}
	
	getIsPaid(): number {
		return this.isPaid;
	}

	setIsPaid(isPaid: number) {
		this.isPaid = isPaid;
	}

	getPaymentMethod(): string {
		return this.paymentMethod;
	}

    setPaymentMethod(paymentMethod: string) {
		this.paymentMethod = paymentMethod;
	}

	getPaymentId(): number {
		return this.paymentId;
	}

	setPaymentId(paymentId: number) {
		this.paymentId = paymentId;
	}

	getStudentId(): number {
		return this.studentId;
	}

	setStudentId(studentId: number) {
		this.studentId = studentId;
	}

	getPaymentAmount(): number {
		return this.paymentAmount;
	}

	setPaymentAmount(paymentAmount: number) {
		this.paymentAmount = paymentAmount;
	}

	getDueDate(): Date {
		return this.dueDate;
	}

	setDueDate(dueDate: Date) {
		this.dueDate = dueDate;
	}

	getSemester(): string {
		return this.semester;
	}

	setSemester(semester: string) {
		this.semester = semester;
	}
}