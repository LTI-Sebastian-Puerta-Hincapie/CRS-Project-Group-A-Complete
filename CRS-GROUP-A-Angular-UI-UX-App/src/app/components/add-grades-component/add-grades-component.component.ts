import { Component, OnInit } from '@angular/core';
import { Grade } from 'src/app/models/grade';
import { ProfessorServiceService } from 'src/app/services/professor-service.service';

@Component({
  selector: 'app-add-grades-component',
  templateUrl: './add-grades-component.component.html',
  styleUrls: ['./add-grades-component.component.css']
})
export class AddGradesComponentComponent implements OnInit {

  professorID:number = 0;
  getData:any;

  constructor(private _httpService:ProfessorServiceService) { }

  ngOnInit(): void {
  }
  
  addGrades(studentId:number, grade:Grade) {
    console.log("Calling add grades method");
    this._httpService.addGrades(studentId, grade).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
