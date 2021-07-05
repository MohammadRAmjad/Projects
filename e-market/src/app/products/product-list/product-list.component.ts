import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Subject } from 'rxjs';
import {Product} from '../../shared/product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
 
  
  // @Output() productWasSelected = new EventEmitter<Product>()
  // @Input() categorySelected = new EventEmitter<string>()
  products: Product[] = [];
  value:string="All";
  

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.products =this.productService.getProducts(this.value)
  }

  buttonClick(e:string){
    this.products =this.productService.getProducts(e)
  }

  // onProductSelect(product: Product){
  //   this.productWasSelected.emit(product)
  // }
  

}
