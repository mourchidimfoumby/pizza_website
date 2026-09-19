import { inject, Injectable, signal } from '@angular/core';
import { CartItemData } from '../../domain/entity/cart-item-data.model';
import { StorageService } from '../../domain/storage.service';
import { AppStorageKey } from '../../../app-storage-key.model';
import { CartData } from '../../domain/entity/cart-data.model';

const defaultValue: CartData = {
  items: [],
  totalPrice: 0
}

@Injectable({
  providedIn: 'root',
})
export class CartService {
  storageService = inject(StorageService);
  cartData = signal(this.storageService.get<CartData>(AppStorageKey.cart) ?? defaultValue);

  addItem(cartItemData: CartItemData) {
    const cartData = this.storageService.get<CartData>(AppStorageKey.cart) ?? defaultValue;
    const currentCartItemData = cartData.items.find((item) => item.id === cartItemData.id);

    if (currentCartItemData) {
      currentCartItemData.quantity += 1;
    } else {
      cartData.items.push(cartItemData);
    }

    cartData.totalPrice += cartItemData.price * cartItemData.quantity;

    this.storageService.save(AppStorageKey.cart, cartData);
    this.cartData.set(cartData);
  }

  removeItem(cartItemData: CartItemData) {
    const cartData = this.storageService.get<CartData>(AppStorageKey.cart) ?? defaultValue;

    cartData.items = cartData.items.filter(item => item.id !== cartItemData.id);
    cartData.totalPrice -= cartItemData.price;

    this.storageService.save(AppStorageKey.cart, cartData);
    this.cartData.set(cartData);
  }
}
