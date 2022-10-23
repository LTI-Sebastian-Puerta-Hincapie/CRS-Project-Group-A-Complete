import { Component, OnInit } from '@angular/core';
import { ProfessorServiceService } from 'src/app/services/professor-service.service';

@Component({
  selector: 'app-professor-view-component',
  templateUrl: './professor-view-component.component.html',
  styleUrls: ['./professor-view-component.component.css']
})
export class ProfessorViewComponentComponent implements OnInit {

  professorId:number = 0;
  getProfessorData:any;
  getProfessorCoursesData:any;

  constructor(private _httpService:ProfessorServiceService) { }

  ngOnInit(): void {
  }

  getProfessorProfile(professorId:number) {

    this.getProfessor(professorId);
    this.getProfessorCourses(professorId);
  }

  getProfessor(professorId:number) {
    console.log("Calling get professor method");
    this._httpService.getProfessor(professorId).subscribe((res:any[]) => {
      console.log(res);
      this.getProfessorData = res;
    });
  }

  getProfessorCourses(professorId:number) {
    console.log("Calling get professor courses method");
    this._httpService.getProfessorCourses(professorId).subscribe((res:any[]) => {
      console.log(res);
      this.getProfessorCoursesData = res;
    });
  }
}
