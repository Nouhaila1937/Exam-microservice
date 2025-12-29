package org.example.inventoryservice.command.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private String status;
    private String categoryId;

    public CreateProductCommand(String productId, String name, double price,
                                int quantity, String status, String categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.categoryId = categoryId;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public String getCategoryId() { return categoryId; }
}
