import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/shared/models/models';
import { ProductService } from 'src/app/shared/services/product.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.scss']
})
export class ProductsListComponent implements OnInit {

  constructor(private productService : ProductService) { }

  ngOnInit(): void {

    this.getProducts();
    console.log(this.productList);
  }

  productList: Product[];

  public getProducts(){
    this.productService.getProducts().subscribe((data: Product[]) => {
      this.productList = data;
    })

  }
}
