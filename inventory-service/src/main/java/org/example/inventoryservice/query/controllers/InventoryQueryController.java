
package org.example.inventoryservice.query.controllers;

import org.example.inventoryservice.query.entities.CategoryEntity;
import org.example.inventoryservice.query.entities.ProductEntity;
import org.example.inventoryservice.query.repositories.ProductRepository;
import org.example.inventoryservice.query.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/categories")
public class InventoryQueryController {

    private final CategoryRepository categoryRepository;

    public InventoryQueryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategory(@PathVariable String id) {
        return categoryRepository.findById(id).orElse(null);
    }
}

