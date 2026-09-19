import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Drink from './drink.model';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class DrinkService {
  baseURL = environment.apiUrl + '/drinks';
  httpClient = inject(HttpClient);

  getDrinks() {
    return this.httpClient.get<Drink[]>(this.baseURL);
  }
}
