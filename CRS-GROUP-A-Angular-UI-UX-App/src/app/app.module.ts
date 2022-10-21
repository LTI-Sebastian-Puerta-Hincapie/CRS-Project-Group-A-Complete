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
import { HeaderComponentComponent } from './components/header-component/header-component.component';
import { FooterComponentComponent } from './components/footer-component/footer-component.component';
import { NavBarComponentComponent } from './components/nav-bar-component/nav-bar-component.component';
import { GenerateReportCardComponentComponent } from './components/generate-report-card-component/generate-report-card-component.component';
import { ViewCourseAvailabilityComponentComponent } from './components/view-course-availability-component/view-course-availability-component.component';
import { UpdateCoursesComponentComponent } from './components/update-courses-component/update-courses-component.component';
import { UpdateProfessorsComponentComponent } from './components/update-professors-component/update-professors-component.component';
import { ProfessorViewComponentComponent } from './components/professor-view-component/professor-view-component.component';
import { AddGradesComponentComponent } from './components/add-grades-component/add-grades-component.component'

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
    HeaderComponentComponent,
    FooterComponentComponent,
    NavBarComponentComponent,
    GenerateReportCardComponentComponent,
    ViewCourseAvailabilityComponentComponent,
    UpdateCoursesComponentComponent,
    UpdateProfessorsComponentComponent,
    ProfessorViewComponentComponent,
    AddGradesComponentComponent
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
