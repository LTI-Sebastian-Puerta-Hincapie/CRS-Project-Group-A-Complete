import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { SemesterRegistration } from 'src/app/models/semester-registration';
import { User } from 'src/app/models/user';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { SemesterRegistrationServiceService } from 'src/app/services/semester-registration-service.service';

@Component({
  selector: 'app-semester-registration-component',
  templateUrl: './semester-registration-component.component.html',
  styleUrls: ['./semester-registration-component.component.css']
})
export class SemesterRegistrationComponentComponent implements OnInit {

  studentId = 0;
  username = "";
  password = "";

  studentIdApprove = 0;
  usernameApprove = "";
  passwordApprove = "";

  studentIdView = 0;
  usernameView = "";
  passwordView = "";

  create:boolean = false;
  approve:boolean= false;
  view:boolean = false;
  empty:boolean = false;

  user = new User(0, "", "", 1); // admin user
  semesterRegistration = new SemesterRegistration(0, 0, 0, 0, "");

  getData:any;
  getUserData:any;
  semesterRegistrationValidationMessage = "";
  semesterRegistrationApprovalValidationMessage = "";
  semesterRegistrationViewValidationMessage = "";

  constructor(private _httpService:SemesterRegistrationServiceService,
              private _userService:LoginServiceService,
              private toastr: ToastrService) { }

  ngOnInit(): void {

  }

  // service methods
  getSemesterRegistration(studentId:number, process:number) {
    console.log("Get semester registration method");

    this._httpService.getSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }

  public createSemesterRegistration(studentId:number, form:NgForm) {

    console.log("Calling create semester registration method");

    if(!this.semesterRegistrationValidations()) {
      this.showError();
      return;
    }
    
    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 0 , "Pending Approval");
    this._httpService.createSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Semester Registration Created");
      form.reset();
      this.semesterRegistrationValidationMessage = "";
    })
  }

  public approveSemesterRegistration(studentId:number, form:NgForm) {

    console.log("Calling update semester registration method");

    if(!this.semesterRegistrationApprovalValidations()) {
      this.showError();
      return;
    }

    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 1, "Approved");
    this._httpService.approveSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Semester Registration Approved");
      form.reset();
      this.semesterRegistrationApprovalValidationMessage = "";
    })
  }

  deleteSemesterRegistration(studentId:number){

    console.log("Calling delete semester registration method");

    this._httpService.deleteSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  viewSemesterRegistration(studentId:number) {
    console.log("View semester registration method");

    if(!this.semesterRegistrationViewValidations()) {
      this.showError();
      return;
    }

    this._httpService.getSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
      this.semesterRegistrationViewValidationMessage = "";
    })
  }

  semesterRegistrationSelection(selection:number) {

    // reset data
    this.getData = null;
    this.semesterRegistrationValidationMessage = "";
    this.semesterRegistrationApprovalValidationMessage = "";
    this.semesterRegistrationViewValidationMessage = "";

    if(selection == 1) {
      this.create = !this.create;
      this.approve = false;
      this.view = false;
    }
    else if (selection == 2) {
      this.approve = !this.approve;
      this.create = false;
      this.view = false;
    } else {
      this.view = !this.view;
      this.create = false;
      this.approve = false;
    }
  }

  semesterRegistrationValidations():boolean {
    console.log("Create semester registration validations");

   // Initial input validations
   if(this.username == "" || this.username == undefined || this.username == null){
    this.semesterRegistrationValidationMessage = "Missing username";
    return false;
    }
    else if(this.password == "" || this.password == undefined || this.password == null){
      this.semesterRegistrationValidationMessage = "Missing password";
      return false;
    }
    else if(this.studentId == 0 || this.studentId == undefined || this.studentId == null){
      this.semesterRegistrationValidationMessage = "Missing studentId";
      return false;
    }

    // CREATE VALIDATIONS
    if(this.getUserData == undefined) {
      this.semesterRegistrationValidationMessage = "user does not exist";
      return false;
    }
    else if(this.getUserData[0].username != this.username) {
      this.semesterRegistrationValidationMessage = "user does not exist";
      return false;
    }
    else if(this.getUserData[0].password != this.password) {
      this.semesterRegistrationValidationMessage = "Incorrect user credentials, try again";
      return false;
    }

    this.semesterRegistrationValidationMessage = "";
    return true;
  }

  semesterRegistrationApprovalValidations() {

   // Initial input validations
   if(this.usernameApprove == "" || this.usernameApprove == undefined || this.usernameApprove == null){
    this.semesterRegistrationApprovalValidationMessage = "Missing username";
    return false;
    }
    else if(this.passwordApprove == "" || this.passwordApprove == undefined || this.passwordApprove == null){
      this.semesterRegistrationApprovalValidationMessage = "Missing password";
      return false;
    }
    else if(this.studentIdApprove == 0 || this.studentIdApprove == undefined || this.studentIdApprove == null){
      this.semesterRegistrationApprovalValidationMessage = "Missing studentId";
      return false;
    }

    // APPROVAL VALIDATIONS
    console.log("Approve semester registration validations");
    if(this.getUserData == undefined){
      this.semesterRegistrationApprovalValidationMessage = "user does not exist";
      return false;
    }
    else if(this.getUserData[0].username != this.usernameApprove) {
      this.semesterRegistrationApprovalValidationMessage = "user does not exist";
      return false;
    }
    else if(this.getUserData[0].password != this.passwordApprove) {
      this.semesterRegistrationApprovalValidationMessage = "Incorrect user credentials, try again";
      return false;
    }
    
    this.semesterRegistrationApprovalValidationMessage = "";
    return true;
  }

  semesterRegistrationViewValidations() {

    // Initial input validations
    if(this.usernameView == "" || this.usernameView == undefined || this.usernameView == null){
     this.semesterRegistrationViewValidationMessage = "Missing username";
     return false;
     }
     else if(this.passwordView == "" || this.passwordView == undefined || this.passwordView == null){
       this.semesterRegistrationViewValidationMessage = "Missing password";
       return false;
     }
     else if(this.studentIdView == 0 || this.studentIdView == undefined || this.studentIdView == null){
       this.semesterRegistrationViewValidationMessage = "Missing studentId";
       return false;
     }
 
     // APPROVAL VALIDATIONS
     console.log("Approve semester registration validations");
     if(this.getUserData == undefined){
       this.semesterRegistrationViewValidationMessage = "user does not exist";
       return false;
     }
     else if(this.getUserData[0].username != this.usernameView) {
       this.semesterRegistrationViewValidationMessage = "user does not exist";
       return false;
     }
     else if(this.getUserData[0].password != this.passwordView) {
       this.semesterRegistrationViewValidationMessage = "Incorrect user credentials, try again";
       return false;
     }
     
     this.semesterRegistrationViewValidationMessage = "";
     return true;
   }

  getUser(username:string) {
    console.log("get user component method");
    
    if(username == undefined || username == null || username == "") return;

    this._userService.getUserByUsername(username).subscribe((res:any) => {
      console.log(res);
      this.getUserData = res;
    })
  }

  semesterRegistrationExists():boolean {
    console.log("Semester registration exists method");

    if(this.getData == undefined || this.getData == null) {
      return false;
    }
    
    this.semesterRegistrationValidationMessage = "Semester registration already exists for this student";
    return true;
  }

  semesterRegistrationApproved():boolean {
    console.log("Semester registration approved method");

    if(this.getData == undefined || this.getData == null) {
      return false;
    } 

    if(this.getData.approvalStatus == 1) {
        this.semesterRegistrationApprovalValidationMessage = "Semester registration has already been approved for this student";
        return true;
    }
    else {
      return false;
    }
  }

  resetValidationMessages() {
    this.getData = null;
    this.semesterRegistrationValidationMessage = "";
    this.semesterRegistrationApprovalValidationMessage = "";
    this.semesterRegistrationViewValidationMessage = "";
  }

  showSuccess(message:string) {
    this.toastr.success(message, 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
