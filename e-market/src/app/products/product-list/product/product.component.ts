  
import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart/cart.service';
import { Product } from 'src/app/shared/product.model';
import { CartItem } from 'src/app/shared/cartItem.model';
import { ProductService } from '../../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input()
  product!: Product;
  liked: boolean = false;
  color = "white";

  constructor(private cartService: CartService, private productService: ProductService) { }

  ngOnInit(): void {
  }

  onAdd() {
    console.log("Add " + this.product.title + " to cart!");
    // add to cart
    this.cartService.addToCart(this.product);
  }

  toggleLike() {
    this.liked = !this.liked;
    console.log(this.liked);
    if(this.liked){
      this.color="pink";
    } else {
      this.color="white";
    }

  }
}