package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.Entity.Category;
import com.ecommerce.year2_sem2_project.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getFeaturedProducts();

    Product getProductById(Long id);

    List<Product> getProductsByCategory(Category category);

    void saveProduct(Product product);

    void deleteProduct(Long id);

}

