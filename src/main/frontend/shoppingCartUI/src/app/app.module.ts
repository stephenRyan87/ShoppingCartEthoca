import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoreComponent } from './store/store.component';
import { ProductsComponent } from './store/products/products.component';
import { OrdersComponent } from './store/orders/orders.component';
import { CartComponent } from './store/cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    StoreComponent,
    ProductsComponent,
    OrdersComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
