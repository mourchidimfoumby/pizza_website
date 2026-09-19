import { Component, EventEmitter, Input, input, Output } from '@angular/core';
import { Button } from 'primeng/button';
import { Card } from 'primeng/card';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-product-card',
  imports: [Button, Card, NgOptimizedImage],
  templateUrl: './product-card.html',
  styleUrl: './product-card.css',
})
export class ProductCard {
  id = input.required<number>()
  imageUrl = input.required<string>();
  title = input.required<string>();
  content = input<string>();
  price = input.required<number>();

  @Output() added = new EventEmitter<number>();

  onAddClick() {
    this.added.emit(this.id());
  }
}
