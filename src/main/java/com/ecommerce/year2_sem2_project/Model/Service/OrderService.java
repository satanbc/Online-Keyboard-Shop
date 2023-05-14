package com.ecommerce.year2_sem2_project.Model.Service;

import com.ecommerce.year2_sem2_project.Model.Entity.Order;
import java.util.List;

/// Сервіс який обробляє бізнес-логіку замовлень
public interface OrderService {

    /// Створює нове замовлення
    public void createOrder(Order order);

    /// Отримує всі замовлення
    public List<Order> getAllOrders();

    /// Обчислює загальну вартість замовлення
    public double calculateTotalPrice(Order order);

    /// Отримує замовлення за його унікальним ідентифікатором
    public Order getOrderById(Long orderId);
}

