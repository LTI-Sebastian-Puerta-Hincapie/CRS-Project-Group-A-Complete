import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { RegisteredCourse } from 'src/app/models/registered-course';
import { CourseServiceService } from 'src/app/services/course-service.service';

@Component({
  selector: 'app-course-component',
  templateUrl: './course-component.component.html',
  styleUrls: ['./course-component.component.css']
})
export class CourseComponentComponent implements OnInit {

  // in memory data - demo purposes
  courses:Array<Course> = [
    new Course(1, "Biology 1", "Biology"),
    new Course(2, "Biology 2", "Biology"),
    new Course(3, "Biology 3", "Biology")
  ];

  studentCourses:Array<Course> = new Array();
  studentRegisteredCourses:Array<Course> = new Array();

  getCourseData:any;  // get data for one course
  getCoursesData:any;    // data for all courses
  getAddedCoursesData:any;  // added courses
  getRegisteredCoursesData:any;   // registered courses

  constructor(private _httpService:CourseServiceService) { }

  ngOnInit(): void {}

  addCourse(courseId: number) {
    console.log("add course method");

    // pre-condition
    if(this.studentCourses.find(x => x.getCourseId() == courseId) != undefined) return;

    let element = this.courses.find(x => x.getCourseId() == courseId);
    if(element != undefined) {
      this.studentCourses.push(element);
    }

    console.log(this.studentCourses);
  }

  dropCourse(courseId: number) {
    console.log("drop course method");
    
    // pre-condition
    if(this.studentCourses.find(x => x.getCourseId() == courseId) == undefined) 
    {
      return;
    }

    let element = this.courses.find(x => x.getCourseId() == courseId);
    if(element != undefined) {

      // added courses
      let index = this.studentCourses.indexOf(element, 0);
      this.studentCourses.splice(index, 1);

      // registered courses
      let index2 = this.studentRegisteredCourses.indexOf(element, 0);
      this.studentRegisteredCourses.splice(index2, 1);
    }


    console.log(this.studentCourses);
    console.log(this.studentRegisteredCourses);
  }

  registerCourse(courseId: number) {
    console.log("register course method");

    // pre-condition
    if(this.studentRegisteredCourses.find(x => x.getCourseId() == courseId) != undefined) return;

    let element = this.studentCourses.find(x => x.getCourseId() == courseId);
    if(element != undefined) {
      this.studentRegisteredCourses.push(element);
    }

    console.log(this.studentRegisteredCourses);
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

     this.getAddedCourses();

     this.getRegisteredCoursesData = this.getAddedCoursesData
      .filter((x: { registeredStatus: number; }) => x.registeredStatus == 1);
  }

  public createRegisteredCourse(course:any) {

    console.log("Calling create registered course method");
    
    let registeredCourse = new RegisteredCourse(course.courseId, course.courseName, 100, 0, "");

    this._httpService.createRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public updateRegisteredCourse(course:any, status:number) {

    console.log("Calling update registered course method");

    let registeredCourse = new RegisteredCourse(course.courseId, course.courseName, 100, status, "");
    this._httpService.updateRegisteredCourse(course.id, registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }
  
  deleteRegisteredCourse(course:any) {

    console.log("Calling delete registered course method");

    this._httpService.deleteRegisteredCourse(course.id).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
