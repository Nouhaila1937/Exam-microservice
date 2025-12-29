package org.example.inventoryservice.command.aggregate;


import org.example.inventoryservice.command.commands.*;
import org.example.inventoryservice.command.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private int quantity;
    private String status;

    public ProductAggregate() {}

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        apply(new ProductCreatedEvent(
                command.getProductId(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getStatus(),
                command.getCategoryId()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductStockCommand command) {
        apply(new ProductStockUpdatedEvent(command.getProductId(), command.getQuantity()));
    }

    @CommandHandler
    public void handle(ChangeProductStatusCommand command) {
        apply(new ProductStatusChangedEvent(command.getProductId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.quantity = event.getQuantity();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(ProductStockUpdatedEvent event) {
        this.quantity = event.getQuantity();
    }

    @EventSourcingHandler
    public void on(ProductStatusChangedEvent event) {
        this.status = event.getStatus();
    }
}
