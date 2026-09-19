import { Routes } from '@angular/router';

export const DessertPaths = {
  root: 'dessert',
};

export const DESSERT_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () => import('./dessert-list/dessert-list').then((c) => c.DessertList),
  },
];
