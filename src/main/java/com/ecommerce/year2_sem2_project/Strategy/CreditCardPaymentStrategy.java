package com.ecommerce.year2_sem2_project.Strategy;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}



