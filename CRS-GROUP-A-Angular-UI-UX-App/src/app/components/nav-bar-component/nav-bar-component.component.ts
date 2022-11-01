import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-nav-bar-component',
  templateUrl: './nav-bar-component.component.html',
  styleUrls: ['./nav-bar-component.component.css']
})
export class NavBarComponentComponent implements OnInit {           

  constructor(private loginService:LoginServiceService, public router:Router) { }

  ngOnInit() {}

  checkUrl() {

    let url = this.router.url;
    let visible = true;
    if(url.includes("/admin")) {
      visible = false;
    }
    else if(url.includes("/student")) {
      visible = false;
    }
    else if(url.includes("/professor")){
      visible = false;
    }
    return visible;
  }

  isLoggedIn() {

    let url = this.router.url;
    let visible = false;

    if(url.includes("/admin")) {
      visible = true;
    }
    else if(url.includes("/student")){
      visible = true;
    }
    else if(url.includes("/professor")){
      visible = true;
    }
    return visible;
  }

  logOut() {

        // Remove saved data from sessionStorage
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("password");
        sessionStorage.removeItem("role");
        sessionStorage.removeItem("userId");

        // Remove all saved data from sessionStorage
        sessionStorage.clear();
  }
}
