import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee';
import { Contacts } from '../../../model/contact';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../../service/employee.service';
import { Addresses } from '../../../model/Address';
import { PersonalInformation } from 'src/app/model/personalInformation';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  employee: Employee;
  personal: PersonalInformation;
  primaryContact: Contacts;
  secondaryContact: Contacts;
  primaryAddress: Addresses;
  secondaryAddress: Addresses;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployee(this.id)
      .subscribe(res => {
        this.employee = res.data;
        this.personal = this.employee.personalInformation;
        this.employee.personalInformation.contacts.forEach((element) => {
          if (element.isPrimary === true) {
            this.primaryContact = element;
          } else {
            this.secondaryContact = element;
          }
        });

        this.employee.personalInformation.addresses.forEach((element) => {
          if (element.isPrimary === true) {
            this.primaryAddress = element;
          } else {
            this.secondaryAddress = element;
          }
        });

      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.id, this.employee)
      .subscribe(data => {
        this.gotoList();
      }
        , error => console.log(error));
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

  btnSave() {
      this.updateEmployee();
  }

  btnCancel() {
    console.log('cancel...');
    this.router.navigate(['/employees']);
  }
}
