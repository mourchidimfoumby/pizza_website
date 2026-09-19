import { Component, effect, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './navbar/navbar';
import { ThemeService } from './theme.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  themeService = inject(ThemeService);

  constructor() {
    effect(() => {
      this.initDarkMode()
    });
  }

  private initDarkMode() {
    document.documentElement.classList.toggle('app-dark', this.themeService.isDark());
  }
}
