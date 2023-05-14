package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.Entity.Product;

import java.util.List;

/// Сервіс який обробляє бізнес-логіку продуктів
public interface ProductService {

    /// Отримання всіх продуктів
    List<Product> getAllProducts();

    /// Отримання продукту за його унікальним ідентифікатором
    Product getProductById(Long id);

    /// Збереження замовлення
    void saveProduct(Product product);

    /// Видалення замовлення за його унікальним ідентифікатором
    void deleteById(Long id);

    /// Оновлення замовлення
    void updateProduct(Product updatedProduct);
}

