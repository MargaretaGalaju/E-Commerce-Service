package com.ecommerce.catalogservice.repository;

import com.ecommerce.catalogservice.models.CatalogItemTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogItemTable, Long> {
}
