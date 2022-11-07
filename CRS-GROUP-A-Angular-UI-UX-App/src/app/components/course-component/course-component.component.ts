import { Component, OnInit } from '@angular/core';
import { timeStamp } from 'console';
import { Course } from 'src/app/models/course';
import { RegisteredCourse } from 'src/app/models/registered-course';
import { CourseServiceService } from 'src/app/services/course-service.service';

@Component({
  selector: 'app-course-component',
  templateUrl: './course-component.component.html',
  styleUrls: ['./course-component.component.css']
})
export class CourseComponentComponent implements OnInit {

  studentID:number = 0;
  getCourseData:any;  // get data for one course
  getCoursesData:any;    // data for all courses
  getAddedCoursesData:any;  // added courses
  getRegisteredCoursesData:any;   // registered courses

  constructor(private _httpService:CourseServiceService) { }

  ngOnInit(): void {

    // Get saved data from sessionStorage
    let sessionUserId = sessionStorage.getItem("userId");
    console.log("Session userId: ", sessionUserId);
    if(sessionUserId != undefined) {
      this.studentID = parseInt(sessionUserId); 
    }
    
    this.refresh();
  }

  // service methods
  getCourses() {

    console.log("Get courses method");

    this._httpService.getCourses().subscribe((res:any[]) => {
      console.log(res);
      this.getCoursesData=res;
    })
  }

  getCourse(courseId:number) {

    console.log("Get course method");

    this._httpService.getCourse(courseId).subscribe((res:any[]) => {
      console.log(res);
      this.getCourseData=res;
    })
  }

  getAddedCourses() {

    console.log("Get added courses method");

    this._httpService.getRegisteredCourses().subscribe((res:any[]) => {
      console.log(res);
      this.getAddedCoursesData=res;
    })
  }

  getRegisteredCourses() {
     console.log("Get registered courses method");

    //  this.getAddedCourses();

     this.getRegisteredCoursesData = this.getAddedCoursesData
      .filter((x: { registeredStatus: number; }) => x.registeredStatus == 1);
  }

  public addCourse(course:any) {

    console.log("Calling create registered course method");
    
    let registeredCourse = new RegisteredCourse(
      course.courseId, course.courseName, this.studentID, 0, "");

    console.log(registeredCourse);
    this._httpService.createRegisteredCourse(registeredCourse)
        .subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public registerCourse(course:any) {

    console.log("Calling update registered course method");

    let registeredCourse = new RegisteredCourse(
      course.courseId, course.courseName, this.studentID, 1, "");
    this._httpService.registerCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public unRegisterCourse(course:any) {

    console.log("Calling update registered course method");

    let registeredCourse = new RegisteredCourse(
      course.courseId, course.courseName, this.studentID, 0, "");
    this._httpService.unRegisterCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }
  
  dropCourse(course:any) {

    console.log("Calling delete registered course method");

    let registeredCourse = new RegisteredCourse(
      course.courseId,
      course.courseName,
      this.studentID,
      course.registeredStatus,
      course.grade);

    this._httpService.deleteRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  generateStudentFee(studentId:number) {

    console.log("Calling generate student fee method");

    this._httpService.generateStudentFee(this.studentID).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  refresh() {
    this.getCourses();
    this.getAddedCourses();
    this.getRegisteredCourses();
  }
}
