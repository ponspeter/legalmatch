import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../../service/login.service';
import { User } from 'src/app/model/user';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: 'login-form.component.html'
})

export class LoginComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  user: User = new User();

  constructor(private http: HttpClient,
              private router: Router,
              private loginService: LoginService,
              private formBuilder: FormBuilder
             ) { }

  ngOnInit() {
   this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
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

  btnSubmit() {
    console.log(this.user);
    this.loginService.loginUser(this.user)
      .subscribe(res => {
        console.log(res.data);
        this.gotoList();
      },
        error => console.log(error));
}

  gotoList() {
    console.log('gotoList...');
    this.router.navigate(['/employees']);
  }

  btnCancel() {
    console.log('cancel...');
    this.router.navigate(['/']);
  }
}
