package com.ecommerce.catalogservice.resources;

import com.ecommerce.catalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("Lenovo Notebook", "Super innovative laptop", "9c594250-de6b-4939-8757-eff9c0cbce68", "5")
        );
    }

    @RequestMapping("/product/{productId}")
    public CatalogItem getProductById(@PathVariable("productId") String productId) {
        return new CatalogItem("Lenovo Notebook", "Super innovative laptop", "9c594250-de6b-4939-8757-eff9c0cbce68", "5");
    }
}
