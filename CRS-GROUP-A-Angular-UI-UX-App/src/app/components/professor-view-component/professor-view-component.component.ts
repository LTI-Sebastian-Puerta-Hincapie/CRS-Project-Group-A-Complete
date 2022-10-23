import { Component, OnInit } from '@angular/core';
import { ProfessorServiceService } from 'src/app/services/professor-service.service';

@Component({
  selector: 'app-professor-view-component',
  templateUrl: './professor-view-component.component.html',
  styleUrls: ['./professor-view-component.component.css']
})
export class ProfessorViewComponentComponent implements OnInit {

  professorID:number = 0;
  getData:any;

  constructor(private _httpService:ProfessorServiceService) { }

  ngOnInit(): void {
  }

  getProfessor(professorId:number) {
    console.log("Calling get professor method");
    this._httpService.getProfessor(professorId).subscribe((res:any[]) => {
      console.log(res);
    });
  }

  getCourseEnrollment(professorId:number) {
    console.log("Calling get course enrollment method");
    this._httpService.getCourseEnrollment(professorId).subscribe((res:any[]) => {
      console.log(res);
    });
  }

  getProfessorCourses(professorId:number) {
    console.log("Calling get professor courses method");
    this._httpService.getProfessorCourses(professorId).subscribe((res:any[]) => {
      console.log(res);
    });
  }
}
