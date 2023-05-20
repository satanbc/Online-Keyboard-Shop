package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Builder_Example;

import com.ecommerce.year2_sem2_project.Model.Entity.Product;

/// Білдер для створення продуктів
public class ProductBuilder {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Integer stock;
    private String imageUrl;

    public ProductBuilder() {
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Product build() {
        return new Product(id, name, description, price, stock, imageUrl);
    }
}

