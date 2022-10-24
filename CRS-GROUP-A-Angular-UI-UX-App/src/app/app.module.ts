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
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { StudentComponentComponent } from './components/student-component/student-component.component';
import { AdminComponentComponent } from './components/admin-component/admin-component.component';
import { ProfessorComponentComponent } from './components/professor-component/professor-component.component';
import { ProfessorProfileComponent } from './components/professor-profile/professor-profile.component';
import { ProfessorEnrolledCoursesComponent } from './components/professor-enrolled-courses/professor-enrolled-courses.component';
import { ProfessorOfferedCoursesComponent } from './components/professor-offered-courses/professor-offered-courses.component';
import { ProfessorAddGradesComponent } from './components/professor-add-grades/professor-add-grades.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    CourseComponentComponent,
    UpdatePasswordComponentComponent,
    PaymentComponentComponent,
    StudentViewComponentComponent,
    SemesterRegistrationComponentComponent,
    StudentComponentComponent,
    AdminComponentComponent,
    ProfessorComponentComponent,
    ProfessorProfileComponent,
    ProfessorEnrolledCoursesComponent,
    ProfessorOfferedCoursesComponent,
    ProfessorAddGradesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
