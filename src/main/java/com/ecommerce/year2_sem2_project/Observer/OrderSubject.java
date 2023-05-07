package com.ecommerce.year2_sem2_project.Observer;

import com.ecommerce.year2_sem2_project.Entity.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
        notifyObservers();
    }

    @Override
    public void addObserver(java.util.Observer observer) {

    }

    @Override
    public void removeObserver(java.util.Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}

