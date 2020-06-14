import { Component, OnInit } from '@angular/core';
import {CustomerOrder} from "../models/CustomerOrder";
import {Subscription} from "rxjs";
import {Product} from "../models/Product";
import {OrderProduct} from "../models/OrderProduct";
import {StoreFrontService} from "../service/storeFrontService";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productOrders: OrderProduct[] = [];
  products: Product[] = [];
  selectedProductOrder: OrderProduct;
  private shoppingCartOrders: CustomerOrder;
  sub: Subscription;
  productSelected: boolean = false;

  constructor(private storeFrontService: StoreFrontService) {}

  ngOnInit() {
    this.productOrders = [];
    this.loadProducts();
    this.loadOrders();
  }

  addToCart(order: OrderProduct) {
    this.storeFrontService.SelectedProductOrder = order;
    this.selectedProductOrder = this.storeFrontService.SelectedProductOrder;
    this.productSelected = true;
  }

  loadProducts() {
    this.storeFrontService.getAllProducts()
      .subscribe(
        (products: any[]) => {
          this.products = products;
          this.products.forEach(product => {
            this.productOrders.push(new OrderProduct(product.name, 0, 0));
          })
        },
        (error) => console.log(error)
      );
  }

  loadOrders() {
    this.sub = this.storeFrontService.OrdersChanged.subscribe(() => {
      this.shoppingCartOrders = this.storeFrontService.ProductOrders;
    });
  }

  reset() {
    this.productOrders = [];
    this.loadProducts();
    this.storeFrontService.ProductOrders.orderProducts = [];
    this.loadOrders();
    this.productSelected = false;
  }

}
