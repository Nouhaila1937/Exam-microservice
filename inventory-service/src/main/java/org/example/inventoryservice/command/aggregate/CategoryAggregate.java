package org.example.inventoryservice.command.aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.inventoryservice.command.commands.CreateCategoryCommand;
import org.example.inventoryservice.command.events.CategoryCreatedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class CategoryAggregate {

    @AggregateIdentifier
    private String categoryId;
    private String name;

    public CategoryAggregate() {}

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        apply(new CategoryCreatedEvent(
                command.getCategoryId(),
                command.getName(),
                command.getDescription()
        ));
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event) {
        this.categoryId = event.getCategoryId();
        this.name = event.getName();
    }
}
