package com.ecommerce.year2_sem2_project.DAO;

import com.ecommerce.year2_sem2_project.Entity.Category;
import com.ecommerce.year2_sem2_project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    @Query("SELECT p FROM Product p WHERE p.featured")
    List<Product> findFeaturedProducts();

}

