package com.ecommerce.reviewsservice.models;

import java.util.Date;

public class Review {

    private double Rating;
    private String Message;
    private String Id;
    private String UserId;
    private Date Date;
    private String ProductId;

    public Review(double rating, String message, String id, String userId, java.util.Date date, String productId) {
        Rating = rating;
        Message = message;
        Id = id;
        UserId = userId;
        Date = date;
        ProductId = productId;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        this.Rating = rating;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }
}
