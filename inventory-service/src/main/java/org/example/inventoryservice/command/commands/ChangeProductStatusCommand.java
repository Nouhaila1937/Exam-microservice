package org.example.inventoryservice.command.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ChangeProductStatusCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String status;

    public ChangeProductStatusCommand(String productId, String status) {
        this.productId = productId;
        this.status = status;
    }

    public String getProductId() { return productId; }
    public String getStatus() { return status; }
}
