import { Component, OnInit } from '@angular/core';
import { ProfessorProfileService } from 'src/app/services/professor-profile.service';

@Component({
  selector: 'app-professor-offered-courses',
  templateUrl: './professor-offered-courses.component.html',
  styleUrls: ['./professor-offered-courses.component.css']
})
export class ProfessorOfferedCoursesComponent implements OnInit {

  coursesData:any;

  constructor(private _httpService:ProfessorProfileService) { }

  ngOnInit(): void {
    this.getProfessorCourses();
  }

  getProfessorCourses(){
    console.log("Get Professor courses method");
  this._httpService.getProfessorCourses(5).subscribe(
    success => {
      this.coursesData = success;
      console.log(success);
      console.log(this.coursesData);
    })
  }

}
