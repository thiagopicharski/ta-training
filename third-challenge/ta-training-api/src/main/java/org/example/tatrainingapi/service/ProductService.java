package org.example.tatrainingapi.service;

import org.example.tatrainingapi.model.Cart;
import org.example.tatrainingapi.model.Product;
import org.example.tatrainingapi.persistence.CartRepository;
import org.example.tatrainingapi.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository.getOne(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(long id, Map.Entry<String, Integer> entry) {

    }
}
