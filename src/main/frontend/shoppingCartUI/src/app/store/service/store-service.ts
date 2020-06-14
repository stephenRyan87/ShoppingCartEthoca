import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CustomerOrder} from "../models/CustomerOrder";

@Injectable()
export class StoreService {

  private productsUrl = "/cart/products";
  private ordersUrl = "/cart/orders";

  constructor(private http: HttpClient) {}

  getAllProducts() {
    return this.http.get(this.productsUrl);
  }

  saveOrder(order: CustomerOrder) {
    return this.http.post(this.ordersUrl, order);
  }
}
