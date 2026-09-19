import { Component, EventEmitter, input, Output } from '@angular/core';
import { CartItemData } from '../../../domain/entity/cart-item-data.model';
import { Button } from 'primeng/button';

@Component({
  selector: 'app-cart-item',
  imports: [Button],
  templateUrl: './cart-item.html',
  styleUrl: './cart-item.css',
})
export class CartItem {
  cartItemData = input.required<CartItemData>();

  @Output() removed = new EventEmitter<void>();

  onRemoveClick() {
    this.removed.emit();
  }
}
