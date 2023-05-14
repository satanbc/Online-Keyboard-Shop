package com.ecommerce.year2_sem2_project;

import com.ecommerce.year2_sem2_project.Controller.ProductController;
import com.ecommerce.year2_sem2_project.Entity.Order;
import com.ecommerce.year2_sem2_project.Entity.Product;
import com.ecommerce.year2_sem2_project.Service.OrderService;
import com.ecommerce.year2_sem2_project.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/// Тестування контролеру продуктів
@SpringBootTest
public class ProductControllerTest {

    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private OrderService orderService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService, orderService);
    }

    @Test
    void testListProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg"));
        productList.add(new Product(2L, "Product 2", "Description 2", 20.0, 200, "image2.jpg"));

        when(productService.getAllProducts()).thenReturn(productList);
        for (Product product : productList) {
            when(productService.getProductById(product.getId())).thenReturn(product);
        }

        String viewName = productController.listProducts(model);

        assertEquals("admin/productList", viewName);
        verify(model).addAttribute("products", productList);
    }



    @Test
    void testAddProductSubmit() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg");

        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);

        String viewName = productController.addProductSubmit(product);

        assertEquals("redirect:/admin/products", viewName);

        verify(productService).saveProduct(productCaptor.capture());
        Product capturedProduct = productCaptor.getValue();
        assertEquals(product, capturedProduct);
    }



    @Test
    void testEditProductSubmit() {
        long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        product.setName("Updated Product");
        product.setDescription("Updated Description");
        product.setPrice(20.0);
        product.setStock(200);
        product.setImageUrl("image2.jpg");

        String viewName = productController.editProductSubmit(productId, product);

        assertEquals("redirect:/admin/products", viewName);
        verify(productService).updateProduct(product);
    }

    @Test
    void testDeleteProduct() {
        long productId = 1L;

        String message = productController.delete(productId);

        assertEquals("Product has been deleted successfully", message);
        verify(productService).deleteById(productId);
    }

    @Test
    void testShowAdminOrdersPage() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderService.getAllOrders()).thenReturn(orders);

        String viewName = productController.showAdminOrdersPage(model);

        assertEquals("admin/ordersList", viewName);
        verify(model).addAttribute("orders", orders);
    }
}

