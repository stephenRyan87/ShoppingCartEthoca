import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoreFrontComponent } from './store-front/store-front.component';
import { ProductsComponent } from './storeFront/products/products.component';
import { OrdersComponent } from './store-front/orders/orders.component';
import { ShoppingCartComponent } from './store-front/shopping-cart/shopping-cart.component';

@NgModule({
  declarations: [
    AppComponent,
    StoreFrontComponent,
    ProductsComponent,
    OrdersComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
