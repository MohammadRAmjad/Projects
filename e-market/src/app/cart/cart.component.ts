import { Component, OnChanges, OnInit} from '@angular/core';
import { Product } from '../shared/product.model';
import { CartItem } from "../shared/cartItem.model";
import { CartService } from './cart.service';



@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent  {

  items: CartItem[]= []
  totalCost = 0

  constructor(private cartService: CartService) {};

  ngOnInit(){
    this.cartService.getItems().subscribe((data:[])=>{
        this.items = data
        this.totalCost = this.cartService.calcTotalCost(this.items)
        console.log(this.items.length)
       
    })
}

  removeFromCart(e:CartItem){
    this.cartService.removeItemFromCart(e)
    this.totalCost -= e.item.price

  }

  clearCart() {
   this.cartService.clearCart()
   this.items = []
   this.totalCost = 0
  }

 

}