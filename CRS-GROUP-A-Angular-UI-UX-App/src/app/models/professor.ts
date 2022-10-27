export class Professor {

    id:number;
	name:string;
	departmentId:number;
	email:string;
	phone:string;
	address:string;
	
	constructor(id:number, name:string, departmentId:number, email:string, phone:string, address:string) {
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	getEmail():string {
		return this.email;
	}

	setEmail(email:string) {
		this.email = email;
	}

	getPhone():string {
		return this.phone;
	}

	setPhone(phone:string) {
		this.phone = phone;
	}

	getAddress():string {
		return this.address;
	}

	setAddress(address:string) {
		this.address = address;
	}

	getId():number {
		return this.id;
	}

	setId(id:number) {
		this.id = id;
	}

	getName():string {
		return this.name;
	}

	setName(name:string) {
		this.name = name;
	}

	getDepartmentId():number {
		return this.departmentId;
	}

	setDepartmentId(departmentId:number) {
		this.departmentId = departmentId;
	}
}
