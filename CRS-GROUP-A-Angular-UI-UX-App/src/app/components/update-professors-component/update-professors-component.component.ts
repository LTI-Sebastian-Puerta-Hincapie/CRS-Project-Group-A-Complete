import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/models/professor';
import { AdminServiceService } from 'src/app/services/admin-service.service';

@Component({
  selector: 'app-update-professors-component',
  templateUrl: './update-professors-component.component.html',
  styleUrls: ['./update-professors-component.component.css']
})
export class UpdateProfessorsComponentComponent implements OnInit {

  add:boolean = false;
  edit:boolean = false;

  professorId:number = 0;
  professorName:string = "";
  departmentId:number = 0;
  email:string = "";
  phone:string = "";
  address:string = "";

  constructor(private _httpService:AdminServiceService) { }

  ngOnInit(): void {
  }

  // ADMIN SERVICE METHODS
  addProfessor(professorId:number, 
                professorName:string,
                departmentId:number,
                email:string,
                phone:string,
                address:string) {

    console.log("Calling add professor method");
    let professor = new Professor(professorId,
                                  professorName,
                                  departmentId,
                                  email,
                                  phone,
                                  address);
    this._httpService.addProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  updateProfessor(professorId:number, 
                   professorName:string,
                   departmentId:number,
                   email:string,
                   phone:string,
                   address:string) {

    console.log("Calling update professor method");
    let professor = new Professor(professorId,
                                  professorName,
                                  departmentId,
                                  email,
                                  phone,
                                  address);
    this._httpService.updateProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  deleteProfessor(professorId:number) {

    console.log("Calling delete professor method");

    this._httpService.deleteProfessor(professorId).subscribe((res:any[]) => {
      console.log(res);
    })
  }

  professorSelection(selection:number) {
    if(selection == 1) {
      this.add = !this.add;
      this.edit = false;
    }
   else {
      this.edit = !this.edit;
      this.add = false;
    }
  }
}
