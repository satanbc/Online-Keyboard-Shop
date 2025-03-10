package com.ecommerce.year2_sem2_project.Model.DAO;

import com.ecommerce.year2_sem2_project.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/// Репозиторій для доступу та маніпулювання даними продуктів в базі даних
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT MAX(p.id) FROM Product p")
    Long findMaxId();

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE products AUTO_INCREMENT = ?1", nativeQuery = true)
    void resetAutoIncrement(Long newValue);
}

