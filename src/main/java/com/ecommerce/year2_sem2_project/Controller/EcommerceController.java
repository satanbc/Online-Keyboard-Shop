package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/// Контролер Spring MVC, який відповідає за обробку основних сторінок веб-додатку
@Controller
public class EcommerceController {

    @Autowired
    private ProductService productService;

    /// Відображає домашню сторінку, яка містить список доступних товарів
    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "home";
    }

    /// Відображає сторінку з контактною інформацією
    @GetMapping("/contact")
    public String contact() {

        return "contact";
    }

    ///  Відображає сторінку "Про нас", яка містить інформацію про компанію
    @GetMapping("/about")
    public String about() {

        return "about";
    }

    ///  Відображає сторінку входу для адміністратора
    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
