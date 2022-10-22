import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Professor } from '../models/professor';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {


  // cros implementation
  headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient:HttpClient) { }

  // GET
  generateReportCard(studentId:number):Observable<any> {
    console.log("Generate report card service method");
    let uri:string = "http://localhost:9098/admin/generatereportcard/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  viewStudentCourses(studentId:number):Observable<any> {
    console.log("View student courses service method");
    let uri:string = "http://localhost:9098/admin/viewcourses/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  checkCourseAvailability(studentId:number):Observable<any> {
    console.log("Check course availability service method");
    let uri:string = "http://localhost:9098/admin/checkavailable/" + studentId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  addProfessor(professor:Professor):Observable<any> {
    console.log("Add professor service method");
    let uri:string = "http://localhost:9098/admin/addprofessor";
    return this.httpClient.post<any>(uri, professor);
  }

  addCourse(course:Course):Observable<any> {
    console.log("Add course service method");
    let uri:string = "http://localhost:9098/admin/addcourse";
    return this.httpClient.post<any>(uri, course);
  }

  // PUT
  updateCourse(course:any):Observable<any> {
    console.log("Update course service method");
    let uri:string = "http://localhost:9098/admin/updatecourse/" 
      + course.courseId + "/" + course.courseName + "/" +  course.description;
    return this.httpClient.put<any>(uri, {headers:this.headers});
  }

  updateProfessor(professor:Professor):Observable<any> {
    console.log("Add professor service method");
    let uri:string = "http://localhost:9098/admin/updateprofessor";
    return this.httpClient.put<any>(uri, professor);
  }

  // DELETE
  deleteCourse(courseId:number):Observable<any> {
    console.log("Delete course service method");
    let uri:string = "http://localhost:9098/admin/removecourse/" + courseId;
    return this.httpClient.delete<any>(uri, {headers:this.headers});
  }

  deleteProfessor(professorId:number):Observable<any> {
    console.log("Delete course service method");
    let uri:string = "http://localhost:9098/admin/deleteprofessor/" + professorId;
    return this.httpClient.delete<any>(uri, {headers:this.headers});
  }
}
