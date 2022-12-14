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

  generateStudentFee(studentId:number):Observable<any> {
    console.log("Generate student fee service method");
    // let uri:string = "http://localhost:7005/registeredcourses/create";
    let uri:string = "http://localhost:8092/student/" + studentId + "/generatefee";
    return this.httpClient.post<any>(uri, {headers:this.headers});
  }

  // PUT
  registerCourse(course:RegisteredCourse):Observable<any> {
    console.log("register course service method");
    // let uri:string = "http://localhost:7005/registeredcourses/update/" + id;
    let uri:string = "http://localhost:8092/student/registercourse";
    return this.httpClient.put<any>(uri, course);
  }

  unRegisterCourse(course:RegisteredCourse):Observable<any> {
    console.log("unegister course service method");
    // let uri:string = "http://localhost:7005/registeredcourses/update/" + id;
    let uri:string = "http://localhost:8092/student/unregistercourse";
    return this.httpClient.put<any>(uri, course);
  }

  // DELETE
  deleteRegisteredCourse(course:RegisteredCourse):Observable<any> {
    console.log("Delete registered courses service method");
    // let uri:string = "http://localhost:7005/registeredcourses/delete/" + id;
    let uri:string = "http://localhost:8092/student/dropcourse";
    return this.httpClient.delete<any>(uri, {body:course});
  }
}
