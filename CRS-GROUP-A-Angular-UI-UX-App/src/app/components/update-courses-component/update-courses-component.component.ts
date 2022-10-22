import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-update-courses-component',
  templateUrl: './update-courses-component.component.html',
  styleUrls: ['./update-courses-component.component.css']
})
export class UpdateCoursesComponentComponent implements OnInit {

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  addCourse(course:Course) {

    console.log("Calling add course method");

    this._httpService.addCourse(course).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  updateCourse(course:Course) {

    console.log("Calling update course method");

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

}
