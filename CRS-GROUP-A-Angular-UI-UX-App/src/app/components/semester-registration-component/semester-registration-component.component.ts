import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SemesterRegistration } from 'src/app/models/semester-registration';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-semester-registration-component',
  templateUrl: './semester-registration-component.component.html',
  styleUrls: ['./semester-registration-component.component.css']
})
export class SemesterRegistrationComponentComponent implements OnInit {

  studentId = 0;
  userName = "";
  password = "";

  public users:Array<User> = [
    new User(1, "admin", "test", 1),    //admin
    new User(10, "rwu", "welcome", 2),   // professor
    new User(1000, "tparker", "welcome", 3) // student
];

  semesterRegistrationList:Array<SemesterRegistration> = [
    new SemesterRegistration(10, 1, 0, "Pending Approval"),
    new SemesterRegistration(11, 1, 0, "Pending Approval"),
    new SemesterRegistration(12, 1, 0, "Pending Approval")
  ];

  constructor() { }

  ngOnInit(): void {
  }

  // functions
  public semesterRegistration(studentId:number) {

    console.log("Calling semester registration method");
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
  

}
