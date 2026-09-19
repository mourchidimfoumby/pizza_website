import { Routes } from '@angular/router';
import { PizzaPaths } from './features/pizza/pizza.routes';
import { DrinkPaths } from './features/drink/drink.routes';
import { AccountPaths } from './features/account/account.routes';
import { AuthPaths } from './features/auth/auth.routes';
import { DessertPaths } from './features/dessert/dessert.routes';

export const AppPaths = {
  root: PizzaPaths.root,
  cart: 'cart'
}

export const routes: Routes = [
  {
    path: '',
    redirectTo: AppPaths.root,
    pathMatch: 'full'
  },
  {
    path: PizzaPaths.root,
    loadChildren: () =>
      import('./features/pizza/pizza.routes').then(r => r.PIZZA_ROUTES)
  },
  {
    path: DrinkPaths.root,
    loadChildren: () =>
      import('./features/drink/drink.routes').then(r => r.DRINK_ROUTES)
  },
  {
    path: DessertPaths.root,
    loadChildren: () =>
      import('./features/dessert/dessert.routes').then(r => r.DESSERT_ROUTES)
  },
  {
    path: AuthPaths.root,
    loadChildren: () =>
      import('./features/auth/auth.routes').then(r => r.AUTH_ROUTES)
  },
  {
    path: AccountPaths.root,
    loadChildren: () =>
      import('./features/account/account.routes').then(r => r.ACCOUNT_ROUTES)
  },
  {
    path: '**',
    redirectTo: ''
  }
];
