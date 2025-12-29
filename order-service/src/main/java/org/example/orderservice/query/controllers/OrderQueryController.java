package org.example.orderservice.query.controllers;

import org.example.orderservice.query.entities.OrderEntity;
import org.example.orderservice.query.entities.CustomerEntity;
import org.example.orderservice.query.repositories.OrderRepository;
import org.example.orderservice.query.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
public class OrderQueryController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderQueryController(OrderRepository orderRepository,
                                CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // Orders
    @GetMapping("/orders")
    public List<OrderEntity> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public OrderEntity getOrder(@PathVariable String id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Customers
    @GetMapping("/customers")
    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public CustomerEntity getCustomer(@PathVariable String id) {
        return customerRepository.findById(id).orElse(null);
    }
}
