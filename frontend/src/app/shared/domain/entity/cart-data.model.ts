import { CartItemData } from './cart-item-data.model';

export interface CartData {
  items: CartItemData[];
  totalPrice: number;
}
