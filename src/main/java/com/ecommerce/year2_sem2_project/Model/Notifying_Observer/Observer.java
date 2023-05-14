package com.ecommerce.year2_sem2_project.Model.Notifying_Observer;

import com.ecommerce.year2_sem2_project.Model.Entity.Order;

/// Об'єкт, який підписується на сповіщення від суб'єкта та отримує оновлення про зміни в його стані
public interface Observer {

    void update(Order order);
}

