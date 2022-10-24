import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { CourseCatalog } from '../models/course-catalog';
import { CourseEnrollment } from '../models/course-enrollment';
import { Grade } from '../models/grade';
import { Professor } from '../models/professor';

@Injectable({
  providedIn: 'root'
})
export class ProfessorProfileService {

  // cross implementation
  headers = new HttpHeaders()
              .set('Content-Type', 'application/json')
              .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient: HttpClient) { }

  getProfessorProfileById(id:Number):Observable<Professor>{
    console.log("getting professor by Id");
    let uri:string="http://localhost:9095/professors/"+id;
    return this.httpClient.get<Professor>(uri,{headers:this.headers}).pipe(
      tap((receivedData: Professor) => console.log(receivedData))
  );
  }

  // change return type to array, create a model.ts
  getProfessorCourses(id:Number):Observable<CourseCatalog[]>{
    console.log("getting professor by Id");
    let uri:string="http://localhost:9095/professor/"+id+"/courses";
    return this.httpClient.get<CourseCatalog[]>(uri,{headers:this.headers}).pipe(
      tap((receivedData: CourseCatalog[]) => console.log(receivedData))
  );
  }

    // change return type to array, create a model.ts
  getStudentEnrolledCourses(id:Number):Observable<CourseEnrollment[]>{
    console.log("getting professor by Id");
    let uri:string="http://localhost:9095/professor/enrolled/courses/"+id;
    return this.httpClient.get<CourseEnrollment[]>(uri,{headers:this.headers}).pipe(
      tap((receivedData: CourseEnrollment[]) => console.log(receivedData))
  );
  }

  // POST
  addGrades(studentId:string, grade:Grade):Observable<any> {
    console.log("add grade service method with student Id "+studentId+grade.getCourse().getCourseId()
    +grade.getGrade());
    let uri:string = "http://localhost:9095/professor/addgrades/"+studentId;
    return this.httpClient.post<any>(uri, grade);
  }
}
