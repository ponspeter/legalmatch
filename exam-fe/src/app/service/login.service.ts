import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
    private baseUrl = 'http://localhost:9090/api/v1/login';

    constructor(private http: HttpClient) { }

    loginUser(user: User): Observable<any> {
        return this.http.post(this.baseUrl, user);
      }
  }
