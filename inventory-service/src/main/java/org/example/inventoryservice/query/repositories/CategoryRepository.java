package org.example.inventoryservice.query.repositories;

import org.example.inventoryservice.query.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {}