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
  key: string;
  value: string;
  employees: Employee[];
  public show = false;
  public buttonName: any = 'Show';

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
    this.id = this.route.snapshot.params.id;
    this.loadEmployeeDetails(this.id);
  }

  loadEmployeeDetails(id: number) {
    this.employee = new Employee();
    this.employeeService.getEmployee(id)
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

  btnCancel() {
    console.log('cancel...');
    this.router.navigate(['/details']);
  }

  selectChangeHandler(event: any) {
    // update the ui
    this.key = event.target.value;
  }

  searchEmployees() {
    const param = this.key + this.value;
    this.employeeService.searchEmployees(param).subscribe(res => {
      this.employees = res;
    }, error => console.log(error));
  }
  /** Filtering data */

  /** toggle */
  toggle() {

    this.show = !this.show;

    // CHANGE THE NAME OF THE BUTTON.
    if (this.show) {
      this.buttonName = 'Hide';
    } else {
      this.buttonName = 'Show';
    }
  }
  /** toggle */
  details(id: number) {
    this.show = !this.show;
    // CHANGE THE NAME OF THE BUTTON.
    if (this.show) {
      this.buttonName = 'Hide';
    } else {
      this.loadEmployeeDetails(id);
      this.buttonName = 'Show';
    }
  }

}
