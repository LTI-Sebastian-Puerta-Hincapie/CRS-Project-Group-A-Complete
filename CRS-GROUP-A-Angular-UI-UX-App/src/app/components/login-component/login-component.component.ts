import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SemesterRegistration } from 'src/app/models/semester-registration';
import { User } from 'src/app/models/user';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { SemesterRegistrationServiceService } from 'src/app/services/semester-registration-service.service';

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

  semestereRegistrationValidationMessage:string = "";

  constructor(private router: Router, 
              private _userService:LoginServiceService,
              private _semesterRegistrationService:SemesterRegistrationServiceService) {}

  ngOnInit() {}

  login(username:string, password:string, roleId:number) {

    console.log("Login component method");
    if (roleId == 1) {
      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate(["admin", { admin: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, "admin", this.getData[0].Id);
      })
    }
    else if (roleId == 2) {
      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate(["professor", { professor: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, "professor", this.getData[0].Id);
      })
    }
    else if(roleId == 3)  {

      // Student Registration Validation
      if(this.getSemesterRegistrationData == undefined) {
        console.log("Student semester registration does not exist, please request admin to create registration");
        this.semestereRegistrationValidationMessage = "Student semester registration does not exist, please request admin to create registration";
        return;
      } else if (this.getSemesterRegistrationData.approvalStatus == 0) {
         console.log("Semester registartion exists but the registration has not yet been approved by admin, please contact admin");
         this.semestereRegistrationValidationMessage = "Semester registartion exists but the registration has not yet been approved by admin, please contact admin";
         return;
        } else {
        console.log("Semester registration exists");
      }


      this._userService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate(["student", { student: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, "student", this.getData[0].Id);
      })
    }
    else {
      console.log("user role does not exist");
    }
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
    this._userService.getUserByUsername(this._username).subscribe((res:any) => {
      console.log(res);
      this.getUserData = res;
    })
  }

  getSemesterRegistration() {
    console.log("get semester registration component method");
    if(this.getUserData == undefined) return;
    let userId = this.getUserData[0].id;
    this._semesterRegistrationService.getSemesterRegistration(userId).subscribe((res:any) => {
      console.log(res);
      this.getSemesterRegistrationData = res;
    })
  }
}
