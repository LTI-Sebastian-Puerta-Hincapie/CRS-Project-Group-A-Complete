import { Component, OnInit } from '@angular/core';
import { Observer } from 'rxjs';
import { Professor } from 'src/app/models/professor';
import { ProfessorProfileService } from 'src/app/services/professor-profile.service';


@Component({
  selector: 'app-professor-profile',
  templateUrl: './professor-profile.component.html',
  styleUrls: ['./professor-profile.component.css']
})
export class ProfessorProfileComponent implements OnInit {

  resultData: any;

  ngOnInit(): void {
    this.getSemesterRegistration();
  }

  constructor(private _httpService:ProfessorProfileService) { }

  // service methods
  getSemesterRegistration() {
    console.log("Get semester registration method");
    this._httpService.getProfessorProfileById(5).subscribe(
      success => {
        this.resultData = success;
        console.log(success);
        console.log(this.resultData);
      })
    }

}
