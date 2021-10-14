package com.ecommerce.apigatewayservice.models;

import lombok.Data;

import java.util.Collection;

@Data
public class ProductDetails {
    private long Id;
    private String Name;
    private String Description;
    private String CategoryId;

    private Collection<Review> Reviews;

    public ProductDetails(long id, String name, String description, String categoryId, Collection<Review> reviews) {
        Id = id;
        Name = name;
        Description = description;
        CategoryId = categoryId;
        Reviews = reviews;
    }

}
