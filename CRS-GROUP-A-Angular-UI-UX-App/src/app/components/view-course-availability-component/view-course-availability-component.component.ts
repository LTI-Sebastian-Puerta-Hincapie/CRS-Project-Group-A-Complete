import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-view-course-availability-component',
  templateUrl: './view-course-availability-component.component.html',
  styleUrls: ['./view-course-availability-component.component.css']
})
export class ViewCourseAvailabilityComponentComponent implements OnInit {

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  checkCourseAvailability(studentId:number) {

    console.log("Calling check course availability method");

    this._httpService.checkCourseAvailability(studentId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

}
