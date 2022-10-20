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
  getCourses():Observable<any> {
    console.log("Get courses service method");
    // let uri:string = "http://localhost:7003/courses"; 
    let uri:string = "http://localhost:8092/student/courses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getCourse(courseId:number):Observable<any> {
    console.log("Get course service method");
    let uri:string = "http://localhost:7003/courses/" + courseId; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  getRegisteredCourses():Observable<any> {
    console.log("Get registered courses service method");
    // let uri:string = "http://localhost:7005/registeredcourses"; 
    let uri:string = "http://localhost:8092/student/registeredcourses"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  createRegisteredCourse(course:RegisteredCourse):Observable<any> {
    console.log("Create registered courses service method");
    // let uri:string = "http://localhost:7005/registeredcourses/create";
    let uri:string = "http://localhost:8092/student/addcourse";
    return this.httpClient.post<any>(uri, course);
  }

  // PUT
  updateRegisteredCourse(id:number, course:RegisteredCourse):Observable<any> {
    console.log("Update registered courses service method");
    let uri:string = "http://localhost:7005/registeredcourses/update/" + id;
    return this.httpClient.put<any>(uri, course);
  }

  // DELETE
  deleteRegisteredCourse(id:number):Observable<any> {
    console.log("Delete registered courses service method");
    let uri:string = "http://localhost:7005/registeredcourses/delete/" + id;
    return this.httpClient.delete<any>(uri, {headers:this.headers});
  }
}
