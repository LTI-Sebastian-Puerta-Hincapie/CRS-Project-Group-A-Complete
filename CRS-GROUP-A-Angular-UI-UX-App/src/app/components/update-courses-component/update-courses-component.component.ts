import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Course } from 'src/app/models/course';
import { AdminServiceService } from 'src/app/services/admin-service.service';
import { CourseServiceService } from 'src/app/services/course-service.service';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-update-courses-component',
  templateUrl: './update-courses-component.component.html',
  styleUrls: ['./update-courses-component.component.css']
})
export class UpdateCoursesComponentComponent implements OnInit {

  courseId:number = 0;
  updateCourseId:number = 0;
  credits:number = 0;
  capacity:number = 0;

  courseName:string = "";
  updateCourseName:string = "";
  description:string = "";
  updateDescription:string = "";
  semester:string = "";
  addCourseValidationMessage:string = "";
  updateCourseValidationMessage:string = "";

  add:boolean = false;
  edit:boolean = false;
  view:boolean = false;

  getData: any;

  constructor(private _httpService:AdminServiceService,
              private toastr: ToastrService,
              private _courseService: CourseServiceService) { }

  ngOnInit(): void {
  }

  addCourse(courseId:number, courseName:string, description:string) {

    console.log("Calling add course method");

    if(!this.addCourseValidations()) {
      this.showError();
      return;
    }

    let course = new Course(courseId, courseName, description);

    this._httpService.addCourse(course).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Course was successfully added");
    })
  }

  updateCourse(courseId:number, courseName:string, description:string) {

    console.log("Calling update course method");

    if(!this.updateCourseValidations()) {
      this.showError();
      return;
    }

    let course = new Course(courseId, courseName, description);

    this._httpService.updateCourse(course).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Course was successfully updated");
    })
  }

  deleteCourse(courseId:number) {

    console.log("Calling delete course method");

    if(courseId == 0 || courseId == undefined || courseId == null) {
      this.updateCourseValidationMessage = "Missing or incorrect course id input";
      this.showError();
      return;
    }

    this._httpService.deleteCourse(courseId).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("Course was successfully deleted");
    })
  }

  getCourses() {
    console.log("Get courses method");

    this._courseService.getCourses().subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })
  }

  courseSelection(selection:number) {
    if(selection == 1) {
      this.add = !this.add;
      this.edit = false;
      this.view = false;
    }
   else if(selection  == 2){
      this.edit = !this.edit;
      this.add = false;
      this.view = false;
    }
    else {
      this.view = !this.view;
      this.add = false;
      this.edit = false;
    }
  }

  addCourseValidations():boolean {
    if(this.courseId == 0 || this.courseId == undefined || this.courseId == null) {
      this.addCourseValidationMessage = "Missing or incorrect course id input";
      return false;
    }
    else if(this.courseName == '' || this.courseName == undefined || this.courseName == null) {
      this.addCourseValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.description == '' || this.description == undefined || this.description == null) {
      this.addCourseValidationMessage = "Missing or incorrect course description input";
      return false;
    }
    return true;
  }

  updateCourseValidations():boolean {
    if(this.updateCourseId == 0 || this.updateCourseId == undefined || this.updateCourseId == null) {
      this.updateCourseValidationMessage = "Missing or incorrect course id input";
      return false;
    }
    else if(this.updateCourseName == '' || this.updateCourseName == undefined || this.updateCourseName == null) {
      this.updateCourseValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.updateDescription == '' || this.updateDescription == undefined || this.updateDescription == null) {
      this.updateCourseValidationMessage = "Missing or incorrect course description input";
      return false;
    }
    return true;
  }

  showSuccess(message:string) {
    this.toastr.success(message, 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
