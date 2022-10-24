import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponentComponent } from './components/admin-component/admin-component.component';
import { CourseComponentComponent } from './components/course-component/course-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { PaymentComponentComponent } from './components/payment-component/payment-component.component';
import { ProfessorAddGradesComponent } from './components/professor-add-grades/professor-add-grades.component';
import { ProfessorComponentComponent } from './components/professor-component/professor-component.component';
import { ProfessorEnrolledCoursesComponent } from './components/professor-enrolled-courses/professor-enrolled-courses.component';
import { ProfessorOfferedCoursesComponent } from './components/professor-offered-courses/professor-offered-courses.component';
import { ProfessorProfileComponent } from './components/professor-profile/professor-profile.component';
import { SemesterRegistrationComponentComponent } from './components/semester-registration-component/semester-registration-component.component';
import { StudentComponentComponent } from './components/student-component/student-component.component';
import { StudentViewComponentComponent } from './components/student-view-component/student-view-component.component';
import { UpdatePasswordComponentComponent } from './components/update-password-component/update-password-component.component';

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
  {path:'profile', component: ProfessorProfileComponent},
  {path:'enrolledcourses', component: ProfessorEnrolledCoursesComponent},
  {path:'offeredcourses', component: ProfessorOfferedCoursesComponent},
  {path:'addGrades', component: ProfessorAddGradesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
