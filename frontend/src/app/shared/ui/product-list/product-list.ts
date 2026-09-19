import { Component, inject, input } from '@angular/core';
import { Cart } from '../cart/cart/cart';
import { ProductCard } from '../product-card/product-card';
import { CartService } from '../cart/cart.service';
import { RequestState, RequestStatus } from '../../domain/entity/request-state.model';
import { Product } from '../../domain/entity/product.model';
import { RouterLink } from '@angular/router';
import { AppPaths } from '../../../app.routes';
import { Badge } from 'primeng/badge';
import { ButtonDirective } from 'primeng/button';

@Component({
  selector: 'app-product-list',
  imports: [Cart, ProductCard, RouterLink, Badge, ButtonDirective],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css',
})
export class ProductList {
  cartService = inject(CartService);
  productState = input.required<RequestState<Product[]>>();

  addToCart(product: Product) {
    this.cartService.addItem({
      id: product.id,
      name: product.name,
      type: product.type,
      price: product.price,
      quantity: 1
    });
  }

  protected readonly RequestStatus = RequestStatus;
  protected readonly AppPaths = AppPaths;
}
