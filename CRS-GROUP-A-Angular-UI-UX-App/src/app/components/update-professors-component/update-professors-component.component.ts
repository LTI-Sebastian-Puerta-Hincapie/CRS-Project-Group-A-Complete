import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Professor } from 'src/app/models/professor';
import { AdminServiceService } from 'src/app/services/admin-service.service';
import { ProfessorServiceService } from 'src/app/services/professor-service.service';

@Component({
  selector: 'app-update-professors-component',
  templateUrl: './update-professors-component.component.html',
  styleUrls: ['./update-professors-component.component.css']
})
export class UpdateProfessorsComponentComponent implements OnInit {

  add:boolean = false;
  edit:boolean = false;
  view:boolean = false;

  professorId:number = 0;
  professorName:string = "";
  departmentId:number = 0;
  email:string = "";
  phone:string = "";
  address:string = "";

  updateProfessorId:number = 0;
  updateProfessorName:string = "";
  updateDepartmentId:number = 0;
  updateEmail:string = "";
  updatePhone:string = "";
  updateAddress:string = "";

  addProfessorValidationMessage:string = "";
  updateProfessorValidationMessage:string = "";

  getData: any;

  constructor(private _httpService:AdminServiceService,
              private toastr: ToastrService,
              private _professorService: ProfessorServiceService) { }

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

    if(!this.addProfessorValidations()) {
      this.showError();
      return;
    }

    let professor = new Professor(professorId,
                                  professorName,
                                  departmentId,
                                  email,
                                  phone,
                                  address);
    this._httpService.addProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("You have successfully added a new professor");
    })
  }

  updateProfessor(professorId:number, 
                   professorName:string,
                   departmentId:number,
                   email:string,
                   phone:string,
                   address:string) {

    console.log("Calling update professor method");

    if(!this.updateProfessorValidations()) {
      this.showError();
      return;
    }

    let professor = new Professor(professorId,
                                  professorName,
                                  departmentId,
                                  email,
                                  phone,
                                  address);
    this._httpService.updateProfessor(professor).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("You have successfully updated this professor");
    })
  }

  deleteProfessor(professorId:number) {

    console.log("Calling delete professor method");

    if(professorId == 0 || professorId == undefined || professorId == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course id input";
      this.showError();
      return;
    }

    this._httpService.deleteProfessor(professorId).subscribe((res:any[]) => {
      console.log(res);
      this.showSuccess("You have successfully deleted this professor");
    })
  }

  getProfessors() {
    console.log("Calling get professors method");
    this._professorService.getProfessors().subscribe((res:any[]) => {
      console.log(res);
      this.getData = res;
    });
  }

  professorSelection(selection:number) {
    if(selection == 1) {
      this.add = !this.add;
      this.edit = false;
      this.view = false;
    }
   else if(selection == 2) {
      this.edit = !this.edit;
      this.add = false;
      this.view = false;
    }
    else {
      this.view = !this.view;
      this.add = false;
      this.edit = false;
    }
  }

  addProfessorValidations():boolean {
    if(this.professorId == 0 || this.professorId == undefined || this.professorId == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course id input";
      return false;
    }
    else if(this.professorName == '' || this.professorName == undefined || this.professorName == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.departmentId == 0 || this.departmentId == undefined || this.departmentId == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.email == '' || this.email == undefined || this.email == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.address == '' || this.address == undefined || this.address == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.phone == '' || this.phone == undefined || this.phone == null) {
      this.addProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    return true;
  }

  updateProfessorValidations():boolean {
    if(this.updateProfessorId == 0 || this.updateProfessorId == undefined || this.updateProfessorId == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course id input";
      return false;
    }
    else if(this.updateProfessorName == '' || this.updateProfessorName == undefined || this.updateProfessorName == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.updateDepartmentId == 0 || this.updateDepartmentId == undefined || this.updateDepartmentId == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.updateEmail == '' || this.updateEmail == undefined || this.updateEmail == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.updateAddress == '' || this.updateAddress == undefined || this.updateAddress == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    else if(this.updatePhone == '' || this.updatePhone == undefined || this.updatePhone == null) {
      this.updateProfessorValidationMessage = "Missing or incorrect course name input";
      return false;
    }
    return true;
  }

  showSuccess(message:string) {
    this.toastr.success(message, 'Success');
  }

  showError() {
    this.toastr.error('An error occurred, please try again', 'Error');
  }
}
