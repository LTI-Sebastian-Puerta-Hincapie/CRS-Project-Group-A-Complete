import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {

    // cros implementation
  headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin',"*");

  constructor(private httpClient:HttpClient) { }

  // Service methods
  // GET

  // POST

  // PUT

  // DELETE
}
