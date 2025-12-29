package org.example.orderservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private String id;
    private String productId;
    private int quantity;
    private double totalPrice;
    private String status; // e.g., "PENDING", "COMPLETED"
    private LocalDateTime orderDate;
}
