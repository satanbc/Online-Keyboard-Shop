package com.ecommerce.year2_sem2_project.Strategy;

import org.springframework.stereotype.Component;

@Component
public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}
