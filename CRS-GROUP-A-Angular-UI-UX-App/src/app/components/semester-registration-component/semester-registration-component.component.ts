import { Component, OnInit } from '@angular/core';
import { SemesterRegistration } from 'src/app/models/semester-registration';
import { User } from 'src/app/models/user';
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
  create:boolean = false;
  approve:boolean= false;
  view:boolean = false;

  user = new User(0, "", "", 1); // admin user
  semesterRegistration = new SemesterRegistration(0, 0, 0, 0, "");

  getData:any;

  constructor(private _httpService:SemesterRegistrationServiceService) { }

  ngOnInit(): void {
  }

  // service methods
  getSemesterRegistration(studentId:number) {
    console.log("Get semester registration method");
    this._httpService.getSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }
  public createSemesterRegistration(studentId:number) {

    console.log("Calling create semester registration method");
    
    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 0 , "Pending Approval");
    this._httpService.createSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public approveSemesterRegistration(studentId:number) {

    console.log("Calling update semester registration method");

    let semesterRegistration = new SemesterRegistration(0, studentId, 1, 1, "Approved");
    this._httpService.approveSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
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
}
