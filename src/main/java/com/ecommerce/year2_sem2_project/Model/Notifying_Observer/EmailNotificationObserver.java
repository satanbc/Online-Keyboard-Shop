package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

import com.ecommerce.year2_sem2_project.Model.Entity.Order;

/// Реалізація спостерігача через email
public class EmailNotificationObserver implements Observer {

    String email;

    public EmailNotificationObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(Order order) {

        System.out.println("Sending email notification for order: " + order.getId());
    }
}

