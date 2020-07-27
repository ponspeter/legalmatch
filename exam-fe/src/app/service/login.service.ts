import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
    private baseUrl = 'http://localhost:9090/api/v1/auth';

    SESSION_KEY = 'auth_user';

    public username: string;
    public password: string;
    public user: any;

    constructor(private http: HttpClient) { }

    authenticate(username: string, password: string) {
        return this.http.get(this.baseUrl, {
          headers: { authorization: this.createBasicAuthToken(username, password) }})
          .pipe(map((res) => {
            this.username = username;
            this.password = password;
            this.user = res;
            this.registerSuccessfulLogin(username, password);
        }));
    }

    createBasicAuthToken(username: string, password: string) {
        return 'Basic ' + window.btoa(username + ':' + password);
    }

    registerSuccessfulLogin(username, password) {
        sessionStorage.setItem(this.SESSION_KEY, username);
      }

    logout() {
        sessionStorage.removeItem(this.SESSION_KEY);
        this.username = null;
        this.password = null;
    }

    isUserLoggedin() {
        let user = sessionStorage.getItem(this.SESSION_KEY);
        if (user === null) { return false; }
        return true;
    }

    getLoggedinUser() {
      let user = sessionStorage.getItem(this.SESSION_KEY);
      if (user === null) { return ''; }
      return user;
    }
  }
