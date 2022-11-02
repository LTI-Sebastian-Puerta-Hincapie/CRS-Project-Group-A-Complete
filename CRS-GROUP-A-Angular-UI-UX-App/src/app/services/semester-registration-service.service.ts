import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SemesterRegistration } from '../models/semester-registration';

@Injectable({
  providedIn: 'root'
})
export class SemesterRegistrationServiceService {

  // cros implementation
  headers = new HttpHeaders()
              .set('Content-Type', 'application/json')
              .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient:HttpClient) { }

  // USER SERVICE METHODS
  // GET 
  getSemesterRegistration(studentId:number):Observable<any> {
    console.log("Get semester registration service method");
    // let uri:string = "http://localhost:7004/semesterregistration"; 
    let uri:string = "http://localhost:9098/admin/getregistration/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  createSemesterRegistration(semesterRegistration:SemesterRegistration):Observable<any> {
    console.log("Create semester registration service method");
    // let uri:string = "http://localhost:7004/semesterregistration/create";
    let uri:string = "http://localhost:9098/admin/createregistration";
    return this.httpClient.post<any>(uri, semesterRegistration);
  }

  // PUT
  approveSemesterRegistration(semesterRegistration:SemesterRegistration):Observable<any> {
    console.log("Update semester registration service method");
    let uri:string = "http://localhost:9098/admin/approve/" + semesterRegistration.getStudentId() + "/" + semesterRegistration.getApprovalStatus();
    return this.httpClient.put<any>(uri, {headers:this.headers});
  }

  // DELETE
  deleteSemesterRegistration(studentId:number):Observable<any> {
    console.log("Delete semester registration service method");
    let uri:string = "http://localhost:9098/admin/registration/" + studentId;
    return this.httpClient.delete<any>(uri, {headers:this.headers});
  }
}
