import {Injectable} from "@angular/core";
import {OrderProduct} from "../models/OrderProduct";
import {CustomerOrder} from "../models/CustomerOrder";
import {Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class EcommerceService {
  private productsUrl = "/cart/products";
  private ordersUrl = "/cart/orders";

  private orderProduct: OrderProduct;
  private orders: CustomerOrder = new CustomerOrder();

  private productOrderSubject = new Subject();
  private ordersSubject = new Subject();
  private totalSubject = new Subject();

  private total: number;

  ProductOrderChanged = this.productOrderSubject.asObservable();
  OrdersChanged = this.ordersSubject.asObservable();
  TotalChanged = this.totalSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  getAllProducts() {
    return this.http.get(this.productsUrl);
  }

  saveOrder(order: CustomerOrder) {
    return this.http.post(this.ordersUrl, order);
  }

  set SelectedProductOrder(value: OrderProduct) {
    this.orderProduct = value;
    this.productOrderSubject.next();
  }

  get SelectedProductOrder() {
    return this.orderProduct;
  }

  set ProductOrders(value: CustomerOrder) {
    this.orders = value;
    this.ordersSubject.next();
  }

  get ProductOrders() {
    return this.orders;
  }

  get Total() {
    return this.total;
  }

  set Total(value: number) {
    this.total = value;
    this.totalSubject.next();
  }
}
