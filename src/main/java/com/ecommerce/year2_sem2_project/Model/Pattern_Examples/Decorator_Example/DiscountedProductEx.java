package com.ecommerce.year2_sem2_project.Model.Pattern_Examples.Decorator_Example;

/// Конкретний декоратор
public class DiscountedProductEx extends ProductDecoratorEx {

    private double discount;

    public DiscountedProductEx(ProductEx decoratedProduct, double discount) {
        super(decoratedProduct);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        double originalPrice = super.getPrice();
        double discountedPrice = originalPrice - (originalPrice * discount);
        return discountedPrice;
    }
}
