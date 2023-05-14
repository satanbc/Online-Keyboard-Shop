package com.ecommerce.year2_sem2_project.Model.CreatingProducts_Factory;

import com.ecommerce.year2_sem2_project.Model.Entity.Product;

/// Фабрика для створення продуктів
public class ProductFactory {
    public static Product createProduct(String name, String description, double price, int stock, String imageUrl) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setImageUrl(imageUrl);
        return product;
    }
}