package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Entity.Order;
import com.ecommerce.year2_sem2_project.Entity.OrderedItem;
import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.OrderService;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @ModelAttribute("cart")
    public List<Product> initializeCart() {
        return new ArrayList<>();
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

    @GetMapping("/cart/order")
    public String showOrderForm(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "order-form";
    }

    @PostMapping("/cart/order/create")
    public String createOrder(@RequestParam("customerName") String customerName,
                              @RequestParam("email") String email,
                              @RequestParam("address") String address,
                              @ModelAttribute("cart") List<Product> cart,
                              HttpSession session,
                              Model model) {

        // Create the order
        double totalPrice = 0;
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setEmail(email);
        order.setAddress(address);

        List<OrderedItem> orderedItems = new ArrayList<>();

        // Create ordered items and calculate total price
        for (Product product : cart) {
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setProduct(product);
            orderedItem.setQuantity(1); // Assuming quantity is always 1
            orderedItem.setPrice(product.getPrice());

            orderedItems.add(orderedItem);
            totalPrice += orderedItem.getPrice();
        }

        order.setTotalPrice(totalPrice);
        order.setOrderedItems(orderedItems);

        // Save the order to the database
        orderService.createOrder(order);

        // Clear the cart items from the session
        cart.clear();

        // Add the order object to the model
        model.addAttribute("order", order);

        // Return the view name for order success page
        return "order-success";
    }

}

