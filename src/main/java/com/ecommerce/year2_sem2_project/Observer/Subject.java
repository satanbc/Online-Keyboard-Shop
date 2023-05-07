package com.ecommerce.year2_sem2_project.Observer;

import java.util.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

