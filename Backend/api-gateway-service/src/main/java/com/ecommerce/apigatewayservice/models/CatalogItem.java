package com.ecommerce.apigatewayservice.models;

public class CatalogItem {

    private String name;
    private String description;
    private String categoryId;
    private Boolean available;
    private long id;

    public CatalogItem() {}

    public CatalogItem(String name, String description, long id, String categoryId, Boolean available) {
        name = name;
        description = description;
        id = id;
        categoryId = categoryId;
        available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
