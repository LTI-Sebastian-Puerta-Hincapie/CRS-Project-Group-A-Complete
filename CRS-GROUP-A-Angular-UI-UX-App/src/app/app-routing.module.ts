import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponentComponent } from './components/admin-component/admin-component.component';
import { CourseComponentComponent } from './components/course-component/course-component.component';
import { GenerateReportCardComponentComponent } from './components/generate-report-card-component/generate-report-card-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { PaymentComponentComponent } from './components/payment-component/payment-component.component';
import { ProfessorComponentComponent } from './components/professor-component/professor-component.component';
import { SemesterRegistrationComponentComponent } from './components/semester-registration-component/semester-registration-component.component';
import { StudentComponentComponent } from './components/student-component/student-component.component';
import { StudentViewComponentComponent } from './components/student-view-component/student-view-component.component';
import { UpdateCoursesComponentComponent } from './components/update-courses-component/update-courses-component.component';
import { UpdatePasswordComponentComponent } from './components/update-password-component/update-password-component.component';
import { UpdateProfessorsComponentComponent } from './components/update-professors-component/update-professors-component.component';
import { ViewCourseAvailabilityComponentComponent } from './components/view-course-availability-component/view-course-availability-component.component';

const routes: Routes = [
  {path:'login', component:LoginComponentComponent},
  {path:'updatepassword', component:UpdatePasswordComponentComponent},
  {path:'semesterregistration', component:SemesterRegistrationComponentComponent},
  {path:'courses', component: CourseComponentComponent},
  {path:'payment', component: PaymentComponentComponent},
  {path:'studentview', component: StudentViewComponentComponent},
  {path:'admin', component: AdminComponentComponent},
  {path:'student', component: StudentComponentComponent},
  {path:'professor', component: ProfessorComponentComponent},
  {path:'updateprofessors', component: UpdateProfessorsComponentComponent},
  {path:'updatecourses', component: UpdateCoursesComponentComponent},
  {path:'viewcourseavailability', component: ViewCourseAvailabilityComponentComponent},
  {path:'generatereportcard', component: GenerateReportCardComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
