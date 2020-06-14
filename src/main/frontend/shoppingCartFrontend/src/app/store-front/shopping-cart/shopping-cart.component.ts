import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CustomerOrder} from "../models/CustomerOrder";
import {Subscription} from "rxjs";
import {StoreFrontService} from "../service/storeFrontService";
import {OrderProduct} from "../models/OrderProduct";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderFinished: boolean;
  orders: CustomerOrder;
  total: number;
  sub: Subscription;

  @Output() onOrderFinished: EventEmitter<boolean>;

  constructor(private storeFrontService: StoreFrontService) {
    this.total = 0;
    this.orderFinished = false;
    this.onOrderFinished = new EventEmitter<boolean>();
  }

  ngOnInit() {
    this.orders = new CustomerOrder();
    this.loadCart();
    this.loadTotal();
  }

  loadTotal() {
    this.sub = this.storeFrontService.OrdersChanged.subscribe(() => {
      this.total = this.calculateTotal(this.orders.orderProducts);
    });
  }

  loadCart() {
    this.sub = this.storeFrontService.ProductOrderChanged.subscribe(() => {
      let productOrder = this.storeFrontService.SelectedProductOrder;
      if (productOrder) {
        this.orders.orderProducts.push(new OrderProduct(
          productOrder.name, productOrder.price, productOrder.quantity));
      }
      this.storeFrontService.ProductOrders = this.orders;
      this.orders = this.storeFrontService.ProductOrders;
      this.total = this.calculateTotal(this.orders.orderProducts);
    });
  }

  private calculateTotal(products: OrderProduct[]): number {
    let sum = 0;
    products.forEach(value => {
      sum += (value.price * value.quantity);
    });
    return sum;
  }


  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
