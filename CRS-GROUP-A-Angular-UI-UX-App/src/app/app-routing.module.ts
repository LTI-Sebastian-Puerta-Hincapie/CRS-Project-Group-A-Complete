import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponentComponent } from './components/about-component/about-component.component';
import { AddGradesComponentComponent } from './components/add-grades-component/add-grades-component.component';
import { AdminComponentComponent } from './components/admin-component/admin-component.component';
import { CourseComponentComponent } from './components/course-component/course-component.component';
import { GenerateReportCardComponentComponent } from './components/generate-report-card-component/generate-report-card-component.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { PageNotFoundComponentComponent } from './components/page-not-found-component/page-not-found-component.component';
import { PaymentComponentComponent } from './components/payment-component/payment-component.component';
import { ProfessorComponentComponent } from './components/professor-component/professor-component.component';
import { ProfessorViewComponentComponent } from './components/professor-view-component/professor-view-component.component';
import { SemesterRegistrationComponentComponent } from './components/semester-registration-component/semester-registration-component.component';
import { StudentComponentComponent } from './components/student-component/student-component.component';
import { StudentViewComponentComponent } from './components/student-view-component/student-view-component.component';
import { UpdateCoursesComponentComponent } from './components/update-courses-component/update-courses-component.component';
import { UpdatePasswordComponentComponent } from './components/update-password-component/update-password-component.component';
import { UpdateProfessorsComponentComponent } from './components/update-professors-component/update-professors-component.component';
import { ViewCourseAvailabilityComponentComponent } from './components/view-course-availability-component/view-course-availability-component.component';

const routes: Routes = [  

  {path:'', component: HomeComponentComponent},
  {path:'login', component: LoginComponentComponent},
  {path:'updatepassword', component:UpdatePasswordComponentComponent},
  {path:'semesterregistration', component:SemesterRegistrationComponentComponent},
  {path:'about', component:AboutComponentComponent},

  {
    path:'student', component: StudentComponentComponent,
    children: [
      {path:'courses', component: CourseComponentComponent},
      {path:'payment', component: PaymentComponentComponent},
      {path:'studentview', component: StudentViewComponentComponent},
    ]
  },

  {
    path:'admin', component: AdminComponentComponent,
    children: [
      {path:'updateprofessors', component: UpdateProfessorsComponentComponent},
      {path:'updatecourses', component: UpdateCoursesComponentComponent},
      {path:'viewcourseavailability', component: ViewCourseAvailabilityComponentComponent},
      {path:'generatereportcard', component: GenerateReportCardComponentComponent}
    ]
  },

  {
    // path:'professorDashboard', component: ProfessorDashboardComponentComponent,
    path:'professor', component: ProfessorComponentComponent,
    children: [
      {path:'addgrades', component: AddGradesComponentComponent},
      {path:'professorview', component: ProfessorViewComponentComponent}
    ]
  },

  {path:'**', component: PageNotFoundComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
