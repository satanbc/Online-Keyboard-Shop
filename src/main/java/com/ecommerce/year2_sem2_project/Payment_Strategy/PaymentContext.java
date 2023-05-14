package com.ecommerce.year2_sem2_project.Payment_Strategy;

import org.springframework.stereotype.Component;

/// Клас для здійснення платежів у системі електронної комерції з використанням стратегії платежу
@Component
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

