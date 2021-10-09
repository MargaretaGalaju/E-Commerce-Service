package com.ecommerce.apigatewayservice.resources;

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

        ProductReviews productReviews = webClientBuilder.build().get()
                .uri("http://localhost:8081/reviews/lala")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductReviews.class).block();

        List<Review> reviews = null;
        if (productReviews != null) {
            reviews = productReviews.getProductReviews();
        }
        return new ProductDetails("d", "d", "d", "d", reviews);
    }
}
