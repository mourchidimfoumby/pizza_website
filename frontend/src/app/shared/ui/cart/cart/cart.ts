import { Component, inject } from '@angular/core';
import { CartItem } from '../cart-item/cart-item';
import { CartItemData } from '../../../domain/entity/cart-item-data.model';
import { ButtonDirective } from 'primeng/button';
import { CartService } from '../cart.service';
import { Divider } from 'primeng/divider';

@Component({
  selector: 'app-cart',
  imports: [CartItem, Divider, ButtonDirective],
  templateUrl: './cart.html',
  styleUrl: './cart.css',
})
export class Cart {
  cartService = inject(CartService);

  onRemoveCartItem(cartItemData: CartItemData) {
    this.cartService.removeItem(cartItemData);
  }
}
