import { Routes } from '@angular/router';

export const PizzaPaths = {
  root: 'pizza'
}

export const PIZZA_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () => import('./pizza-list/pizza-list')
      .then(c => c.PizzaList)
  }
];

