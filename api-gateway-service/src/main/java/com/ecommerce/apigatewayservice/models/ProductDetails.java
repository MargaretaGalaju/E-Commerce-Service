package com.ecommerce.apigatewayservice.models;

import java.util.Collection;

public class ProductDetails {
    private String Id;
    private String Name;
    private String Description;
    private String CategoryId;

    private Collection<Review> Reviews;

    public ProductDetails(String id, String name, String description, String categoryId, Collection<Review> reviews) {
        Id = id;
        Name = name;
        Description = description;
        CategoryId = categoryId;
        Reviews = reviews;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public Collection<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        Reviews = reviews;
    }
}
