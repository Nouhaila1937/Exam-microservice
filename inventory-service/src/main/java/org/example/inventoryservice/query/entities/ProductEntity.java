package org.example.inventoryservice.query.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String status;
    private String categoryId;


}
