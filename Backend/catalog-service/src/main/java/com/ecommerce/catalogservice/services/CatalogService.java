package com.ecommerce.catalogservice.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.catalogservice.exceptions.ResourceNotFoundException;
import com.ecommerce.catalogservice.models.CatalogItem;
import com.ecommerce.catalogservice.models.CatalogItemTable;
import com.ecommerce.catalogservice.repository.CatalogRepository;
import org.springframework.stereotype.Service;


@Service
public class CatalogService implements ICatalogService {

    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        super();
        this.catalogRepository = catalogRepository;
    }

    @Override
    public CatalogItemTable saveProduct(CatalogItemTable product) {
        return catalogRepository.save(product);
    }

    @Override
    public List<CatalogItemTable> getAllProducts() {
        return catalogRepository.findAll();
    }

    @Override
    public CatalogItemTable getProductById(long id) {
        return catalogRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("CatalogItem", "Id", id));

    }

    @Override
    public CatalogItemTable updateProduct(CatalogItemTable CatalogItem, long id) {
        CatalogItemTable existingProduct = catalogRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("CatalogItem", "Id", id));

        existingProduct.setName(CatalogItem.getName());
        existingProduct.setDescription(CatalogItem.getDescription());
        existingProduct.setCategoryId(CatalogItem.getCategoryId());
        existingProduct.setAvailable(CatalogItem.getAvailable());
        catalogRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        catalogRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("CatalogItem", "Id", id));
        catalogRepository.deleteById(id);
    }

}