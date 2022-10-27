export class Student {
	
	private id: number;
	private name: string;
	private majorId: number;
	private email: string;
	private phone: string;
	private address: string;
	
	constructor(id: number, name:string, majorId: number, email: string, phone: string, address: string) {
		
		this.id = id;
		this.name = name;
		this.majorId = majorId;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	getEmail(): string {
		return this.email;
	}

	setEmail(email: string) {
		this.email = email;
	}

	getPhone(): string {
		return this.phone;
	}

	setPhone(phone: string) {
		this.phone = phone;
	}

	getAddress(): string {
		return this.address;
	}

	setAddress(address: string) {
		this.address = address;
	}

	getMajorId(): number {
		return this.majorId;
	}

	setMajorId(majorId: number) {
		this.majorId = majorId;
	}

	getId(): number {
		return this.id;
	}

	setId(id: number) {
		this.id = id;
	}

	getName(): string {
		return this.name;
	}

	setName(name: string) {
		this.name = name;
	}

}