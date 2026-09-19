import { Component, inject } from '@angular/core';
import { Card } from 'primeng/card';
import { InputText } from 'primeng/inputtext';
import { Button } from 'primeng/button';
import { AuthService } from '../auth-service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Password } from 'primeng/password';

@Component({
  selector: 'app-login-form',
  imports: [Card, InputText, Button, ReactiveFormsModule, Password],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css',
})
export class LoginForm {
  router = inject(Router);
  authService = inject(AuthService);

  form = new FormGroup({
    email: new FormControl('', {
      validators: [Validators.required],
      nonNullable: true,
    }),
    password: new FormControl('', {
      validators: [Validators.required, Validators.minLength(6)],
      nonNullable: true,
    }),
  });

  login() {
    this.form.markAsTouched();
    if (this.form.invalid) return;

    const { email, password } = this.form.getRawValue();
    this.authService.login(email, password).subscribe(() => {
      void this.router.navigate(['/']);
    });
  }
}
