package org.example.inventoryservice.command.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateProductStockCommand {

    @TargetAggregateIdentifier
    private String productId;
    private int quantity;

    public UpdateProductStockCommand(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
