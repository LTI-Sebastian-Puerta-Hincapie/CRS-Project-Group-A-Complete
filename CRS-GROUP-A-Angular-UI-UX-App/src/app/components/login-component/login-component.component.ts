import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  _username:String = "";
  _password:String = "";

  public users:Array<User> = [
    new User(1, "admin", "test", 1),    //admin
    new User(10, "rwu", "welcome", 2),   // professor
    new User(1000, "tparker", "welcome", 3) // student
];

  constructor() { }

  ngOnInit(): void {
  }

  login(username:String, password:String) {

    let user = this.users.find(x => x.getUsername() == username);
    if(user != undefined) {

      console.log("You are logged in");
    }
  }

}
