package org.example.inventoryservice.command.events;

public class CategoryCreatedEvent {
    private String categoryId;
    private String name;
    private String description;

    public CategoryCreatedEvent(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public String getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
