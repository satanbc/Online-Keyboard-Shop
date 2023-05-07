package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.DAO.OrderRepository;
import com.ecommerce.year2_sem2_project.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            orderRepository.save(order);
        });
        executorService.shutdown();
    }

    @Override
    public List<Order> getAllOrders() {
        int cores = Runtime.getRuntime().availableProcessors();
        int batchSize = 1000;
        List<Order> allProducts = new ArrayList<>();

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(cores);
            List<Callable<List<Order>>> tasks = new ArrayList<>();

            long totalProducts = orderRepository.count();
            long totalPages = (long) Math.ceil((double) totalProducts / batchSize);

            for (int i = 0; i < totalPages; i++) {
                int page = i;
                Callable<List<Order>> task = () -> {
                    Pageable pageable = PageRequest.of(page, batchSize);
                    return orderRepository.findAll(pageable).getContent();
                };
                tasks.add(task);
            }

            List<Future<List<Order>>> futures = executorService.invokeAll(tasks);
            executorService.shutdown();

            for (Future<List<Order>> future : futures) {
                allProducts.addAll(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        Collections.reverse(allProducts);

        return allProducts;
    }
}

