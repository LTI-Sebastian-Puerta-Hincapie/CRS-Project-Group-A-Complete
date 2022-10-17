import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { CourseComponentComponent } from './components/course-component/course-component.component';
import { UpdatePasswordComponentComponent } from './components/update-password-component/update-password-component.component';
import { PaymentComponentComponent } from './components/payment-component/payment-component.component';
import { StudentViewComponentComponent } from './components/student-view-component/student-view-component.component';
import { SemesterRegistrationComponentComponent } from './components/semester-registration-component/semester-registration-component.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    CourseComponentComponent,
    UpdatePasswordComponentComponent,
    PaymentComponentComponent,
    StudentViewComponentComponent,
    SemesterRegistrationComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
