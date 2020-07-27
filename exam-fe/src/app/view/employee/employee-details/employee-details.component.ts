import { Employee } from '../../../model/employee';
import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../../../service/employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonalInformation } from 'src/app/model/personalInformation';
import { Address } from 'src/app/model/address';
import { Contact } from 'src/app/model/contact';
import { LoginService } from 'src/app/service/login.service';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  registerForm: FormGroup;
  id: number;
  employee: Employee;
  personal: PersonalInformation;
  primaryContact: Contact;
  secondaryContact: Contact;
  primaryAddress: Address;
  secondaryAddress: Address;
  isLoggedin = false;
  loggedinUser = '';

  constructor(private route: ActivatedRoute,
              private router: Router,
              private loginService: LoginService,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.isLoggedin = this.loginService.isUserLoggedin();
    this.loggedinUser = this.loginService.getLoggedinUser();
    if (!this.isLoggedin) {
      this.router.navigateByUrl('login');
    }

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
}
