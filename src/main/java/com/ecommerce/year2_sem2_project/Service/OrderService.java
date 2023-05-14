package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.Entity.Order;
import java.util.List;


public interface OrderService {

    public void createOrder(Order order);

    public List<Order> getAllOrders();

    public double calculateTotalPrice(Order order);

    public Order getOrderById(Long orderId);
}

