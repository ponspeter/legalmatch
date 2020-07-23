import { Employee } from '../../../model/employee';
import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../../../service/employee.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number;
  employee: Employee;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();

    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployee(this.id)
      .subscribe(res => {
        console.log(res);
        this.employee = res.data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['employees']);
  }
}
