
package org.example.orderservice.query.repositories;

import org.example.orderservice.query.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
