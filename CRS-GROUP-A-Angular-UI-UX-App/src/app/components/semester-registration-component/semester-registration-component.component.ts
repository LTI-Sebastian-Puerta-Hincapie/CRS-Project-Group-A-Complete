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
  userName = "";
  password = "";

  user = new User(0, "", "", 1); // admin user
  semesterRegistration = new SemesterRegistration(0, 0, 0, "");

  // in memory data - demo purposes
  semesterRegistrationList:Array<SemesterRegistration> = [
    new SemesterRegistration(10, 1, 0, "Pending Approval"),
    new SemesterRegistration(11, 1, 0, "Pending Approval"),
    new SemesterRegistration(12, 1, 0, "Pending Approval")
  ];

  getData:any;

  constructor(private _httpService:SemesterRegistrationServiceService) { }

  ngOnInit(): void {
  }

  // functions using array implementation
  public createSemesterRegistrationArr(studentId:number) {

    console.log("Calling create semester registration method");
    console.log("StudentId: " + studentId);
    
    // pre-condition
    if(studentId < 1) {
      return;
    }

    let element = this.semesterRegistrationList.find(x => x.getStudentId() == studentId);
    if(element == undefined) return;

    this.semesterRegistrationList.push(new SemesterRegistration(studentId, 1, 0, "Pending Approval"));

    console.log(this.semesterRegistrationList);
  }

  public updateSemesterRegistrationArr(studentId:number) {

    console.log("Calling update semester registration method");
    console.log("StudentId: " + studentId);
    
    // pre-condition
    if(studentId < 1) {
      return;
    }

    let element = this.semesterRegistrationList.find(x => x.getStudentId() == studentId);
    if(element != undefined) {
      let index = this.semesterRegistrationList.indexOf(element);
      this.semesterRegistrationList[index].setApprovalStatus(1);
      this.semesterRegistrationList[index].setComments("Approved");
    }

    console.log(this.semesterRegistrationList);
  }

  // service methods
  getSemesterRegistration() {
    console.log("Get semester registration method");
    this._httpService.getSemesterRegistration().subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }
  public createSemesterRegistration(studentId:number) {

    console.log("Calling create semester registration method");
    
    let semesterRegistration = new SemesterRegistration(studentId, 1, 0 , "Pending Approval");
    this._httpService.createSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);

    })

  }

  public updateSemesterRegistration(studentId:number) {

    console.log("Calling update semester registration method");

    let semesterRegistration = new SemesterRegistration(studentId, 1, 1, "Approved");
    this._httpService.updateSemesterRegistration(semesterRegistration).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  
  deleteSemesterRegistration(studentId:number){

    console.log("Calling delete semester registration method");

    this._httpService.deleteSemesterRegistration(studentId).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
