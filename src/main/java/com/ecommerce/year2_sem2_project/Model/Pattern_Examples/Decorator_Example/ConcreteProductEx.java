package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Decorator_Example;

/// Конкретний продукт
public class ConcreteProductEx implements ProductEx {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Integer stock;
    private String imageUrl;

    public ConcreteProductEx(Long id, String name, String description, double price, Integer stock, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
