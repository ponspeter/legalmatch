import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent,  AppDateAdapter, APP_DATE_FORMATS } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule,
  MatNativeDateModule,
  MatFormFieldModule,
  NativeDateAdapter,
  MAT_DATE_FORMATS,
  DateAdapter,
  MatInputModule } from '@angular/material';
import { CreateEmployeeComponent } from './view/employee/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './view/employee/employee-details/employee-details.component';
import { EmployeeListComponent } from './view/employee/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './view/employee/update-employee/update-employee.component';
import { LoginComponent } from './view/login/login-form.component';
import { HttpInterceptorService } from './service/httpInterceptor.service';



@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatDatepickerModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: DateAdapter, useClass: AppDateAdapter
    },
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

