import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponentComponent } from './components/student-component/student-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { CourseComponentComponent } from './components/course-component/course-component.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponentComponent,
    LoginComponentComponent,
    CourseComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
