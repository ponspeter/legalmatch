import { Component } from '@angular/core';
import { Employee } from '../../../model/employee';
import { Router } from '@angular/router';
import { EmployeeService } from '../../../service/employee.service';
import { PersonalInformation } from 'src/app/model/personalInformation';
import { Contacts } from 'src/app/model/contact';
import { Addresses } from 'src/app/model/Address';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent   {

  employee: Employee = new Employee();
  personal: PersonalInformation = new PersonalInformation();
  saveContacts: Contacts[] = [];
  primaryContact: Contacts = new Contacts();
  secondaryContact: Contacts = new Contacts();
  saveAddresses: Addresses[] = [];
  primaryAddress: Addresses = new Addresses();
  secondaryAddress: Addresses = new Addresses();

  submitted = false;
  constructor(private employeeService: EmployeeService,
              private router: Router,
              ) { }


  /*newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }*/

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
