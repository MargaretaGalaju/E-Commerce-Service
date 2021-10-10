package com.ecommerce.apigatewayservice.resources;

import com.ecommerce.apigatewayservice.models.CatalogItem;
import com.ecommerce.apigatewayservice.models.ProductDetails;
import com.ecommerce.apigatewayservice.models.ProductReviews;
import com.ecommerce.apigatewayservice.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/product")
public class APIGatewayResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{productId}")
    public ProductDetails getProductDetails(@PathVariable("productId") String productId) {
        ProductDetails productDetails = new ProductDetails("", "", "", "", null);
        ProductReviews productReviews = restTemplate.getForObject("http://REVIEWS-SERVICE/reviews/lala", ProductReviews.class);
        CatalogItem catalogItem = restTemplate.getForObject("http://CATALOG-SERVICE/catalog/product/my-id", CatalogItem.class);

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
}
