package org.example.dataanalyticsservice.events;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
    private String orderId;
    private String productId;
    private int quantity;
    private double totalPrice;
    private String customerId;
}
