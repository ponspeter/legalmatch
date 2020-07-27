import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee';
import { Router } from '@angular/router';
import { EmployeeService } from '../../../service/employee.service';
import { PersonalInformation } from 'src/app/model/personalInformation';
import { Contact } from 'src/app/model/contact';
import { Address } from 'src/app/model/address';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  employee: Employee = new Employee();
  personal: PersonalInformation = new PersonalInformation();
  saveContacts: Contact[] = [];
  primaryContact: Contact = new Contact();
  secondaryContact: Contact = new Contact();
  saveAddresses: Address[] = [];
  primaryAddress: Address = new Address();
  secondaryAddress: Address = new Address();
  isLoggedin = false;
  loggedinUser = '';

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private formBuilder: FormBuilder,
              private loginService: LoginService
  ) { }

  ngOnInit() {
    this.isLoggedin = this.loginService.isUserLoggedin();
    this.loggedinUser = this.loginService.getLoggedinUser();
    if (!this.isLoggedin) {
      this.router.navigateByUrl('login');
    }


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
  }

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }
  }

  save() {
    this.employeeService.createEmployee(this.employee)
      .subscribe(data => {
        this.gotoList();
      }, error => console.log(error));
  }

  gotoList() {
    console.log('gotoList...');
    this.router.navigate(['/employees']);
  }

  btnCancel() {
    console.log('cancel...');
    this.router.navigate(['/employees']);
  }

  btnSubmit() {
    console.log('submit...');
    this.primaryContact.isPrimary = true;
    this.secondaryContact.isPrimary = false;
    this.primaryAddress.isPrimary = true;
    this.secondaryAddress.isPrimary = false;
    this.employee.status = 'ACTIVE';
    this.saveAddresses.push(this.primaryAddress);
    this.saveAddresses.push(this.secondaryAddress);
    this.saveContacts.push(this.primaryContact);
    this.saveContacts.push(this.secondaryContact);
    this.personal.contacts = this.saveContacts;
    this.personal.addresses = this.saveAddresses;
    this.employee.personalInformation = this.personal;
    console.log(this.employee);
    this.save();
  }
}
