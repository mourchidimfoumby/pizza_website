import { Component, inject, signal } from '@angular/core';
import { DrinkService } from '../drink.service';
import { RequestState, RequestStatus } from '../../../shared/domain/entity/request-state.model';
import { catchError, map, Observable, of } from 'rxjs';
import { ProductList } from '../../../shared/ui/product-list/product-list';
import { Product } from '../../../shared/domain/entity/product.model';
import Drink from '../drink.model';

@Component({
  selector: 'app-drink-list',
  imports: [ProductList],
  templateUrl: './drink-list.html',
  styleUrl: './drink-list.css',
})
export class DrinkList {
  drinkService = inject(DrinkService);
  productState = signal<RequestState<Product[]>>({ status: RequestStatus.LOADING });

  constructor() {
    this.loadDrinks();
  }

  loadDrinks() {
    this.drinkService
      .getDrinks()
      .pipe(
        map((drinks): RequestState<Product[]> => ({
          status: RequestStatus.SUCCESS,
          data: drinks.map((drink: Drink): Product => ({
            id: drink.id,
            imageUrl: drink.imageUrl,
            name: `${drink.name} (${drink.volume.toFixed(2)} L)`,
            price: drink.price,
            type: 'drink',
          })),
        })),
        catchError((): Observable<RequestState<Product[]>> =>
          of({
            status: RequestStatus.ERROR,
            message: 'Erreur lors du chargement des boissons.',
          }),
        ),
      )
      .subscribe((state) => this.productState.set(state));
  }
}
