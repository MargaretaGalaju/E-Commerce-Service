package com.ecommerce.apigatewayservice.services;

import com.ecommerce.apigatewayservice.models.CatalogItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            })
    public CatalogItem getCatalogItem(long productId) {
        CatalogItem catalogItem = restTemplate.getForObject("http://CATALOG-SERVICE/catalog/"+productId, CatalogItem.class);
        return catalogItem;
    }

    public CatalogItem getFallbackCatalogItem(long productId) {
        return new CatalogItem("No item", "Could not load description", 0, "", false);
    }
}
