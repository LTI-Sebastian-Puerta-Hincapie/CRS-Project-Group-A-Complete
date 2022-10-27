import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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
    login(username:string, password:string, role:string):Observable<any> {
      console.log("Login service method");

      let uri:string = "http://localhost:8091/user/" + username + "/" + password + "/" + role; 
      let response = this.httpClient.get(uri, {headers:this.headers});
      return response;
    }
}
