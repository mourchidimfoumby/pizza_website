import { Component, inject } from '@angular/core';
import { Button } from 'primeng/button';
import { NgOptimizedImage } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AppPaths } from '../app.routes';
import { PizzaPaths } from '../features/pizza/pizza.routes';
import { DrinkPaths } from '../features/drink/drink.routes';
import { AuthPaths } from '../features/auth/auth.routes';
import { UserService } from '../shared/domain/user.service';
import { AccountPaths } from '../features/account/account.routes';
import { ThemeService } from '../theme.service';
import { DessertPaths } from '../features/dessert/dessert.routes';

@Component({
  selector: 'app-navbar',
  imports: [Button, NgOptimizedImage, RouterLink],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {
  userService = inject(UserService);
  user = this.userService.getUser();
  themeService = inject(ThemeService);

  toggleDarkMode() {
    this.themeService.toggle();
  }

  protected readonly AppPaths = AppPaths;
  protected readonly PizzaPaths = PizzaPaths;
  protected readonly DrinkPaths = DrinkPaths;
  protected readonly AuthPaths = AuthPaths;
  protected readonly AccountPaths = AccountPaths;
  protected readonly DessertPaths = DessertPaths;
}
