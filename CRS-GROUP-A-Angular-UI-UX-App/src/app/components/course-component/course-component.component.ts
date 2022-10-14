import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';

@Component({
  selector: 'app-course-component',
  templateUrl: './course-component.component.html',
  styleUrls: ['./course-component.component.css']
})
export class CourseComponentComponent implements OnInit {

  courses:Array<Course> = [
    new Course(1, "Biology 1", "Biology"),
    new Course(2, "Biology 2", "Biology"),
    new Course(3, "Biology 3", "Biology")
  ];

  studentCourses:Array<Course> = new Array();
  studentRegisteredCourses:Array<Course> = new Array();

  constructor() { }

  ngOnInit(): void {
  }

  addCourse(courseId: number) {
    console.log("add course method");

    // pre-condition
    if(this.studentCourses.find(x => x.getCourseId() == courseId) != undefined) return;

    this.studentCourses.push(this.courses.filter(x => x.getCourseId() == courseId)[0]);
  }

  dropCourse(courseId: number) {
    console.log("drop course method");
    
    // pre-condition
    if(this.studentCourses.find(x => x.getCourseId() == courseId) == undefined) return;

    let element = this.courses.filter(x => x.getCourseId() == courseId)[0];
    let index = this.courses.indexOf(element, 0);
    this.studentCourses.splice(index, 1);
    // delete this.studentCourses[index];
    
    console.log(this.studentCourses);
  }

  registerCourse(courseId: number) {
    console.log("register course method");

    // pre-condition
    if(this.studentRegisteredCourses.find(x => x.getCourseId() == courseId) != undefined) return;

    this.studentRegisteredCourses.push(this.studentCourses.filter(x => x.getCourseId() == courseId)[0]);
  }

  makePayment() {
    console.log("make payment method");
  }

  viewStudent() {
    console.log("view student method");
  }

  viewAddedCourses() {
    console.log("view added courses method");
  }

  viewRegisteredCourses() {
    console.log("view registered courses method");
  }
}
