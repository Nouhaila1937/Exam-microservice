package org.example.inventoryservice.query.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryEntity {

    @Id
    private String id;
    private String name;
    private String description;


}
