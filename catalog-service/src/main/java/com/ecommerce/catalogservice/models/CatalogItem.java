package com.ecommerce.catalogservice.models;

public class CatalogItem {

    private String Name;
    private String Description;
    private String Id;
    private String CategoryId;

    public CatalogItem(String name, String description, String id, String categoryId) {
        Name = name;
        Description = description;
        Id = id;
        CategoryId = categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }
}
