package org.example.inventoryservice.query.controllers;

import org.example.inventoryservice.query.entities.ProductEntity;
import org.example.inventoryservice.query.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/query/products")
public class ProductQueryController {

    private final ProductRepository productRepository;

    public ProductQueryController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }
}
