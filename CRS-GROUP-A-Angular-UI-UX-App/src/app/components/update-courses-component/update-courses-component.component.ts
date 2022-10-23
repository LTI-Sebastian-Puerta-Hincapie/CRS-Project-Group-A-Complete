import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-update-courses-component',
  templateUrl: './update-courses-component.component.html',
  styleUrls: ['./update-courses-component.component.css']
})
export class UpdateCoursesComponentComponent implements OnInit {

  courseId:number = 0;
  credits:number = 0;
  capacity:number = 0;

  courseName:string = "";
  description:string = "";
  semester:string = "";

  add:boolean = false;
  edit:boolean = false;

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  addCourse(courseId:number, courseName:string, description:string) {

    console.log("Calling add course method");

    let course = new Course(courseId, courseName, description);

    this._httpService.addCourse(course).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  updateCourse(courseId:number, courseName:string, description:string) {

    console.log("Calling update course method");

    let course = new Course(courseId, courseName, description);

    this._httpService.updateCourse(course).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  deleteCourse(courseId:number) {

    console.log("Calling delete course method");

    this._httpService.deleteCourse(courseId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  courseSelection(selection:number) {
    if(selection == 1) {
      this.add = !this.add;
      this.edit = false;
    }
   else {
      this.edit = !this.edit;
      this.add = false;
    }
  }
}
