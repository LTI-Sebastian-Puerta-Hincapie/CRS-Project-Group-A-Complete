import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/models/course';
import { Grade } from 'src/app/models/grade';
import { ProfessorProfileService } from 'src/app/services/professor-profile.service';

@Component({
  selector: 'app-professor-add-grades',
  templateUrl: './professor-add-grades.component.html',
  styleUrls: ['./professor-add-grades.component.css']
})
export class ProfessorAddGradesComponent implements OnInit {

  studentId = "0";
  courseId = "";
  gradeValue = "";

  course = new Course(parseInt(this.courseId),"","");
  grade = new Grade(this.gradeValue,this.course);
  coursesData:any;

  constructor(private _httpService:ProfessorProfileService) { }

  ngOnInit(): void {
  }

  addGrades(){
    console.log("courseId gradeValue "+this.courseId+this.gradeValue);
    this.course.setCourseId(parseInt(this.courseId));
    this.grade.setCourse(this.course);
    this.grade.setGrade(this.gradeValue)
    this._httpService.addGrades(this.studentId,this.grade).subscribe(
      success => {
        this.coursesData = "success";
        console.log(success);
        alert(success);
      //  console.log(this.coursesData);
      }
    )
    this.coursesData = "success";
  }

}
