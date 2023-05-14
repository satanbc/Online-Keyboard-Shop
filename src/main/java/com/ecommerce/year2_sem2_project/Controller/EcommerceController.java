package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Model.Entity.Product;
import com.ecommerce.year2_sem2_project.Model.Notifying_Observer.*;
import com.ecommerce.year2_sem2_project.Model.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    ///  Відображає сторінку групової закупки
    @GetMapping("/group-buy")
    public String groupBuy() {

        return "group-buy";
    }

    /// Додає спостерігачів
    @PostMapping("/notify")
    public String addObserver(@RequestParam("email") String email,
                            @RequestParam("phoneNumber") String phoneNumber) {
        NotifySubject notifySubject = new NotifySubject();
        Observer observer1 = new EmailNotificationObserver(email);
        Observer observer2 = new SMSNotificationObserver(phoneNumber);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ObserverAdditionTask(notifySubject, observer1));
        executorService.submit(new ObserverAdditionTask(notifySubject, observer2));

        executorService.shutdown();

        return "redirect:/group-buy";
    }
}
