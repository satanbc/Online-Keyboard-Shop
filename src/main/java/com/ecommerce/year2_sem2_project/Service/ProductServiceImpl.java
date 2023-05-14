package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.DAO.ProductRepository;
import com.ecommerce.year2_sem2_project.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/// Реалізація сервісу продуктів
@Service
@Scope("singleton")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        int cores = Runtime.getRuntime().availableProcessors();
        int batchSize = 1000;
        List<Product> allProducts = new ArrayList<>();

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(cores);
            List<Callable<List<Product>>> tasks = new ArrayList<>();

            long totalProducts = productRepository.count();
            long totalPages = (long) Math.ceil((double) totalProducts / batchSize);

            for (int i = 0; i < totalPages; i++) {
                int page = i;
                Callable<List<Product>> task = () -> {
                    Pageable pageable = PageRequest.of(page, batchSize);
                    return productRepository.findAll(pageable).getContent();
                };
                tasks.add(task);
            }

            List<Future<List<Product>>> futures = executorService.invokeAll(tasks);
            executorService.shutdown();

            for (Future<List<Product>> future : futures) {
                allProducts.addAll(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return allProducts;
    }


    @Override
    public Product getProductById(Long id) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Product> future = executor.submit(() -> productRepository.findById(id).orElse(null));
        executor.shutdown();
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }


    @Override
    public void saveProduct(Product product) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            productRepository.save(product);
        });
        executorService.shutdown();
    }

    @Override
    public void deleteById(Long id) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            productRepository.deleteById(id);
        });
        executorService.shutdown();
    }

    public void updateProduct(Product updatedProduct) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            productRepository.save(updatedProduct);
        });
        executorService.shutdown();
    }
}



