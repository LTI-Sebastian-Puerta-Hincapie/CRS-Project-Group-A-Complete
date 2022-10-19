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
  viewRegisteredCoursesData:Array<string> = new Array();

  coursesData:any;
  registeredCoursesData:any;

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
  getCourses() {

    console.log("Get courses method");

    this._httpService.getCourses().subscribe((res:any[]) => {
      console.log(res);
      this.coursesData=res;
    })
  }

  getRegisteredCourses() {

    console.log("Get registered courses method");

    this._httpService.getRegisteredCourses().subscribe((res:any[]) => {
      console.log(res);
      this.registeredCoursesData=res;
    })
  }

  public createRegisteredCourse(courseId:number) {

    console.log("Calling create registered course method");
    
    let registeredCourse = new RegisteredCourse(courseId, 100, 0, "");
    this._httpService.createRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  public updateRegisteredCourse(courseId:number) {

    console.log("Calling update registered course method");

    let registeredCourse = new RegisteredCourse(courseId, 100, 1, "");
    this._httpService.updateRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  
  deleteRegisteredCourse(courseId:number) {

    console.log("Calling delete registered course method");

    let registeredCourse = new RegisteredCourse(courseId, 100, 0, "");
    this._httpService.deleteRegisteredCourse(registeredCourse).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
