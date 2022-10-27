import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  _username:string = "";
  _password:string = "";
  _role:string = "";

  user:User = new User(0, "", "", 0);
  getData:any;

  constructor(private router: Router, private _httpService:LoginServiceService) {}

  ngOnInit() {}

  login(username:string, password:string, role:string) {

    console.log("Login component method");
    console.log(this._role.toLowerCase());
    if (this._role.toLowerCase() == "admin") {
      this._httpService.login(username, password, role).subscribe(data => {
        this.router.navigate(['admin', { admin: data }]);
        console.log(data);
        this.getData = data;
      })
    }
    else if (this._role.toLowerCase() == "professor") {
      this._httpService.login(username, password, role).subscribe((res:any[]) => {
        this.router.navigate(['professor', { professor: res }]);
        console.log(res);
        this.getData = res;
      })
    }
    else if(this._role.toLowerCase() == "student")  {
      this._httpService.login(username, password, role).subscribe((res:any[]) => {
        this.router.navigate(['student', { student: res }]);
        console.log(res);
        this.getData = res;
      })
    }
    else {
      console.log("user role does not exist");
    }
  }
}
