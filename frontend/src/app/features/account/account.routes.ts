import { Routes } from '@angular/router';

export const AccountPaths = {
  root: 'account'
}

export const ACCOUNT_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () => import('./account-info/account-info')
      .then(c => c.AccountInfo)
  }
];

