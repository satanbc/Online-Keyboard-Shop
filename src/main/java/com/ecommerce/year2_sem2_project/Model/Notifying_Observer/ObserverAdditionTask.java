package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

/// Додавання спостерігачей
public class ObserverAdditionTask implements Runnable {
    private NotifySubject notifySubject;
    private Observer observer;

    public ObserverAdditionTask(NotifySubject notifySubject, Observer observer) {
        this.notifySubject = notifySubject;
        this.observer = observer;
    }

    @Override
    public void run() {
        notifySubject.addObserver(observer);
    }
}

