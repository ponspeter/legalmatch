import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee';
import { Contact } from '../../../model/contact';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../../service/employee.service';
import { Address } from '../../../model/address';
import { PersonalInformation } from 'src/app/model/personalInformation';
import { LoginService } from 'src/app/service/login.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  /** FORM VALIDATION */
  registerForm: FormGroup;
  submitted = false;
  /** FORM VALIDATION */
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
              private formBuilder: FormBuilder,
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

  /** FORM VALIDATION */
    this.registerForm = this.formBuilder.group({
    firstName: ['', Validators.required],
    middleName: ['', Validators.required],
    lastName: ['', Validators.required],
    maritalStatus: ['', Validators.required],
    birthDate: ['', Validators.required],
    position: ['', Validators.required],
    dateHired: ['', Validators.required],
    gender: ['', Validators.required],
    phone: ['', Validators.maxLength],
    mobile: ['', Validators.required],
    email: ['', Validators.maxLength],
    houseNumber: ['', Validators.required],
    street: ['', Validators.maxLength],
    town: ['', Validators.required],
    province: ['', Validators.required],
    postalCode: ['', Validators.required]
  });
  /** FORM VALIDATION */
  }

  /** FORM VALIDATION */
  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }
  }
  /** FORM VALIDATION */

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
