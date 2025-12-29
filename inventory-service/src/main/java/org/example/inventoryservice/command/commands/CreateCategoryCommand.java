package org.example.inventoryservice.command.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateCategoryCommand {

    @TargetAggregateIdentifier
    private String categoryId;
    private String name;
    private String description;

    public CreateCategoryCommand(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public String getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
