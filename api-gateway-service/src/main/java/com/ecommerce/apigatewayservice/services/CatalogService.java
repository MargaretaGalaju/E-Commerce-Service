package com.ecommerce.apigatewayservice.services;

import com.ecommerce.apigatewayservice.models.CatalogItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem() {
        CatalogItem catalogItem = restTemplate.getForObject("http://CATALOG-SERVICE/catalog/product/my-id", CatalogItem.class);
        return catalogItem;
    }

    public CatalogItem getFallbackCatalogItem() {
        return new CatalogItem("No item", "Could not load description", "", "");
    }
}
