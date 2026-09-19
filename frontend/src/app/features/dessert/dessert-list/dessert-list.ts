import { Component, inject, signal } from '@angular/core';
import { DessertService } from '../dessert.service';
import { RequestState, RequestStatus } from '../../../shared/domain/entity/request-state.model';
import { Dessert } from '../dessert.model';
import { catchError, map, Observable, of } from 'rxjs';
import { ProductList } from '../../../shared/ui/product-list/product-list';
import { Product } from '../../../shared/domain/entity/product.model';

@Component({
  selector: 'app-dessert-list',
  imports: [ProductList],
  templateUrl: './dessert-list.html',
  styleUrl: './dessert-list.css',
})
export class DessertList {
  dessertService = inject(DessertService);
  productState = signal<RequestState<Product[]>>({ status: RequestStatus.LOADING });

  constructor() {
    this.loadDesserts();
  }

  loadDesserts() {
    this.dessertService
      .getDesserts()
      .pipe(
        map((desserts): RequestState<Product[]> => ({
          status: RequestStatus.SUCCESS,
          data: desserts.map((dessert: Dessert): Product => ({
            id: dessert.id,
            imageUrl: dessert.imageUrl,
            name: dessert.name,
            price: dessert.price,
            type: 'dessert',
          })),
        })),
        catchError((): Observable<RequestState<Product[]>> =>
          of({
            status: RequestStatus.ERROR,
            message: 'Erreur lors du chargement des desserts.',
          }),
        ),
      )
      .subscribe((state) => this.productState.set(state));
  }
}
