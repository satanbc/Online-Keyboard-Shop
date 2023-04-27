package com.ecommerce.year2_sem2_project.Service;

import com.ecommerce.year2_sem2_project.DAO.ProductRepository;
import com.ecommerce.year2_sem2_project.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }
}


