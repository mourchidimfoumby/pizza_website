import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Dessert } from './dessert.model';

@Injectable({
  providedIn: 'root',
})
export class DessertService {
  baseURL = environment.apiUrl + '/desserts';
  httpClient = inject(HttpClient);

  getDesserts() {
    return this.httpClient.get<Dessert[]>(this.baseURL);
  }
}
