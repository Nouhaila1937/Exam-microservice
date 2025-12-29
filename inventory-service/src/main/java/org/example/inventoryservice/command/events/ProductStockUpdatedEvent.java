package org.example.inventoryservice.command.events;


public class ProductStockUpdatedEvent {

    private String productId;
    private int quantity;

    public ProductStockUpdatedEvent(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
