//import { forEachTrailingCommentRange, isTaggedTemplateExpression, isTemplateExpression } from "typescript";
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
    

    
    addToCart(product: Product) {
       
        let itemdNotInList = true
        console.log("After intialization: "+itemdNotInList)
        let index
        if(this.cartItems.length > 0){
            for(let i = 0; i < this.cartItems.length; i++){
                if(this.cartItems[i].item.id === product.id){
                    this.cartItems[i].quantity += 1
                    itemdNotInList = false
                    console.log("inside the for loop" + itemdNotInList)
                    this.items.next(this.cartItems)  
                }  
            }
        } 
       if(itemdNotInList){
            console.log("inside the if else statement"+ itemdNotInList)
            let newItem = new CartItem(product, 1);
            this.cartItems.push(newItem)
            this.items.next(this.cartItems)   
        }        
    }

    removeItemFromCart(item:CartItem){
        let index
        
        for(let i = 0; i < this.cartItems.length; i++){
            if (this.cartItems[i].item.id === item.item.id){
                if(this.cartItems[i].quantity === 1) {
                    //this.cartItems = this.cartItems.splice(i,1)
                    this.cartItems = this.cartItems.filter(product => product.item.id !== item.item.id)
                    this.items.next(this.cartItems)
                    break
                }
               if(this.cartItems[i].quantity > 1){
                this.cartItems[i].quantity -= 1
                this.items.next(this.cartItems)
                break
               }
          
            }
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