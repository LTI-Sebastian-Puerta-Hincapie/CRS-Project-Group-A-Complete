import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {

   // cros implementation
 headers = new HttpHeaders()
 .set('Content-Type', 'application/json')
 .set('Access-Control-Allow-Origin',"*");


  constructor(private httpClient:HttpClient) { }

  // Service methods

  // GET
  getStudentFee(studentId:number):Observable<any> {
    console.log("Get student fee method");
    let uri:string = "http://localhost:8092/student/" + studentId + "/getfee"; 
    return this.httpClient.get(uri, {headers:this.headers});
  }

  // POST
  // added this portion to the courses component -- may need to move it laer

  // PUT
  payStudentFee(studentId:number, paymentMethod:string):Observable<any> {
    console.log("Pay student fee method");
    let uri:string = "http://localhost:8092/student/" + studentId + "/payfee/" + paymentMethod; 
    return this.httpClient.put(uri, {headers:this.headers});
  }

  // DELETE
}
