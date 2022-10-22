import { Component, OnInit } from '@angular/core';
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

  

}
