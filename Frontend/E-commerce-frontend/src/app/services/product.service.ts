import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(
    private httpClient: HttpClient,
  ) { }

  public getAvailableProductIds(): Observable<any> {
    return this.httpClient.get('http://localhost:8080/catalog/4');
  }

  public getSpecificProduct(productId: string) {
    return this.httpClient.get('http://localhost:8083/product/' + productId);
  }

  public addNewProduct(product: any) {
    return this.httpClient.post('http://localhost:8080/catalog', product);
  }
  
  public postExistingProduct(product: any) {
    return this.httpClient.post('http://localhost:8080/catalog/4', product);
  }
}
