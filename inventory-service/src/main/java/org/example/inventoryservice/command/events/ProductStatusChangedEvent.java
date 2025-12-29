package org.example.inventoryservice.command.events;


public class ProductStatusChangedEvent {

    private String productId;
    private String status;

    public ProductStatusChangedEvent(String productId, String status) {
        this.productId = productId;
        this.status = status;
    }

    public String getProductId() { return productId; }
    public String getStatus() { return status; }
}
