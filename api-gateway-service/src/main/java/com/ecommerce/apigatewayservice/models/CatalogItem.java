package com.ecommerce.apigatewayservice.models;

public class CatalogItem {

    private String name;
    private String description;
    private long id;
    private String categoryId;

    public CatalogItem() {}

    public CatalogItem(String name, String description, long id, String categoryId) {
        name = name;
        description = description;
        id = id;
        categoryId = categoryId;
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
        id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        categoryId = categoryId;
    }
}
