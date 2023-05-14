package com.ecommerce.year2_sem2_project.Model.DAO;

import com.ecommerce.year2_sem2_project.Model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/// Репозиторій для доступу та маніпулювання даними замовлень в базі даних
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

