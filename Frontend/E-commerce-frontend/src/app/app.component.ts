import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public productIds: string[] = [];
  public searchedProduct: string = '';
  public productInfo:any = null;
  public newProductForm: FormGroup = new FormGroup({});
  public showAddForm = false;

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
  ) {

  }

  public ngOnInit() {
    this.getAvailableProductIds();

    this.newProductForm = this.formBuilder.group({
      name: ['Some test name', Validators.required],
      description: ['What an interesting description woooooow', Validators.required],
      categoryId: ['books', Validators.required],
      available: [true],
    })
  }

  public getAvailableProductIds() {
    this.productService.getAvailableProductIds().subscribe((products: any[]) => {
      this.productIds = products.map((product) => product.id);
    })
  }

  public searchForSpecificProduct() {
    this.productService.getSpecificProduct(this.searchedProduct).subscribe((data) => {
      this.productInfo = data;
    });
  }

  public onFormSubmit() {
    this.productService.postExistingProduct(this.newProductForm.value).subscribe(() => {
      this.getAvailableProductIds();
    })
  }
}
