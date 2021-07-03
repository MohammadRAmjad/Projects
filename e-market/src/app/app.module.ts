import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { CartComponent } from './cart/cart.component';
import { HeaderComponent } from './header/header.component';
import { ProductsComponent } from './products/products.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { ProductComponent } from './products/product-list/product/product.component';
import { CartEditComponent } from './cart/cart-edit/cart-edit.component';
import { ProductDetailesComponent } from './products/product-detailes/product-detailes.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DropdownDirective } from './shared/dropdown.directive';
import { CartProductComponent } from './cart/cart-product/cart-product.component';
import { CartService } from './cart/cart.service';



@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    HeaderComponent,
    ProductsComponent,
    ProductListComponent,
    ProductComponent,
    CartEditComponent,
    ProductDetailesComponent,
    DropdownDirective,
    CartProductComponent,

  
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
