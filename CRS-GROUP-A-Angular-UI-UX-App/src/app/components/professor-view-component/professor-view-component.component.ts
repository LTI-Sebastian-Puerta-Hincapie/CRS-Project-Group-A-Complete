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

}
