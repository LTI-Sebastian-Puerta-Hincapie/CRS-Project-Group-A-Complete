import { Component, OnInit } from '@angular/core';
import { ProfessorProfileService } from 'src/app/services/professor-profile.service';

@Component({
  selector: 'app-professor-enrolled-courses',
  templateUrl: './professor-enrolled-courses.component.html',
  styleUrls: ['./professor-enrolled-courses.component.css']
})
export class ProfessorEnrolledCoursesComponent implements OnInit {

   coursesData:any;

  constructor(private _httpService: ProfessorProfileService) {
    this.getEnrolledCourses();
   }

  ngOnInit(): void {
  }

  getEnrolledCourses(){
    this._httpService.getStudentEnrolledCourses(2).subscribe(
      success => {
        this.coursesData = success;
        console.log(success);
        console.log(this.coursesData);
      })
  }


}
