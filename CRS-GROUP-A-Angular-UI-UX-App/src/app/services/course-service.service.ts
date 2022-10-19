import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RegisteredCourse } from '../models/registered-course';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

 // cros implementation
 headers = new HttpHeaders()
 .set('Content-Type', 'application/json')
 .set('Access-Control-Allow-Origin',"*");

constructor(private httpClient:HttpClient) { }

  // USER SERVICE METHODS
  // GET 
  getRegisteredCourses():Observable<any> {
    console.log("Get semester registartion servie method");
    let uri:string = "http://localhost:7005/registeredcourses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  createRegisteredCourse(course:RegisteredCourse):Observable<any> {
    console.log("Create registered courses service method");
    let uri:string = "http://localhost:7005/registeredcourses/create";
    return this.httpClient.post<any>(uri, course);
  }

  // PUT
  updateRegisteredCourse(course:RegisteredCourse):Observable<any> {
    console.log("Update registered courses service method");
    let uri:string = "http://localhost:7005/registeredcourses/update/" + course.getStudentId() + "/" + course.getCourseId();
    return this.httpClient.put<any>(uri, course);
  }

  // DELETE
  deleteRegisteredCourse(course:RegisteredCourse):Observable<any> {
    console.log("Delete registered courses service method");
    let uri:string = "http://localhost:7005/registeredcourses/delete/" + course.getStudentId() + "/" + course.getCourseId();
    return this.httpClient.delete<any>(uri, {headers:this.headers});
  }
}
