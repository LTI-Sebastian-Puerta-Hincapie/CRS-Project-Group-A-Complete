import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  // cros implementation
  headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient:HttpClient) { }

  // SERVICE METHODS
  //GET
  getStudent(studentId:number):Observable<any> {
    console.log("Get student method");
    let uri:string = "http://localhost:8092/student/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getStudentCourses(studentId:number):Observable<any> {
    console.log("Get student method");
    let uri:string = "http://localhost:8092/student/" + studentId + "/courses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getStudentRegisteredCourses(studentId:number):Observable<any> {
    console.log("Get student method");
    let uri:string = "http://localhost:8092/student/" + studentId + "/registeredcourses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getStudentGrades(studentId:number):Observable<any> {
    console.log("Get student method");
    let uri:string = "http://localhost:8092/student/" + studentId + "/viewgrades"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  //POST

  //PUT

  //DELETE


}
