package com.ecommerce.year2_sem2_project.Model.Payment_Strategy;

import org.springframework.stereotype.Component;

/// Стратегія оплати через PayPal
@Component
public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}
