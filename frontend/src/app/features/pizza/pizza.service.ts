import { inject, Injectable } from '@angular/core';
import Pizza from './models/pizza.model';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PizzaService {
  baseURL = environment.apiUrl + '/pizzas';
  httpClient = inject(HttpClient);

  getPizzas(): Observable<Pizza[]> {
    return this.httpClient.get<Pizza[]>(this.baseURL);
  }
}
