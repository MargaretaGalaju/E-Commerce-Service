package com.ecommerce.catalogservice.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class CatalogItemTable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "description")
    private String Description;

    @Column(name = "categoryId")
    private String CategoryId;

    @Column(name = "available")
    private Boolean Available;
}
