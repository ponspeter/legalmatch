import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../service/employee.service';
import { Employee } from '../../../model/employee';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  isLoggedin = false;
  loggedinUser = '';

  constructor(private employeeService: EmployeeService,
              private loginService: LoginService,
              private router: Router) {}

  ngOnInit() {
    this.isLoggedin = this.loginService.isUserLoggedin();
    this.loggedinUser = this.loginService.getLoggedinUser();
    if (!this.isLoggedin) {
      this.router.navigateByUrl('login');
    }

    this.reloadData();
  }

  reloadData() {
    this.employeeService.getEmployeesList().subscribe(res => {
       this.employees = res;
    }, error => console.log(error));
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number) {
    this.router.navigate(['update', id]);
  }
}
