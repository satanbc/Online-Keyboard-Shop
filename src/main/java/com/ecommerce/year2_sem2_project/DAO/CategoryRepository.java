package com.ecommerce.year2_sem2_project.DAO;

import com.ecommerce.year2_sem2_project.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}

