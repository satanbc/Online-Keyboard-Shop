package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

/// Реалізація спостерігача через SMS
public class SMSNotificationObserver implements Observer {

    String phoneNumber;

    public SMSNotificationObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update() {

        System.out.println("Sending SMS notification");
    }
}
