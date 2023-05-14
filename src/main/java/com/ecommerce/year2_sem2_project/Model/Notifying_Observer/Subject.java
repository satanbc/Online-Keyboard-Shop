package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

/// Дії над спостерігачами
public interface Subject {
    void addObserver(Observer observer); /// Додавання спостерігача
    void removeObserver(Observer observer); /// Видалення спостерігача
    void notifyObservers(); /// Сповіщення спостерігачей
}

