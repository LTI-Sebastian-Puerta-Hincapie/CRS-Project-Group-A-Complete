import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-student-view-component',
  templateUrl: './student-view-component.component.html',
  styleUrls: ['./student-view-component.component.css']
})
export class StudentViewComponentComponent implements OnInit {

  studentID:number = 0;
  getStudentData:any;
  getStudentCoursesData:any;
  getStudentRegisteredCoursesData:any;
  getStudentGradesData:any;

  constructor(private _httpService:StudentServiceService) { }

  ngOnInit(): void {

    // Get saved data from sessionStorage
    let sessionUserId = sessionStorage.getItem("userId");
    console.log(sessionUserId);
    if(sessionUserId != undefined) {
      this.studentID = parseInt(sessionUserId); 
    }

    this.getStudentProfile(this.studentID);
  }

  getStudentProfile(studentID:number) {
    
    this.getStudent(studentID);
    this.getStudentCourses(studentID);
    this.getStudentRegisteredCourses(studentID);
    this.getStudentGrades(studentID);
  }

  getStudent(studentId:number) {

    console.log("Get student method");

    this._httpService.getStudent(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getStudentData=res;
    })
  }

  getStudentCourses(studentId:number) {

    console.log("Get student courses method");

    this._httpService.getStudentCourses(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getStudentCoursesData=res;
    })
  }

  getStudentRegisteredCourses(studentId:number) {

    console.log("Get student registered courses method");

    this._httpService.getStudentRegisteredCourses(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getStudentRegisteredCoursesData=res;
    })
  }

  getStudentGrades(studentId:number) {

    console.log("Get student grades method");

    this._httpService.getStudentGrades(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getStudentGradesData=res;
    })
  }

}
