import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

    constructor(private authService: LoginService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.authService.isUserLoggedin() && req.url.indexOf('basicauth') === -1) {
            const request = req.clone({
                headers: new HttpHeaders({
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${window.btoa(this.authService.username + ":" + this.authService.password)}`
                })
            });
            return next.handle(request);
        }
        return next.handle(req);
    }

}
