import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../../service/login.service';
import { User } from 'src/app/model/user';


@Component({ selector: 'app-login',
templateUrl: 'login-form.component.html' })

export class LoginComponent implements OnInit {

  user: User = new User();

    constructor(private http: HttpClient,
                private router: Router,
                private loginService: LoginService ) { }

    ngOnInit() {
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
