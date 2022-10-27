import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Grade } from '../models/grade';

@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {

    // cros implementation
  headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient:HttpClient) { }

  // Service methods
  // GET 
  getProfessor(studentId:number):Observable<any> {
    console.log("Get semester registartion servie method"); 
    let uri:string = "http://localhost:9095/professors/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getCourseEnrollment(courseId:number):Observable<any> {
    console.log("Get course enrollment servie method"); 
    let uri:string = "http://localhost:9095/professor/enrolled/courses/" + courseId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getProfessorCourses(professorId:number):Observable<any> {
    console.log("Get professor courses servie method"); 
    let uri:string = "http://localhost:9095/professor/" + professorId + "/courses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  addGrades(studentId:number, grade:Grade):Observable<any> {
    console.log("Add grades service method");
    let uri:string = "http://localhost:9095/professor/addgrades/" + studentId;
    return this.httpClient.post<any>(uri, grade);
  }

  // PUT

  // DELETE
}
