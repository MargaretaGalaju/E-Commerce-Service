package com.ecommerce.apigatewayservice.services;

import com.ecommerce.apigatewayservice.models.ProductDetails;
import com.ecommerce.apigatewayservice.models.ProductReviews;
import com.ecommerce.apigatewayservice.models.Review;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackProductReviews",
            threadPoolKey = "reviewsPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public ProductReviews getProductReviews(long productId) {
        ProductReviews productReviews = restTemplate.getForObject("http://REVIEWS-SERVICE/reviews/"+productId, ProductReviews.class);
        return productReviews;
    }

    public ProductReviews getFallbackProductReviews(long productId) {
        List<Review> productReviews = new ArrayList<Review>();
        return new ProductReviews(productReviews);
    }
}
