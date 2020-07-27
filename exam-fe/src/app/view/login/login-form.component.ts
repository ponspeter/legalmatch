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
    this.loginService.authenticate(this.user.username, this.user.password)
      .subscribe(res => {
        this.gotoList(this.loginService.user.data.role, 
          this.loginService.user.data.personalInformation.personalInformationId);
      },
        error => console.log(error));
}

  gotoList(role: string, infoId:number) {
    console.log('gotoList...');
    if (role === 'ROLE_ADMIN') {
      this.router.navigate(['/employees']);
    } else {
      this.router.navigate(['/update/'+infoId]);
    }
    
  }

  btnCancel() {
    console.log('cancel...');
    this.router.navigate(['/']);
  }

  logout() {
    this.loginService.logout();
    this.router.navigateByUrl('login');
  }
}
