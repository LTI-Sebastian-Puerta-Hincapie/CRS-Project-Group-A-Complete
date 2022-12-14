import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { UpdatePassword } from 'src/app/models/update-password';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { UpdatePasswordServiceService } from 'src/app/services/update-password-service.service';

@Component({
  selector: 'app-update-password-component',
  templateUrl: './update-password-component.component.html',
  styleUrls: ['./update-password-component.component.css']
})
export class UpdatePasswordComponentComponent implements OnInit {

  user:UpdatePassword = new UpdatePassword("", "", "");
  getUserData: any;
  updateValidationMessage = "";
  confirmationPassword = "";

  constructor(private _updatePasswordService: UpdatePasswordServiceService, 
              private _userService: LoginServiceService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  updatePassword(username:string, currentPassword:string, newPassword:string, form:NgForm){
    console.log("Update password component method");

    if(!this.updatePasswordValidations()) {
      this.showError();
      return;
    }

    // update password
    this._updatePasswordService.updatePassword(username, currentPassword, newPassword).subscribe((res:any) => {
      console.log(res);
      this.showSuccess();
      this.updateValidationMessage = "";
      form.reset();
    })
  }

  updatePasswordValidations():boolean {

    // Initial input validations
    if(this.user.username == "" || this.user.username == undefined || this.user.username == null){
      this.updateValidationMessage = "Missing username";
      return false;
    }
    else if(this.user.currentPassword == "" || this.user.currentPassword == undefined || this.user.currentPassword == null){
      this.updateValidationMessage = "Missing current password";
      return false;
    }
    else if(this.user.newPassword == "" || this.user.newPassword == undefined || this.user.newPassword == null){
      this.updateValidationMessage = "Missing new password";
      return false;
    }
    else if(this.confirmationPassword == "" || this.confirmationPassword == undefined || this.confirmationPassword == null){
      this.updateValidationMessage = "Missing confirmation password";
      return false;
    }

    // credential validations
    if(this.getUserData == undefined) {
      this.updateValidationMessage = "user does not exist";
      return false;
    }
    else if(this.user.username == "" 
          || this.user.currentPassword == "" 
          || this.user.newPassword == "") {
      this.updateValidationMessage = "please fill out required fields";
      return false;
    }
    else if(this.user.username == undefined 
        || this.user.username == "" 
        || this.user.username != this.getUserData[0].username) {
      this.updateValidationMessage = "user does not exist";
      return false;
    }
    else if(this.getUserData[0].password != this.user.currentPassword) {
      this.updateValidationMessage = "current password does not match existing password";
      return false;
    }
    else if(this.user.currentPassword == this.user.newPassword) {
      this.updateValidationMessage = "new password cannot be the same as the old password";
      return false;
    }
    else if(this.user.newPassword != this.confirmationPassword) {
      this.updateValidationMessage = "passwords do not match";
      return false;
    }
    else {
      return true;
    }
  }

  getUser() {
    console.log("get user component method");
    
    if(this.user.username == undefined || this.user.username == "") return;

    this._userService.getUserByUsername(this.user.username).subscribe((res:any) => {
      console.log(res);
      this.getUserData = res;
    })
  }

  showSuccess() {
    this.toastr.success('Password updated', 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
