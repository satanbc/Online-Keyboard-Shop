package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.Entity.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    void saveCategory(Category category);

    void deleteCategory(Long id);

}

