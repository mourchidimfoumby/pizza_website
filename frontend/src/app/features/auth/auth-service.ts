import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  baseUrl = environment.apiUrl + '/auth';
  httpClient = inject(HttpClient);

  login(email: string, password: string) {
    return this.httpClient.post(this.baseUrl + 'login', {email, password})
  }
}
