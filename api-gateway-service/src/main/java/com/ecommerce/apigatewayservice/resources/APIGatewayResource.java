package com.ecommerce.apigatewayservice.resources;

import com.ecommerce.apigatewayservice.models.CatalogItem;
import com.ecommerce.apigatewayservice.models.ProductDetails;
import com.ecommerce.apigatewayservice.models.ProductReviews;
import com.ecommerce.apigatewayservice.models.Review;
import com.ecommerce.apigatewayservice.services.CatalogService;
import com.ecommerce.apigatewayservice.services.ReviewsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class APIGatewayResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    ReviewsService reviewsService;

    @Autowired
    CatalogService catalogService;

    @RequestMapping("/{productId}")
//    @Cacheable("product")
    @HystrixCommand(fallbackMethod = "getFallbackProductDetails")
    public ProductDetails getProductDetails(@PathVariable("productId") String productId) {
        ProductDetails productDetails = new ProductDetails("", "", "", "", null);

//        Check caching:
//        simulateSlowService();

        ProductReviews productReviews = reviewsService.getProductReviews();
        CatalogItem catalogItem = catalogService.getCatalogItem();

        if (productReviews != null) {
            productDetails.setReviews(productReviews.getProductReviews());
        }

        if (catalogItem != null) {
            productDetails.setName(catalogItem.getName());
            productDetails.setDescription(catalogItem.getDescription());
            productDetails.setId(catalogItem.getId());
            productDetails.setCategoryId(catalogItem.getCategoryId());
        }


        return productDetails;
    }

    public ProductDetails getFallbackProductDetails(@PathVariable("productId") String productId) {
        return new ProductDetails("", "No product", "", "", null);
    }

//    private void simulateSlowService() {
//        try {
//            long time = 3000L;
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }
//    }

}
