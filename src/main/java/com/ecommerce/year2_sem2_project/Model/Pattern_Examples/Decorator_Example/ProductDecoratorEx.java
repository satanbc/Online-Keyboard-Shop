package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Decorator_Example;

/// Декоратор
public class ProductDecoratorEx implements ProductEx{

    private ProductEx decoratedProduct;

    public ProductDecoratorEx(ProductEx decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }
}
