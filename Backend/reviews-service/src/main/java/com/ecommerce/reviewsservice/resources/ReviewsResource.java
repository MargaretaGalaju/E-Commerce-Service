package com.ecommerce.reviewsservice.resources;


import com.ecommerce.reviewsservice.models.ProductReviews;
import com.ecommerce.reviewsservice.models.Review;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reviews")
public class ReviewsResource {

    @RequestMapping("/{productId}")
    public ProductReviews getReviews(@PathVariable("productId") String productId) {
        Date dateNow = new Date();

        List<Review> productReviews = new ArrayList<Review>();

        productReviews.add(
                new Review(8.75, "I liked it", "df0d6134-874a-48ca-b56d-bb3e798e6e43", "b390e573-8496-45cb-bee1-032db283c416", dateNow, "9c594250-de6b-4939-8757-eff9c0cbce68")
        );

        productReviews.add(
                new Review(10, "Wow! perfect", "78378383-874a-48ca-b56d-bb3e798e6e43", "deeerr4rr-8496-45cb-bee1-032db283c416", dateNow, "2345678-de6b-4939-8757-eff9c0cbce68")
        );

        productReviews.add(
                new Review(5, "Didn't work", "6666666-874a-48ca-b56d-bb3e798e6e43", "r3ju333f-8496-45cb-bee1-032db283c416", dateNow, "7654356-de6b-4939-8757-eff9c0cbce68")
        );

        ProductReviews reviews = new ProductReviews();
        reviews.setProductReviews(productReviews);

        return reviews;
    }
}