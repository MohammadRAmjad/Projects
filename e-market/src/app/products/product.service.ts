import { Product } from "../shared/product.model";

export class ProductService {

private products: Product[] = [
    new Product(1,'65-inch TV', 670.55, 'Electronics'),
    new Product(2,'70-inch TV', 755.55, 'Electronics'),
    new Product(3,'Headphones', 25.00, 'Electronics'),
    new Product(4,'Desk', 149.99, 'Furniture'),
    new Product(5,'Desk Chair', 119.95, 'Furniture'),
    new Product(6,'Area Rug', 160.00, 'Furniture'),
    new Product(7,'Fuzzy Socks', 8.95, 'Clothing'),
    new Product(8,'Beanie', 19.99, 'Clothing'),
    new Product(9,'Puffer Jacket', 100.00, 'Clothing')
  ];
  getProducts(v:string){
      if(v === 'All')
        return this.products;
      else{
        let selectedProducts: Product[] = [];
        for (var item of this.products){
            if(item.category === v)
                selectedProducts.push(item)
                console.log(item.title)
        }
        console.log(selectedProducts.length)
        return selectedProducts
      }
      
        
  }
}