import { Routes } from '@angular/router';

export const AuthPaths = {
  root: 'auth',
  login: () => [AuthPaths.root, 'login']
}

export const AUTH_ROUTES: Routes = [
  {
    path: 'login',
    loadComponent: () => import('./login-form/login-form')
      .then(c => c.LoginForm)
  }
];

