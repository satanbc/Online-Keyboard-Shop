package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

import com.ecommerce.year2_sem2_project.Model.Entity.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/// Реалізація дій над спостерігачами
@Service
public class OrderSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Scheduled(cron = "0 0 9 15 6 *") // Runs at 9:00 AM on the 15th of June
    @Override
    public void notifyObservers() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Observer observer : observers) {
            executorService.submit(() -> observer.update(order));
        }

        executorService.shutdown();
    }
}

