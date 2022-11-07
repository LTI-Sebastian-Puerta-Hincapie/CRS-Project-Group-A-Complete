import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-view-course-availability-component',
  templateUrl: './view-course-availability-component.component.html',
  styleUrls: ['./view-course-availability-component.component.css']
})
export class ViewCourseAvailabilityComponentComponent implements OnInit {

  courseId:number = 0;
  courseIsAvailable:string = "";
  courseIsNotAvailable:string = "";
  available:boolean = false;
  getData:any;

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  checkCourseAvailability(studentId:number) {

    console.log("Calling check course availability method");

    this._httpService.checkCourseAvailability(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData = res;
      if(this.getData) {
        this.available = true;
        this.courseIsAvailable = "COURSE IS AVAILABLE";
      }
      else {
        this.available = false;
        this.courseIsNotAvailable = "COURSE IS NOT AVAILABLE";
      }
    })
  }

}
