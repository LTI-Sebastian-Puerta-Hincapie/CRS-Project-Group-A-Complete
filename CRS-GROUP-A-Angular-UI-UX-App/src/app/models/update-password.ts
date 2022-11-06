export class UpdatePassword {

    public username:string;
	public currentPassword:string;
	public newPassword:string;
    
    constructor(username:string, currentPassword:string, newPassword:string) {
        this.username = username;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }
}
