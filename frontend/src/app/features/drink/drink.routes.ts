import { Routes } from '@angular/router';

export const DrinkPaths = {
  root: 'drink',
};

export const DRINK_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () => import('./drink-list/drink-list').then((c) => c.DrinkList),
  },
];
