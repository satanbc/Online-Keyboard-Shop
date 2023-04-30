package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public List<Product> initializeCart() {
        return new ArrayList<>();
    }

    private double getTotalPrice(List<Product> cart) {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }


    @GetMapping("/cart")
    public String showCart(Model model, @ModelAttribute("cart") List<Product> cart) {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }


    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId, @ModelAttribute("cart") List<Product> cart) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cart.add(product);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{productId}")
    public String removeFromCart(@PathVariable("productId") Long productId, @ModelAttribute("cart") List<Product> cart) {
        Product productToRemove = null;
        for (Product product : cart) {
            if (product.getId().equals(productId)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            cart.remove(productToRemove);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/checkout")
    public String checkoutCart(@ModelAttribute("cart") List<Product> cart) {
        String to = "satanbbc@gmail.com";
        String from = "easykeyscommerce@gmail.com";
        final String username = "b2b46c837c7173";
        final String password = "2fdfdc5559d85e";
        String host = "sandbox.smtp.mailtrap.io";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(props, authenticator);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Here is your order!");
            message.setContent(createConfirmationBody(cart), "text/html");
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        cart.clear();
        return "redirect:/";
    }

    private String createConfirmationBody(List<Product> cart) {
        String body = "<html><body>";
        body += "<h1>Order Confirmation</h1>";
        body += "<p>Thank you for your order! Here are the details:</p>";
        body += "<ul>";
        for (Product product : cart) {
            body += "<li>" + product.getName() + " = $" + product.getPrice() + "</li>";
        }
        body += "</ul>";
        body += "<p>Total: $" + getTotalPrice(cart) + "</p>";
        body += "</body></html>";
        return body;
    }
}

