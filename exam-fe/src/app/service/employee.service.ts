import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:9090/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.baseUrl + '/' + id);
  }

  createEmployee(employee: Employee): Observable<any> {
    return this.http.post(this.baseUrl, employee);
  }

  updateEmployee(id: number, emp: Employee): Observable<any> {
    return this.http.patch(this.baseUrl + '/' + id, emp);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id, { responseType: 'text' });
  }

  getEmployeesList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }
}
