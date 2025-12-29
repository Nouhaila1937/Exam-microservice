package org.example.inventoryservice.query.handlers;

import org.axonframework.eventhandling.EventHandler;
import org.example.inventoryservice.command.events.CategoryCreatedEvent;
import org.example.inventoryservice.command.events.ProductCreatedEvent;
import org.example.inventoryservice.command.events.ProductStatusChangedEvent;
import org.example.inventoryservice.command.events.ProductStockUpdatedEvent;
import org.example.inventoryservice.query.entities.CategoryEntity;
import org.example.inventoryservice.query.entities.ProductEntity;
import org.example.inventoryservice.query.repositories.CategoryRepository;
import org.example.inventoryservice.query.repositories.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventHandler {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public InventoryEventHandler(ProductRepository productRepository,
                                 CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @EventHandler
    public void on(CategoryCreatedEvent event) {
        CategoryEntity category = new CategoryEntity();
        category.setId(event.getCategoryId());
        category.setName(event.getName());
        category.setDescription(event.getDescription());
        categoryRepository.save(category);
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity product = new ProductEntity();
        product.setId(event.getProductId());
        product.setName(event.getName());
        product.setPrice(event.getPrice());
        product.setQuantity(event.getQuantity());
        product.setStatus(event.getStatus());
        product.setCategoryId(event.getCategoryId());
        productRepository.save(product);
    }

    @EventHandler
    public void on(ProductStockUpdatedEvent event) {
        productRepository.findById(event.getProductId()).ifPresent(p -> {
            p.setQuantity(event.getQuantity());
            productRepository.save(p);
        });
    }

    @EventHandler
    public void on(ProductStatusChangedEvent event) {
        productRepository.findById(event.getProductId()).ifPresent(p -> {
            p.setStatus(event.getStatus());
            productRepository.save(p);
        });
    }
}
