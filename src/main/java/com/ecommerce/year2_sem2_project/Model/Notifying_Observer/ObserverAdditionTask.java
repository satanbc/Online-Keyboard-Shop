package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

/// Додавання спостерігачей
public class ObserverAdditionTask implements Runnable {
    private OrderSubject orderSubject;
    private Observer observer;

    public ObserverAdditionTask(OrderSubject orderSubject, Observer observer) {
        this.orderSubject = orderSubject;
        this.observer = observer;
    }

    @Override
    public void run() {
        orderSubject.addObserver(observer);
    }
}

