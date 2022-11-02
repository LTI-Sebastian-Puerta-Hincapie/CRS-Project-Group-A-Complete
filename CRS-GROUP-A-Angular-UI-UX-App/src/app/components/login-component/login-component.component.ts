import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SemesterRegistration } from 'src/app/models/semester-registration';
import { User } from 'src/app/models/user';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { SemesterRegistrationServiceService } from 'src/app/services/semester-registration-service.service';
import { ToastrService } from 'ngx-toastr';
import { retryWhen } from 'rxjs';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  _username:string = "";
  _password:string = "";
  _role:number = 0;

  user:User = new User(0, "", "", 0);
  getData:any;
  getUserData:any;
  getSemesterRegistrationData:any;

  loginValidationMessage:string = "";

  constructor(private router: Router, 
              private _userService:LoginServiceService,
              private _semesterRegistrationService:SemesterRegistrationServiceService,
              private toastr: ToastrService) {}

  ngOnInit() {}

  sleep = (ms:number) => new Promise(r => setTimeout(r, ms));

  login(username:string, password:string, roleId:number) {

    console.log("Login component method");
    if (roleId == 1) {

      if(!this.userPasswordValidation()) return;

      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        console.log(res);
        if(res != undefined) {  
          this.showSuccess();
          this.router.navigate(["admin", { admin: res }]);
          this.getData = res;
          this.userSession(username, password, "admin", this.getData[0].id);
        }
      })
    }
    else if (roleId == 2) {

      if(!this.userPasswordValidation()) return;

      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        console.log(res);
        if(res != undefined) {
          this.showSuccess();
          this.router.navigate(["professor", { professor: res }]);
          this.getData = res;
          this.userSession(username, password, "professor", this.getData[0].id);
        }
      })
    }
    else if(roleId == 3)  {

      if(!this.userPasswordValidation()) return;

      if(!this.studentSemesterValidation()) return;

      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => { 
        console.log("student res:", res);
        this.showSuccess();
        this.router.navigate(["student", { student: res }]);
        this.getData = res;  
        this.userSession(username, password, "student", this.getData[0].id);
      })
    } else {
      console.log("user role does not exist");
      this.showError();
    }
    return;
  }

  userSession(username:string, password:string, role:string, userId:string) {

    // Save data to sessionStorage
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("password", password);
    sessionStorage.setItem("role", role);
    sessionStorage.setItem("userId", userId);
  }

  getUser() {
    console.log("get user component method");
    
    if(this._username == undefined || this._username == null || this._username == "") return;

    this._userService.getUserByUsername(this._username).subscribe((res:any) => {
      console.log(res);
      this.getUserData = res;
    })
  }

  getSemesterRegistration() {
    console.log("get semester registration component method");
    if(this.getUserData == undefined || this._role != 3) return;
    let userId = this.getUserData[0].id;
    this._semesterRegistrationService.getSemesterRegistration(userId).subscribe((res:any) => {
      console.log(res);
      this.getSemesterRegistrationData = res;
    })
  }

  userPasswordValidation():boolean {
    // PASSWORD VALIDATION
    console.log(this.getUserData);
    if(this.getUserData != undefined) {
      if(this.getUserData[0].password != this._password) {
        this.loginValidationMessage = "Incorrect user credentials, please try again";
        return false;
      } 
      else {
        return true;
      }
    } 
    this.loginValidationMessage = "User does not exist"; 
    return false;
  }

  studentSemesterValidation():boolean {
    // STUDENT REGISTRATION VALIDATION
    if(this.getSemesterRegistrationData == undefined) {
      console.log("Student semester registration does not exist, please request admin to create registration");
      this.loginValidationMessage = "Student semester registration does not exist, please request admin to create registration";
      return false;
    } else if (this.getSemesterRegistrationData.approvalStatus == 0) {
        console.log("Semester registration exists but the registration has not yet been approved by admin, please contact admin");
        this.loginValidationMessage = "Semester registration exists but the registration has not yet been approved by admin, please contact admin";
        return false;
      } else {
      console.log("Semester registration exists");
      return true;
    }
  }

  resetModels() {
    this.getUserData = undefined;
    this.getSemesterRegistrationData = undefined;
  }

  showSuccess() {
    this.toastr.success('Welcome back, you have successfully logged in', 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
