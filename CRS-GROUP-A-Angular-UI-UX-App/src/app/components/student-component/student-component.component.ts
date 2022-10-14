import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-component',
  templateUrl: './student-component.component.html',
  styleUrls: ['./student-component.component.css']
})
export class StudentComponentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  addCourse() {
    console.log("add course method");
  }

  dropCourse() {
    console.log("drop course method");
  }

  registerCourse() {
    console.log("register course method");
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
