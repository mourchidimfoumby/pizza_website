import { Component, inject, signal } from '@angular/core';
import { PizzaService } from '../pizza.service';
import Pizza from '../models/pizza.model';
import { RequestState, RequestStatus } from '../../../shared/domain/entity/request-state.model';
import { catchError, map, Observable, of } from 'rxjs';
import { ProductList } from '../../../shared/ui/product-list/product-list';
import { Product } from '../../../shared/domain/entity/product.model';

@Component({
  selector: 'app-pizza-list',
  imports: [ProductList],
  templateUrl: './pizza-list.html',
  styleUrl: './pizza-list.css',
})
export class PizzaList {
  pizzaService = inject(PizzaService);
  productState = signal<RequestState<Product[]>>({ status: RequestStatus.LOADING });

  constructor() {
    this.loadPizzas();
  }

  loadPizzas() {
    this.pizzaService
      .getPizzas()
      .pipe(
        map((pizzas): RequestState<Product[]> => ({
          status: RequestStatus.SUCCESS,
          data: pizzas.map((pizza: Pizza): Product => ({
            id: pizza.id,
            imageUrl: pizza.imageUrl,
            name: pizza.name,
            description: this.getIngredientNames(pizza),
            price: pizza.price,
            type: 'pizza',
          })),
        })),
        catchError((): Observable<RequestState<Product[]>> =>
          of({
            status: RequestStatus.ERROR,
            message: 'Erreur lors du chargement des pizzas.',
          }),
        ),
      )
      .subscribe((state) => this.productState.set(state));
  }

  getIngredientNames(pizza: Pizza): string {
    return pizza.ingredients.map((i) => i.name).join(', ');
  }
}
