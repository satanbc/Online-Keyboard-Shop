package com.ecommerce.year2_sem2_project;

import com.ecommerce.year2_sem2_project.Controller.CartController;
import com.ecommerce.year2_sem2_project.Model.Entity.Order;
import com.ecommerce.year2_sem2_project.Model.Entity.OrderedItem;
import com.ecommerce.year2_sem2_project.Model.Entity.Product;
import com.ecommerce.year2_sem2_project.Model.Service.OrderService;
import com.ecommerce.year2_sem2_project.Model.Service.ProductService;
import com.ecommerce.year2_sem2_project.Model.Payment_Strategy.PaymentContext;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/// Тестування контролеру корзини та замовлень
@SpringBootTest
public class CartControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private OrderService orderService;

    @Mock
    private PaymentContext paymentContext;

    @Mock
    private Model model;

    @Mock
    private HttpSession httpSession;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cartController = new CartController(productService, orderService, paymentContext);
    }

    @Test
    public void testShowCart() {
        List<Product> cart = new ArrayList<>();
        cart.add(new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg"));
        cart.add(new Product(2L, "Product 2", "Description 2", 20.0, 200, "image2.jpg"));

        when(model.addAttribute(eq("cart"), anyList())).thenReturn(model);
        when(model.addAttribute(eq("totalPrice"), anyDouble())).thenReturn(model);

        String viewName = cartController.showCart(model, cart);

        assertEquals("cart", viewName);
        verify(model).addAttribute("cart", cart);
        verify(model).addAttribute("totalPrice", 30.0);
    }

    @Test
    public void testAddToCart() {
        Product product = new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg");
        when(productService.getProductById(1L)).thenReturn(product);

        String viewName = cartController.addToCart(1L, new ArrayList<>());

        assertEquals("redirect:/cart", viewName);
    }

    @Test
    public void testRemoveFromCart() {
        List<Product> cart = new ArrayList<>();
        Product product1 = new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg");
        Product product2 = new Product(2L, "Product 2", "Description 2", 20.0, 200, "image2.jpg");
        cart.add(product1);
        cart.add(product2);

        String viewName = cartController.removeFromCart(1L, cart);

        assertEquals("redirect:/cart", viewName);
        assertEquals(1, cart.size());
        assertEquals(product2, cart.get(0));
    }

    @Test
    public void testShowOrderForm() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg"));
        products.add(new Product(2L, "Product 2", "Description 2", 20.0, 200, "image2.jpg"));

        when(productService.getAllProducts()).thenReturn(products);
        when(model.addAttribute(eq("products"), anyList())).thenReturn(model);

        String viewName = cartController.showOrderForm(model);

        assertEquals("order-form", viewName);
        verify(model).addAttribute("products", products);
    }

    @Test
    public void testCreateOrder() {
        List<Product> cart = new ArrayList<>();
        cart.add(new Product(1L, "Product 1", "Description 1", 10.0, 100, "image1.jpg"));

        String customerName = "John Doe";
        String email = "john.doe@example.com";
        String address = "123 Main St";
        String paymentMethod = "creditCard";
        double productPrice = 10.0;
        double totalPrice = productPrice;

        Product product = new Product(1L, "Product 1", "Description 1", productPrice, 100, "image1.jpg");
        cart.add(product);

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setEmail(email);
        order.setAddress(address);
        order.setTotalPrice(totalPrice);

        List<OrderedItem> orderedItems = new ArrayList<>();
        OrderedItem orderedItem = new OrderedItem();
        orderedItem.setProduct(product);
        orderedItem.setQuantity(1);
        orderedItem.setPrice(productPrice);
        orderedItems.add(orderedItem);
        order.setOrderedItems(orderedItems);

        when(productService.getAllProducts()).thenReturn(cart);
        when(productService.getProductById(1L)).thenReturn(product);
        doNothing().when(orderService).createOrder(any(Order.class));

        String viewName = cartController.createOrder(customerName, email, address, paymentMethod, cart, httpSession, model);

        assertEquals("order-success", viewName);
        verify(orderService).createOrder(any(Order.class));

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(model).addAttribute(eq("order"), orderCaptor.capture());

        Order capturedOrder = orderCaptor.getValue();
        assertEquals(order.getCustomerName(), capturedOrder.getCustomerName());
        assertEquals(order.getEmail(), capturedOrder.getEmail());
        assertEquals(order.getAddress(), capturedOrder.getAddress());

        assertEquals(0, cart.size());
    }

}
