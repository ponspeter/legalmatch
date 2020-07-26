import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './view/employee/employee-list/employee-list.component';
import { CreateEmployeeComponent } from './view/employee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './view/employee/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './view/employee/employee-details/employee-details.component';
import { LoginComponent } from './view/login/login-form.component';





const routes: Routes = [
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
