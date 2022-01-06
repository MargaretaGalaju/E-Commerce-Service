package com.ecommerce.catalogservice.resources;

import com.ecommerce.catalogservice.models.CatalogItem;
import com.ecommerce.catalogservice.models.CatalogItemTable;
import com.ecommerce.catalogservice.services.CatalogService;
import com.ecommerce.catalogservice.services.ICatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    private ICatalogService catalogService;

    public CatalogResource(ICatalogService catalogService) {
        super();
        this.catalogService = catalogService;
    }

    @PostMapping()
    public ResponseEntity<CatalogItemTable> saveProduct(@RequestBody CatalogItemTable catalogItemTable){

        return new ResponseEntity<CatalogItemTable>(catalogService.saveProduct(catalogItemTable), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CatalogItemTable> getAllProducts(){
        return catalogService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<CatalogItemTable> getEmployeeById(@PathVariable("id") long productId){
        return new ResponseEntity<CatalogItemTable>(catalogService.getProductById(productId), HttpStatus.OK);
    }
}
