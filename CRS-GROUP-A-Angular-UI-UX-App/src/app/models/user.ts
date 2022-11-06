export class User {

    public id:number;
	public username:String;
	public password:String;
	public roleId:number;
	
	constructor(id:number, username:String, password:String, roleId:number) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	public getPassword():String {
		return this.password;
	}

	public setPassword(password:String) {
		this.password = password;
	}

	public getRoleId():number {
		return this.roleId;
	}

	public setRole(roleId:number) {
		this.roleId = roleId;
	}

	public getId():number {
		return this.id;
	}

	public getUsername():String {
		return this.username;
	}

	public setUsername(username:String) {
		this.username = username;
	}
}
