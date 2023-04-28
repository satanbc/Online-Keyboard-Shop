package com.ecommerce.year2_sem2_project.DAO;

import com.ecommerce.year2_sem2_project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

