import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-generate-report-card-component',
  templateUrl: './generate-report-card-component.component.html',
  styleUrls: ['./generate-report-card-component.component.css']
})
export class GenerateReportCardComponentComponent implements OnInit {

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  generateReportCard(studentId:number) {

    console.log("Calling generate report card method");

    this._httpService.generateReportCard(studentId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

}
