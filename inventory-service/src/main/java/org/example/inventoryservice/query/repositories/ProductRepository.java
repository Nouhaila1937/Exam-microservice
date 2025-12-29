package org.example.inventoryservice.query.repositories;

import org.example.inventoryservice.query.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {}