package com.ecommerce.reviewsservice.models;

import java.util.List;

public class ProductReviews {
    private List<Review> productReviews;

    public ProductReviews() {}

    public ProductReviews(List<Review> productReviews) {
        this.productReviews = productReviews;
    }

    public List<Review> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<Review> productReviews) {
        this.productReviews = productReviews;
    }
}
