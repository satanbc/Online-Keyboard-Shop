package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Entity.Category;
import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.CategoryService;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EcommerceController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getFeaturedProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/products/category/{categoryId}")
    public String category(@PathVariable("categoryId") Long categoryId, Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        List<Product> products = productService.getProductsByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "category";
    }
}
