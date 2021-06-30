import { Component, OnInit } from '@angular/core';
import {Product} from '../../shared/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [
    new Product(1,'TV', 750.55, 'Electronics'),
    new Product(2,'TV', 755.55, 'Electronics')
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
