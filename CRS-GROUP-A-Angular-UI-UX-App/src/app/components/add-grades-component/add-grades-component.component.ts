import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { Grade } from 'src/app/models/grade';
import { ProfessorServiceService } from 'src/app/services/professor-service.service';

@Component({
  selector: 'app-add-grades-component',
  templateUrl: './add-grades-component.component.html',
  styleUrls: ['./add-grades-component.component.css']
})
export class AddGradesComponentComponent implements OnInit {

  professorId:number = 0;
  courseId:number = 0;
  courseName:string = "";
  studentId:number = 0;
  grade:string = "";
  getData:any;

  constructor(private _httpService:ProfessorServiceService) { }

  ngOnInit(): void {
  }
  
  getCourseEnrollment(courseId:number) {
    console.log("Calling get course enrollment method");
    this._httpService.getCourseEnrollment(courseId).subscribe((res:any[]) => {
      console.log(res);
      this.getData = res;
      console.log(this.getData);
    });
  }

  addGrades(studentId:number, gradeInput:string, courseId:number, courseName:string) {
    console.log("Calling add grades method");
    let grade = new Grade(gradeInput, new Course(courseId, courseName, ""));
    this._httpService.addGrades(studentId, grade).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
