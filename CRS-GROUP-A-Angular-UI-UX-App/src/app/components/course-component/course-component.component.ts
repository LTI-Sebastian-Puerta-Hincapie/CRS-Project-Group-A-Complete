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

  getData:any;

  constructor(private _httpService:CourseServiceService) { }

  ngOnInit(): void {
  }

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
  getRegisteredCourses() {

    console.log("Get registered courses method");

    this._httpService.getRegisteredCourses().subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }

  public createSemesterRegistration(registeredCourse:RegisteredCourse) {

    console.log("Calling create registered course method");
    
    this._httpService.createRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public updateSemesterRegistration(registeredCourse:RegisteredCourse) {

    console.log("Calling update registered course method");

    this._httpService.updateRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  
  deleteSemesterRegistration(registeredCourse:RegisteredCourse){

    console.log("Calling delete registered course method");

    this._httpService.deleteRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
