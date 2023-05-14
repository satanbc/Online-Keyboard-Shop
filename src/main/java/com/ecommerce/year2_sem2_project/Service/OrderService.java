package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.Entity.Order;
import java.util.List;

/// Сервіс який обробляє бізнес-логіку замовлень
public interface OrderService {

    /// Створення нового замовлення
    public void createOrder(Order order);

    /// Отримання всіх замовлень
    public List<Order> getAllOrders();

    /// Обчислення загальної вартості замовлення
    public double calculateTotalPrice(Order order);

    /// Отримання замовлення за  його унікальним ідентифікатором
    public Order getOrderById(Long orderId);
}

