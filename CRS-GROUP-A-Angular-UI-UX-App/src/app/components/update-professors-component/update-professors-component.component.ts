import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/models/professor';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-update-professors-component',
  templateUrl: './update-professors-component.component.html',
  styleUrls: ['./update-professors-component.component.css']
})
export class UpdateProfessorsComponentComponent implements OnInit {

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  // ADMIN SERVICE METHODS
  addProfessors(professor:Professor) {

    console.log("Calling add professor method");

    this._httpService.addProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  updateProfessors(professor:Professor) {

    console.log("Calling update professor method");

    this._httpService.updateProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  deleteProfessors(professorId:number) {

    console.log("Calling delete professor method");

    this._httpService.deleteProfessor(professorId).subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
