import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

   // cros implementation
   headers = new HttpHeaders()
   .set('Content-Type', 'application/json')
   .set('Access-Control-Allow-Origin',"*");
  
    constructor(private httpClient:HttpClient) { }
  
    // Service methods

    // GET
    loginSpringServer(username:string, password:string, role:string):Observable<any> {
      console.log("Login service method");

      let uri:string = "http://localhost:8091/user/" + username + "/" + password + "/" + role; 
      let response = this.httpClient.get(uri, {headers:this.headers});
      return response;
    }

    loginExpress(username:string, password:string, roleId:number):Observable<any> {
      console.log("Login service method");

      let uri:string = "http://localhost:3001/user/login"; 
      let user = new User(0, username, password, roleId);
      return this.httpClient.post<any>(uri, user);
    }
}

