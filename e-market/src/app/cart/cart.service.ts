import { forEachTrailingCommentRange, isTaggedTemplateExpression, isTemplateExpression } from "typescript";
import { Subject } from "rxjs";
import { CartItem } from "../shared/cartItem.model";
import { Product } from "../shared/product.model";

import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})

export class CartService {
    cartItems: CartItem[] = [];
    items = new Subject()
    temp = []

    
    addToCart(product: Product) {
        let newItem = new CartItem(product, 1);
        let itemExist = false
        let index
        if(this.cartItems.length > 0){
            for(let i = 0; i < this.cartItems.length; i++){
                if(this.cartItems[i].item.id === newItem.item.id){
                    this.cartItems[i].quantity += 1
                    itemExist = true
                    this.items.next(this.cartItems)  
                }  
            }
        } 
    //    else if(itemExist || this.cartItems.length<= 0){
    //         this.cartItems.push(newItem)
    //         this.items.next(this.cartItems)   
    //     }    
    
        this.cartItems.push(newItem)
        this.items.next(this.cartItems)     
    }

    removeItemFromCart(item:CartItem){
        let index
        for(let i = 0; i < this.cartItems.length; i++){
            if (this.cartItems[i].item.title === item.item.title){
               if(this.cartItems[i].quantity > 1){
                this.cartItems[i].quantity -= 1
               }
               else{
                   this.cartItems.splice(i,1)
               }
            }
            break
        } 
    }
    
    calcTotalCost(cis: CartItem[]) {
        let total = 0
        for (let i of cis) {
            let oneitem = i.item.price * i.quantity
            total+= oneitem
        }
        return total
    }

    getItems(){
        return this.items
    }

    clearCart() {
        
        this.cartItems = [];
    }

}