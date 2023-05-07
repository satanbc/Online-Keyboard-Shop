package com.ecommerce.year2_sem2_project.Controller;

import com.ecommerce.year2_sem2_project.Entity.Order;
import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.OrderService;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String listProducts(Model model) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Product> productList = new ArrayList<>();
        List<Future<Product>> futureList = new ArrayList<>();

        for (Product product : productService.getAllProducts()) {
            Future<Product> future = executorService.submit(() -> productService.getProductById(product.getId()));
            futureList.add(future);
        }

        for (Future<Product> future : futureList) {
            try {
                productList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        model.addAttribute("products", productList);
        return "admin/productList";
    }


    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/addProductForm";
    }

    @PostMapping("/add")
    public String addProductSubmit(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/{id}/edit")
    public String editProductForm(@PathVariable("id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin/editProductForm";
    }

    @PostMapping("/{id}/edit")
    public String editProductSubmit(@PathVariable("id") long id, @ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        return "redirect:/admin/products";
    }

    @DeleteMapping(value = "/products/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);

        return "Product has been deleted successfully";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long theId){

        productService.deleteById(theId);

        return "redirect:/admin/products";
    }

    @GetMapping("/orders")
    public String showAdminOrdersPage(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/ordersList";
    }
}
