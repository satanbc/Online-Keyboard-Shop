package com.ecommerce.year2_sem2_project.Model.Service;

import com.ecommerce.year2_sem2_project.Model.Entity.Product;

import java.util.List;

/// Сервіс який обробляє бізнес-логіку продуктів
public interface ProductService {

    /// Отримує всі продукти
    List<Product> getAllProducts();

    /// Отримує продукт за його унікальним ідентифікатором
    Product getProductById(Long id);

    /// Зберігає замовлення
    void saveProduct(Product product);

    /// Видаляє замовлення за його унікальним ідентифікатором
    void deleteById(Long id);

    /// Оновлює замовлення
    void updateProduct(Product updatedProduct);
}

