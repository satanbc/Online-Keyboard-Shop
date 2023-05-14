package com.ecommerce.year2_sem2_project.Model.Payment_Strategy;

import org.springframework.stereotype.Component;

/// Стратегія оплати карткою
@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}



