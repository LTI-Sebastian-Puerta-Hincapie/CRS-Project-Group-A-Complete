import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponentComponent } from './components/course-component/course-component.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { PaymentComponentComponent } from './components/payment-component/payment-component.component';
import { SemesterRegistrationComponentComponent } from './components/semester-registration-component/semester-registration-component.component';
import { StudentViewComponentComponent } from './components/student-view-component/student-view-component.component';
import { UpdatePasswordComponentComponent } from './components/update-password-component/update-password-component.component';

const routes: Routes = [
  {path:'login', component:LoginComponentComponent},
  {path:'updatepassword', component:UpdatePasswordComponentComponent},
  {path:'semesterregistration', component:SemesterRegistrationComponentComponent},
  {path:'courses', component: CourseComponentComponent},
  {path:'payment', component: PaymentComponentComponent},
  {path:'studentview', component: StudentViewComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
