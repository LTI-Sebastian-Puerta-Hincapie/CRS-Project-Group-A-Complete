import { Component, OnInit } from '@angular/core';
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

    if(process == 1 && !this.semesterRegistrationValidations()) return;
    if(process == 2 && !this.semesterRegistrationApprovalValidations()) return;

    this._httpService.getSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }

  public createSemesterRegistration(studentId:number) {

    console.log("Calling create semester registration method");

    if(!this.semesterRegistrationValidations()) return;
    
    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 0 , "Pending Approval");
    this._httpService.createSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
      if(res != undefined) this.showSuccess("Semester Registration Created");
      else this.showError();
    })
  }

  public approveSemesterRegistration(studentId:number) {

    console.log("Calling update semester registration method");

    if(!this.semesterRegistrationApprovalValidations()) return;

    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 1, "Approved");
    this._httpService.approveSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Semester Registration Approved");
    })
  }

  deleteSemesterRegistration(studentId:number){

    console.log("Calling delete semester registration method");

    this._httpService.deleteSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  semesterRegistrationSelection(selection:number) {
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

    // CREATE VALIDATIONS
    console.log("Create semester registration validations");
    if(this.getUserData == undefined && (this.username == "" || this.username == null || this.username == undefined)) {
      this.semesterRegistrationValidationMessage = "";
      return false;
    }
    else if(this.getUserData == undefined && (this.username != "" && this.username != null)) {
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
    else if(this.studentId == 0 || this.studentId == null) {
      this.semesterRegistrationValidationMessage = "Please enter a valid studentId";
      return false;
    }

    this.semesterRegistrationValidationMessage = "";
    return true;
  }

  semesterRegistrationApprovalValidations() {

    // APPROVAL VALIDATIONS
    console.log("Approve semester registration validations");
    if(this.getUserData == undefined && (this.usernameApprove == "" || this.usernameApprove == null || this.usernameApprove == undefined)) {
      this.semesterRegistrationApprovalValidationMessage = "";
      return false;
    }
    else if(this.getUserData == undefined && (this.usernameApprove != "" && this.usernameApprove != null)) {
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
    else if(this.studentIdApprove == 0 || this.studentIdApprove == null) {
      this.semesterRegistrationApprovalValidationMessage = "Please enter a valid studentId";
      return false;
    }
    
    this.semesterRegistrationValidationMessage = "";
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
    // console.log("Semester registration exists method");
    if(this.getData != undefined) {
      this.semesterRegistrationValidationMessage = "Semester registration already exists for this student";
      return true;
    }
    this.semesterRegistrationValidationMessage = "";
    return false;
  }

  semesterRegistrationApproved():boolean {
    // console.log("Semester registration approved method");
    console.log(this.getData);
    if(this.getData != undefined) {
      if(this.getData.approvalStatus == 1) {
        this.semesterRegistrationApprovalValidationMessage = "Semester registration has already been approved for this student";
        return true;
      }
    }
    this.semesterRegistrationApprovalValidationMessage = "";
    return false;
  }

  showSuccess(message:string) {
    this.toastr.success(message, 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
