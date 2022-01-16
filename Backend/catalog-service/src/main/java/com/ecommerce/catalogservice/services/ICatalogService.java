package com.ecommerce.catalogservice.services;
import java.util.List;

import com.ecommerce.catalogservice.models.CatalogItemTable;

public interface ICatalogService {
    CatalogItemTable saveProduct(CatalogItemTable product);
    List<CatalogItemTable> getAllProducts();
    CatalogItemTable getProductById(long id);
    CatalogItemTable updateProduct(CatalogItemTable product, long id);
    void deleteProduct(long id);
}