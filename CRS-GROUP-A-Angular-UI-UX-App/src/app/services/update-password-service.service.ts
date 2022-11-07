import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UpdatePassword } from '../models/update-password';

@Injectable({
  providedIn: 'root'
})
export class UpdatePasswordServiceService {

    // cros implementation
    headers = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin',"*");
  
    constructor(private httpClient:HttpClient) { }

    // SERVICE METHODS
    //PUT
    updatePassword(username:string, currentPassword:string, newPassword:string):Observable<any> {
      console.log("POST update password method");
      let payload = new UpdatePassword(username, currentPassword, newPassword);
      let uri:string = "http://localhost:3001/user/updatepassword"; 
      return this.httpClient.post(uri, payload, {headers:this.headers});
    }
}
