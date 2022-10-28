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

    let roleId = 0;
    role = role.toLowerCase()
    switch(role) {
        case "admin": roleId = 1; break;
        case "professor": roleId = 2; break;
        case "student": roleId = 3; break;
        default: roleId = 1;
    }

    if (role == "admin") {
      this._httpService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate([role, { admin: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, role, this.getData[0].Id);
      })
    }
    else if (role == "professor") {
      this._httpService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate([role, { professor: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, role, this.getData[0].Id);
      })
    }
    else if(role == "student")  {
      this._httpService.loginExpress(username, password, roleId).subscribe((res:any[]) => {
        this.router.navigate([role, { student: res }]);
        console.log(res);
        this.getData = res;
        this.userSession(username, password, role, this.getData[0].Id);
      })
    }
    else {
      console.log("user role does not exist");
    }
  }

  userSession(username:string, password:string, role:string, userId:string) {

    // Save data to sessionStorage
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("password", password);
    sessionStorage.setItem("role", role);
    sessionStorage.setItem("userId", userId);
  }
}
